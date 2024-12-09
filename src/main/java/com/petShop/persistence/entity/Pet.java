package com.petShop.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table (name = "mascotas")
public class Pet {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota")
    private Integer idPet;

    @Column(name = "nombre")
    private String namePet;

    @Column(name = "especie")
    private String species;

    @Column(name = "edad")
    private int age;

    @Column(name = "genero")
    private String gender;

    @ManyToOne
    @JoinColumn(name = "id_propietario") //llave a foranea
    private Owner owner;

    public Integer getIdPet() {
        return idPet;
    }

    public void setIdPet(Integer idPet) {
        this.idPet = idPet;
    }

    public String getNamePet() {
        return namePet;
    }

    public void setNamePet(String namePet) {
        this.namePet = namePet;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}