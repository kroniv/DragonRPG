package com.example.DragonRPG.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {

  @Id
  private String userId;

  @Column(name = "username")
  private String username;

  @Column(name = "level")
  private int level;

  public User(String userId, String username) {
    this.userId = userId;
    this.username = username;
    this.level = 1;
  }

  public User() {
  }

  public String getUserId() {
    return userId;
  }

  public String getUsername() {
    return username;
  }

  public int getLevel() {
    return level;
  }
}
