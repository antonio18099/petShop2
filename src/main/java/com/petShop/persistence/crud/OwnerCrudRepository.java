package com.petShop.persistence.crud;

import com.petShop.persistence.entity.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerCrudRepository extends CrudRepository<Owner,Integer> {
}