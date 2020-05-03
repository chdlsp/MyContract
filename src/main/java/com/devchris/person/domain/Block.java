package com.devchris.person.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RequiredArgsConstructor
public class Block {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;
    private String reason;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

}
