package com.petShop.persistence;

import com.petShop.domain.dto.OwnerDTO;
import com.petShop.domain.repository.OwnerDomainRepository;
import com.petShop.persistence.crud.OwnerCrudRepository;
import com.petShop.persistence.entity.Owner;
import com.petShop.persistence.mapper.OwnerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class OwnerRepository implements OwnerDomainRepository {

    @Autowired
    private OwnerCrudRepository ownerCrudRepository;

    @Autowired
    private OwnerMapper mapper;
    @Override
    public Iterable<OwnerDTO> getAll() {
        Iterable<Owner> owners = ownerCrudRepository.findAll();
        // Mapeo explícito de cada entidad a DTO
        return ((List<Owner>) owners).stream()
                .map(mapper::toOwnerDTO) // Mapea cada Pet a PetDTO
                .collect(Collectors.toList());
    }

    @Override
    public Optional<OwnerDTO> getOwnerById(int idOwner){
        Optional<Owner> owner = ownerCrudRepository.findById(idOwner);
        return owner.map(mapper::toOwnerDTO);
    }
    @Override
    public OwnerDTO save(OwnerDTO ownerDTO){
        Owner owner = mapper.toEntity(ownerDTO);
        if (!existsOwner(owner.getIdOwner())) {
            Owner savedOwner = ownerCrudRepository.save(owner);
            return mapper.toOwnerDTO(savedOwner);
        }
        throw new IllegalArgumentException("El registro ya existe");
    }

    @Override
    public OwnerDTO update(OwnerDTO ownerDTO){
        Owner owner = mapper.toEntity(ownerDTO);
        if (existsOwner(owner.getIdOwner())) {
            Owner updateOwner = ownerCrudRepository.save(owner);
            return mapper.toOwnerDTO(updateOwner);
        }
        throw new IllegalArgumentException("El registro no existe");
    }
    @Override
    public void delete(int idOwner){

        if (existsOwner(idOwner)) {
            ownerCrudRepository.deleteById(idOwner);
        } else {
            throw new IllegalArgumentException("El registro no existe");
        }
    }
    @Override
    public boolean existsOwner(int idOwner){
        return ownerCrudRepository.existsById(idOwner);
    }
    @Override
    public long countAll(){
        return ownerCrudRepository.count();
    }

    @Override
    public Optional<List<OwnerDTO>> getByName(String name) {
        return Optional.empty();
    }
}