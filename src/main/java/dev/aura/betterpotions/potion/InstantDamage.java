package dev.aura.betterpotions.potion;

import dev.aura.betterpotions.config.PluginConfiguration;
import dev.aura.betterpotions.util.Permissions;
import dev.aura.betterpotions.util.PotionHandler;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.effect.potion.PotionEffectType;
import org.spongepowered.api.effect.potion.PotionEffectTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.serializer.TextSerializers;

public class InstantDamage {

  private static final String potionName = "Instant Damage";
  private static final String potionCommand = "instantdamage";
  private static final PotionEffectType potionType = PotionEffectTypes.INSTANT_DAMAGE;
  private static final String permission = Permissions.INSTANT_DAMAGE;
  private static final boolean enabled = PluginConfiguration.GlobalConfigs.InstantDamage;

  public static CommandSpec build() {

    return CommandSpec.builder()
        .description(Text.of(potionName + " command for Better Potions"))
        .permission(permission)
        .executor(
            (source, args) -> {
              if (source instanceof Player) {
                Player player = (Player) source;
                if (enabled) {
                  PotionHandler.PotionHandler(potionType, player, potionName, potionCommand);
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
