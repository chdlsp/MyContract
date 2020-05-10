package com.devchris.person.repository;

import com.devchris.person.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    @Test
    void findByBloodType() {
        givenPeople();
        List<Person> result = personRepository.findByBloodType("A");
        result.forEach(System.out::println);
    }

    @Test
    void findByBirthdayBetween() {
        givenPeople();
        List<Person> result = personRepository.findByBirthdayBetween(LocalDate.of(1991,8,1), LocalDate.of(1991,8,31));
        result.forEach(System.out::println);
    }

    @Test
    void cascadeTest() {
        givenPeople();
        List<Person> result = personRepository.findAll();
        result.forEach(System.out::println);

        Person person = result.get(3);
        person.getBlock().setStartDate(LocalDateTime.now());
        person.getBlock().setEndDate(LocalDateTime.now());

        personRepository.save(person);
        personRepository.findAll().forEach(System.out::println);
    }

    private void givenPeople() {
        givenPerson("martin", 10, "A", LocalDate.of(1991,8,1));
        givenPerson("chris", 11, "A", LocalDate.of(1991,8,31));
        givenPerson("denis", 12, "AB", LocalDate.of(1991,5,1));
        givenPerson("denis", 13, "AB", LocalDate.of(1991,4,1));
    }

    private void givenPerson(String name, int age, String bloodType, LocalDate birthDay) {
        personRepository.save(Person.builder().name(name).age(age).bloodType(bloodType).birthday(birthDay).build());
    }
}