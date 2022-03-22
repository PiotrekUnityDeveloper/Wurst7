/*
 * Copyright (c) 2014-2022 Wurst-Imperium and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package net.wurstclient.hacks;

import net.wurstclient.Category;
import net.wurstclient.SearchTags;
import net.wurstclient.hack.Hack;
import net.wurstclient.settings.SliderSetting;
import net.wurstclient.settings.SliderSetting.ValueDisplay;

@SearchTags({"range"})
public final class ReachHack extends Hack
{
	private final SliderSetting range =
		new SliderSetting("Range", 6, 1, 20, 0.05, ValueDisplay.DECIMAL);
	
	private final SliderSetting rangedev =
			new SliderSetting("Range Deviation", 0, 0, 4, 0.001, ValueDisplay.DECIMAL);
	
	public ReachHack()
	{
		super("Reach");
		setCategory(Category.OTHER);
		addSetting(range);
		addSetting(rangedev);
	}
	
	public float getReachDistance()
	{
		return range.getValueF();
	}
	
	// See ClientPlayerInteractionManagerMixin.onGetReachDistance() and
	// ClientPlayerInteractionManagerMixin.hasExtendedReach()
}
