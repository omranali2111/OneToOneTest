package com.OneToOne.OneToOneTest.controller;


import com.OneToOne.OneToOneTest.entity.Instructor;
import com.OneToOne.OneToOneTest.service.InstService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {

    private final InstService instructorService;

    @Autowired
    public InstructorController(InstService instructorService) {
        this.instructorService = instructorService;
    }

    // 1. Get all Instructors
    @GetMapping
    public List<Instructor> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

    // 2. Get Instructor by ID
    @GetMapping("/{id}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable int id) {
        Optional<Instructor> instructorOptional = instructorService.getInstructorById(id);
        return instructorOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 3. Get Instructor by email
    @GetMapping("/email/{email}")
    public ResponseEntity<Instructor> getInstructorByEmail(@PathVariable String email) {
        Optional<Instructor> instructorOptional = instructorService.findInstructorByEmail(email);
        return instructorOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 4. Create a new Instructor
    @PostMapping
    public ResponseEntity<Instructor> createInstructor(@Valid @RequestBody Instructor instructor) {
        Instructor savedInstructor = instructorService.saveInstructor(instructor);
        return ResponseEntity.ok(savedInstructor);
    }

    // 5. Update an existing Instructor by ID
    @PutMapping("/{id}")
    public ResponseEntity<Instructor> updateInstructor(@PathVariable int id, @RequestBody Instructor instructor) {
        try {
            Instructor updatedInstructor = instructorService.updateInstructor(id, instructor);
            return ResponseEntity.ok(updatedInstructor);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // 6. Delete an Instructor by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable int id) {
        try {
            instructorService.deleteInstructor(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
