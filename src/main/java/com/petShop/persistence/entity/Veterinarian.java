package com.petShop.persistence.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name = "veterinario")
public class Veterinarian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_veterinario")
    private Integer idVeterinarian;

    @Column(name = "nombre")
    private String nameVeterinarian;

    @Column(name = "apellidos")
    private String lastName;

    @Column(name = "especialidad")
    private String speciality;

    @Column(name = "telefono")
    private String number;

    @Column(name = "fecha_ingreso")
    private String date;

    public Integer getIdVeterinarian() {return idVeterinarian;}

    public void setIdVeterinarian(Integer idVeterinarian) {
        this.idVeterinarian = idVeterinarian;
    }

}