# Wurst Client v7 Custom Development [Bigos Client]
i know there are like 300 wurst client forks but i was bored, okay? So this is a list of modules i added:
- AimBot (instantly aims at entities)
- SmoothAim (smoothly aims at entities)
- ClickAimBot (aims instantly/partially at entities)
- AutoSwing (swings player's main hand every set(X) seconds)
- AutoBucketMLG (makes water bucket mlg's to avoid fall damage)

Module Changes:
- Made ScaffoldWalk place blocks only on the same Y position the player was standing on when enabling the module - 1 (below player's feet)
- Added module called Scaffold which acts like the old ScaffoldWalk module

ClickGUI Changes:
Added 4 New Tabs:
- Player
- Ghost
- Blatant
- Client (currently, this one is empty)

Moved some modules from Combat tab to Blatant and Ghost tabs.

##Planned Features:
- AimAssist module (lowers mouse sensitivity when hovering over an enemy)
- EntityLookFOV (renders a camera fov of an enemy, so u can tell if they see you from the corner of the screen. And yes i know this has no practical use)
- AirJump, AirPlace
- SuperHot Slowmotion module which stops time with timer when player is not moving :D
- CrystalPVP modules
- More Killaura options
- and Generally more modules
==================================================================================================================================================
hope u enjoy

## ⚠ We Are Looking For Translators & Proofreaders ⚠

Mostly proofreaders. Many translations are currently stuck because we have no one who can proofread them. See table below and the ["reviews wanted" label](https://github.com/Wurst-Imperium/Wurst7/pulls?q=is%3Aopen+label%3A%22reviews+wanted%22+label%3Atranslation).

### Current Status of Translations

|Language|Status|
|--------|--------|
|Chinese (Simplified/Mainland)|Pending changes: [#574](https://github.com/Wurst-Imperium/Wurst7/pull/574), [#588](https://github.com/Wurst-Imperium/Wurst7/pull/588)|
|Chinese (Traditional/Taiwan)|151/154 done|
|Chinese (Cantonese/Hong Kong)|154/154 done|
|French (France)|There are 3 pending submissions ([#515](https://github.com/Wurst-Imperium/Wurst7/pull/515), [#531](https://github.com/Wurst-Imperium/Wurst7/pull/531), [#552](https://github.com/Wurst-Imperium/Wurst7/pull/552)) with different translations and I don't know which one to merge. If you speak French, please check these submissions for any grammatical errors and let me know which one sounds best to a native speaker.|
|German (Germany)|53/154 done. I'll probably do the rest myself since I can speak it natively.|
|Italian (Italy)|146/154 done|
|Japanese (Japan)|137/154 done|
|Polish (Poland)|154/154 done|
|Portugese (Brazil)|Pending, needs reviews, check [#528](https://github.com/Wurst-Imperium/Wurst7/pull/528).|
|Russian (Russia)|Pending changes: [#572](https://github.com/Wurst-Imperium/Wurst7/pull/572)|
|Turkish (Turkey)|There are 2 pending submissions ([#511](https://github.com/Wurst-Imperium/Wurst7/pull/511), [#512](https://github.com/Wurst-Imperium/Wurst7/pull/512)) with different translations and I don't know which one to merge. If you speak Turkish, please check these submissions for any grammatical errors and let me know which one sounds best to a native speaker. |
|Ukrainian (Ukraine)|137/154 done|

If you speak both English and some other language, please help us by translating Wurst or reviewing existing translations. The translation files are located [here](https://github.com/Wurst-Imperium/Wurst7/tree/master/src/main/resources/assets/wurst/lang) and work the same as in other Minecraft mods.

Names of features (hacks/commands/etc.) should always be kept in English. This ensures that everyone can use the same commands, keybinds, etc. regardless of their language setting. It also makes it easier to communicate with someone who uses Wurst in a different language.

For discussion about translations, see [Issue #404](https://github.com/Wurst-Imperium/Wurst7/issues/404) here or [#wurst-translations](https://chat.wurstimperium.net/channel/wurst-translations) on our RocketChat server.

## Downloads (for users)

https://www.wurstclient.net/download/

## Setup (for developers) (using Windows 10 & Eclipse)

Requirements: [JDK 17](https://adoptium.net/?variant=openjdk17&jvmVariant=hotspot)

1. Run these two commands in PowerShell:

```
./gradlew.bat genSources
./gradlew.bat eclipse
```

2. In Eclipse, go to `Import...` > `Existing Projects into Workspace` and select this project.

## License

This code is licensed under the GNU General Public License v3. **You can only use this code in open-source clients that you release under the same license! Using it in closed-source/proprietary clients is not allowed!**

## Note about Pull Requests

If you are contributing multiple unrelated features, please create a separate pull request for each feature. Squeezing everything into one giant pull request makes it very difficult for us to add your features, as we have to test, validate and add them one by one.

Thank you for your understanding - and thanks again for taking the time to contribute!!




...also

**Thanks for help with understanding how SmoothAim works (Meteor client devs)**
https://github.com/MeteorDevelopment/meteor-client/blob/master/src/main/java/meteordevelopment/meteorclient/systems/modules/combat/AimAssist.java
