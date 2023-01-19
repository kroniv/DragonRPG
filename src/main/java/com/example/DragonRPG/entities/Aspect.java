package com.example.DragonRPG.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name="aspects")
public class Aspect {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int aspectId;
  @Column(name = "aspect_name")
  private String aspectName;
  @Column(name = "aspect_desc")
  private String aspectDesc;
  @Column(name = "aspect_power")
  private int aspectPower;
  @OneToMany(mappedBy = "aspect")
  private List<Inventory> inventories;



}
