package com.petShop.domain.service;


import com.petShop.domain.dto.PetDTO;
import com.petShop.domain.dto.VeterinarianDTO;
import com.petShop.domain.repository.VeterinarianDomainRepository;

import com.petShop.persistence.mapper.VeterinarianMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class VeterinarianService {
    @Autowired
    private VeterinarianDomainRepository veterinarianDomainRepository;

    @Autowired
    private VeterinarianMapper veterinarianMapper;

    public Iterable<VeterinarianDTO> getAll() { return veterinarianDomainRepository.getAll();
    }

    public Optional<VeterinarianDTO> getVeterinarianById(int idVeterinarian) {
        return veterinarianDomainRepository.getVeterinarianById(idVeterinarian);
    }

    public VeterinarianDTO save(VeterinarianDTO veterinarianDTO){
        return veterinarianDomainRepository.save(veterinarianDTO);
    }

    public VeterinarianDTO update(VeterinarianDTO veterinarianDTO){
        return veterinarianDomainRepository.update(veterinarianDTO);
    }

    public void delete(int idVeterinarian){
        veterinarianDomainRepository.delete(idVeterinarian);
    }


}