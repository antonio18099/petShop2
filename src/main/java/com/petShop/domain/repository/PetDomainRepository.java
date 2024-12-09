package com.petShop.domain.repository;

import com.petShop.domain.dto.PetDTO;
import java.util.List;
import java.util.Optional;

public interface PetDomainRepository {
    Iterable<PetDTO> getAll();
    Optional<PetDTO> getPetById(int idPet);
    PetDTO save(PetDTO petDTO);
    PetDTO update(PetDTO petDTO);
    void delete(int idPet);
    boolean existsPet(int idPet);
    long countAll();
    Optional<List<PetDTO>> getByName(String name);

//    List<PetDTO> findBySpeciesOrderByIdAsc(String species);
}