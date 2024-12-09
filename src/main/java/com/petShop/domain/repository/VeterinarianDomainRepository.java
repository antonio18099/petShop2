package com.petShop.domain.repository;

import com.petShop.domain.dto.VeterinarianDTO;

import java.util.Optional;

public interface VeterinarianDomainRepository {
    Iterable<VeterinarianDTO> getAll();
    Optional<VeterinarianDTO> getVeterinarianById(int idVeterinarian);
    VeterinarianDTO save(VeterinarianDTO veterinarianDTO);
    VeterinarianDTO update(VeterinarianDTO veterinarianDTO);
    void delete(int idVeterinarian);

}