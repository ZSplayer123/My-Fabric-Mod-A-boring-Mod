package com.example;


import com.example.Item.Heart;
import com.example.Multi.MultiBlackDiamondTool;
import com.example.Multi.MultiBlackDiamondToolItem;
import com.example.armor.BlackDiamondArmor;
import com.example.enchantment.FLYenchantment;
import com.example.enchantment.HealingEnchantment;
import com.example.tool.*;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.util.Locals;

import javax.tools.Tool;

public class ExampleMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("boring");
	//ore
	private static final Block BLACK_DIAMOND_ORE=
			Registry.register(Registries.BLOCK,new Identifier("boring","black_diamond_ore"),
					new ExperienceDroppingBlock(UniformIntProvider.create(10,17),
							AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY)
									.instrument(Instrument.BASEDRUM)
									.requiresTool()
									.strength(1.5f,1.75f)
									.sounds(BlockSoundGroup.NETHER_ORE)));

	private static final Block DEEPSLATE_BLACK_DIAMOND_ORE=
			Registry.register(Registries.BLOCK,new Identifier("boring","deepslate_black_diamond_ore"),
					new ExperienceDroppingBlock(UniformIntProvider.create(10,17),
							AbstractBlock.Settings.copy(BLACK_DIAMOND_ORE).mapColor(MapColor.STONE_GRAY)
									.instrument(Instrument.BASEDRUM)
									.requiresTool()
									.strength(1.6f,1.85f)
									.sounds(BlockSoundGroup.DEEPSLATE)));
	//sword
	private static final Item BLACK_DIAMOND_SWORD =
			Registry.register(Registries.ITEM,new Identifier("boring","black_diamond_sword"),
					new SwordItem(BlackDiamondTool.BLACKDIAMONDTOOL,9,0.5f,new FabricItemSettings()));

	private static final Item BLACK_DIAMOND_BLOCK_SWORD =
			Registry.register(Registries.ITEM,new Identifier("boring","black_diamond_block_sword"),
					new SwordItem(BlackDiamondBlockTool.BLACKDIAMONDBLOCKTOOL,11,0.25f,new FabricItemSettings()));

	private static final Item HEART_SWORD =
			Registry.register(Registries.ITEM,new Identifier("boring","heart_sword"),
					new SwordItem(HealingTool.HEALING_TOOL,-1,0.25f,new FabricItemSettings()));

	private static final Item BLACK_DIAMOND_EZ_SWORD =
			Registry.register(Registries.ITEM,new Identifier("boring","black_diamond_ez_sword"),
					new SwordItem(BlackDiamondEZTool.BLACK_DIAMOND_EZ_TOOL,10,0.25f,new FabricItemSettings()));
	//pickaxe
	private static final Item BLACK_DIAMOND_PICKAXE =
			Registry.register(Registries.ITEM,new Identifier("boring","black_diamond_pickaxe"),
					new PickaxeItem(BlackDiamondTool.BLACKDIAMONDTOOL,3,0.5f,new FabricItemSettings()));

	private static final Item BLACK_DIAMOND_BLOCK_PICKAXE =
			Registry.register(Registries.ITEM,new Identifier("boring","black_diamond_block_pickaxe"),
					new PickaxeItem(BlackDiamondBlockTool.BLACKDIAMONDBLOCKTOOL,3,0.9f,
							new FabricItemSettings()));

	private static final Item BLACK_DIAMOND_EZ_PICKAXE =
			Registry.register(Registries.ITEM,new Identifier("boring","black_diamond_ez_pickaxe"),
					new PickaxeItem(BlackDiamondEZTool.BLACK_DIAMOND_EZ_TOOL,3,0.9f,new FabricItemSettings()));

	//hammer
	public static final Item BLACK_DIAMOND_HAMMER =
			Registry.register(Registries.ITEM,new Identifier("boring","black_diamond_hammer"),
					new PickaxeItem(BlackDiamondTool.BLACKDIAMONDTOOL,10,0.5f,new FabricItemSettings()));

	//axe
	private static final Item BLACK_DIAMOND_AXE =
			Registry.register(Registries.ITEM,new Identifier("boring","black_diamond_axe"),
					new AxeItem(BlackDiamondTool.BLACKDIAMONDTOOL,11,0.5f,new FabricItemSettings()));

	private static final Item BLACK_DIAMOND_BLOCK_AXE =
			Registry.register(Registries.ITEM,new Identifier("boring","black_diamond_block_axe"),
					new AxeItem(BlackDiamondBlockTool.BLACKDIAMONDBLOCKTOOL,17,0.9f,
							new FabricItemSettings()));

	private static final Item BLACK_DIAMOND_EZ_AXE =
			Registry.register(Registries.ITEM,new Identifier("boring","black_diamond_ez_axe"),
					new AxeItem(BlackDiamondEZTool.BLACK_DIAMOND_EZ_TOOL,15,0.3f,new FabricItemSettings()));
	//armor
	private static final Item BLACK_DIAMOND_HELMET =
			Registry.register(Registries.ITEM,new Identifier("boring","black_diamond_helmet"),
					new ArmorItem(BlackDiamondArmor.BLACK_DIAMOND_ARMOR,ArmorItem.Type.HELMET, new FabricItemSettings()));
	private static final Item BLACK_DIAMOND_CHESTPLATE =
			Registry.register(Registries.ITEM,new Identifier("boring","black_diamond_chestplate"),
					new ArmorItem(BlackDiamondArmor.BLACK_DIAMOND_ARMOR,ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
	private static final Item BLACK_DIAMOND_LEGGINGS =
			Registry.register(Registries.ITEM,new Identifier("boring","black_diamond_leggings"),
					new ArmorItem(BlackDiamondArmor.BLACK_DIAMOND_ARMOR,ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
	private static final Item BLACK_DIAMOND_BOOTS =
			Registry.register(Registries.ITEM,new Identifier("boring","black_diamond_boots"),
					new ArmorItem(BlackDiamondArmor.BLACK_DIAMOND_ARMOR,ArmorItem.Type.BOOTS, new FabricItemSettings()));
	//block
	private static final Block BLACK_DIAMOND_BLOCK=
			Registry.register(Registries.BLOCK,new Identifier("boring","black_diamond_block"),
					new ExperienceDroppingBlock(UniformIntProvider.create(0,0),
							AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY)
							.instrument(Instrument.BASEDRUM)
							.requiresTool()
							.strength(1.5f,1.75f)
							.sounds(BlockSoundGroup.NETHER_ORE)));

	private static final Block BLACK_GOLD_BLOCK =
			Registry.register(Registries.BLOCK,new Identifier("boring","black_gold_block"),
					new ExperienceDroppingBlock(UniformIntProvider.create(0,0),
							AbstractBlock.Settings.copy(BLACK_DIAMOND_BLOCK)
									.mapColor(MapColor.STONE_GRAY)
									.instrument(Instrument.BASEDRUM)
									.requiresTool()
									.strength(1.25f,1.8f)
									.sounds(BlockSoundGroup.NETHER_ORE)));
	//item
	public static final Item BLACK_DIAMOND =
			Registry.register(Registries.ITEM,new Identifier("boring","black_diamond"),
					new Item(new FabricItemSettings()));

	public static final BlockItem BLACK_DIAMOND_BLOCK_ITEM =
			Registry.register(Registries.ITEM,new Identifier("boring","black_diamond_block"),
					new BlockItem(BLACK_DIAMOND_BLOCK,new FabricItemSettings()));

	public static final BlockItem BLACK_DIAMOND_ORE_ITEM =
			Registry.register(Registries.ITEM,new Identifier("boring","black_diamond_ore"),
					new BlockItem(BLACK_DIAMOND_ORE,new FabricItemSettings()));

	public static final BlockItem DEEPSLATE_BLACK_DIAMOND_ORE_ITEM =
			Registry.register(Registries.ITEM,new Identifier("boring","deepslate_black_diamond_ore"),
					new BlockItem(DEEPSLATE_BLACK_DIAMOND_ORE,new FabricItemSettings()));

	private static final Item BLACK_GOLD_INGOT =
			Registry.register(Registries.ITEM,new Identifier("boring","black_gold_ingot"),
					new Item(new FabricItemSettings()));

	public static final Item HEART =
			Registry.register(Registries.ITEM,new Identifier("boring","heart"),
					new Heart(new FabricItemSettings()));

	private static final Item BLACK_GOLD_BLOCK_ITEM =
			Registry.register(Registries.ITEM,new Identifier("boring","black_gold_block"),
					new BlockItem(BLACK_GOLD_BLOCK,new FabricItemSettings()));
	//placed feature
	private static final RegistryKey<PlacedFeature> BLACK_DIAMOND_ORE_PLACED_FEATURE =
			RegistryKey.of(RegistryKeys.PLACED_FEATURE,new Identifier("boring","black_diamond_ore"));

	//enchantment
	private static final FLYenchantment FLY_ENCHANTMENT =
			Registry.register(Registries.ENCHANTMENT,new Identifier("boring","zbrnfql"),
					new FLYenchantment(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.WEAPON,new EquipmentSlot[]{
							EquipmentSlot.MAINHAND
					}));

	private static final HealingEnchantment HEALING_ENCHANTMENT =
			Registry.register(Registries.ENCHANTMENT,new Identifier("boring","healing_enchantment"),
					new HealingEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.WEAPON,new EquipmentSlot[]{
							EquipmentSlot.MAINHAND
					}));


	//extra
	public static final Item MULTI_BLACK_DIAMOND_TOOL =
			Registry.register(Registries.ITEM,new Identifier("boring_extra","multi_black_diamond_tool"),
					new MultiBlackDiamondToolItem(MultiBlackDiamondTool.MultiBlackDiamondTool,10f,0.25f,new FabricItemSettings()));





	private static final ItemGroup ITEM_GROUP=
			Registry.register(Registries.ITEM_GROUP,new Identifier("boring","item_group"),
					FabricItemGroup.builder()
							.icon(()->new ItemStack(BLACK_DIAMOND))
							.displayName(Text.translatable("itemGroup.boring.item_group"))
							.entries((content,entries)->{
								//block
								entries.add(BLACK_DIAMOND_BLOCK);
								entries.add(BLACK_GOLD_BLOCK);
								//item
								entries.add(BLACK_DIAMOND);
								entries.add(BLACK_GOLD_INGOT);
								entries.add(HEART);
								//armor
								entries.add(BLACK_DIAMOND_HELMET);
								entries.add(BLACK_DIAMOND_CHESTPLATE);
								entries.add(BLACK_DIAMOND_LEGGINGS);
								entries.add(BLACK_DIAMOND_BOOTS);
								//weapons
								entries.add(BLACK_DIAMOND_SWORD);
								entries.add(BLACK_DIAMOND_PICKAXE);
								entries.add(BLACK_DIAMOND_AXE);
								entries.add(BLACK_DIAMOND_HAMMER);
								entries.add(BLACK_DIAMOND_BLOCK_SWORD);
								entries.add(BLACK_DIAMOND_BLOCK_PICKAXE);
								entries.add(BLACK_DIAMOND_BLOCK_AXE);
								entries.add(HEART_SWORD);
								entries.add(BLACK_DIAMOND_EZ_SWORD);
								entries.add(BLACK_DIAMOND_EZ_PICKAXE);
								entries.add(BLACK_DIAMOND_EZ_AXE);
								//ores
								entries.add(BLACK_DIAMOND_ORE);
								entries.add(DEEPSLATE_BLACK_DIAMOND_ORE);
							})
							.build());

	private static final ItemGroup ITEM_GROUP_EXTRA=
			Registry.register(Registries.ITEM_GROUP,new Identifier("boring","item_group_extra"),
					FabricItemGroup.builder()
							.icon(()->new ItemStack(MULTI_BLACK_DIAMOND_TOOL))
							.displayName(Text.translatable("itemGroup.boring.item_group_extra"))
							.entries((content,entries)->{
								//extra
								entries.add(MULTI_BLACK_DIAMOND_TOOL);
							})
							.build());

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
				GenerationStep.Feature.UNDERGROUND_ORES,
				BLACK_DIAMOND_ORE_PLACED_FEATURE);
	}
}