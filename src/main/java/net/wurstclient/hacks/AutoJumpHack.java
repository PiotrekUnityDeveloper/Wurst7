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
import net.wurstclient.settings.CheckboxSetting;

@SearchTags({"auto jump", "jumping"})
public final class AutoJumpHack extends Hack implements UpdateListener
{
	private final CheckboxSetting inair =
			new CheckboxSetting("In Air", false);
	
	public AutoJumpHack()
	{
		super("AutoJump", "Jumps for you");
		setCategory(Category.MOVEMENT);
		addSetting(inair);
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
		
		///KeyBinding forwardKey = MC.options.forwardKey;
		///forwardKey.setPressed(((IKeyBinding)forwardKey).isActallyPressed());
	}
	
	@Override
	public void onUpdate()
	{
		///MC.options.forwardKey.setPressed(true);
		
		if(MC.player.isOnGround() == true && inair.isChecked() == false)
		{
			MC.player.jump();
		}
		else if(inair.isChecked() == true)
		{
			MC.player.jump();
		}
	}
}
