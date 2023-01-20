package com.example.DragonRPG.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.springframework.stereotype.Component;

@Component
public class Help extends Command {

  public Help() {
    setCommandName("help");
    setCommandDesc("help");
    commandMap.put("help",this);
  }

  @Override
  public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
    EmbedBuilder embedBuilder = new EmbedBuilder();

    embedBuilder.setTitle("Help");
    embedBuilder.addField("roll", "random number", true).appendDescription("test1");
    embedBuilder.addField("test1", "test1", false);
    event.replyEmbeds(embedBuilder.build()).queue();
  }
}
