package com.example.DragonRPG.commands;

import java.time.format.DateTimeFormatter;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.springframework.stereotype.Component;

@Component
public class Avatar extends Command {

  public Avatar() {
    setCommandName("avatar");
    setCommandDesc("user avatar");
    commandMap.put("avatar", this);
  }

  @Override
  public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
    OptionMapping option = event.getOption("user");
    EmbedBuilder embedBuilder = new EmbedBuilder();

    embedBuilder.setTitle("User");
    embedBuilder.addField("Name", option.getAsUser().getName(), true);
    embedBuilder.setThumbnail(option.getAsUser().getAvatarUrl());
    embedBuilder.addField("Account creation date", option.getAsMember().getTimeCreated().format(
        DateTimeFormatter.ofPattern("dd-MM-yyyy")), true);

    event.replyEmbeds(embedBuilder.build()).queue();
  }
}
