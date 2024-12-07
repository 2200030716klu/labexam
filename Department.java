package com.klef.jfsd.exam.hibernate_hql_labexam;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  
  @Column(name = "name")
  private String name;

  @Column(name = "location")
  private String location;

  @Column(name = "hod_name")
  private String hodName;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getHodName() {
    return hodName;
  }

  public void setHodName(String hodName) {
    this.hodName = hodName;
  }

  @Override
  public String toString() {
    return "Department [id=" + id + ", name=" + name + ", location=" + location + ", hodName=" + hodName + "]";
  }
}
