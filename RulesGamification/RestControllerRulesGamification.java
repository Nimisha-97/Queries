package com.wipro.RulesGamification;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(value="http://ec2-52-66-189-143.ap-south-1.compute.amazonaws.com:3000")
@RestController
@RequestMapping(path="/dashboard")
public class RestControllerRulesGamification {
	@Autowired
	private RuleRepositoryGamification repository;
	@Autowired
	private MongoTemplate mongoTemplate;
	@RequestMapping(value = "/team", method = RequestMethod.GET)
	public List<BeanRulesGamification> getAllTeam1() {
		System.out.println("Nimisha");
		Query query = new Query();
		query.addCriteria(Criteria.where("team").in(true));
		//Query query1=new Query();
	//	query1.addCriteria(Criteria.where("team").in(false));
	  return mongoTemplate.find(query,BeanRulesGamification.class);
	}
	
	/*@RequestMapping(value = "/individual", method = RequestMethod.GET)
	public List<BeanRulesGamification> getAllTeam() {
		System.out.println("Nimisha");
		//Query query = new Query();
		//query.addCriteria(Criteria.where("team").in(true));
		Query query1=new Query();
		query1.addCriteria(Criteria.where("team").in(false));
	  return mongoTemplate.find(query1,BeanRulesGamification.class);
	}*/
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public List<BeanRulesGamification> getPetById(@PathVariable("id") ObjectId id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("team").in(true));
		//query.addCriteria(Criteria.where("individual").in(false));
	  return mongoTemplate.find(query,BeanRulesGamification.class);
		
	 // return repository.findBy_id(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyGameById(@PathVariable("id") ObjectId id, @Valid 
	@RequestBody BeanRulesGamification game) {
		
		Query query = new Query(Criteria.where("team").is(true));
	//	Query query1 = new Query(Criteria.where("individual").is(false));
		mongoTemplate.findOne(query, BeanRulesGamification.class);
	   
        mongoTemplate.save(game);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public BeanRulesGamification createGame(@Valid @RequestBody BeanRulesGamification game) {
		System.out.println("Hemanth");
		Query query = new Query();
		query.addCriteria(Criteria.where("team").in(true));
		mongoTemplate.findOne(query, BeanRulesGamification.class);
        mongoTemplate.save(game);
	  return game;
	}
	
	/*@RequestMapping(value = "/add/individual", method = RequestMethod.POST)
	public BeanRulesGamification createGame(@Valid @RequestBody BeanRulesGamification game) {
		System.out.println("Hemanth");
		Query query1 = new Query();
		query1.addCriteria(Criteria.where("team").in(false));
		mongoTemplate.findOne(query1, BeanRulesGamification.class);
        mongoTemplate.save(game);
	  return game;
	}*/
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	  public void deleteGame(@PathVariable ObjectId id) {
	    repository.delete(repository.findBy_id(id));
	  }

}
