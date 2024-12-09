package com.petShop.web.controller;

import com.petShop.domain.dto.PetDTO;
import com.petShop.domain.service.PetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pets")
public class PetController {
    @Autowired
    private PetService petService;


    // Consultar todos los registros
    @Operation(summary = "Obtener todas las mascotas", description = "Retorna una lista de todas las mascotas registradas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de mascotas obtenida exitosamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/getAll")
    public ResponseEntity<Iterable<PetDTO>> getAll() {
        Iterable<PetDTO> pets = petService.getAll();
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public Optional<PetDTO> getPetById(@PathVariable("id") int id) {
        return petService.getPetById(id);
    }

    @PostMapping("/save")
    public PetDTO save(@RequestBody PetDTO petDTO) {
        return petService.save(petDTO);
    }

    @PutMapping("/update")
    public PetDTO update(@RequestBody PetDTO petDTO) {
        return petService.update(petDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) {
        petService.delete(id);
    }

    @GetMapping("/existsPet/{id}")
    public boolean existsPet(@PathVariable("id") int id) {
        return petService.existsPet(id);
    }

    @GetMapping("/countPets")
    public long countPets() {
        return petService.countAll();
    }

//    @GetMapping("/getBySpecies/{species}")
//    public List<PetDTO> getBySpecies(@PathVariable("species") String species) {
//        return petService.getBySpecies(species);
//    }


}