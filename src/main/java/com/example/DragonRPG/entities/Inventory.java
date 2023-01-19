package com.example.DragonRPG.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventory")
public class Inventory {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int inventoryId;

  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "userId")
  private User user;

  @ManyToOne
  @JoinColumn(name = "aspect_id",referencedColumnName = "aspectId")
  private Aspect aspect;


}
