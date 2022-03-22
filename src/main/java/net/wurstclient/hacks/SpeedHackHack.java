/*
 * Copyright (c) 2014-2022 Wurst-Imperium and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package net.wurstclient.hacks;

import net.minecraft.util.math.Vec3d;
import net.wurstclient.Category;
import net.wurstclient.SearchTags;
import net.wurstclient.events.UpdateListener;
import net.wurstclient.hack.Hack;
import net.wurstclient.settings.CheckboxSetting;
import net.wurstclient.settings.SliderSetting;
import net.wurstclient.settings.SliderSetting.ValueDisplay;

@SearchTags({"speed hack"})
public final class SpeedHackHack extends Hack implements UpdateListener
{
	private final SliderSetting speed =
			new SliderSetting("Speed", 5, 1, 6, 0.05, ValueDisplay.DECIMAL);
	
	private final SliderSetting maxspeed =
			new SliderSetting("Max Speed", 5, 1, 6, 0.05, ValueDisplay.DECIMAL);
	
	private final CheckboxSetting siema =
			new CheckboxSetting("Default Speed", true);
			
	public SpeedHackHack()
	{
		super("SpeedHack");
		setCategory(Category.MOVEMENT);
		addSetting(speed);
		addSetting(maxspeed);
		addSetting(siema);
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
		if(siema.isChecked() == true)
		{
			// return if sneaking or not walking
			if(MC.player.isSneaking()
				|| MC.player.forwardSpeed == 0 && MC.player.sidewaysSpeed == 0)
				return;
			
			// activate sprint if walking forward
			if(MC.player.forwardSpeed > 0 && !MC.player.horizontalCollision)
				MC.player.setSprinting(true);
			
			// activate mini jump if on ground
			if(!MC.player.isOnGround())
				return;
			
			Vec3d v = MC.player.getVelocity();
			MC.player.setVelocity(v.x * 1.8, v.y + 0.1, v.z * 1.8);
			
			v = MC.player.getVelocity();
			double currentSpeed = Math.sqrt(Math.pow(v.x, 2) + Math.pow(v.z, 2));
			
			// limit speed to highest value that works on NoCheat+ version
			// 3.13.0-BETA-sMD5NET-b878
			// UPDATE: Patched in NoCheat+ version 3.13.2-SNAPSHOT-sMD5NET-b888
			double maxSpeed = 0.66F;
			
			if(currentSpeed > maxSpeed)
				MC.player.setVelocity(v.x / currentSpeed * maxSpeed, v.y,
					v.z / currentSpeed * maxSpeed);
		}
		else
		{
			//use custom speed setting here
			// return if sneaking or not walking
						if(MC.player.isSneaking()
							|| MC.player.forwardSpeed == 0 && MC.player.sidewaysSpeed == 0)
							return;
						
						// activate sprint if walking forward
						if(MC.player.forwardSpeed > 0 && !MC.player.horizontalCollision)
							MC.player.setSprinting(true);
						
						// activate mini jump if on ground
						if(!MC.player.isOnGround())
							return;
						
						Vec3d v = MC.player.getVelocity();
						MC.player.setVelocity(v.x * speed.getValue(), v.y + 0.1, v.z * speed.getValue());
						
						v = MC.player.getVelocity();
						double currentSpeed = Math.sqrt(Math.pow(v.x, 2) + Math.pow(v.z, 2));
						
						// limit speed to highest value that works on NoCheat+ version
						// 3.13.0-BETA-sMD5NET-b878
						// UPDATE: Patched in NoCheat+ version 3.13.2-SNAPSHOT-sMD5NET-b888
						double maxSpeed = maxspeed.getValue();
						
						if(currentSpeed > maxSpeed)
							MC.player.setVelocity(v.x / currentSpeed * maxSpeed, v.y,
								v.z / currentSpeed * maxSpeed);
		}
		
		
	}
}
