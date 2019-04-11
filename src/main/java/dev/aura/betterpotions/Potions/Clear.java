package dev.aura.betterpotions.Potions;

import dev.aura.betterpotions.Configuration.PluginConfiguration;
import dev.aura.betterpotions.Utilities.Permissions;
import java.util.List;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.service.pagination.PaginationList;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.action.TextActions;
import org.spongepowered.api.text.serializer.TextSerializers;

public class Clear {

  private static final String permission = Permissions.CLEAR;

  public static CommandSpec build() {

    return CommandSpec.builder()
        .description(Text.of("Clear Effects command for Better Potions"))
        .permission(permission)
        .executor(
            (source, args) -> {
              if (source instanceof Player) {
                Player player = (Player) source;

                if (player.get(Keys.POTION_EFFECTS).isPresent()) {
                  List<PotionEffect> effects = player.get(Keys.POTION_EFFECTS).get();
                  effects.clear();

                  player.offer(Keys.POTION_EFFECTS, effects);

                  PaginationList.builder()
                      .title(
                          TextSerializers.FORMATTING_CODE.deserialize(
                              "&dPotion Effects&8: &aCleared"))
                      .contents(
                          Text.builder()
                              .append(
                                  Text.builder()
                                      .append(
                                          TextSerializers.FORMATTING_CODE.deserialize(
                                              "\n&dEffects &7have been &acleared &7for &b"
                                                  + player.getName()
                                                  + "\n"))
                                      .build())
                              .onHover(
                                  TextActions.showText(
                                      TextSerializers.FORMATTING_CODE.deserialize(
                                          "&6&o/potions clear")))
                              .onClick(TextActions.runCommand("/potions clear"))
                              .build())
                      .padding(
                          TextSerializers.FORMATTING_CODE.deserialize(
                              PluginConfiguration.Pagination.Padding))
                      .sendTo(player);
                } else {
                  player.sendMessage(
                      TextSerializers.FORMATTING_CODE.deserialize(
                          "&cYou don't have any potion effects!"));
                }
              }
              return CommandResult.success();
            })
        .build();
  }
}
