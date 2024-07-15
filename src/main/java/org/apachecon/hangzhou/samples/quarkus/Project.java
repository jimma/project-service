package org.apachecon.hangzhou.samples.quarkus;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Project extends PanacheEntity {
   //@Id
   //@GeneratedValue(strategy = GenerationType.SEQUENCE)
   //private Long id;
   public String name;
   public int age;
}