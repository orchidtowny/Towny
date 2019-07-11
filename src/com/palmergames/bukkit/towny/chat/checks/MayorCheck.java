package com.palmergames.bukkit.towny.chat.checks;

import com.palmergames.bukkit.towny.TownyUniverse;
import com.palmergames.bukkit.towny.exceptions.NotRegisteredException;
import net.tnemc.tnc.core.common.chat.ChatCheck;
import org.bukkit.entity.Player;

/**
 * @author creatorfromhell
 */
public class MayorCheck extends ChatCheck {
	@Override
	public String name() {
		return "ismayor";
	}

	@Override
	public boolean runCheck(Player player, String checkString) {
		try {
			if(TownyUniverse.getInstance().getDatabase().getResident(player.getName()).hasTown()) {
				return TownyUniverse.getInstance().getDatabase().getResident(player.getName()).getTown().isMayor(TownyUniverse.getInstance().getDatabase().getResident(player.getName()));
			}
		} catch(NotRegisteredException ignore) {
		}
		return false;
	}
}