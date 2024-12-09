package com.petShop.domain.dto;

import lombok.Data;

@Data
public class VeterinarianDTO {
    private Integer idVeterinario;
    private String nombre;
    private String apellido;
    private String especialidad;
    private String telefono;
    private String fecha;


}