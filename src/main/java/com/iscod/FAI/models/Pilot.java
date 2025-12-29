package com.iscod.FAI.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Setter
@Getter
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Pilot {

    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    @Column(updatable = false, nullable = false)
    private UUID id = UUID.randomUUID();

    @Transient
    private UUID raceId;
    @Transient
    private UUID carID;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "race_id")
    @JsonBackReference
    private Race race;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "car_id", unique = true)
    private Car car;

}