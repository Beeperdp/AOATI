package com.beeperdp.aoati;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends ServerProxy{
	
	public void registerRenderThings(){
		//RenderingRegistry.registerEntityRenderingHandler(EntityTutMob.class, new RenderTutMob(new ModelTutMob(), 0));
		//RenderingRegistry.registerEntityRenderingHandler(EntityGrenade.class, new RenderSnowball(TMItem.tutGrenade));
		
		//ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTutChest.class, new TutChestRenderer());
		//MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(TMBlock.tutChest), new ItemRenderTutChest());
	}
	
	public int addArmor(String armor){
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
}
