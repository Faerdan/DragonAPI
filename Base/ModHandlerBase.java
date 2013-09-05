/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2013
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.DragonAPI.Base;

import Reika.DragonAPI.Auxiliary.APIRegistry;
import Reika.DragonAPI.Libraries.Java.ReikaJavaLibrary;

/** Reflection tools to read other mods. */
public abstract class ModHandlerBase {

	protected ModHandlerBase() {
		ReikaJavaLibrary.pConsole("Loading handler for mod "+this.getMod());
	}

	public abstract boolean initializedProperly();

	public abstract APIRegistry getMod();

	protected void noMod() {
		//throw new ModHandlerException(this.getMod());
	}

	public boolean hasMod() {
		return this.getMod().conditionsMet();
	}

}
