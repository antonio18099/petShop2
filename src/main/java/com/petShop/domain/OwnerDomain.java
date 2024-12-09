package com.petShop.domain;


import com.petShop.persistence.entity.Pet;
import lombok.Data;

import java.util.List;

@Data
public class OwnerDomain {
    private Integer idPorpietario;
    private String propietario;
    private String apellido;
    private String correo;
    private Integer numero;
    private String direccion;
}