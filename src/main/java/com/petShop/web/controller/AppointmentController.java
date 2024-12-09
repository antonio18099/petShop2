package com.petShop.web.controller;


import com.petShop.domain.dto.AppointmentDTO;

import com.petShop.domain.dto.PetDTO;
import com.petShop.domain.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/getAll")
    public ResponseEntity<Iterable<AppointmentDTO>> getAll() {
        Iterable<AppointmentDTO> pets = appointmentService.getAll();
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    @GetMapping("/getById/{id_cita}")
    public Optional<AppointmentDTO> getIdAppointment(@PathVariable("id_cita") int idAppointment) {
        return appointmentService.getIdAppointment(idAppointment);
    }
    @PostMapping("/save")
    public AppointmentDTO save(@RequestBody AppointmentDTO appointmentDTO) {
        return appointmentService.save(appointmentDTO);
    }
    @PutMapping("/update")
    public AppointmentDTO update(@RequestBody AppointmentDTO appointmentDTO) {
        return appointmentService.update(appointmentDTO);
    }
    @DeleteMapping("/delete/{id_cita}")
    public void delete(@PathVariable("id_cita") int idAppointment) {
        appointmentService.delete(idAppointment);
    }
}
