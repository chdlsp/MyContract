package com.devchris.person.repository;

import com.devchris.person.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void curd() {
        Person person = new Person();
        personRepository.save(person);
        
        List<Person> people = personRepository.findAll();
        assertThat(people.size()).isEqualTo(1);
    }

}