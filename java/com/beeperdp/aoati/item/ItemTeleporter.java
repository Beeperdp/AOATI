package com.beeperdp.aoati.item;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class ItemTeleporter extends Item{
	public ItemTeleporter() {
		this.setUnlocalizedName("itemTeleporter");
		this.setTextureName("aoati:itemTeleporter");
	}
	
	@SideOnly(Side.CLIENT)
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player){
		//MovingObjectPosition objectPosition = player.rayTrace(300,1);
		//int x = objectPosition.blockX;
		//int y = objectPosition.blockY;
		//int z = objectPosition.blockZ;
		//EntityPlayerMP entityplayermp = (EntityPlayerMP)player;
		//EnderTeleportEvent event = new EnderTeleportEvent(entityplayermp, x, y, z, 0F);
		Random rand = new Random();
		
		boolean good = false;
		
		int x = 0;
		int y = 0;
		int z = 0;
		
		int count = 0;
		
		while(!good){
			if(count > 5){
				//System.out.println("Warning: AOATI Teleporter was unable to find a proper place to go after 2 tries!");
				break;
			}
			count++;
			x = rand.nextInt(10000);
			z = rand.nextInt(10000);
			y = findSuitableYPos(world, x, z, 20, player);
			if(y > 20){
				player.setPositionAndUpdate(x, y, z);
				player.fallDistance=0F;
				item.stackSize = item.stackSize-1;
				ChunkCoordinates chunk = new ChunkCoordinates(x, y, z);
				player.setSpawnChunk(chunk, true);//True means to not check for a bed
				player.addChatMessage(new ChatComponentText("Spawn Point Set"));
				good = true;
			}
		}
		return item;
	}

	private int findSuitableYPos(World world, int x, int z, int lowest, EntityPlayer player) {
		int y = 0;
		
		for(int i=256;i>lowest;i--){
			Block block = world.getBlock(x, i, z);
			Block block2 = world.getBlock(x, i+1, z);
			Block block3 = world.getBlock(x, i-1, z);
			Block block4 = world.getBlock(x, i-2, z);
			Block block5 = world.getBlock(x, y-3, z);
			if(block == Blocks.air){
				if(block2 == Blocks.air 
				&& block3 == Blocks.air 
				&& block4 != Blocks.air 
				&& block4 != Blocks.water
				&& block4 != Blocks.flowing_water
				&& block5 != Blocks.water 
				&& block5 != Blocks.flowing_water
				&& block3 != Blocks.lava
				&& block3 != Blocks.flowing_lava
				&& block4 != Blocks.lava
				&& block4 != Blocks.flowing_lava
				&& block != Blocks.flowing_lava
				&& block != Blocks.lava){
					System.out.println("Suitable spot found for " + player.getDisplayName());
					System.out.println("|" + x + "|" + i + "|" + z + "|");
					y=i;
					break;
				}
			}
		}
		
		return y;
	}
	
@Override
public void addInformation(ItemStack h, EntityPlayer e, List l, boolean p){
	l.add("When right clicked while in hand,");
	l.add("this item will teleport you randomly to");
	l.add("any spot within 10,000 blocks from spawn.");
	l.add("It will also set your spawn point.");
	l.add("One Use Only");
}
	
}