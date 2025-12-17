package dev.colbster937.papi.expansions.smallcaps;

import org.bukkit.plugin.java.JavaPlugin;

public class SmallCapsBukkitPlugin extends JavaPlugin {
  @Override
  public void onEnable() {
    (new SmallCapsPAPIExpansion()).register();
  }
}
