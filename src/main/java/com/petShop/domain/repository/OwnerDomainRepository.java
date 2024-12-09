package com.petShop.domain.repository;

import com.petShop.domain.dto.OwnerDTO;

import java.util.List;
import java.util.Optional;

public interface OwnerDomainRepository {

    Iterable<OwnerDTO> getAll();
    Optional<OwnerDTO> getOwnerById(int idOwner);
    OwnerDTO save(OwnerDTO ownerDTO);
    OwnerDTO update(OwnerDTO ownerDTO);
    void delete(int idOwner);
    boolean existsOwner(int idOwner);
    long countAll();
    Optional<List<OwnerDTO>> getByName(String name);
}