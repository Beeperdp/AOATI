package com.beeperdp.aoati;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.beeperdp.aoati.block.BlockAdamantiumOre;
import com.beeperdp.aoati.block.BlockCompressor;
import com.beeperdp.aoati.block.BlockIngotFormer;
import com.beeperdp.aoati.block.BlockVirus;
import com.beeperdp.aoati.block.BlockVirusAdamantium;
import com.beeperdp.aoati.block.BlockVirusCoal;
import com.beeperdp.aoati.block.BlockVirusLiquid;
import com.beeperdp.aoati.block.BlockVirusRemoval;
import com.beeperdp.aoati.handler.GuiHandler;
import com.beeperdp.aoati.item.ItemAdamantiumBits;
import com.beeperdp.aoati.item.ItemAdamantiumIngot;
import com.beeperdp.aoati.item.ItemAdamantiumPiece;
import com.beeperdp.aoati.item.ItemAdamantiumPieces;
import com.beeperdp.aoati.item.ItemCharredCoal;
import com.beeperdp.aoati.item.ItemSoulIngot;
import com.beeperdp.aoati.item.ItemTeleporter;
import com.beeperdp.aoati.worldgen.AoatiWorldGen;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "aoati", name = "AOATI", version = "1.0")
public class aoati {
	
	@Instance("aoati")
	public static aoati modInstance;
	
	@SidedProxy(clientSide = "com.beeperdp.aoati.ClientProxy", serverSide = "com.beeperdp.aoati.ServerProxy") 
	public static ServerProxy proxy;
	
	public static Block blockAdamantiumOre;
	public static Block blockCompressor;
	public static Block blockVirus;
	public static Block blockVirusRemoval;
	public static Block blockVirusAdamantium;
	public static Block blockVirusCoal;
	public static Block blockIngotFormer;
	public static Block blockVirusLiquid;
	
	public static Item itemAdamantiumBits;
	public static Item itemAdamantiumPiece;
	public static Item itemCharredCoal;
	public static Item itemAdamantiumPieces;
	public static Item itemTeleporter;
	public static Item itemAdamantiumIngot;
	public static Item itemSoulIngot;
	public static Item itemSoul;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		//Item/Block Registering Initialization Section
		//Configuration File Reading/Parsing Section
		
		//Items
		DeclareItems();
		
		//Item Registering
		RegisterItems();
		
		//Blocks
		DeclareBlocks();
		
		//Block Registering
		RegisterBlocks();
		
