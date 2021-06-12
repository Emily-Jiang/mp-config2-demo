package com.example.livecode;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.ConfigValue;
import org.eclipse.microprofile.config.inject.ConfigProperties;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 *
 */
@Path("/hello")
@RequestScoped
public class HelloController {

    @Inject @ConfigProperty(name="discount") ConfigValue discount;
    @Inject @ConfigProperty(name="customer.name") ConfigValue customerName;
    
    @Inject @ConfigProperties Person customer;
    @Inject @ConfigProperties(prefix="client") Person client;
    @GET
    public String displayDiscount() {
        return "Today's discount: " + discount.getValue()+ "% from " +discount.getSourceName()+ " for the customer: " + customerName.getValue() + " from: " + customerName.getSourceName();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/persons")
    public List<Person> displayPersons() {
        List<Person> persons = new ArrayList<Person>();
         persons.add(customer);
         persons.add(client);
         return persons;

    }
}
