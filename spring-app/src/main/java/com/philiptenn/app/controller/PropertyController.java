package com.philiptenn.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.philiptenn.app.model.Property;

@Controller
@RequestMapping("/property")
public class PropertyController {
	
	@RequestMapping(value="{name}", method = RequestMethod.GET)
	public @ResponseBody Property getPropertyByName(@PathVariable String name) {
 
		Property property = new Property();
		
		switch (name) {
			case "home":
				property.setAddress1("123 home street.");
				property.setCity("Tampa");
				property.setState("FL");
				property.setZip("33618");
				break;
			case "work":
				property.setAddress1("123 work street.");
				property.setCity("Tampa");
				property.setState("FL");
				property.setZip("33618");
				break;
			default: 
				break;
				
		}				
		return property; 
	}

}
