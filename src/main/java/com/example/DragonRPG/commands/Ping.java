package com.example.DragonRPG.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.springframework.stereotype.Component;

@Component
public class Ping extends Command {

  public Ping() {
    setCommandName("ping");
    setCommandDesc("test command");
    commandMap.put("ping", this);
  }

  @Override
  public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
    event.reply("pong").queue();
  }
}
