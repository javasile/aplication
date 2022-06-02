package com.entex.aplication.api.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;


@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 60)
    private String name;

    @Column(length = 60)
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    private String email;

    @Column(length = 60)
    private String password;

    @Column(length = 12)
    private String phone;

    @Column(length = 512)
    private String comment;

    @ManyToOne
    private Localities localities;

    @ManyToOne
    private County county;

    @OneToOne(cascade = CascadeType.PERSIST)
    private AddressDetails address;
}
