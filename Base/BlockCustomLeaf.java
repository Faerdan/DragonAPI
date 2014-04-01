/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2014
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.DragonAPI.Base;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import Reika.DragonAPI.ModRegistry.ModWoodList;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;

public abstract class BlockCustomLeaf extends BlockLeaves {

	/** For fast/fancy graphics */
	protected Icon[][] icon = new Icon[16][2];

	protected final Random rand = new Random();

	protected BlockCustomLeaf(int ID) {
		super(ID);
		this.setCreativeTab(this.showInCreative() ? this.getCreativeTab() : null);
		this.setStepSound(Block.soundGrassFootstep);
		if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
			this.setGraphicsLevel(Minecraft.getMinecraft().gameSettings.fancyGraphics);
		this.setHardness(0.2F);
		this.setLightOpacity(1);
		this.setTickRandomly(this.decays() || this.shouldRandomTick());
	}

	/** Overridden to allow conditional disabling of mod leaf control hacks, like the one in RandomThings. */
	@Override
	public final void onNeighborBlockChange(World world, int x, int y, int z, int neighborID) {
		this.onBlockUpdate(world, x, y, z);
		if (this.allowModDecayControl()) {
			super.onNeighborBlockChange(world, x, y, z, neighborID);
		}
		else {

		}
	}

	protected void onBlockUpdate(World world, int x, int y, int z) {

	}

	public abstract boolean shouldRandomTick();

	public abstract boolean decays();

	public abstract boolean allowModDecayControl();

	public abstract boolean showInCreative();

	public abstract CreativeTabs getCreativeTab();

	@Override
	public final Icon getIcon(int par1, int par2)
	{
		return icon[par2][this.getOpacityIndex()];
	}

	private final int getOpacityIndex() {
		graphicsLevel = Minecraft.getMinecraft().gameSettings.fancyGraphics;
		return graphicsLevel ? 0 : 1;
	}

	@Override
	public int getFlammability(IBlockAccess world, int x, int y, int z, int metadata, ForgeDirection face)
	{
		return 30;
	}

	@Override
	public int getFireSpreadSpeed(World world, int x, int y, int z, int metadata, ForgeDirection face)
	{
		return 60;
	}

	@Override
	public final void updateTick(World world, int x, int y, int z, Random par5Random)
	{
		int meta = world.getBlockMetadata(x, y, z);
		//ReikaJavaLibrary.pConsole(blockID+" @ "+x+", "+y+", "+z+"  : "+this.decays()+"&"+this.shouldTryDecay(world, x, y, z, meta));
		boolean flag = false;
		if (this.decays() && this.shouldTryDecay(world, x, y, z, meta)) {
			flag = this.decay(world, x, y, z, par5Random);
		}
		if (!flag)
			this.onRandomUpdate(world, x, y, z, par5Random);
	}

	protected void onRandomUpdate(World world, int x, int y, int z, Random r) {

	}

	public abstract boolean shouldTryDecay(World world, int x, int y, int z, int meta);

	protected boolean decay(World world, int x, int y, int z, Random par5Random) {
		int r = 4;
		boolean decay = true;
		for (int i = -r; i <= r; i++) {
			for (int j = -r; j <= r; j++) {
				for (int k = -r; k <= r; k++) {
					int id = world.getBlockId(x+i, y+j, z+k);
					int meta = world.getBlockMetadata(x+i, y+j, z+k);
					if (id == Block.wood.blockID || ModWoodList.isModWood(id, meta)) {
						decay = false;
						i = j = k = r+1;
					}
				}
			}
		}

		boolean hasAdj = false;
		for (int i = 0; i < 6; i++) {
			ForgeDirection dir = ForgeDirection.VALID_DIRECTIONS[i];
			int dx = x+dir.offsetX;
			int dy = y+dir.offsetY;
			int dz = z+dir.offsetZ;
			int id = world.getBlockId(dx, dy, dz);
			if (id != 0) {
				hasAdj = true;
				i = 6;
			}
		}
		if (!hasAdj)
			decay = true;

		int meta = world.getBlockMetadata(x, y, z);
		if (decay) {
			this.dropBlockAsItemWithChance(world, x, y, z, meta, 1, 0);
			world.setBlock(x, y, z, 0);
		}
		return decay;
	}

	@Override
	public final void beginLeavesDecay(World world, int x, int y, int z)
	{
		if (this.decays()) {

		}
	}

	@Override
	public final void registerIcons(IconRegister ico)
	{
		for (int i = 0; i < 16; i++) {
			icon[i][0] = ico.registerIcon(this.getFancyGraphicsIcon(i));
			icon[i][1] = ico.registerIcon(this.getFastGraphicsIcon(i));
		}
	}

	public abstract String getFastGraphicsIcon(int meta);
	public abstract String getFancyGraphicsIcon(int meta);

}
