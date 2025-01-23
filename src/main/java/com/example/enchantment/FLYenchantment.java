package com.example.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

public class FLYenchantment extends Enchantment {

    public FLYenchantment(Rarity rarity, EnchantmentTarget target, EquipmentSlot[] slotTypes) {
        super(rarity, target, slotTypes);
    }

    @Override
    public int getMaxLevel() {
        return 255;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        boolean bl = user.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING);
        float power = level * 2.5f;
        user.getWorld().createExplosion(user, target.getX(), target.getY(), target.getZ(), power, bl, World.ExplosionSourceType.MOB);
    }
}
