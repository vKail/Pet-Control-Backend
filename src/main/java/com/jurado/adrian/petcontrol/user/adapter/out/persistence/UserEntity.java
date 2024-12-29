package com.jurado.adrian.petcontrol.user.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "Users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column()
    private String name;
    @Column()
    private String lastname;
    @Column()
    private String username;
    @Column()
    private String password;
    @Column()
    private String email;
    @Column()
    private String phone;
}
