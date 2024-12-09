package com.petShop.domain.dto;

import com.petShop.persistence.entity.Pet;
import lombok.Data;

import java.util.List;
@Data
public class OwnerDTO {
    private Integer idPropietario;
    private String propietario;
    private String apellido;
    private String correo;
    private Integer numero;
    private String direccion;
}