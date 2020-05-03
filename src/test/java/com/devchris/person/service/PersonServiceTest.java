package com.devchris.person.service;

import com.devchris.person.domain.Block;
import com.devchris.person.domain.Person;
import com.devchris.person.repository.BlockReposiroty;
import com.devchris.person.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.w3c.dom.ls.LSOutput;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BlockReposiroty blockReposiroty;
    
    @Test
    void getPeopleExcludeBlocks() {
        givenPeople();
        givenBlocks();

        List<Person> result = personService.getPeopleExcludeBlocks();
        result.forEach(System.out::println);
    }

    private void givenBlocks() {
        givenBlock("martin");
    }
    private void givenBlock(String name) {
        blockReposiroty.save(new Block(name));
    }

    private void givenPeople() {
        givenPerson("martin", 10, "A");
        givenPerson("chris", 11, "A");
        givenPerson("denis", 12, "AB");
        givenPerson("denis", 13, "AB");
    }

    private void givenPerson(String name, int age, String bloodType) {
        personRepository.save(Person.builder().name(name).age(age).bloodType(bloodType).build());
    }
}