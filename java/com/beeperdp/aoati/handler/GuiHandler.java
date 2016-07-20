package com.beeperdp.aoati.handler;

import com.beeperdp.aoati.gui.GuiBlockCompressor;
import com.beeperdp.aoati.gui.GuiBlockIngotFormer;
import com.beeperdp.aoati.inventory.ContainerBlockCompressor;
import com.beeperdp.aoati.inventory.ContainerBlockIngotFormer;
import com.beeperdp.aoati.tile_entity.TileEntityBlockCompressor;
import com.beeperdp.aoati.tile_entity.TileEntityBlockIngotFormer;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == 0){
			TileEntityBlockCompressor tileEntityBlockCompressor = (TileEntityBlockCompressor) world.getTileEntity(x, y, z);
			return new ContainerBlockCompressor(player.inventory, tileEntityBlockCompressor);
		}else if(ID == 1){
			TileEntityBlockIngotFormer tileEntityBlockIngotFormer = (TileEntityBlockIngotFormer) world.getTileEntity(x, y, z);
			return new ContainerBlockIngotFormer(player.inventory, tileEntityBlockIngotFormer);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == 0){
			TileEntityBlockCompressor tileEntityBlockCompressor = (TileEntityBlockCompressor) world.getTileEntity(x, y, z);
			return new GuiBlockCompressor(player.inventory, tileEntityBlockCompressor);
		}else if(ID == 1){
			TileEntityBlockIngotFormer tileEntityBlockIngotFormer = (TileEntityBlockIngotFormer) world.getTileEntity(x, y, z);
			return new GuiBlockIngotFormer(player.inventory, tileEntityBlockIngotFormer);
		}
		return null;
	}
	
}
