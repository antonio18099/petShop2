package com.petShop.domain.dto;


import lombok.Data;

@Data
public class AppointmentDTO {
    private Integer idCita;
    private Integer diaCita;
    private String mesCita;
    private String razon;
    private Integer idveterinario;
    private Integer idmascota;

}