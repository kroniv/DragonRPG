package com.example.DragonRPG.commands;

import com.example.DragonRPG.entities.User;
import com.example.DragonRPG.repositories.UsersRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Profile extends Command{
  @Autowired
  private UsersRepository usersRepository;

  public Profile(){
    setCommandName("profile");
    setCommandDesc("check your profile");
  }

  @Override
  public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
    if(usersRepository.existsById(event.getUser().getId())){

      event.reply(usersRepository.findById(event.getUser().getId())
          .get()
          .getUsername())
          .queue();
    } else {
      usersRepository.save(new User(event.getUser().getId(),event.getUser().getName()));
      event.reply("New profile has been created").queue();
    }
  }
}
