package com.devchris.person.repository;

import com.devchris.person.domain.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockReposiroty extends JpaRepository<Block, Long> {

}
