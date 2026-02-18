package com.AprendendoTestes.testes.web;

import com.AprendendoTestes.testes.domain.Planet;
import com.AprendendoTestes.testes.domain.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planets")

public class PlanetController {
    @Autowired
    private PlanetService service;

@PostMapping
public ResponseEntity<Planet> create(@RequestBody Planet planet){

    Planet planet1 = service.create(planet);
    return ResponseEntity.status(HttpStatus.CREATED).body(planet1);
};
@GetMapping
    public ResponseEntity<Planet>findById(Long id){
        return service.findById(id).map(planet -> ResponseEntity.ok(planet)).orElseGet(()->ResponseEntity.notFound().build());
    };
@GetMapping("name/{name}")
    public ResponseEntity<Planet>findByName(@PathVariable String name){
        return service.findByname(name).map(planet -> ResponseEntity.ok(planet)).orElseGet(()->ResponseEntity.notFound().build());
    };


    @GetMapping
    public ResponseEntity<List<Planet>>List(@RequestParam(required = false)String terrain,@RequestParam(required = false)String climate){
    List<Planet> planetList =service.list(terrain,climate);
    return ResponseEntity.ok(planetList);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable("id") Long id){
        service.deleteByid(id);
        return ResponseEntity.noContent().build();

    }



}
