package com.jurado.adrian.petcontrol.petsPecimen.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "Specimens")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SpecimenEntity {
        @Id
        @GeneratedValue
        @Column(name = "id")
        private Long id;
        @Column(name = "name")
        private String name;
}
