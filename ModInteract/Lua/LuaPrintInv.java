package Reika.DragonAPI.ModInteract.Lua;

import java.util.ArrayList;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class LuaPrintInv extends LuaMethod {

	public LuaPrintInv() {
		super("printInv", IInventory.class);
	}

	@Override
	public Object[] invoke(TileEntity te, Object[] args) throws Exception {
		ArrayList<String> li = new ArrayList();
		IInventory ii = (IInventory) te;
		for (int i = 0; i < ii.getSizeInventory(); i++) {
			ItemStack is = ii.getStackInSlot(i);
			String name = is != null ? is.getDisplayName() : "Empty";
			li.add(name);
		}
		return li.toArray();
	}

}