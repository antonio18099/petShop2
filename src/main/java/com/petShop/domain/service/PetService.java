package com.petShop.domain.service;


import com.petShop.domain.dto.PetDTO;
import com.petShop.domain.repository.PetDomainRepository;
import com.petShop.persistence.mapper.PetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    @Autowired
    private PetDomainRepository petDomainRepository; //llamar a petrepositoriy

    @Autowired
    private PetMapper petMapper;

    public Iterable<PetDTO> getAll() {
        return petDomainRepository.getAll();
    }

    public  Optional<PetDTO> getPetById(int id) {
        return petDomainRepository.getPetById( id);
    }

    public PetDTO save(PetDTO petDTO){
        return petDomainRepository.save(petDTO);
    }

    public Optional<List<PetDTO>> getByName(String name) {

        return petDomainRepository.getByName(name);
    }

    public PetDTO update(PetDTO petDTO){
        return petDomainRepository.update(petDTO);
    }

    public void delete(int id){
        petDomainRepository.delete(id);
    }

    public boolean existsPet(int id) {

        return petDomainRepository.existsPet(id);
    }

    public long countAll() {

        return petDomainRepository.countAll();
    }

//    public List<PetDTO> getBySpecies(String species) {
//        return petDomainRepository.findBySpeciesOrderByIdAsc(species);
//    }


}