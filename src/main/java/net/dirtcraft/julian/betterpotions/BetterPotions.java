package net.dirtcraft.julian.betterpotions;

import com.google.inject.Inject;
import net.dirtcraft.julian.betterpotions.Configuration.ConfigManager;
import net.dirtcraft.julian.betterpotions.Potions.*;
import net.dirtcraft.julian.betterpotions.Utilities.Permissions;
import net.dirtcraft.julian.betterpotions.Utilities.Reload;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import org.bstats.sponge.Metrics2;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.config.DefaultConfig;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.GameReloadEvent;
import org.spongepowered.api.event.game.state.GamePreInitializationEvent;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.metric.MetricsConfigManager;

@Plugin(
        id = BetterPotions.ID,
        name = BetterPotions.NAME,
        description = BetterPotions.DESCRIPTION,
        authors = {BetterPotions.AUTHOR}
)
public class BetterPotions {

    public static final String ID = "betterpotions";
    public static final String NAME = "Better Potions";
    public static final String DESCRIPTION = "Allows players to choose their own potion effects!";
    public static final String AUTHOR = "juliann";

    @Inject
    private Metrics2 metrics;

    @Inject
    @DefaultConfig(sharedRoot = false)
    private ConfigurationLoader<CommentedConfigurationNode> loader;
    private ConfigManager cfgManager;

    @Inject
    private Logger logger;

    @Inject
    private PluginContainer container;

    private static BetterPotions instance;

    @Inject
    private MetricsConfigManager metricsConfigManager;

    @Listener
    public void onPreInit(GamePreInitializationEvent event) {
        instance = this;
        registerCommands();
        loadConfig();
        logger.info("Configuration for " + container.getName() + " has been successfully loaded.");
    }

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        logger.info(container.getName() +
                " running (version "
                + container.getVersion().orElse("")
                + ")! Hey, I'm alive!");
    }

    @Listener
    public void onReload(GameReloadEvent event) {
        loadConfig();
        logger.info("Configuration for " + container.getName() + " has been successfully reloaded.");
    }

    public void loadConfig() {
        this.cfgManager = new ConfigManager(loader);
    }

    private void registerCommands() {
        //Base command
        CommandSpec base = CommandSpec.builder()
                .description(Text.of("Base command for " + container.getName()))
                .executor(new Commands())
                .child(Reload.build(), "reload")
                .child(NightVision.build(), "nightvision")
                .child(Nausea.build(), "nausea")
                .child(Regeneration.build(), "regeneration")
                .child(Invisibility.build(), "invisibility")
                .child(JumpBoost.build(), "jumpboost")
                .child(Swiftness.build(), "swiftness")
                .child(FireResistance.build(), "fireresistance")
                .child(HealthBoost.build(), "healthboost")
                .child(Strength.build(), "strength")
                .child(WaterBreathing.build(), "waterbreathing")
                .child(Absorption.build(), "absorption")
                .child(Blindness.build(), "blindness")
                .child(Glowing.build(), "glowing")
                .child(Haste.build(), "haste")
                .child(Hunger.build(), "hunger")
                .child(Godmode.build(), "godmode")
                .child(Levitation.build(), "levitation")
                .child(Luck.build(), "luck")
                .child(MiningFatigue.build(), "miningfatigue")
                .child(Poison.build(), "poison")
                .child(Resistance.build(), "resistance")
                .child(Saturation.build(), "saturation")
                .child(Slowness.build(), "slowness")
                .child(Weakness.build(), "weakness")
                .child(Wither.build(), "wither")
                .child(Clear.build(), "clear")
                .permission(Permissions.BASE)
                .build();
        logger.info("Registering commands for " + container.getName() + "...");
        Sponge.getCommandManager().register(this, base, "betterpotions", "bp", "potion", "potions", "pot", "pots");
        logger.info("Commands for " + container.getName() +" have been registered...");
    }

    public Logger getLogger() {
        return logger;
    }

    public PluginContainer getContainer() {
        return container;
    }

    public static BetterPotions getInstance() {
        return instance;
    }


}
