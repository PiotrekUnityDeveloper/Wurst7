/*
 * Copyright (c) 2014-2022 Wurst-Imperium and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package net.wurstclient;

public enum Category
{
	COMBAT("Combat"),
	BLATANT("Blatant"),
	PLAYER("Player"),
	MOVEMENT("Movement"),
	RENDER("Render"),
	BLOCKS("Blocks"),
	CHAT("Chat"),
    GHOST("Ghost"),
	FUN("Fun"),
	ITEMS("Items"),
	CLIENT("Client"),
	OTHER("Other");
	
	private final String name;
	
	private Category(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
}
