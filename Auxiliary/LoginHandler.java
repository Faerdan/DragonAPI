/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2013
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.DragonAPI.Auxiliary;

import java.util.List;

import Reika.DragonAPI.ModList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;
import cpw.mods.fml.common.IPlayerTracker;

public final class LoginHandler implements IPlayerTracker {

	public static final LoginHandler instance = new LoginHandler();

	private static final String reikaMessage = getReikaWelcome();

	private LoginHandler() {

	}

	private static String getReikaWelcome() {
		StringBuilder sb = new StringBuilder();
		sb.append("Welcome ");
		sb.append(EnumChatFormatting.LIGHT_PURPLE.toString()+"Reika");
		sb.append(EnumChatFormatting.WHITE.toString()+", Developer of:\n");
		sb.append(EnumChatFormatting.GOLD.toString()+"   DragonAPI\n");
		List<ModList> li = ModList.getReikasMods();
		for (int i = 0; i < li.size(); i++) {
			ModList mod = li.get(i);
			sb.append(EnumChatFormatting.GOLD.toString()+"   ");
			sb.append(mod.getModLabel());
			sb.append(" ");
			if (mod.isLoaded()) {
				sb.append(EnumChatFormatting.GREEN.toString()+"(Installed)");
			}
			else {
				sb.append(EnumChatFormatting.RED.toString()+"(Not Installed)");
			}
			sb.append(EnumChatFormatting.WHITE.toString()+"\n");
		}
		sb.append("to the server!");
		return sb.toString();
	}

	@Override
	public void onPlayerLogin(EntityPlayer ep) {
		if ("Reika_Kalseki".equals(ep.getEntityName())) {
			ChatMessageComponent chat = new ChatMessageComponent();
			chat.addText(reikaMessage);
			MinecraftServer.getServer().getConfigurationManager().sendChatMsg(chat);
		}
	}

	@Override
	public void onPlayerLogout(EntityPlayer player) {

	}

	@Override
	public void onPlayerChangedDimension(EntityPlayer player) {

	}

	@Override
	public void onPlayerRespawn(EntityPlayer player) {

	}

}
