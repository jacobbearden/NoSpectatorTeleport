package com.aefonix.nospectatorteleport;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

public class NoSpectatorTeleport extends JavaPlugin implements Listener {
  @Override
  public void onEnable() {
    this.getServer().getPluginManager().addPermission(new Permission("nospectatorteleport.bypass"));
    this.getServer().getPluginManager().registerEvents(this, this);
  }

  @Override
  public void onDisable() {}

  @EventHandler
  final void onPlayerTeleportEvent(PlayerTeleportEvent event) {
    if (!event.isCancelled() && !event.getPlayer().hasPermission("nospectatorteleport.bypass")) {
      if (event.getPlayer().getGameMode() == GameMode.SPECTATOR && event.getCause().equals(TeleportCause.SPECTATE)) {
        event.setCancelled(true);
      }
    }
  }
}
