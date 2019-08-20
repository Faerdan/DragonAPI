package Reika.DragonAPI.Instantiable;

import net.minecraft.util.IIcon;
import net.minecraft.util.Vec3;
import net.minecraftforge.common.util.ForgeDirection;

import Reika.DragonAPI.Instantiable.GridDistortion.OffsetGroup;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CubePoints {

	public final CubeVertex x1y1z1;
	public final CubeVertex x2y1z1;
	public final CubeVertex x1y1z2;
	public final CubeVertex x2y1z2;

	public final CubeVertex x1y2z1;
	public final CubeVertex x2y2z1;
	public final CubeVertex x1y2z2;
	public final CubeVertex x2y2z2;

	public CubePoints(Vec3 x1y1z1, Vec3 x2y1z1, Vec3 x1y1z2, Vec3 x2y1z2, Vec3 x1y2z1, Vec3 x2y2z1, Vec3 x1y2z2, Vec3 x2y2z2) {
		this.x1y1z1 = new CubeVertex(x1y1z1);
		this.x2y1z1 = new CubeVertex(x2y1z1);
		this.x1y1z2 = new CubeVertex(x1y1z2);
		this.x2y1z2 = new CubeVertex(x2y1z2);

		this.x1y2z1 = new CubeVertex(x1y2z1);
		this.x2y2z1 = new CubeVertex(x2y2z1);
		this.x1y2z2 = new CubeVertex(x1y2z2);
		this.x2y2z2 = new CubeVertex(x2y2z2);
	}

	public void applyOffset(ForgeDirection side, OffsetGroup off) {
		switch(side) {
			case DOWN:
				x1y1z1.position.xCoord += off.offsetAMM;
				x2y1z1.position.xCoord += off.offsetAPM;
				x1y1z2.position.xCoord += off.offsetAMP;
				x2y1z2.position.xCoord += off.offsetAPP;
				x1y1z1.position.zCoord += off.offsetBMM;
				x2y1z1.position.zCoord += off.offsetBPM;
				x1y1z2.position.zCoord += off.offsetBMP;
				x2y1z2.position.zCoord += off.offsetBPP;
				break;
			case UP:
				x1y2z1.position.xCoord += off.offsetAMM;
				x2y2z1.position.xCoord += off.offsetAPM;
				x1y2z2.position.xCoord += off.offsetAMP;
				x2y2z2.position.xCoord += off.offsetAPP;
				x1y2z1.position.zCoord += off.offsetBMM;
				x2y2z1.position.zCoord += off.offsetBPM;
				x1y2z2.position.zCoord += off.offsetBMP;
				x2y2z2.position.zCoord += off.offsetBPP;
				break;
			case WEST:
				x1y1z1.position.yCoord += off.offsetAMM;
				x1y2z1.position.yCoord += off.offsetAPM;
				x1y1z2.position.yCoord += off.offsetAMP;
				x1y2z2.position.yCoord += off.offsetAPP;
				x1y1z1.position.zCoord += off.offsetBMM;
				x1y2z1.position.zCoord += off.offsetBPM;
				x1y1z2.position.zCoord += off.offsetBMP;
				x1y2z2.position.zCoord += off.offsetBPP;
				break;
			case EAST:
				x2y1z1.position.yCoord += off.offsetAMM;
				x2y2z1.position.yCoord += off.offsetAPM;
				x2y1z2.position.yCoord += off.offsetAMP;
				x2y2z2.position.yCoord += off.offsetAPP;
				x2y1z1.position.zCoord += off.offsetBMM;
				x2y2z1.position.zCoord += off.offsetBPM;
				x2y1z2.position.zCoord += off.offsetBMP;
				x2y2z2.position.zCoord += off.offsetBPP;
				break;
			case NORTH:
				x1y1z1.position.xCoord += off.offsetAMM;
				x2y1z1.position.xCoord += off.offsetAPM;
				x1y2z1.position.xCoord += off.offsetAMP;
				x2y2z1.position.xCoord += off.offsetAPP;
				x1y1z1.position.yCoord += off.offsetBMM;
				x2y1z1.position.yCoord += off.offsetBPM;
				x1y2z1.position.yCoord += off.offsetBMP;
				x2y2z1.position.yCoord += off.offsetBPP;
				break;
			case SOUTH:
				x1y1z2.position.xCoord += off.offsetAMM;
				x2y1z2.position.xCoord += off.offsetAPM;
				x1y2z2.position.xCoord += off.offsetAMP;
				x2y2z2.position.xCoord += off.offsetAPP;
				x1y1z2.position.yCoord += off.offsetBMM;
				x2y1z2.position.yCoord += off.offsetBPM;
				x1y2z2.position.yCoord += off.offsetBMP;
				x2y2z2.position.yCoord += off.offsetBPP;
				break;
			default:
				break;
		}
	}

	public void setSidePosition(ForgeDirection side, double val) {
		switch(side) {
			case DOWN:
				x1y1z1.position.yCoord = val;
				x2y1z1.position.yCoord = val;
				x2y1z2.position.yCoord = val;
				x1y1z2.position.yCoord = val;
				break;
			case UP:
				x1y2z1.position.yCoord = val;
				x2y2z1.position.yCoord = val;
				x2y2z2.position.yCoord = val;
				x1y2z2.position.yCoord = val;
				break;
			case WEST:
				x1y1z1.position.xCoord = val;
				x1y2z1.position.xCoord = val;
				x1y2z2.position.xCoord = val;
				x1y1z2.position.xCoord = val;
				break;
			case EAST:
				x2y1z1.position.xCoord = val;
				x2y2z1.position.xCoord = val;
				x2y2z2.position.xCoord = val;
				x2y1z2.position.xCoord = val;
				break;
			case NORTH:
				x1y1z1.position.zCoord = val;
				x1y2z1.position.zCoord = val;
				x2y2z1.position.zCoord = val;
				x2y1z1.position.zCoord = val;
				break;
			case SOUTH:
				x1y1z2.position.zCoord = val;
				x1y2z2.position.zCoord = val;
				x2y2z2.position.zCoord = val;
				x2y1z2.position.zCoord = val;
				break;
			default:
				break;
		}
	}

	@SideOnly(Side.CLIENT)
	public double getTextureU(IIcon ico, ForgeDirection side) {
		switch(side) {
			case DOWN:
				return ico.getInterpolatedU(16*x1y1z1.position.xCoord);
			case UP:
				return ico.getInterpolatedU(16*x1y2z1.position.xCoord);
			case WEST:
				return ico.getInterpolatedU(16*x1y1z1.position.zCoord);
			case EAST:
				return ico.getInterpolatedU(16*x2y1z1.position.zCoord);
			case NORTH:
				return ico.getInterpolatedU(16*x1y1z1.position.xCoord);
			case SOUTH:
				return ico.getInterpolatedU(16*x1y1z2.position.xCoord);
			default:
				return 0;
		}
	}

	@SideOnly(Side.CLIENT)
	public double getTextureDU(IIcon ico, ForgeDirection side) {
		switch(side) {
			case DOWN:
				return ico.getInterpolatedU(16*x2y1z1.position.xCoord);
			case UP:
				return ico.getInterpolatedU(16*x2y2z1.position.xCoord);
			case WEST:
				return ico.getInterpolatedU(16*x1y1z2.position.zCoord);
			case EAST:
				return ico.getInterpolatedU(16*x2y1z2.position.zCoord);
			case NORTH:
				return ico.getInterpolatedU(16*x2y1z1.position.xCoord);
			case SOUTH:
				return ico.getInterpolatedU(16*x2y1z2.position.xCoord);
			default:
				return 0;
		}
	}

	@SideOnly(Side.CLIENT)
	public double getTextureV(IIcon ico, ForgeDirection side) {
		switch(side) {
			case DOWN:
				return ico.getInterpolatedV(16*x1y1z1.position.zCoord);
			case UP:
				return ico.getInterpolatedV(16*x1y2z1.position.zCoord);
			case WEST:
				return ico.getInterpolatedV(16*x1y1z1.position.yCoord);
			case EAST:
				return ico.getInterpolatedV(16*x2y1z1.position.yCoord);
			case NORTH:
				return ico.getInterpolatedV(16*x1y1z1.position.yCoord);
			case SOUTH:
				return ico.getInterpolatedV(16*x1y1z2.position.yCoord);
			default:
				return 0;
		}
	}

	@SideOnly(Side.CLIENT)
	public double getTextureDV(IIcon ico, ForgeDirection side) {
		switch(side) {
			case DOWN:
				return ico.getInterpolatedV(16*x1y1z2.position.zCoord);
			case UP:
				return ico.getInterpolatedV(16*x1y2z2.position.zCoord);
			case WEST:
				return ico.getInterpolatedV(16*x1y2z2.position.yCoord);
			case EAST:
				return ico.getInterpolatedV(16*x2y2z2.position.yCoord);
			case NORTH:
				return ico.getInterpolatedV(16*x2y2z1.position.yCoord);
			case SOUTH:
				return ico.getInterpolatedV(16*x2y2z2.position.yCoord);
			default:
				return 0;
		}
	}

	public static final class CubeVertex {

		public final Vec3 position;

		private CubeVertex(Vec3 pos) {
			position = pos;
		}

	}

	public static CubePoints fullBlock() {
		return new CubePoints(Vec3.createVectorHelper(0, 0, 0), Vec3.createVectorHelper(1, 0, 0), Vec3.createVectorHelper(0, 0, 1), Vec3.createVectorHelper(1, 0, 1), Vec3.createVectorHelper(0, 1, 0), Vec3.createVectorHelper(1, 1, 0), Vec3.createVectorHelper(0, 1, 1), Vec3.createVectorHelper(1, 1, 1));
	}

}