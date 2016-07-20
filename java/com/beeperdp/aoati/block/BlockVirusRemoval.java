package com.beeperdp.aoati.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.beeperdp.aoati.aoati;

public class BlockVirusRemoval extends Block {

	private int tempx = 0;
	private int tempy = 0;
	private int tempz = 0;
	
	private int orientation = 0;
	
	public IIcon[] icons = new IIcon[6];
	
	public BlockVirusRemoval(Material material){
		super(material);
		this.setHardness(345F);
		this.setBlockName("blockVirusRemoval");
		this.setBlockTextureName("aoati:blockVirusRemoval");
		this.setResistance(16000F);
		this.setLightLevel(0F);
		this.setHarvestLevel("pickaxe", 3);
		this.setTickRandomly(false);
	}
	
	@Override
    public int tickRate(World p_149738_1_){
        return 2;
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
		
		world.setBlock(x, y, z, Blocks.air);
	    for(int i=0;i<6;i++){
	        if(i == 0){
	        	Block preblock = world.getBlock(x+1, y, z);
	        	if(preblock == aoati.blockVirusLiquid || preblock == aoati.blockVirusCoal || preblock == aoati.blockVirus || preblock == aoati.blockVirusAdamantium){
	        		dx = x+1;
	        		dy = y;
	        		dz = z;
	        		world.setBlock(dx, dy, dz, aoati.blockVirusRemoval);
	        	}
	        }else if(i == 1){
	        	Block preblock = world.getBlock(x-1, y, z);
	        	if(preblock == aoati.blockVirusLiquid || preblock == aoati.blockVirusCoal || preblock == aoati.blockVirus || preblock == aoati.blockVirusAdamantium){
	        		dx = x-1;
	        		dy = y;
	        		dz = z;
	        		world.setBlock(dx, dy, dz, aoati.blockVirusRemoval);
	        	}
	        }else if(i == 2){
	        	Block preblock = world.getBlock(x, y+1, z);
	        	if(preblock == aoati.blockVirusLiquid || preblock == aoati.blockVirusCoal || preblock == aoati.blockVirus || preblock == aoati.blockVirusAdamantium){
	        		dx = x;
	        		dy = y+1;
	        		dz = z;
	        		world.setBlock(dx, dy, dz, aoati.blockVirusRemoval);
	        	}
	        }else if(i == 3){
	        	Block preblock = world.getBlock(x, y-1, z);
	        	if(preblock == aoati.blockVirusLiquid || preblock == aoati.blockVirusCoal || preblock == aoati.blockVirus || preblock == aoati.blockVirusAdamantium){
	        		dx = x;
	        		dy = y-1;
	        		dz = z;
	        		world.setBlock(dx, dy, dz, aoati.blockVirusRemoval);
	        	}
	        }else if(i == 4){
	        	Block preblock = world.getBlock(x, y, z+1);
	        	if(preblock == aoati.blockVirusLiquid || preblock == aoati.blockVirusCoal || preblock == aoati.blockVirus || preblock == aoati.blockVirusAdamantium){
	        		dx = x;
	        		dy = y;
	        		dz = z+1;
	        		world.setBlock(dx, dy, dz, aoati.blockVirusRemoval);
	        	}
	        }else if(i == 5){
	        	Block preblock = world.getBlock(x, y, z-1);
	        	if(preblock == aoati.blockVirusLiquid || preblock == aoati.blockVirusCoal || preblock == aoati.blockVirus || preblock == aoati.blockVirusAdamantium){
	        		dx = x;
	        		dy = y;
	        		dz = z-1;
	        		world.setBlock(dx, dy, dz, aoati.blockVirusRemoval);
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
