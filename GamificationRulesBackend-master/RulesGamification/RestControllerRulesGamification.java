package com.wipro.RulesGamification;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(value="http://ec2-52-66-189-143.ap-south-1.compute.amazonaws.com:3000")
@RestController
@RequestMapping(path="/dash")
public class RestControllerRulesGamification {
	@Autowired
	private RuleRepositoryGamification repository;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<BeanRulesGamification> getAllTeam() {
		System.out.println("Nimisha");
	  return repository.findAll();
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public BeanRulesGamification getPetById(@PathVariable("id") ObjectId id) {
	  return repository.findBy_id(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyGameById(@PathVariable("id") ObjectId id, @Valid 
	@RequestBody BeanRulesGamification game) {
		game.set_id(id);
	  repository.save(game);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public BeanRulesGamification createGame(@Valid @RequestBody BeanRulesGamification game) {
		System.out.println("Hemanth");
		game.set_id(ObjectId.get());
	  repository.save(game);
	  return game;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	  public void deleteGame(@PathVariable ObjectId id) {
	    repository.delete(repository.findBy_id(id));
	  }

}
