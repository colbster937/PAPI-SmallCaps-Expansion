package dev.colbster937.papi.expansions.smallcaps;

import java.util.Map;
import java.util.HashMap;
import java.util.regex.Pattern;

import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.Configurable;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;

import org.bukkit.OfflinePlayer;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.ViaAPI;


@SuppressWarnings("unchecked")
public class SmallCapsPAPIExpansion extends PlaceholderExpansion implements Configurable {
  private static final Map<String, Object> CONFIG_DEFAULTS = new HashMap<String, Object>();
  
  private boolean version_safe;
  private ViaAPI<OfflinePlayer> via;

  @Override
  public String getIdentifier() {
    return "${expansion_id}";
  }

  @Override
  public String getVersion() {
    return "${expansion_version}";
  }

  @Override
  public String getRequiredPlugin() {
    return "${expansion_depend}";
  }

  @Override
  public String getAuthor() {
    return "${expansion_author}";
  }

  @Override
  public boolean register() {
    this.version_safe = this.getBoolean("version_safe", (boolean) CONFIG_DEFAULTS.get("version_safe"));
    this.via = (ViaAPI<OfflinePlayer>) Via.getAPI();
    return super.register();
  }

  @Override
  public Map<String, Object> getDefaults() {
    return CONFIG_DEFAULTS;
  }

  @Override
  public String onRequest(OfflinePlayer plr, String str) {
    String out = str;
    out = replaceLast(out.replaceFirst(Pattern.quote("{"), "%"), "}", "%");
    if (out.contains("%")) out = PlaceholderAPI.setPlaceholders(plr, out);
    if (plr == null || (this.via.getPlayerVersion(plr) >= 393 && this.version_safe)) out = SmallCapsCharacterMap.string2SmallCaps(out);
    return out;
  }
  
  private static String replaceLast(String s, String t, String r) {
    int i = s.lastIndexOf(t);
    if (i == -1) return s;
    return s.substring(0, i) + r + s.substring(i + t.length());
  }

  static {
    CONFIG_DEFAULTS.put("version_safe", true);
  }
}