package com.devchris.person.repository;

import com.devchris.person.domain.Block;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BlockReposirotyTest {

    @Autowired
    private BlockReposiroty blockReposiroty;

    @Test
    void crud() {
        Block block = new Block();
        block.setName("martin");
        block.setReason("Don't know");
        block.setStartDate(LocalDateTime.now());
        block.setEndDate(LocalDateTime.now());

        blockReposiroty.save(block);

        List<Block> blockList = blockReposiroty.findAll();

        assertThat(blockList.size()).isEqualTo(1);

    }

}