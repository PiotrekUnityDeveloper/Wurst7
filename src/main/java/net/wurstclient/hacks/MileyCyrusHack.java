/*
 * Copyright (c) 2014-2022 Wurst-Imperium and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package net.wurstclient.hacks;

import net.minecraft.client.option.KeyBinding;
import net.wurstclient.Category;
import net.wurstclient.SearchTags;
import net.wurstclient.events.UpdateListener;
import net.wurstclient.hack.Hack;
import net.wurstclient.mixinterface.IKeyBinding;
import net.wurstclient.settings.SliderSetting;
import net.wurstclient.settings.SliderSetting.ValueDisplay;

@SearchTags({"miley cyrus", "twerk"})
public final class MileyCyrusHack extends Hack implements UpdateListener
{
	private final SliderSetting twerkSpeed = new SliderSetting("Twerk speed",
		"yes", 5, 1, 10, 1,
		ValueDisplay.INTEGER);
	
	private int timer;
	
	public MileyCyrusHack()
	{
		super("MileyCyrus");
		setCategory(Category.FUN);
		addSetting(twerkSpeed);
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
		
		KeyBinding sneak = MC.options.sneakKey;
		sneak.setPressed(((IKeyBinding)sneak).isActallyPressed());
	}
	
	@Override
	public void onUpdate()
	{
		timer++;
		if(timer < 10 - twerkSpeed.getValueI())
			return;
		
		MC.options.sneakKey.setPressed(!MC.options.sneakKey.isPressed());
		timer = -1;
	}
}
