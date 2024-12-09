package com.petShop.domain.repository;



import com.petShop.domain.dto.AppointmentDTO;

import java.util.Optional;

public interface AppointmentDomainRepository {
    Iterable<AppointmentDTO> getAll();
    Optional<AppointmentDTO> getIdAppointment(int idAppointment);
    AppointmentDTO save(AppointmentDTO petDTO);
    AppointmentDTO update(AppointmentDTO petDTO);
    void delete(int idAppointment);

}