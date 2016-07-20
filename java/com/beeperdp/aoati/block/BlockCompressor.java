package com.beeperdp.aoati.block;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import com.beeperdp.aoati.aoati;
import com.beeperdp.aoati.tile_entity.TileEntityBlockCompressor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCompressor extends BlockContainer{
	
	private static boolean isBurning;
	private final boolean isBurning2;
	private final Random random = new Random();
	
	private int tempx = 0;
	private int tempy = 0;
	private int tempz = 0;
	
	private int orientation = 0;
	
	public IIcon[] icons = new IIcon[6];
	
	public BlockCompressor(Material material, boolean isActive) {
		super(material);
		isBurning2 = isActive;
		this.setBlockName("blockCompressor");
		this.setBlockTextureName("aoati:blockCompressor");
		this.setHardness(2F);
		this.setResistance(1600F);
		this.setLightLevel(0F);
		this.setHarvestLevel("pickaxe", 2);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister reg) {
	    for (int i = 0; i < 6; i ++) {
	        this.icons[i] = reg.registerIcon(this.textureName + "_" + i);
	    }
	}
	
	private int parser(int side, int meta){
		if(side == 3 && meta == 3 == false){
			side = 4;
		}
		return side;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int meta) {
		//Headache.
		if(meta == 0 && side == 3){
			return this.icons[3];
		}
		return (side == meta) ? this.icons[3] : this.icons[parser(side, meta)];
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_){
		player.openGui(aoati.modInstance, 0, world, x, y, z);
		return true;
		
		//if(!world.isRemote){
			//Minecraft.getMinecraft().displayGuiScreen(new GuiCompressor());
		//}
		//return super.onBlockActivated(world, x, y, z, player, p_149727_6_, p_149727_7_, p_149727_8_, p_149727_9_);
		
		/**int dx = x;
		int dy = y;
		int dz = z;
		
        for(int i=0;i<6;i++){
        	if(i == 0){
        		Block preblock = world.getBlock(x+1, y, z);
        		if(preblock == Blocks.crafting_table){
        			dx = x+1;
        			dy = y;
        			dz = z;
        		}
        	}else if(i == 1){
        		Block preblock = world.getBlock(x-1, y, z);
        		if(preblock == Blocks.crafting_table){
        			dx = x-1;
        			dy = y;
        			dz = z;
        		}
        	}else if(i == 2){
        		Block preblock = world.getBlock(x, y+1, z);
        		if(preblock == Blocks.crafting_table){
        			dx = x;
        			dy = y+1;
        			dz = z;
        		}
        	}else if(i == 3){
        		Block preblock = world.getBlock(x, y-1, z);
        		if(preblock == Blocks.crafting_table){
        			dx = x;
        			dy = y-1;
        			dz = z;
        		}
        	}else if(i == 4){
        		Block preblock = world.getBlock(x, y, z+1);
        		if(preblock == Blocks.crafting_table){
        			dx = x;
        			dy = y;
        			dz = z+1;
        		}
        	}else if(i == 5){
        		Block preblock = world.getBlock(x, y, z-1);
        		if(preblock == Blocks.crafting_table){
        			dx = x;
        			dy = y;
        			dz = z-1;
        		}
        	}
        }
        
        if(dx == x == false || dy == y == false || dz == z == false){
        	player.displayGUIWorkbench(dx, dy, dz);
        }
		
		//world.setBlock(x, y, z, preblock);
		//world.setBlockMetadataWithNotify(x, y, z, premeta, 2);
		
    	return false;
    	*/
    }
	
	
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack istack){
    	int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        if (l == 0){//North
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }
        if (l == 1){//East
        	world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }
        if (l == 2){//South
        	world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }
        if (l == 3){//West
        	world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }
        
        if(istack.hasDisplayName()){
        	((TileEntityBlockCompressor) world.getTileEntity(x, y, z)).furnaceName(istack.getDisplayName());
        }
        
    }
    
    
    public static void updateBlockState(World world, int x, int y, int z){
    	TileEntity tileentity = world.getTileEntity(x, y, z);
    	if(tileentity != null){
    		tileentity.validate();
    		world.setTileEntity(x, y, z, tileentity);
    	}
    }
    
    public void breakBlock(World world, int x, int y, int z, Block block, int meta){
    	if(!isBurning){
    		TileEntityBlockCompressor tileentityblockcompressor = (TileEntityBlockCompressor) world.getTileEntity(x, y, z);
    		
    		if(tileentityblockcompressor != null){
    			for(int i=0;i<tileentityblockcompressor.getSizeInventory();++i){
    				ItemStack itemstack = tileentityblockcompressor.getStackInSlot(i);
    				
    				if(itemstack != null){
    					float f = this.random.nextFloat()*0.6F+0.1F;
    					float f1 = this.random.nextFloat()*0.6F+0.1F;
    					float f2 = this.random.nextFloat()*0.6F+0.1F;
    					
    					while(itemstack.stackSize > 0){
    						int j = this.random.nextInt(21)+10;
    						
    						if(j>itemstack.stackSize){
    							j=itemstack.stackSize;
    						}
    						
    						itemstack.stackSize -= j;
    						EntityItem entityitem = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float) z + f2), new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));
    					
    						if(itemstack.hasTagCompound()){
    							entityitem.getEntityItem().setTagCompound(((NBTTagCompound) itemstack.getTagCompound().copy()));
    						}
    						
    						float f3 = 0.025F;
    						entityitem.motionX = (double) ((float) this.random.nextGaussian()*f3);
    						entityitem.motionY = (double) ((float) this.random.nextGaussian()*f3 + 0.1F);
    						entityitem.motionZ = (double) ((float) this.random.nextGaussian()*f3);
    						world.spawnEntityInWorld(entityitem);
    					}
    				}
    			}
    			world.func_147453_f(x, y, z, block);
    		}
    	}
    	super.breakBlock(world, x, y, z, block, meta);
    }

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_){
		return new TileEntityBlockCompressor();
	}
    
}
