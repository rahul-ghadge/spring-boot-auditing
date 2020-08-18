package com.arya.hibernate.envers.auditing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Audited
public class SuperHero implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String superName;
    private String profession;
    private int age;
    private boolean canFly;

}
