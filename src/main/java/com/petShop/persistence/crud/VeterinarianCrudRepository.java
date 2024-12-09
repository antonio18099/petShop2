package com.petShop.persistence.crud;

import com.petShop.persistence.entity.Veterinarian;
import org.springframework.data.repository.CrudRepository;

public interface VeterinarianCrudRepository extends CrudRepository<Veterinarian,Integer> {


}