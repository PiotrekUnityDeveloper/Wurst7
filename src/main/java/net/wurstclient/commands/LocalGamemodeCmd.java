/*
 * Copyright (c) 2014-2022 Wurst-Imperium and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package net.wurstclient.commands;

import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameMode;
import net.wurstclient.command.CmdError;
import net.wurstclient.command.CmdException;
import net.wurstclient.command.CmdSyntaxError;
import net.wurstclient.command.Command;
import net.wurstclient.util.MathUtils;

public final class LocalGamemodeCmd extends Command
{
	public LocalGamemodeCmd()
	{
		super("localgamemode", "Changes ur gamemode",
			".localgamemode <index>", "Btw it is clientside",
			"Example: .localgamemode 1 (enabled gamemode creative)",
			"please dont ask why u cant destroy server's lobby with this..");
	}
	
	@Override
	public void call(String[] args) throws CmdException
	{
		if(args.length == 0)
			throw new CmdSyntaxError();
		
		
		
		int amount = parseAmount(args[0]);
		//applyDamage(amount);
		
		if(amount > 3 && amount < 0)
			throw new CmdError("Choose a number from 0 to 3");
		
		MC.interactionManager.setGameMode(GameMode.byId(amount));
	}
	
	private int parseAmount(String dmgString) throws CmdSyntaxError
	{
		if(!MathUtils.isInteger(dmgString))
			throw new CmdSyntaxError("Not a number: " + dmgString);
		
		int dmg = Integer.parseInt(dmgString);
		
		if(dmg < 0)
			throw new CmdSyntaxError("Minimum amount is 0.");
		
		if(dmg > 3)
			throw new CmdSyntaxError("Maximum amount is 3.");
		
		return dmg;
	}
	
	private void applyDamage(int amount)
	{
		Vec3d pos = MC.player.getPos();
		
		for(int i = 0; i < 80; i++)
		{
			sendPosition(pos.x, pos.y + amount + 2.1, pos.z, false);
			sendPosition(pos.x, pos.y + 0.05, pos.z, false);
		}
		
		sendPosition(pos.x, pos.y, pos.z, true);
	}
	
	private void sendPosition(double x, double y, double z, boolean onGround)
	{
		MC.player.networkHandler.sendPacket(
			new PlayerMoveC2SPacket.PositionAndOnGround(x, y, z, onGround));
	}
}
