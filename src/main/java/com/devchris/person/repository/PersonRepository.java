package com.devchris.person.repository;

import com.devchris.person.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByName(String name);
    List<Person> findByBlockIsNull();
    List<Person> findByBloodType(String bloodType);
    List<Person> findByBirthdayBetween(LocalDate startDate, LocalDate endDate);
}
