package com.devchris.person.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RequiredArgsConstructor
public class Person {

    @Id
    @GeneratedValue // GenerationType strategy() default AUTO;
    @ToString.Exclude
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private int age;

    private String hobby;
    private String bloodType;
    private String address;
    private LocalDateTime birthday;
    private String job;
    private String phoneNumber;

    @OneToOne
    private Block block;

}
