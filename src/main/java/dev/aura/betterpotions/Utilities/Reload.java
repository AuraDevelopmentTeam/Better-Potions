package dev.aura.betterpotions.Utilities;

import dev.aura.betterpotions.BetterPotions;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.serializer.TextSerializers;

public class Reload implements CommandExecutor {
  private static final BetterPotions PLUGIN = BetterPotions.getInstance();

  @Override
  public CommandResult execute(CommandSource source, CommandContext args) {
    source.sendMessage(
        TextSerializers.FORMATTING_CODE.deserialize(
            "&6Reloading configuration for &b" + PLUGIN.getContainer().getName()));
    PLUGIN.loadConfig();
    source.sendMessage(
        TextSerializers.FORMATTING_CODE.deserialize(
            "&aConfiguration successfully reloaded for &b" + PLUGIN.getContainer().getName()));

    return CommandResult.success();
  }

  public static CommandSpec build() {
    return CommandSpec.builder()
        .description(Text.of("Reload command for " + PLUGIN.getContainer().getName()))
        .executor(new Reload())
        .permission(Permissions.RELOAD)
        .build();
  }
}
