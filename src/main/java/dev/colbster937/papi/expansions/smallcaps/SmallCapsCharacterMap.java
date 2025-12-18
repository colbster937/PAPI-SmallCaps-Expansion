package dev.colbster937.papi.expansions.smallcaps;

import java.util.Map;
import java.util.HashMap;

public class SmallCapsCharacterMap {
  private static final Map<Character, Character> characterToSmallCapsMap = new HashMap<Character, Character>();
  private static final Map<Character, Character> smallCapsToCharacterMap = new HashMap<Character, Character>();

  private static void register(char c, char s) {
    characterToSmallCapsMap.put(c, s);
    smallCapsToCharacterMap.put(s, c);
  }

  public static char char2SmallCaps(char c) {
    Character m = characterToSmallCapsMap.get(Character.toLowerCase(c));
    return m != null ? m : c;
  }

  public static char smallCaps2Char(char s) {
    Character m = smallCapsToCharacterMap.get(s);
    return m != null ? m : s;
  }

  public static String string2SmallCaps(String s) {
    StringBuilder o = new StringBuilder(s.length());
    for (char c : s.toCharArray()) o.append(char2SmallCaps(c));
    return o.toString();
  }

  public static String smallCaps2String(String s) {
    StringBuilder o = new StringBuilder(s.length());
    for (char c : s.toCharArray()) o.append(smallCaps2Char(c));
    return o.toString();
  }

  static {
    register('a', 'ᴀ');
    register('b', 'ʙ');
    register('c', 'ᴄ');
    register('d', 'ᴅ');
    register('e', 'ᴇ');
    register('f', 'ꜰ');
    register('g', 'ɢ');
    register('h', 'ʜ');
    register('i', 'ɪ');
    register('j', 'ᴊ');
    register('k', 'ᴋ');
    register('l', 'ʟ');
    register('m', 'ᴍ');
    register('n', 'ɴ');
    register('o', 'ᴏ');
    register('p', 'ᴘ');
    register('q', 'ǫ');
    register('r', 'ʀ');
    register('s', 's');
    register('t', 'ᴛ');
    register('u', 'ᴜ');
    register('v', 'ᴠ');
    register('w', 'ᴡ');
    register('x', 'x');
    register('y', 'ʏ');
    register('z', 'ᴢ');
  }
}
