package com.petShop.persistence.mapper;

import com.petShop.domain.dto.PetDTO;
import com.petShop.persistence.entity.Owner;
import com.petShop.persistence.entity.Pet;
import com.petShop.persistence.mapper.OwnerMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {OwnerMapper.class})
public interface PetMapper {
    @Mappings({
            @Mapping(source = "idPet",target = "idMascota"),
            @Mapping(source = "namePet",target = "mascota"),
            @Mapping(source = "species",target = "especie"),
            @Mapping(source = "age",target = "edad"),
            @Mapping(source = "gender",target = "genero"),
            @Mapping(source = "owner",target = "propietarioDominio") //es una llave foranea
    })
    PetDTO toPetDTO(Pet pet);
//    List<PetDTO> toPetDTOs(List<Pet> pets);

    // Método de mapeo explícito para convertir Propietario a Long (su id)
    @InheritInverseConfiguration
//    Pet toPet(PetDTO petDTO);

    @Mapping(target = "owner", source = "propietarioDominio")
    Pet toEntity(PetDTO petDTO);

    @Mapping(target = "idMascota", source = "idPet")
    default Integer map(Pet pet) {
        if (pet != null) {
            return pet.getIdPet(); // Retorna el id depet2
        } return null;
    }

    // Método de mapeo explícito para convertir Propietario
    @Mapping(target = "idOwner", source = "owner")
    default Integer map(Owner owner) {
        if (owner != null) {
            return owner.getIdOwner(); // Retorna el id del propietario
        } return null;
    }

    // Método de mapeo explícito para convertir Long (id) a Propietario
    @Mapping(target = "idOwner", source = "propietarioDominio")
    default Owner map(Integer propietarioDominio) {
        if (propietarioDominio != null) {
            Owner owner = new Owner();
            owner.setIdOwner(propietarioDominio); // Crear Propietario con el id proporcionado
            return owner;
        } return null;
    }

}