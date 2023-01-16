package com.example.DragonRPG.commands;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandManager extends ListenerAdapter {

  @Autowired
  private Ping ping;
  @Autowired
  private Avatar avatar;
  @Autowired
  private Help help;
  @Autowired
  private Profile profile;

  public void buildCommands(JDA jda) {
    jda.updateCommands().addCommands(
        Commands.slash(ping.getCommandName(), ping.getCommandDesc()),
        Commands.slash(help.getCommandName(), help.getCommandDesc()),
        Commands.slash(avatar.getCommandName(), avatar.getCommandDesc())
            .addOption(OptionType.USER, "user", "username", true),
        Commands.slash(profile.getCommandName(), profile.getCommandDesc())
    ).queue();
  }

  @Autowired
  CommandCollection commandCollection;

  @Override
  public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
    var item = commandCollection.getMap().get(event.getName());
    if (item == null) {
      event.reply("Command not found").queue();
    } else {
      Command command = (Command) item;
      command.onSlashCommandInteraction(event);
    }

  }
}
