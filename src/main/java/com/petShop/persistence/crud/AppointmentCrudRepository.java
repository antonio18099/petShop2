package com.petShop.persistence.crud;


import com.petShop.persistence.entity.Appointment;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentCrudRepository  extends CrudRepository<Appointment,Integer> {
}