		proxy.registerTileEntities();
	}
	
	private static void DeclareItems(){
		itemAdamantiumBits = new ItemAdamantiumBits();
		itemCharredCoal = new ItemCharredCoal();
		itemAdamantiumPiece = new ItemAdamantiumPiece();
		itemAdamantiumPieces = new ItemAdamantiumPieces();
		itemTeleporter = new ItemTeleporter();
		itemAdamantiumIngot = new ItemAdamantiumIngot();
		itemSoulIngot = new ItemSoulIngot();
		itemSoul = new ItemSoul();
	}
	
	private static void RegisterItems(){
		GameRegistry.registerItem(itemAdamantiumBits, itemAdamantiumBits.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemCharredCoal, itemCharredCoal.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemAdamantiumPiece, itemAdamantiumPiece.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemAdamantiumPieces, itemAdamantiumPieces.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemTeleporter, itemTeleporter.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemAdamantiumIngot, itemAdamantiumIngot.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemSoulIngot, itemSoulIngot.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemSoul, itemSoul.getUnlocalizedName().substring(5));
	}
	
	private static void DeclareBlocks(){
		blockAdamantiumOre = new BlockAdamantiumOre(Material.cloth, itemAdamantiumBits, 1, 1, 3);
		blockCompressor = new BlockCompressor(Material.rock, false);
		blockVirus = new BlockVirus(Material.clay);
		blockVirusRemoval = new BlockVirusRemoval(Material.clay);
		blockVirusAdamantium = new BlockVirusAdamantium(Material.clay);
		blockVirusCoal = new BlockVirusCoal(Material.clay);
		blockIngotFormer = new BlockIngotFormer(Material.rock, false);
		blockVirusLiquid = new BlockVirusLiquid(Material.rock);
	}
	
	private static void RegisterBlocks(){
		GameRegistry.registerBlock(blockAdamantiumOre, blockAdamantiumOre.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockCompressor, blockCompressor.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockVirus, blockVirus.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockVirusRemoval, blockVirusRemoval.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockVirusAdamantium, blockVirusAdamantium.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockVirusCoal, blockVirusCoal.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockIngotFormer, blockIngotFormer.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockVirusLiquid, blockVirusLiquid.getUnlocalizedName().substring(5));
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event){
		//Registering of other things like Proxy, TileEntity, entity, GUI and Packet Registering
		//GameRegistry.addRecipe(new ItemStack(bill1, 5), new Object[]{"   ","   ","   ", 'B', bill5});
		
		//GameRegistry.addShapelessRecipe(new ItemStack(level2, 2), new ItemStack(level3, 1));
		GameRegistry.addRecipe(new ItemStack(itemCharredCoal, 1), new Object[]{"BZ ","   ","   ", 'B', Items.coal, 'Z', new ItemStack(Items.coal, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(itemCharredCoal, 1), new Object[]{"B  ","Z  ","   ", 'B', Items.coal, 'Z', new ItemStack(Items.coal, 1, 1)});
		
		GameRegistry.addRecipe(new ItemStack(itemAdamantiumPieces, 1), new Object[]{"BB ","BB ","   ", 'B', new ItemStack(itemAdamantiumPiece,1)});
		
		//Compressor
		GameRegistry.addRecipe(new ItemStack(blockCompressor, 1), new Object[]{"CFC","FIF","CFC", 'F', new ItemStack(Blocks.furnace,1), 'C', Blocks.cobblestone, 'I', Items.iron_ingot});
		
		//Ingot Former
		GameRegistry.addRecipe(new ItemStack(blockIngotFormer, 1), new Object[]{"III","ICI","IFI", 'F', new ItemStack(Blocks.furnace,1), 'C', Blocks.crafting_table, 'I', Items.iron_ingot});
		
		//Soul
		GameRegistry.addRecipe(new ItemStack(itemSoul, 1), new Object[]{"S  ","   ","   ", 'S', Blocks.soul_sand});
		
		//Mining Gels
		GameRegistry.addRecipe(new ItemStack(blockVirus, 1), new Object[]{"III","ISI","III", 'S', itemSoulIngot, 'I', Items.iron_ingot});
		GameRegistry.addRecipe(new ItemStack(blockVirusCoal, 1), new Object[]{"III","ISI","III", 'S', itemSoulIngot, 'I', Items.coal});
		GameRegistry.addRecipe(new ItemStack(blockVirusLiquid, 1), new Object[]{" I "," S "," I ", 'S', itemSoulIngot, 'I', Items.lava_bucket});
		GameRegistry.addRecipe(new ItemStack(blockVirusLiquid, 1), new Object[]{"   ","ISI","   ", 'S', itemSoulIngot, 'I', Items.water_bucket});
		GameRegistry.addRecipe(new ItemStack(blockVirusAdamantium, 1), new Object[]{"III","ISI","III", 'S', itemSoulIngot, 'I', itemAdamantiumBits});
		
		//Teleporter
		GameRegistry.addRecipe(new ItemStack(itemTeleporter, 1), new Object[]{"GIG","ISI","GIG", 'S', Items.diamond, 'I', Items.iron_ingot, 'G', Blocks.glass_pane});
		
		GameRegistry.registerWorldGenerator(new AoatiWorldGen(), 0);
		NetworkRegistry.INSTANCE.registerGuiHandler(modInstance, new GuiHandler());
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}
	
	public static CreativeTabs creativeTab = new CreativeTabs("creativeTab"){
		@Override
		public Item getTabIconItem(){
			return new ItemStack(itemTeleporter).getItem();
		}
	};
	
}