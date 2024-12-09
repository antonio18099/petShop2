package com.petShop.domain.service;

import com.petShop.domain.dto.OwnerDTO;
import com.petShop.domain.repository.OwnerDomainRepository;
import com.petShop.persistence.mapper.OwnerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OwnerService {

    @Autowired
    private OwnerDomainRepository ownerDomainRepository; //llamar a petrepositoriy

    @Autowired
    private OwnerMapper petMapper;

    public Iterable<OwnerDTO> getAll() {
        return ownerDomainRepository.getAll();
    }

    public Optional<OwnerDTO> getOwnerById(int id) {
        return ownerDomainRepository.getOwnerById( id);
    }

    public OwnerDTO save(OwnerDTO ownerDTO){
        return ownerDomainRepository.save(ownerDTO);
    }

    public OwnerDTO update(OwnerDTO ownerDTO){
        return ownerDomainRepository.update(ownerDTO);
    }

    public Optional<List<OwnerDTO>> getByName(String name) {
        return ownerDomainRepository.getByName(name);
    }

    public void delete(int id){
        ownerDomainRepository.delete(id);
    }
    public boolean existsOwner(int id) {
        return ownerDomainRepository.existsOwner(id);
    }

    public long countAll() {
        return ownerDomainRepository.countAll();
    }
}