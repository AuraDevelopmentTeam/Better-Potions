package dev.aura.betterpotions.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.effect.potion.PotionEffectType;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.action.TextActions;
import org.spongepowered.api.text.serializer.TextSerializers;

public class PotionArgsHandler {

  public static void PotionArgsHandler(
      PotionEffectType potType,
      Player player,
      String potionType,
      String potionCommand,
      String potionRange,
      int minPotency,
      int maxPotency,
      CommandContext args)
      throws CommandException {
    final Optional<Integer> potency = args.<Integer>getOne(potionRange);

    if (player
        .get(Keys.POTION_EFFECTS)
        .map(Collection::stream)
        .map(s -> s.map(PotionEffect::getType))
        .map(s -> s.anyMatch(potType::equals))
        .filter(a -> a)
        .isPresent()) {
      checkEffect(potType, player, potionType, potionCommand);
    } else if (!potency.isPresent()) {
      giveEffect(potType, 1, player, potionType, potionCommand);
    } else if (potency.get() < minPotency || potency.get() > maxPotency) {
      throw new CommandException(
          TextSerializers.FORMATTING_CODE.deserialize("&cMust be a value between " + potionRange));
    } else {
      int pot = potency.get();
      giveEffect(potType, pot, player, potionType, potionCommand);
    }
  }

  private static void checkEffect(
      PotionEffectType type, Player player, String potionType, String potionCommand) {
    List<PotionEffect> potionEffects = player.get(Keys.POTION_EFFECTS).orElseGet(ArrayList::new);
    potionEffects.removeIf(effect -> type.equals(effect.getType()));
    player.offer(Keys.POTION_EFFECTS, potionEffects);

    player.sendMessage(
        Text.builder()
            .append(
                Text.builder()
                    .append(
                        TextSerializers.FORMATTING_CODE.deserialize(
                            "&d"
                                + potionType
                                + " &7has been &cdisabled&7 for &b"
                                + player.getName()))
                    .build())
            .onHover(
                TextActions.showText(
                    TextSerializers.FORMATTING_CODE.deserialize(
                        "&6&o/potions " + potionCommand + " &7&o[potency]")))
            .onClick(TextActions.suggestCommand("/potions " + potionCommand + " "))
            .build());
  }

  private static void giveEffect(
      PotionEffectType potType, int i, Player player, String potionType, String potionCommand) {

    List<PotionEffect> potionEffects = player.get(Keys.POTION_EFFECTS).orElseGet(ArrayList::new);
    potionEffects.add(
        PotionEffect.builder()
            .potionType(potType)
            .duration(Integer.MAX_VALUE)
            .amplifier(i - 1)
            .build());
    player.offer(Keys.POTION_EFFECTS, potionEffects);

    player.sendMessage(
        Text.builder()
            .append(
                Text.builder()
                    .append(
                        TextSerializers.FORMATTING_CODE.deserialize(
                            "&d"
                                + potionType
                                + " &7has been &aenabled&7 for &b"
                                + player.getName()))
                    .build())
            .onHover(
                TextActions.showText(
                    TextSerializers.FORMATTING_CODE.deserialize("&6&o/potions " + potionCommand)))
            .onClick(TextActions.runCommand("/potions " + potionCommand))
            .build());
  }
}
