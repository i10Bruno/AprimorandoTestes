package com.AprendendoTestes.testes.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.query.JpqlQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Planet> findById(Long id){

        return repository.findById(id);
    }


    public Optional<Planet> findByname(String name) {
        return repository.findByName(name);
    }


    public List<Planet> list(String terrain, String climate){
        Example<Planet> query = QueryBuilder.makeQuery(new Planet(climate,terrain));

        return repository.findAll(query);
    }
}
