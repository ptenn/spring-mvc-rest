package com.philiptenn.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.philiptenn.app.model.Property;

@Controller
@RequestMapping("properties")
public class PropertyController {
	
	private MongoOperations mongoOperations;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Property> getProperties() {
		
		//TODO Inline DAO code in the Controller for now, will formally separate into DAO layer later.
		List<Property> properties = getMongoOperations().findAll(Property.class);
		return properties;
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public @ResponseBody Property getProperty(@PathVariable String id) {

		//TODO Inline DAO code in the Controller for now, will formally separate into DAO layer later.
		Property property = getMongoOperations().findById(id, Property.class);
		return property; 
	}
	
	@RequestMapping(method =  RequestMethod.POST)
	public @ResponseBody Property addProperty(@RequestBody Property property) {
		getMongoOperations().save(property);
		return property;
	}

	@RequestMapping(method =  RequestMethod.PUT)
	public @ResponseBody Property updateProperty(@RequestBody Property property) {
		getMongoOperations().save(property);
		return property;
	}


	public MongoOperations getMongoOperations() {
		return mongoOperations;
	}

	@Autowired
	public void setMongoOperations(MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}

}
