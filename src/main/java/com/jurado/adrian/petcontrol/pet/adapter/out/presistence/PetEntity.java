package com.jurado.adrian.petcontrol.pet.adapter.out.presistence;

import com.jurado.adrian.petcontrol.petsPecimen.adapter.out.persistence.SpecimenEntity;
import com.jurado.adrian.petcontrol.user.adapter.out.persistence.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Pet")
public class PetEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "gender")
    private String gender;
    @Column(name = "birthdate")
    private Date birthdate;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private UserEntity owner;
    @ManyToOne
    @JoinColumn(name = "specimen_id")
    private SpecimenEntity specimen;
}
