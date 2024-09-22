package com.OneToOne.OneToOneTest.controller;

import com.OneToOne.OneToOneTest.entity.InstructorDetail;
import com.OneToOne.OneToOneTest.service.InstDetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/instructordetail")
public class InstructorDetailController {

    private final InstDetService instructorDetailService;

    @Autowired
    public InstructorDetailController(InstDetService instructorDetailService) {
        this.instructorDetailService = instructorDetailService;
    }

    // 1. Get all InstructorDetails
    @GetMapping
    public List<InstructorDetail> getAllInstructorDetails() {
        return instructorDetailService.getAllInstructorDetails();
    }

    // 2. Get InstructorDetail by ID
    @GetMapping("/{id}")
    public ResponseEntity<InstructorDetail> getInstructorDetailById(@PathVariable int id) {
        Optional<InstructorDetail> instructorDetailOptional = instructorDetailService.getInstructorDetailById(id);
        return instructorDetailOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 3. Get InstructorDetail and associated Instructor by YouTube channel
    @GetMapping("/youtube/{youtubeChannel}")
    public ResponseEntity<InstructorDetail> getInstructorDetailByYoutubeChannel(@PathVariable String youtubeChannel) {
        Optional<InstructorDetail> instructorDetailOptional = instructorDetailService.findInstructorDetailAndInstructorByYoutubeChannel(youtubeChannel);
        return instructorDetailOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 4. Create a new InstructorDetail
    @PostMapping
    public ResponseEntity<InstructorDetail> createInstructorDetail(@RequestBody InstructorDetail instructorDetail) {
        InstructorDetail savedInstructorDetail = instructorDetailService.saveInstructorDetail(instructorDetail);
        return ResponseEntity.ok(savedInstructorDetail);
    }

    // 5. Update an existing InstructorDetail by ID
    @PutMapping("/{id}")
    public ResponseEntity<InstructorDetail> updateInstructorDetail(@PathVariable int id, @RequestBody InstructorDetail instructorDetail) {
        try {
            InstructorDetail updatedInstructorDetail = instructorDetailService.updateInstructorDetail(id, instructorDetail);
            return ResponseEntity.ok(updatedInstructorDetail);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // 6. Delete an InstructorDetail by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstructorDetail(@PathVariable int id) {
        try {
            instructorDetailService.deleteInstructorDetail(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}