package com.petShop.persistence.mapper;


import com.petShop.domain.dto.OwnerDTO;
import com.petShop.persistence.entity.Owner;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper (componentModel = "spring")
public interface OwnerMapper {
    @Mappings({
            @Mapping(source = "idOwner",target = "idPropietario"),
            @Mapping(source = "nameOwner",target = "propietario"),
            @Mapping(source = "lastNameOwner",target = "apellido"),
            @Mapping(source = "email",target = "correo"),
            @Mapping(source = "number",target = "numero"),
            @Mapping(source = "address",target = "direccion")
    })
    OwnerDTO toOwnerDTO(Owner owner);
    Owner toEntity(OwnerDTO ownerDTO);
    List<OwnerDTO> toOwnerDTO(List<Owner> owners);

    @InheritInverseConfiguration
    Owner toOwner(OwnerDTO ownerDTO);
}