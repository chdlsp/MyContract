package com.devchris.person.service;

import com.devchris.person.domain.Block;
import com.devchris.person.domain.Person;
import com.devchris.person.repository.BlockReposiroty;
import com.devchris.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BlockReposiroty blockReposiroty;

    public List<Person> getPeopleExcludeBlocks() {
        List<Person> people = personRepository.findAll();
        List<Block> blocks = blockReposiroty.findAll();

        List<String> blockNames = blocks.stream().map(Block::getName).collect(Collectors.toList());
        return people.stream().filter(person -> person.getBlock() == null).collect(Collectors.toList());
    }
}
