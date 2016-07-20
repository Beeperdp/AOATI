package com.beeperdp.aoati.block;

import java.util.Random;

import com.beeperdp.aoati.aoati;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockVirusCoal extends Block {
public IIcon[] icons = new IIcon[6];
	
	public BlockVirusCoal(Material material){
		super(material);
		this.setHardness(345F);
		this.setBlockName("blockVirusCoal");
		this.setBlockTextureName("aoati:blockVirusCoal");
		this.setResistance(16000F);
		this.setLightLevel(0F);
		this.setHarvestLevel("pickaxe", 3);
		this.setTickRandomly(false);
		this.setCreativeTab(aoati.creativeTab);
	}
	
	@Override
    public int tickRate(World p_149738_1_){
        return 5;
    }
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);

		if(world.getBlock(x, y, z) == this) {
			world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
		}
	}
	
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random rand){
		world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
		world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z)+1, 0);
		int dx = x;
		int dy = y;
		int dz = z;
		if(world.getBlockMetadata(x, y, z) > 14){//Determines if its time to stop
	        world.setBlock(x, y, z, aoati.blockVirusRemoval);
		}else{
		
		if(world.getBlockMetadata(x, y, z) % 2 == 0){//Tick to spread, 1/2 speed in order to allow the removal block to spread fast enough to stop the virus
        Block blok = Blocks.coal_ore;
        for(int i=0;i<10;i++){
        	if(i == 0){
        		Block preblock = world.getBlock(x+1, y, z);
        		if(preblock == Blocks.bedrock == false && preblock == aoati.blockVirusRemoval == false && preblock == Blocks.air == false && preblock == aoati.blockVirusCoal == false && preblock == Blocks.tallgrass == false && preblock == blok == false && preblock == Blocks.water == false && preblock == Blocks.lava == false && preblock == Blocks.flowing_lava == false && preblock == Blocks.flowing_water == false){
        			dx = x+1;
        			dy = y;
        			dz = z;
        			world.setBlock(dx, dy, dz, aoati.blockVirusCoal);
        		}
        	}else if(i == 1){
        		Block preblock = world.getBlock(x-1, y, z);
        		if(preblock == Blocks.bedrock == false && preblock == aoati.blockVirusRemoval == false && preblock == Blocks.air == false && preblock == aoati.blockVirusCoal == false && preblock == Blocks.tallgrass == false && preblock == blok == false && preblock == Blocks.water == false && preblock == Blocks.lava == false && preblock == Blocks.flowing_lava == false && preblock == Blocks.flowing_water == false){
        			dx = x-1;
        			dy = y;
        			dz = z;
        			world.setBlock(dx, dy, dz, aoati.blockVirusCoal);
        		}
        	}else if(i == 2){
        		Block preblock = world.getBlock(x, y+1, z);
        		if(preblock == Blocks.bedrock == false && preblock == aoati.blockVirusRemoval == false && preblock == Blocks.air == false && preblock == aoati.blockVirusCoal == false && preblock == Blocks.tallgrass == false && preblock == blok == false && preblock == Blocks.water == false && preblock == Blocks.lava == false && preblock == Blocks.flowing_lava == false && preblock == Blocks.flowing_water == false){
        			dx = x;
        			dy = y+1;
        			dz = z;
        			world.setBlock(dx, dy, dz, aoati.blockVirusCoal);
        		}
        	}else if(i == 3){
        		Block preblock = world.getBlock(x, y-1, z);
        		if(preblock == Blocks.bedrock == false && preblock == aoati.blockVirusRemoval == false && preblock == Blocks.air == false && preblock == aoati.blockVirusCoal == false && preblock == Blocks.tallgrass == false && preblock == blok == false && preblock == Blocks.water == false && preblock == Blocks.lava == false && preblock == Blocks.flowing_lava == false && preblock == Blocks.flowing_water == false){
        			dx = x;
        			dy = y-1;
        			dz = z;
        			world.setBlock(dx, dy, dz, aoati.blockVirusCoal);
        		}
        	}else if(i == 4){
        		Block preblock = world.getBlock(x, y, z+1);
        		if(preblock == Blocks.bedrock == false && preblock == aoati.blockVirusRemoval == false && preblock == Blocks.air == false && preblock == aoati.blockVirusCoal == false && preblock == Blocks.tallgrass == false && preblock == blok == false && preblock == Blocks.water == false && preblock == Blocks.lava == false && preblock == Blocks.flowing_lava == false && preblock == Blocks.flowing_water == false){
        			dx = x;
        			dy = y;
        			dz = z+1;
        			world.setBlock(dx, dy, dz, aoati.blockVirusCoal);
        		}
        	}else if(i == 5){
        		Block preblock = world.getBlock(x, y, z-1);
        		if(preblock == Blocks.bedrock == false && preblock == aoati.blockVirusRemoval == false && preblock == Blocks.air == false && preblock == aoati.blockVirusCoal == false && preblock == Blocks.tallgrass == false && preblock == blok == false && preblock == Blocks.water == false && preblock == Blocks.lava == false && preblock == Blocks.flowing_lava == false && preblock == Blocks.flowing_water == false){
        			dx = x;
        			dy = y;
        			dz = z-1;
        			world.setBlock(dx, dy, dz, aoati.blockVirusCoal);
        		}
        	}else if(i == 6){//Anything here or beyond is the adjacent, not touching blocks to infect
        		Block preblock = world.getBlock(x-1, y, z-1);
        		if(preblock == Blocks.bedrock == false && preblock == aoati.blockVirusRemoval == false && preblock == Blocks.air == false && preblock == aoati.blockVirusCoal == false && preblock == Blocks.tallgrass == false && preblock == blok == false && preblock == Blocks.water == false && preblock == Blocks.lava == false && preblock == Blocks.flowing_lava == false && preblock == Blocks.flowing_water == false){
        			dx = x-1;
        			dy = y;
        			dz = z-1;
        			world.setBlock(dx, dy, dz, aoati.blockVirusCoal);
        		}
        	}else if(i == 7){
        		Block preblock = world.getBlock(x+1, y, z-1);
        		if(preblock == Blocks.bedrock == false && preblock == aoati.blockVirusRemoval == false && preblock == Blocks.air == false && preblock == aoati.blockVirusCoal == false && preblock == Blocks.tallgrass == false && preblock == blok == false && preblock == Blocks.water == false && preblock == Blocks.lava == false && preblock == Blocks.flowing_lava == false && preblock == Blocks.flowing_water == false){
        			dx = x+1;
        			dy = y;
        			dz = z-1;
        			world.setBlock(dx, dy, dz, aoati.blockVirusCoal);
        		}
        	}else if(i == 8){
        		Block preblock = world.getBlock(x-1, y, z+1);
        		if(preblock == Blocks.bedrock == false && preblock == aoati.blockVirusRemoval == false && preblock == Blocks.air == false && preblock == aoati.blockVirusCoal == false && preblock == Blocks.tallgrass == false && preblock == blok == false && preblock == Blocks.water == false && preblock == Blocks.lava == false && preblock == Blocks.flowing_lava == false && preblock == Blocks.flowing_water == false){
        			dx = x-1;
        			dy = y;
        			dz = z+1;
        			world.setBlock(dx, dy, dz, aoati.blockVirusCoal);
        		}
        	}else if(i == 9){
        		Block preblock = world.getBlock(x+1, y, z+1);
        		if(preblock == Blocks.bedrock == false && preblock == aoati.blockVirusRemoval == false && preblock == Blocks.air == false && preblock == aoati.blockVirusCoal == false && preblock == Blocks.tallgrass == false && preblock == blok == false && preblock == Blocks.water == false && preblock == Blocks.lava == false && preblock == Blocks.flowing_lava == false && preblock == Blocks.flowing_water == false){
        			dx = x+1;
        			dy = y;
        			dz = z+1;
        			world.setBlock(dx, dy, dz, aoati.blockVirusCoal);
        		}
        	}
        }
		}
		}
	}
	
	@Override
	public void registerBlockIcons(IIconRegister reg) {
	    for (int i = 0; i < 6; i ++) {
	        this.icons[i] = reg.registerIcon(this.textureName + "_" + i);
	    }
	}
	
	private int parser(int side, int meta){
		return side;
	}
	
	@Override
	public IIcon getIcon(int side, int meta) {
		return this.icons[0];
	}
}
