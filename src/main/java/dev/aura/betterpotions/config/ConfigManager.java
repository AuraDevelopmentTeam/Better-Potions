package dev.aura.betterpotions.config;

import com.google.common.reflect.TypeToken;
import java.io.IOException;
import ninja.leaping.configurate.ConfigurationOptions;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;

public class ConfigManager {
  private ConfigurationLoader<CommentedConfigurationNode> loader;
  private ConfigurationOptions options;
  private PluginConfiguration cfg;

  public ConfigManager(ConfigurationLoader<CommentedConfigurationNode> loader) {
    this.loader = loader;
    options = ConfigurationOptions.defaults().setShouldCopyDefaults(true);
    update();
  }

  private void update() {
    try {
      CommentedConfigurationNode node = loader.load(options);
      PluginConfiguration cfg =
          node.getValue(TypeToken.of(PluginConfiguration.class), new PluginConfiguration());
      loader.save(node);
      this.cfg = cfg;
    } catch (IOException | ObjectMappingException exception) {
      exception.printStackTrace();
    }
  }
}
