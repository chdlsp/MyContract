package com.devchris.person.service;

import com.devchris.person.domain.Block;
import com.devchris.person.domain.Person;
import com.devchris.person.repository.BlockReposiroty;
import com.devchris.person.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

        List<Person> result = personService.getPeopleExcludeBlocks();
        result.forEach(System.out::println);
    }

    @Test
    void getPeopleByName() {
        givenPeople();

        List<Person> result = personService.getPeopleByName("martin");
        result.forEach(System.out::println);
    }

    @Test
    void getPerson() {
        givenPeople();
        Person person = personService.getPerson(3L);
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