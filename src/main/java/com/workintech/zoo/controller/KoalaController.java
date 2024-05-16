package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Koala;
import com.workintech.zoo.validation.ZooKangarooValidation;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/koalas")
public class KoalaController {
    private Map<Integer, Koala> koalas;

    @Autowired
    public KoalaController(){

    }
    @PostConstruct
    public void init(){
        this.koalas=new HashMap<>();
    }
    @GetMapping
    public List getKoalaList(){
        return new ArrayList<>(this.koalas.values());
    }
    @GetMapping("/{id}")
    public Koala getKoalaId(@PathVariable("id") Integer id){
        return koalas.get(id);
    }
    @PostMapping
    public Koala saveKoala(@RequestBody Koala koala){
        koalas.put(koala.getId(), koala);
        return koalas.get(koala.getId());
    }
    @PutMapping("/{id}")
    public Koala updateKoala (@PathVariable("id") Integer id,@RequestBody Koala koala){
        this.koalas.put(id,new Koala(id, koala.getName(), koala.getWeight(), koala.getSleepHour(), koala.getGender()));
        return koalas.get(id);

    }
    @DeleteMapping("/{id}")
    public Koala deleteKoala(@PathVariable Integer id){
        Koala koala = koalas.get(id);
        koalas.remove(id,koala);
        return koala;
    }


}
