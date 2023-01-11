package com.example.DragonRPG.commands;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandCollection {

  @Autowired
  private Ping ping;
  @Autowired
  private Avatar avatar;
  @Autowired
  private Help help;

  private HashMap<String, Object> commandMap = new HashMap<>();

  @Autowired
  public void createCommand() {
    commandMap.put(ping.getCommandName(), ping);
    commandMap.put(avatar.getCommandName(), avatar);
    commandMap.put(help.getCommandName(), help);
  }

  public HashMap getMap() {
    return commandMap;
  }

}
