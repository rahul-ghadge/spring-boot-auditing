package com.arya.data.envers.auditing.controller;


import com.arya.data.envers.auditing.model.SuperHero;
import com.arya.data.envers.auditing.service.SuperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/data/envers/super-hero")
public class SuperHeroController {

    @Autowired
    private SuperHeroService superHeroService;

    @GetMapping
    public ResponseEntity<List<?>> findAll() {
        List<?> list = superHeroService.findAll();
        return ResponseEntity.ok().body(list);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        SuperHero superHero = superHeroService.findById(id);
        return ResponseEntity.ok().body(superHero);
    }


    @PostMapping
    public ResponseEntity<?> save(@RequestBody SuperHero superHero) {
        SuperHero savedSuperHero = superHeroService.save(superHero);
        return ResponseEntity.ok().body(savedSuperHero);
    }


    @PutMapping
    public ResponseEntity<?> update(@RequestBody SuperHero superHero) {
        SuperHero updatedSuperHero = superHeroService.update(superHero);
        return ResponseEntity.ok().body(updatedSuperHero);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        superHeroService.delete(id);
        return ResponseEntity.ok().body("Deleted successfully...!");
    }
}