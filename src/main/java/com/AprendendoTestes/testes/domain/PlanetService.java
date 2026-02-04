package com.AprendendoTestes.testes.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class PlanetService {
    private PlanetRepository repository;

    public PlanetService (PlanetRepository repository){
        this.repository=repository;

    }

    public Planet create(Planet planet){

    return repository.save(planet);

    };


}
