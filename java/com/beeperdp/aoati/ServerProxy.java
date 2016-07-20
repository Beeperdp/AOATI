package com.beeperdp.aoati;


import com.beeperdp.aoati.handler.GuiHandler;
import com.beeperdp.aoati.tile_entity.TileEntityBlockCompressor;
import com.beeperdp.aoati.tile_entity.TileEntityBlockIngotFormer;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ServerProxy {

	public void registerRenderThings() {

	}

	public int addArmor(String armor) {
		return 0;
	}
	
	public void registerNetworkStuff(){
		NetworkRegistry.INSTANCE.registerGuiHandler(aoati.modInstance, new GuiHandler());
	}

	public void registerTileEntities(){
		GameRegistry.registerTileEntity(TileEntityBlockCompressor.class, "TileEntityBlockCompressor");
		GameRegistry.registerTileEntity(TileEntityBlockIngotFormer.class, "TileEntityBlockIngotFormer");
	}
}