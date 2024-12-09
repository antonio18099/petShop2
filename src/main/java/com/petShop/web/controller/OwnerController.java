package com.petShop.web.controller;

import com.petShop.domain.dto.OwnerDTO;
import com.petShop.domain.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/owners")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @GetMapping("/getAll")
    public Iterable<OwnerDTO> getAll() {
        return ownerService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Optional<OwnerDTO> getOwnerById(@PathVariable("id") int id) {
        return ownerService.getOwnerById(id);
    }

    @PostMapping("/save")
    public OwnerDTO save(@RequestBody OwnerDTO ownerDTO) {
        return ownerService.save(ownerDTO);
    }

    @PutMapping("/update")
    public OwnerDTO update(@RequestBody OwnerDTO ownerDTO) {
        return ownerService.update(ownerDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) {
        ownerService.delete(id);
    }

    @GetMapping("/existsOwner/{id}")
    public boolean existsOwner(@PathVariable("id") int id) {
        return ownerService.existsOwner(id);
    }

    @GetMapping("/countOwners")
    public long countPets() {
        return ownerService.countAll();
    }
}