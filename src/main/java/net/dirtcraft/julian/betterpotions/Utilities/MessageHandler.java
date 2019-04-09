package net.dirtcraft.julian.betterpotions.Utilities;

import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.effect.potion.PotionEffectType;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.action.TextActions;
import org.spongepowered.api.text.serializer.TextSerializers;

import java.util.ArrayList;
import java.util.Collection;

public class MessageHandler {

    public static void noArgs(Player player, ArrayList<Text> potions, PotionEffectType type, String potionCommand, String potionName) {
        if (player.get(Keys.POTION_EFFECTS)
                .map(Collection::stream)
                .map(s -> s.map(PotionEffect::getType))
                .map(s -> s.anyMatch(type::equals))
                .filter(a -> a)
                .isPresent()) {
            potions.add(
                    Text.builder()
                            .append(Text.builder()
                                    .append(TextSerializers.FORMATTING_CODE.deserialize("&d" + potionName + " &a✓"))
                                    .build())
                            .onHover(TextActions.showText(TextSerializers.FORMATTING_CODE.deserialize("&6&o/potions " + potionCommand)))
                            .onClick(TextActions.runCommand("/potions " + potionCommand))
                            .build());
        } else {
            potions.add(
                    Text.builder()
                            .append(Text.builder()
                                    .append(TextSerializers.FORMATTING_CODE.deserialize("&d" + potionName + " &c✗"))
                                    .build())
                            .onHover(TextActions.showText(TextSerializers.FORMATTING_CODE.deserialize("&6&o/potions " + potionCommand)))
                            .onClick(TextActions.runCommand("/potions " + potionCommand))
                            .build());
        }
    }

    public static void withArgs(Player player, ArrayList<Text> potions, PotionEffectType type, String potionCommand, String potionName) {
        if (player.get(Keys.POTION_EFFECTS)
                .map(Collection::stream)
                .map(s -> s.map(PotionEffect::getType))
                .map(s -> s.anyMatch(type::equals))
                .filter(a -> a)
                .isPresent()) {
            potions.add(
                    Text.builder()
                            .append(Text.builder()
                                    .append(TextSerializers.FORMATTING_CODE.deserialize("&d" + potionName + " &a✓"))
                                    .build())
                            .onHover(TextActions.showText(TextSerializers.FORMATTING_CODE.deserialize("&6&o/potions " + potionCommand)))
                            .onClick(TextActions.runCommand("/potions " + potionCommand))
                            .build());
        } else {
            potions.add(
                    Text.builder()
                            .append(Text.builder()
                                    .append(TextSerializers.FORMATTING_CODE.deserialize("&d" + potionName + " &c✗"))
                                    .build())
                            .onHover(TextActions.showText(TextSerializers.FORMATTING_CODE.deserialize("&6&o/potions " + potionCommand + " &7&o[potency]")))
                            .onClick(TextActions.suggestCommand("/potions " + potionCommand + " "))
                            .build());
        }
    }

}
