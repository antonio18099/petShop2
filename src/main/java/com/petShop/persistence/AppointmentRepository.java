package com.petShop.persistence;


import com.petShop.domain.dto.AppointmentDTO;
import com.petShop.domain.repository.AppointmentDomainRepository;
import com.petShop.persistence.crud.AppointmentCrudRepository;
import com.petShop.persistence.entity.Appointment;
import com.petShop.persistence.entity.Veterinarian;
import com.petShop.persistence.mapper.AppointmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class AppointmentRepository implements AppointmentDomainRepository {
    @Autowired
    private AppointmentCrudRepository appointmentCrudRepository;
    @Autowired
    private AppointmentMapper mapper;


    public Iterable<AppointmentDTO> getAll() {
        Iterable<Appointment> appointments = appointmentCrudRepository.findAll();
        return ((List<Appointment>) appointments).stream()
                .map(mapper::toAppointmentDTO
                ) //
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AppointmentDTO> getIdAppointment(int idAppointment) {
        Optional<Appointment> appointment = appointmentCrudRepository.findById(idAppointment);
        return appointment.map(mapper::toAppointmentDTO);
    }

    @Override
    public AppointmentDTO save(AppointmentDTO appointmentDTO) {
        Appointment appointment = mapper.toAppointment(appointmentDTO);

        // Si el ID es nulo, es un registro nuevo
        if (appointment.getIdAppointment() == null || !existsAppointment(appointment.getIdAppointment())) {
            Appointment savedAppointment = appointmentCrudRepository.save(appointment);
            return mapper.toAppointmentDTO(savedAppointment);
        }

        throw new IllegalArgumentException("El registro ya existe");
    }

    @Override
    public AppointmentDTO update(AppointmentDTO appointmentDTO) {
        Appointment appointment = mapper.toAppointment(appointmentDTO);
        if (existsAppointment(appointment.getIdAppointment())) {
            Appointment updateAppointment = appointmentCrudRepository.save(appointment);
            return mapper.toAppointmentDTO(updateAppointment);
        }
        throw new IllegalArgumentException("El registro no existe");
    }

    @Override
    public void delete(int idAppointment) {
        if (existsAppointment(idAppointment)) {
            appointmentCrudRepository.deleteById(idAppointment);
        } else {
            throw new IllegalArgumentException("El registro no existe");
        }
    }

    public boolean existsAppointment(int idAppointment){
        return appointmentCrudRepository.existsById(idAppointment);
    }
}