package com.example.livecode;

import javax.enterprise.context.Dependent;

import org.eclipse.microprofile.config.inject.ConfigProperties;

@ConfigProperties(prefix="customer")
@Dependent
public class Person {
    public String name;
    public String address;
    public int age;
    public String hobby; 
}
