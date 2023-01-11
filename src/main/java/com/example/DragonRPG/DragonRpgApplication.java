package com.example.DragonRPG;

import com.example.DragonRPG.commands.CommandManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class DragonRpgApplication {

  @Autowired
  private Environment env;
  @Autowired
  private CommandManager commandManager;

  public static void main(String[] args) {
    SpringApplication.run(DragonRpgApplication.class, args);
  }

  @Bean
  @ConfigurationProperties(value = "jda")
  public JDA jda() {

    String token = env.getProperty("TOKEN");
    JDA jda = JDABuilder.createDefault(token)
        .enableIntents(
            GatewayIntent.MESSAGE_CONTENT)
        .enableCache(CacheFlag.VOICE_STATE)// enables explicit access to message.getContentDisplay()
        .addEventListeners(commandManager)
        .build();

    commandManager.buildCommands(jda);

    return jda;
  }

}
