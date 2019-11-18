package com.example.demo.controllers;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

import com.example.demo.models.Bosses;
import com.example.demo.repositories.BossesRepository;

import java.util.List;

@RestController
@RequestMapping("/bosses")
public class BossesController {
  @Autowired
  private BossesRepository repository;

  @RequestMapping(value = "", method = RequestMethod.GET)
  public List getAllBosses() {
    return repository.findAll();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Bosses getBossById(@PathVariable("id") final ObjectId id) {
    return repository.findBy_id(id);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)

  public void modifyBossById(@PathVariable("id") final ObjectId id, @Valid @RequestBody final Bosses bosses) {
    bosses.set_id(id);
    repository.save(bosses);
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public Bosses createBoss(@Valid @RequestBody final Bosses bosses) {
    bosses.set_id(ObjectId.get());
    repository.save(bosses);
    return bosses;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deleteBoss(@PathVariable final ObjectId id) {
    repository.delete(repository.findBy_id(id));
  }
}