package com.petShop.persistence.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table (name = "propietarios")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_propietario")
    private Integer idOwner;

    @Column(name = "nombre_propietario")
    private String nameOwner;

    @Column(name = "apellido_propietario")
    private String lastNameOwner;

    @Column(name = "correo")
    private String email;

    @Column(name = "telefono")
    private String number;

    @Column(name = "direccion")
    private String address;

    @OneToMany(mappedBy = "owner")
    private List<Pet> pets;

    public Integer getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(Integer idOwner) {
        this.idOwner = idOwner;
    }

}