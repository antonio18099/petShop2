package com.petShop.persistence.crud;

import com.petShop.persistence.entity.Pet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PetCrudRepository extends CrudRepository<Pet,Integer> {

}