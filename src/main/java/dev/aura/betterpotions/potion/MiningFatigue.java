package dev.aura.betterpotions.potion;

import dev.aura.betterpotions.config.PluginConfiguration;
import dev.aura.betterpotions.util.Permissions;
import dev.aura.betterpotions.util.PotionArgsHandler;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.effect.potion.PotionEffectType;
import org.spongepowered.api.effect.potion.PotionEffectTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.serializer.TextSerializers;

public class MiningFatigue {

  private static final String potionName = "Mining Fatigue";
  private static final String potionCommand = "miningfatigue";
  private static final int minPotency = PluginConfiguration.Potency.MinimumPotency;
  private static final int maxPotency = PluginConfiguration.Potency.MaximumPotency;
  private static final String potionRange = minPotency + "-" + maxPotency;
  private static final PotionEffectType potionType = PotionEffectTypes.MINING_FATIGUE;
  private static final String permission = Permissions.MINING_FATIGUE;
  private static final boolean enabled = PluginConfiguration.GlobalConfigs.MiningFatigue;

  public static CommandSpec build() {

    return CommandSpec.builder()
        .description(Text.of(potionName + " command for Better Potions"))
        .permission(permission)
        .arguments(GenericArguments.optionalWeak(GenericArguments.integer(Text.of(potionRange))))
        .executor(
            (source, args) -> {
              if (source instanceof Player) {
                Player player = (Player) source;
                if (enabled) {
                  PotionArgsHandler.PotionArgsHandler(
                      potionType,
                      player,
                      potionName,
                      potionCommand,
                      potionRange,
                      minPotency,
                      maxPotency,
                      args);
                } else {
                  player.sendMessage(
                      TextSerializers.FORMATTING_CODE.deserialize(
                          "&c" + potionName + " potion is disabled"));
                }
              }
              return CommandResult.success();
            })
        .build();
  }
}
