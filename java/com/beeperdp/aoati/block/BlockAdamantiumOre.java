package com.beeperdp.aoati.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockAdamantiumOre extends Block{
	
	private Item drop;
	private int meta;
	private int least_quantity;
	private int most_quantity;
	
	public IIcon[] icons = new IIcon[6];
	public BlockAdamantiumOre(Material material, Item dropA, int metaA, int least_quantityA, int most_quantityA) {
		super(material);
		this.drop = dropA;
		this.meta = metaA;
		this.least_quantity = least_quantityA;
		this.most_quantity = most_quantityA;
		this.setHardness(3.5F);
		this.setResistance(150F);
		this.setBlockName("blockAdamantiumOre");
		this.setBlockTextureName("aoati:blockAdamantiumOre");
		this.setHardness(2F);
		this.setResistance(1600F);
		this.setLightLevel(0F);
		this.setHarvestLevel("pickaxe", 2);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister reg) {
	    for (int i = 0; i < 6; i ++) {
	        this.icons[i] = reg.registerIcon(this.textureName + "_" + i);
	    }
	}
	
	@Override
	public IIcon getIcon(int side, int meta) {
	    return this.icons[side];
	}
	
	@Override
	public Item getItemDropped(int meta, Random random, int fortune) {
	    return this.drop;
	}

	@Override
	public int damageDropped(int metadata) {
	    return this.meta;
	}

	@Override
	public int quantityDropped(int meta, int fortune, Random random) {
	    if (this.least_quantity >= this.most_quantity)
	        return this.least_quantity;
	    return this.least_quantity + random.nextInt(this.most_quantity - this.least_quantity + fortune + 1);
	}
	
}
