package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Kangaroo;
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
@RequestMapping("/kangaroos")
public class KangarooController {
    private Map<Integer, Kangaroo> kangaroos;
    @Autowired
    public KangarooController(){

    }
    @PostConstruct
    public void init(){
        this.kangaroos=new HashMap<>();
        this.kangaroos.put(1,new Kangaroo(1,"kanguru test",65.0,50.0,"Male",false));
        System.out.println("kangaroos list = " + kangaroos);
    }
    @GetMapping
    public List getKangarooList(){
        return new ArrayList<>(this.kangaroos.values());
    }
    @GetMapping("/{id}")
    public Kangaroo getKangarooId(@PathVariable("id") Integer id){
        ZooKangarooValidation.isIdValid(id);
        ZooKangarooValidation.checkKangarooExistance(kangaroos,id,true);
        return this.kangaroos.get(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Kangaroo addKangaroo(@RequestBody Kangaroo kangaroo){
        ZooKangarooValidation.checkKangarooExistance(kangaroos,kangaroo.getId(),false);
        ZooKangarooValidation.checkKangarooWeight(kangaroo.getWeight());
        this.kangaroos.put(kangaroo.getId(), kangaroo);
        return kangaroos.get(kangaroo.getId());
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Kangaroo updateKangaroo (@PathVariable("id") Integer id,@RequestBody Kangaroo kangaroo){
        ZooKangarooValidation.isIdValid(id);
        ZooKangarooValidation.checkKangarooWeight(kangaroo.getWeight());
        kangaroo.setId(id);
        if(kangaroos.containsKey(id)){
            this.kangaroos.put(id,kangaroo);
            return kangaroos.get(id);
        }
        else{
            return addKangaroo(kangaroo);
        }
    }
    @DeleteMapping("/{id}")
    public Kangaroo deleteKangaroo(@PathVariable Integer id){
        ZooKangarooValidation.isIdValid(id);
        ZooKangarooValidation.checkKangarooExistance(kangaroos,id,true);
        return kangaroos.remove(id);
    }


}
