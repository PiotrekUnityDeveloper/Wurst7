/*
 * Copyright (c) 2014-2022 Wurst-Imperium and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package net.wurstclient.hacks;

import net.minecraft.client.option.KeyBinding;
import net.minecraft.util.Hand;
import net.wurstclient.Category;
import net.wurstclient.SearchTags;
import net.wurstclient.events.UpdateListener;
import net.wurstclient.hack.Hack;
import net.wurstclient.mixinterface.IKeyBinding;
import net.wurstclient.settings.SliderSetting;
import net.wurstclient.settings.SliderSetting.ValueDisplay;

@SearchTags({"miley cyrus", "twerk"})
public final class AutoSwingHack extends Hack implements UpdateListener
{
	private final SliderSetting swingSpeed = new SliderSetting("Swing delay",
		"how fast2swing?", 5, 1, 100, 1,
		ValueDisplay.INTEGER);
	
	private int timer;
	
	public AutoSwingHack()
	{
		super("AutoSwing");
		setCategory(Category.GHOST);
		addSetting(swingSpeed);
	}
	
	@Override
	public void onEnable()
	{
		timer = 0;
		EVENTS.add(UpdateListener.class, this);
	}
	
	@Override
	public void onDisable()
	{
		EVENTS.remove(UpdateListener.class, this);
		
		//KeyBinding sneak = MC.options.sneakKey;
		//sneak.setPressed(((IKeyBinding)sneak).isActallyPressed());
	}
	
	@Override
	public void onUpdate()
	{
		timer++;
		if(timer < 50 - swingSpeed.getValueI())
			return;
		
		//MC.options.sneakKey.setPressed(!MC.options.sneakKey.isPressed());
		MC.player.swingHand(Hand.MAIN_HAND);
		timer = -1;
	}
}
