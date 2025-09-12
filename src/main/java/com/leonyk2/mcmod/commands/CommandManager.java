package com.leonyk2.mcmod.commands;

import com.leonyk2.mcmod.commands.afk.AfkCommand;
import com.leonyk2.mcmod.commands.antrag.AntragCommand;
import com.leonyk2.mcmod.commands.home.HomeCommand;
import com.leonyk2.mcmod.commands.nbt.DumpAllPossibleNbtCommand;
import com.leonyk2.mcmod.commands.nbt.DumpNbtCommand;
import com.leonyk2.mcmod.commands.others.OthersCommand;
import com.leonyk2.mcmod.commands.viewCoords.ViewCoordsCommand;
import com.mojang.brigadier.CommandDispatcher;

import net.minecraft.commands.CommandSourceStack;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class CommandManager {
	@SubscribeEvent
	public static void onCommandRegister(RegisterCommandsEvent event) {
		CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();

		//afk
		//afk scoreboard init:      "/afk-init"               (nur op)
		//afk gehen:                "/afk"
		//afk raus gehen:           "/un-afk"
		//							bewegen wärend afk
		AfkCommand.register(dispatcher);

		//anträge
		//antrag stellen:            "/antrag ..."
		//antrag löschen:			 "/antrag delete ID"       (wenn op kann alle löschen, wenn normale user nur eigene)
		//anträge listen:            "/antrag list"            (nur op)
		//anträge annehmen/ablehnen: "/antrag akzeptieren ID"  (nur op)
		//							 "/antrag ablehnen ID"     (nur op)
		AntragCommand.register(dispatcher);

		//home -- private
		//home position setzen:      "/home set ID"
		//zur home position tp		 "/home tp ID"
		//home position löschen		 "/home clear ID"          (wenn op kann alle clear, wenn nicht nur eigene)
		//home -- public
		//home position setzen:      "/home public set ID"
		//zur home position tp		 "/home public tp ID"
		//home position löschen		 "/home public clear ID"   (wenn op kann alle clear, wenn nicht nur eigene)
		HomeCommand.register(dispatcher);

		//viewCoords
		//view coords of a player    "/viewCoords PLAYER"	   (nur op)
		ViewCoordsCommand.register(dispatcher);

		//others
		//-->nv
		//   give all players nv     "/nv"					   (nur op)
		//-->randomTickSpeed
		//   change rts gamerule     "/randomTickSpeed NUM)    (nur op)
		OthersCommand.register(dispatcher, event.getBuildContext());

        //dumptNbt
        //dump nbt data of held item "/dumpNbt"
        DumpNbtCommand.register(dispatcher);

        DumpAllPossibleNbtCommand.register(dispatcher);
	}
}
