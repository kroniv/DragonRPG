package com.example.DragonRPG.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

  @Id
  private String userId;
  @Column(name = "username")
  private String username;
  @Column(name = "level")
  private int level;
  @Column(name = "exp")
  private int exp;
  @OneToMany(mappedBy = "user")
  private List<Inventory> inventories;


  public User(String userId, String username) {
    this.userId = userId;
    this.username = username;
    level = 1;
    exp = 0;
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
