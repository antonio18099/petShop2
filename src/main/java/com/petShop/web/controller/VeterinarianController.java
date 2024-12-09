package com.petShop.web.controller;


import com.petShop.domain.dto.OwnerDTO;
import com.petShop.domain.dto.PetDTO;
import com.petShop.domain.dto.VeterinarianDTO;
import com.petShop.domain.service.VeterinarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/veterinarians")
public class VeterinarianController {
    @Autowired
    private VeterinarianService veterinarianService;

    @GetMapping("/getAll")
    public ResponseEntity<Iterable<VeterinarianDTO>> getAll() {
        Iterable<VeterinarianDTO> veterinarians = veterinarianService.getAll();
        return new ResponseEntity<>(veterinarians, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public Optional<VeterinarianDTO> getVeterinarianById(@PathVariable("id") int id) {
        return veterinarianService.getVeterinarianById(id);
    }

    @PostMapping("/save")
    public VeterinarianDTO save(@RequestBody VeterinarianDTO veterinarianDTO) {
        return veterinarianService.save(veterinarianDTO);
    }
    @PutMapping("/update")
    public VeterinarianDTO update(@RequestBody VeterinarianDTO veterinarianDTO) {
        return veterinarianService.update(veterinarianDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) {
        veterinarianService.delete(id);
    }
}