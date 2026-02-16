package com.AprendendoTestes.testes.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;

@Getter
@Setter
@Entity
@Table(name = "planets")
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String climate;
    private String terrain;


    public Planet(String name,String climate,String terrain){
        this.name=name;
        this.climate=climate;
        this.terrain=terrain;
    }
    public Planet(Long id,String name,String climate,String terrain){
        this.id=id;
        this.name=name;
        this.climate=climate;
        this.terrain=terrain;
    }

    public Planet(String climate, String terrain) {
        this.climate=climate;
        this.terrain=terrain;
    }

    @Override
    public boolean equals(Object obj){
     return  EqualsBuilder.reflectionEquals(obj,this);

    }


}
