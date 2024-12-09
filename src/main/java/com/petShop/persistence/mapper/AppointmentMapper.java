package com.petShop.persistence.mapper;


import com.petShop.domain.dto.AppointmentDTO;
import com.petShop.domain.dto.PetDTO;
import com.petShop.persistence.entity.Appointment;
import com.petShop.persistence.entity.Pet;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {PetMapper.class,VeterinarianMapper.class})

public interface AppointmentMapper {

    @Mappings({
            @Mapping(source = "idAppointment", target = "idCita"),
            @Mapping(source = "day", target = "diaCita"),
            @Mapping(source = "month", target = "mesCita"),
            @Mapping(source = "reason", target = "razon"),
            @Mapping(source = "veterinarian.idVeterinarian", target = "idveterinario"),
            @Mapping(source = "pet.idPet", target = "idmascota")
    })
    AppointmentDTO toAppointmentDTO(Appointment appointment);

    @Mappings({
            @Mapping(source = "idCita", target = "idAppointment"),
            @Mapping(source = "diaCita", target = "day"),
            @Mapping(source = "mesCita", target = "month"),
            @Mapping(source = "razon", target = "reason"),
            @Mapping(target = "veterinarian.idVeterinarian", source = "idveterinario"),
            @Mapping(target = "pet.idPet", source = "idmascota")
    })
    Appointment toAppointment(AppointmentDTO appointmentDTO);


}
