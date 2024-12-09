package com.petShop.persistence;


import com.petShop.domain.dto.VeterinarianDTO;
import com.petShop.domain.repository.VeterinarianDomainRepository;
import com.petShop.persistence.crud.VeterinarianCrudRepository;
import com.petShop.persistence.entity.Veterinarian;
import com.petShop.persistence.mapper.VeterinarianMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class VeterinarianRepository implements VeterinarianDomainRepository {
    @Autowired
    private VeterinarianCrudRepository veterinarianCrudRepository;


    @Autowired
    private VeterinarianMapper mapper;
    @Override
    public Iterable<VeterinarianDTO> getAll() {
        Iterable<Veterinarian> veterinarians = veterinarianCrudRepository.findAll();
        return ((List<Veterinarian>) veterinarians).stream()
                .map(mapper::toVeterinarianDTO
                ) //
                .collect(Collectors.toList());
    }

    @Override
    public Optional<VeterinarianDTO> getVeterinarianById(int idVeterinarian) {
        Optional<Veterinarian> veterinarian = veterinarianCrudRepository.findById(idVeterinarian);
        return veterinarian.map(mapper::toVeterinarianDTO);
    }

    @Override
//    public VeterinarianDTO save(VeterinarianDTO veterinarianDTO) {
//        Veterinarian veterinarian = mapper.toEntity(veterinarianDTO);
//        if (!existsVeterinarian(veterinarian.getIdVeterinarian())) {
//            Veterinarian savedVeterinarian = veterinarianCrudRepository.save(veterinarian);
//            return mapper.toVeterinarianDTO(savedVeterinarian);
//        }
//        throw new IllegalArgumentException("El registro ya existe");
//    }
    public VeterinarianDTO save(VeterinarianDTO veterinarianDTO) {
        Veterinarian veterinarian = mapper.toEntity(veterinarianDTO);

        // Si el ID es nulo, es un registro nuevo
        if (veterinarian.getIdVeterinarian() == null || !existsVeterinarian(veterinarian.getIdVeterinarian())) {
            Veterinarian savedVeterinarian = veterinarianCrudRepository.save(veterinarian);
            return mapper.toVeterinarianDTO(savedVeterinarian);
        }

        throw new IllegalArgumentException("El registro ya existe");
    }



    @Override
    public VeterinarianDTO update(VeterinarianDTO veterinarianDTO) {
        Veterinarian veterinarian = mapper.toEntity(veterinarianDTO);
        if (existsVeterinarian(veterinarian.getIdVeterinarian())) {
            Veterinarian updateVeterinarian = veterinarianCrudRepository.save(veterinarian);
            return mapper.toVeterinarianDTO(updateVeterinarian);
        }
        throw new IllegalArgumentException("El registro no existe");
    }

    @Override
    public void delete(int idVeterinarian) {
        if (existsVeterinarian(idVeterinarian)) {
            veterinarianCrudRepository.deleteById(idVeterinarian);
        } else {
            throw new IllegalArgumentException("El registro no existe");
        }
    }

    public boolean existsVeterinarian(int idVeterinarian){
        return veterinarianCrudRepository.existsById(idVeterinarian);
    }
}