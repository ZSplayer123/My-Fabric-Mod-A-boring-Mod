package com.example.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.math.MathHelper;

public class HealingEnchantment extends Enchantment {

    public HealingEnchantment(Rarity rarity, EnchantmentTarget target, EquipmentSlot[] slotTypes) {
        super(rarity, target, slotTypes);
    }

    // 处理附魔效果：每次攻击时触发回血
    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity) {
            LivingEntity livingTarget = (LivingEntity) target;

            float healingAmount = 20.0f;

            // 确保恢复的生命不超过目标最大生命
            float newHealth = livingTarget.getHealth() + healingAmount;
            float maxHealth = livingTarget.getMaxHealth();
            livingTarget.setHealth(MathHelper.clamp(newHealth, 0, maxHealth));
        }
    }
}
