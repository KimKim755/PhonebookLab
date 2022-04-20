package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        this.phonebook= new HashMap<>();
    }

    public void add(String name, String phoneNumber) {
       this.phonebook.put(name,List.of(phoneNumber));
    }

    public void addAll(String name, String... phoneNumbers) {
        this.phonebook.put(name,List.of(phoneNumbers));
    }

    public void remove(String name) {
        this.phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return this.phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return this.phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for (Map.Entry<String, List<String>> entry: phonebook.entrySet()){
            if (entry.getValue().contains(phoneNumber)){
                return entry.getKey();
            }
        }
        return "Invalid";
    }

    public List<String> getAllContactNames() {
        List<String> allNames = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry: phonebook.entrySet()){
            allNames.add(entry.getKey());
        }
        return allNames;
    }

    public Map<String, List<String>> getMap() {
        return this.phonebook;


    }

    public static void main(String[] args) {
        PhoneBook phonebook = new PhoneBook();
        phonebook.add("kim","302-123-1234");
        phonebook.add("grandma", "302-345-5678");
        phonebook.add("mom", "302-456-7890");
        System.out.println(phonebook.getAllContactNames());
        phonebook.remove("grandma");
        System.out.println(phonebook.getAllContactNames());
        System.out.println(phonebook.lookup("kim"));
        System.out.println(phonebook.hasEntry("grandma"));
        System.out.println(phonebook.reverseLookup("302-456-7890"));
    }
}
