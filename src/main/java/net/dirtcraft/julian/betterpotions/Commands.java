package net.dirtcraft.julian.betterpotions;

import net.dirtcraft.julian.betterpotions.Configuration.PluginConfiguration;
import net.dirtcraft.julian.betterpotions.Utilities.MessageHandler;
import net.dirtcraft.julian.betterpotions.Utilities.Permissions;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.effect.potion.PotionEffectType;
import org.spongepowered.api.effect.potion.PotionEffectTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.service.pagination.PaginationList;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.action.TextActions;
import org.spongepowered.api.text.serializer.TextSerializers;

import java.util.ArrayList;

public class Commands implements CommandExecutor {
    private final BetterPotions PLUGIN = BetterPotions.getInstance();

    @Override
    public CommandResult execute(CommandSource source, CommandContext args) throws CommandException {
        if (source instanceof Player) {
            Player player = (Player) source;
            final ArrayList<Text> potions = new ArrayList<Text>();

            if (PluginConfiguration.GlobalConfigs.Aborption && player.hasPermission(Permissions.ABSORPTION)) {
                final String potionName = "Absorption";
                final String potionCommand = "absorption";
                final PotionEffectType potionType = PotionEffectTypes.ABSORPTION;

                MessageHandler.withArgs(player, potions, potionType, potionCommand, potionName);
            }
            if (PluginConfiguration.GlobalConfigs.Blindness && player.hasPermission(Permissions.BLINDNESS)) {
                final String potionName = "Blindness";
                final String potionCommand = "blindness";
                final PotionEffectType potionType = PotionEffectTypes.BLINDNESS;

                MessageHandler.noArgs(player, potions, potionType, potionCommand, potionName);
            }
            if (PluginConfiguration.GlobalConfigs.FireResistance && player.hasPermission(Permissions.FIRE_RESISTANCE)) {
                final String potionName = "Fire Resistance";
                final String potionCommand = "fireresistance";
                final PotionEffectType potionType = PotionEffectTypes.FIRE_RESISTANCE;

                MessageHandler.noArgs(player, potions, potionType, potionCommand, potionName);
            }
            if (PluginConfiguration.GlobalConfigs.Glowing && player.hasPermission(Permissions.GLOWING)) {
                final String potionName = "Glowing";
                final String potionCommand = "glowing";
                final PotionEffectType potionType = PotionEffectTypes.GLOWING;

                MessageHandler.noArgs(player, potions, potionType, potionCommand, potionName);
            }
            if (PluginConfiguration.GlobalConfigs.Godmode && player.hasPermission(Permissions.GODMODE)) {
                final String potionName = "Godmode";
                final String potionCommand = "godmode";
                final PotionEffectType potionType = PotionEffectTypes.INSTANT_HEALTH;

                MessageHandler.noArgs(player, potions, potionType, potionCommand, potionName);
            }
            if (PluginConfiguration.GlobalConfigs.Haste && player.hasPermission(Permissions.HASTE)) {
                final String potionName = "Haste";
                final String potionCommand = "haste";
                final PotionEffectType potionType = PotionEffectTypes.HASTE;

                MessageHandler.withArgs(player, potions, potionType, potionCommand, potionName);
            }
            if (PluginConfiguration.GlobalConfigs.HealthBoost && player.hasPermission(Permissions.HEALTH_BOOST)) {
                final String potionName = "Health Boost";
                final String potionCommand = "healthboost";
                final PotionEffectType potionType = PotionEffectTypes.HEALTH_BOOST;

                MessageHandler.noArgs(player, potions, potionType, potionCommand, potionName);
            }
            if (PluginConfiguration.GlobalConfigs.Hunger && player.hasPermission(Permissions.HUNGER)) {
                final String potionName = "Hunger";
                final String potionCommand = "hunger";
                final PotionEffectType potionType = PotionEffectTypes.HUNGER;

                MessageHandler.withArgs(player, potions, potionType, potionCommand, potionName);
            }
            if (PluginConfiguration.GlobalConfigs.Invisbility && player.hasPermission(Permissions.INVISIBILITY)) {
                final String potionName = "Invisibility";
                final String potionCommand = "invisibility";
                final PotionEffectType potionType = PotionEffectTypes.INVISIBILITY;

                MessageHandler.noArgs(player, potions, potionType, potionCommand, potionName);
            }
            if (PluginConfiguration.GlobalConfigs.JumpBoost && player.hasPermission(Permissions.JUMP_BOOST)) {
                final String potionName = "Jump Boost";
                final String potionCommand = "jumpboost";
                final PotionEffectType potionType = PotionEffectTypes.JUMP_BOOST;

                MessageHandler.withArgs(player, potions, potionType, potionCommand, potionName);
            }
            if (PluginConfiguration.GlobalConfigs.Levitation && player.hasPermission(Permissions.LEVITATION)) {
                final String potionName = "Levitation";
                final String potionCommand = "levitation";
                final PotionEffectType potionType = PotionEffectTypes.LEVITATION;

                MessageHandler.withArgs(player, potions, potionType, potionCommand, potionName);
            }
            if (PluginConfiguration.GlobalConfigs.Luck && player.hasPermission(Permissions.LUCK)) {
                final String potionName = "Luck";
                final String potionCommand = "luck";
                final PotionEffectType potionType = PotionEffectTypes.LUCK;

                MessageHandler.withArgs(player, potions, potionType, potionCommand, potionName);
            }
            if (PluginConfiguration.GlobalConfigs.MiningFatigue && player.hasPermission(Permissions.MINING_FATIGUE)) {
                final String potionName = "Mining Fatigue";
                final String potionCommand = "miningfatigue";
                final PotionEffectType potionType = PotionEffectTypes.MINING_FATIGUE;

                MessageHandler.withArgs(player, potions, potionType, potionCommand, potionName);
            }
            if (PluginConfiguration.GlobalConfigs.Nausea && player.hasPermission(Permissions.NAUSEA)) {
                final String potionName = "Nausea";
                final String potionCommand = "nausea";
                final PotionEffectType potionType = PotionEffectTypes.NAUSEA;

                MessageHandler.noArgs(player, potions, potionType, potionCommand, potionName);
            }
            if (PluginConfiguration.GlobalConfigs.NightVision && player.hasPermission(Permissions.NIGHT_VISION)) {
                final String potionName = "Night Vision";
                final String potionCommand = "nightvision";
                final PotionEffectType potionType = PotionEffectTypes.NIGHT_VISION;

                MessageHandler.noArgs(player, potions, potionType, potionCommand, potionName);
            }
            if (PluginConfiguration.GlobalConfigs.Poison && player.hasPermission(Permissions.POISON)) {
                final String potionName = "Poison";
                final String potionCommand = "poison";
                final PotionEffectType potionType = PotionEffectTypes.POISON;

                MessageHandler.withArgs(player, potions, potionType, potionCommand, potionName);
            }
            if (PluginConfiguration.GlobalConfigs.Regeneration && player.hasPermission(Permissions.REGENERATION)) {
                final String potionName = "Regeneration";
                final String potionCommand = "regeneration";
                final PotionEffectType potionType = PotionEffectTypes.REGENERATION;

                MessageHandler.withArgs(player, potions, potionType, potionCommand, potionName);
            }
            if (PluginConfiguration.GlobalConfigs.Resistance && player.hasPermission(Permissions.RESISTANCE)) {
                final String potionName = "Resistance";
                final String potionCommand = "resistance";
                final PotionEffectType potionType = PotionEffectTypes.RESISTANCE;

                MessageHandler.withArgs(player, potions, potionType, potionCommand, potionName);
            }
            if (PluginConfiguration.GlobalConfigs.Saturation && player.hasPermission(Permissions.SATURATION)) {
                final String potionName = "Saturation";
                final String potionCommand = "saturation";
                final PotionEffectType potionType = PotionEffectTypes.SATURATION;

                MessageHandler.withArgs(player, potions, potionType, potionCommand, potionName);
            }
            if (PluginConfiguration.GlobalConfigs.Slowness && player.hasPermission(Permissions.SLOWNESS)) {
                final String potionName = "Slowness";
                final String potionCommand = "slowness";
                final PotionEffectType potionType = PotionEffectTypes.SLOWNESS;

                MessageHandler.withArgs(player, potions, potionType, potionCommand, potionName);
            }
            if (PluginConfiguration.GlobalConfigs.Strength && player.hasPermission(Permissions.STRENGTH)) {
                final String potionName = "Strength";
                final String potionCommand = "strength";
                final PotionEffectType potionType = PotionEffectTypes.STRENGTH;

                MessageHandler.withArgs(player, potions, potionType, potionCommand, potionName);
            }
            if (PluginConfiguration.GlobalConfigs.Swiftness && player.hasPermission(Permissions.SWIFTNESS)) {
                final String potionName = "Swiftness";
                final String potionCommand = "swiftness";
                final PotionEffectType potionType = PotionEffectTypes.SPEED;

                MessageHandler.withArgs(player, potions, potionType, potionCommand, potionName);
            }
            if (PluginConfiguration.GlobalConfigs.WaterBreathing && player.hasPermission(Permissions.WATER_BREATHING)) {
                final String potionName = "Water Breathing";
                final String potionCommand = "waterbreathing";
                final PotionEffectType potionType = PotionEffectTypes.WATER_BREATHING;

                MessageHandler.noArgs(player, potions, potionType, potionCommand, potionName);
            }
            if (PluginConfiguration.GlobalConfigs.Weakness && player.hasPermission(Permissions.WEAKNESS)) {
                final String potionName = "Weakness";
                final String potionCommand = "weakness";
                final PotionEffectType potionType = PotionEffectTypes.WEAKNESS;

                MessageHandler.withArgs(player, potions, potionType, potionCommand, potionName);
            }
            if (PluginConfiguration.GlobalConfigs.Wither && player.hasPermission(Permissions.WITHER)) {
                final String potionName = "Wither";
                final String potionCommand = "wither";
                final PotionEffectType potionType = PotionEffectTypes.WITHER;

                MessageHandler.withArgs(player, potions, potionType, potionCommand, potionName);
            }

            if (player.get(Keys.POTION_EFFECTS).isPresent()) {
                PaginationList.builder()
                        .title(TextSerializers.FORMATTING_CODE.deserialize(PluginConfiguration.Pagination.Title.replace("{pluginName}", PLUGIN.getContainer().getName())))
                        .contents(potions)
                        .padding(TextSerializers.FORMATTING_CODE.deserialize(PluginConfiguration.Pagination.Padding))
                        .linesPerPage(PluginConfiguration.Pagination.LinesPerPage + 3)
                        .footer(
                                Text.builder()
                                        .append(Text.builder()
                                                .append(TextSerializers.FORMATTING_CODE.deserialize(
                                                        "&8[&3Clear Potion Effects&8]"))
                                                .build())
                                        .onHover(TextActions.showText(TextSerializers.FORMATTING_CODE.deserialize("&6&o/potions clear")))
                                        .onClick(TextActions.runCommand("/potions clear"))
                                        .build()
                        )
                        .sendTo(player);
            } else {
                PaginationList.builder()
                        .title(TextSerializers.FORMATTING_CODE.deserialize(PluginConfiguration.Pagination.Title.replace("{pluginName}", PLUGIN.getContainer().getName())))
                        .contents(potions)
                        .padding(TextSerializers.FORMATTING_CODE.deserialize(PluginConfiguration.Pagination.Padding))
                        .linesPerPage(PluginConfiguration.Pagination.LinesPerPage + 2)
                        .sendTo(player);
            }

        } else {
            throw new CommandException(
                    TextSerializers.FORMATTING_CODE.deserialize("&cOnly a player can receive potion effects"));
        }
        return CommandResult.success();
    }

}
