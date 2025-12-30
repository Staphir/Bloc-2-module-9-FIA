package com.iscod.FAI.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    private String name;

    private String country;

    private Boolean start;

    @OneToMany(mappedBy = "race", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Pilot> pilots = new ArrayList<>();

    public void associatePilot(Pilot pilot) {
        this.pilots.add(pilot);
        pilot.setRace(this);
    }

}