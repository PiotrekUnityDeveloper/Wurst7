/*
 * Copyright (c) 2014-2022 Wurst-Imperium and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package net.wurstclient.hacks;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.wurstclient.Category;
import net.wurstclient.events.UpdateListener;
import net.wurstclient.hack.Hack;
import net.wurstclient.settings.SliderSetting;
import net.wurstclient.settings.SliderSetting.ValueDisplay;
import net.wurstclient.util.BlockUtils;

public final class LevitatorHack extends Hack implements UpdateListener
{
	private final SliderSetting levitaionSpeed = new SliderSetting("Levitation speed",
		0.125, 0.005, 1, 0.005, ValueDisplay.DECIMAL);
	
	private final SliderSetting moveSpeed =
		new SliderSetting("Move speed", "Horizontal movement factor.", 1, 0.05,
			20, 0.05, ValueDisplay.PERCENTAGE);
	
	
	
	public LevitatorHack()
	{
		super("Levitator");
		
		setCategory(Category.MOVEMENT);
		addSetting(levitaionSpeed);
		addSetting(moveSpeed);
		//addSetting(minHeight);
	}
	
	@Override
	public void onEnable()
	{
		EVENTS.add(UpdateListener.class, this);
	}
	
	@Override
	public void onDisable()
	{
		EVENTS.remove(UpdateListener.class, this);
	}
	
	@Override
	public void onUpdate()
	{
		ClientPlayerEntity player = MC.player;
		Vec3d v = player.getVelocity();
		
		
		
		if(player.isClimbing() || v.y >= 0)
			return; 
		
		//yayyy, flyying!

		player.setVelocity(v.x, Math.max(v.y, levitaionSpeed.getValue()), v.z);
		player.airStrafingSpeed *= moveSpeed.getValueF();
	}
}
