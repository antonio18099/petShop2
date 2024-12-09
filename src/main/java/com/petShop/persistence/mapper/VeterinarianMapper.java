package com.petShop.persistence.mapper;

import com.petShop.domain.dto.VeterinarianDTO;
import com.petShop.persistence.entity.Veterinarian;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VeterinarianMapper {

    @Mappings({
            @Mapping(source = "idVeterinarian", target = "idVeterinario"),
            @Mapping(source = "nameVeterinarian", target = "nombre"),
            @Mapping(source = "lastName", target = "apellido"),
            @Mapping(source = "speciality", target = "especialidad"),
            @Mapping(source = "number", target = "telefono"),
            @Mapping(source = "date", target = "fecha")
    })
    VeterinarianDTO toVeterinarianDTO(Veterinarian veterinarian);

    @Mappings({
            @Mapping(source = "idVeterinario", target = "idVeterinarian"),
            @Mapping(source = "nombre", target = "nameVeterinarian"),
            @Mapping(source = "apellido", target = "lastName"),
            @Mapping(source = "especialidad", target = "speciality"),
            @Mapping(source = "telefono", target = "number"),
            @Mapping(source = "fecha", target = "date")
    })
    Veterinarian toEntity(VeterinarianDTO veterinarianDTO);

    List<VeterinarianDTO> toVeterinarianDTO(List<Veterinarian> veterinarians);
}