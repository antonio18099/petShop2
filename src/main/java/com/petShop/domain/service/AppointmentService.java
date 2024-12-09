package com.petShop.domain.service;
import com.petShop.domain.dto.AppointmentDTO;
import com.petShop.domain.repository.AppointmentDomainRepository;
import com.petShop.persistence.mapper.AppointmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentDomainRepository appointmentDomainRepository;
    @Autowired
    private AppointmentMapper appointmentMapper;

    public Iterable<AppointmentDTO> getAll() {
        return appointmentDomainRepository.getAll();
    }

    public Optional<AppointmentDTO> getIdAppointment(int idAppointment) {
        return appointmentDomainRepository.getIdAppointment(idAppointment);
    }

    public AppointmentDTO save(AppointmentDTO appointmentDTO){
        return appointmentDomainRepository.save(appointmentDTO);
    }

    public AppointmentDTO update(AppointmentDTO appointmentDTO){
        return appointmentDomainRepository.update(appointmentDTO);
    }

    public void delete(int idAppointment){
        appointmentDomainRepository.delete(idAppointment);
    }

}
