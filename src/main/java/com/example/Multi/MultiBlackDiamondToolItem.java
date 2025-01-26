package com.example.Multi;

import net.minecraft.block.BlockState;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;

public class MultiBlackDiamondToolItem extends ToolItem {
    public MultiBlackDiamondToolItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, settings);
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
    }
    private final float attackDamage;
    private final float attackSpeed;

    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        if (state.isIn(BlockTags.PICKAXE_MINEABLE) ||
                state.isIn(BlockTags.AXE_MINEABLE) ||
                state.isIn(BlockTags.SHOVEL_MINEABLE)) {
            return this.getMaterial().getMiningSpeedMultiplier();
        }
        return super.getMiningSpeedMultiplier(stack, state);
    }

    @Override
    public boolean isSuitableFor(BlockState state) {
        return state.isIn(BlockTags.PICKAXE_MINEABLE) ||
                state.isIn(BlockTags.AXE_MINEABLE) ||
                state.isIn(BlockTags.SHOVEL_MINEABLE);
    }
}
