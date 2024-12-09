package com.petShop.domain;

import com.petShop.persistence.entity.Pet;
import lombok.Data;

@Data
public class PetDomain {
    private Integer idMascota;
    private String mascota;
    private String especie;
    private int edad;
    private String genero;
    private OwnerDomain propietarioDominio;
}