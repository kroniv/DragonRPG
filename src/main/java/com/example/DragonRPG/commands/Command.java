package com.example.DragonRPG.commands;

import net.dv8tion.jda.api.hooks.ListenerAdapter;

public abstract class Command extends ListenerAdapter {

  private String commandName;
  private String commandDesc;

  public String getCommandName() {
    return commandName;
  }

  public String getCommandDesc() {
    return commandDesc;
  }

  public void setCommandName(String commandName) {
    this.commandName = commandName;
  }

  public void setCommandDesc(String commandDesc) {
    this.commandDesc = commandDesc;
  }
}
