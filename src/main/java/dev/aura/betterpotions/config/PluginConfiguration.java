package dev.aura.betterpotions.config;

import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

@ConfigSerializable
public class PluginConfiguration {
  @Setting(value = "Enabled-Potions")
  private PluginConfiguration.GlobalConfigs globalConfigs = new PluginConfiguration.GlobalConfigs();

  @Setting(value = "Potency")
  private PluginConfiguration.Potency potencyConfigs = new PluginConfiguration.Potency();

  @Setting(value = "Pagination")
  private PluginConfiguration.Pagination paginationConfigs = new PluginConfiguration.Pagination();

  @ConfigSerializable
  public static class GlobalConfigs {
    @Setting(comment = "List of enabled potions. true is enabled and false is disabled.")
    public static boolean Aborption = true;

    @Setting public static boolean BadLuck = false;
    @Setting public static boolean InstantDamage = false;
    @Setting public static boolean NightVision = true;
    @Setting public static boolean Nausea = false;
    @Setting public static boolean Regeneration = true;
    @Setting public static boolean JumpBoost = true;
    @Setting public static boolean Invisbility = true;
    @Setting public static boolean Swiftness = true;
    @Setting public static boolean FireResistance = true;
    @Setting public static boolean HealthBoost = true;
    @Setting public static boolean Strength = true;
    @Setting public static boolean WaterBreathing = true;
    @Setting public static boolean Blindness = false;
    @Setting public static boolean Glowing = true;
    @Setting public static boolean Haste = true;
    @Setting public static boolean Hunger = false;
    @Setting public static boolean Godmode = true;
    @Setting public static boolean Levitation = true;
    @Setting public static boolean Luck = true;
    @Setting public static boolean MiningFatigue = false;
    @Setting public static boolean Poison = false;
    @Setting public static boolean Resistance = true;
    @Setting public static boolean Saturation = true;
    @Setting public static boolean Slowness = false;
    @Setting public static boolean Weakness = false;
    @Setting public static boolean Wither = false;
  }

  @ConfigSerializable
  public static class Potency {
    @Setting(comment = "Minimum potency of potions. Example: Strength I is 1")
    public static int MinimumPotency = 1;

    @Setting(comment = "Maximum potency of potions. Example: Regeneration IV is 4")
    public static int MaximumPotency = 4;
  }

  @ConfigSerializable
  public static class Pagination {
    @Setting(comment = "Amount many lines of text to show when doing /potions")
    public static int LinesPerPage = 5;

    @Setting(comment = "Padding for pagination.")
    public static String Padding = "&8&m-";

    @Setting(comment = "Title for pagination when doing /potions")
    public static String Title = "&6{pluginName}";
  }
}
