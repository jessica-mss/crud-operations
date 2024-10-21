package com.development.crud_operations.patient;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService service;

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) throws Exception {
        try {
            PatientResponseDTO body = service.findById(id);
            return new ResponseEntity<>(body, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping
//    public String test() {
//        return "Hello World";
//    }


}
