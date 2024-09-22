package com.OneToOne.OneToOneTest.service;

import com.OneToOne.OneToOneTest.entity.Instructor;
import com.OneToOne.OneToOneTest.repository.InstructorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstService implements IinstService {



    private final InstructorRepo instructorRepository;

    // Constructor-based Dependency Injection
    @Autowired
    public InstService(InstructorRepo instructorRepository) {
        this.instructorRepository = instructorRepository;
    }
    @Override
    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    @Override
    public Optional<Instructor> getInstructorById(int id) {
        return instructorRepository.findById(id);
    }

    @Override
    public Instructor saveInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor updateInstructor(int id, Instructor updatedInstructor) {
        Optional<Instructor> optionalInstructor = instructorRepository.findById(id);
        if (optionalInstructor.isPresent()) {
            Instructor instructor = optionalInstructor.get();
            instructor.setFirstName(updatedInstructor.getFirstName());
            instructor.setLastName(updatedInstructor.getLastName());
            instructor.setEmail(updatedInstructor.getEmail());
            instructor.setInstructorDetail(updatedInstructor.getInstructorDetail());
            return instructorRepository.save(instructor);
        } else {
            throw new RuntimeException("Instructor not found with id: " + id);
        }
    }

    @Override
    public void deleteInstructor(int id) {
        instructorRepository.deleteById(id);
    }

    @Override
    public List<Instructor> findInstructorsByFirstName(String firstName) {
        return instructorRepository.findInstructorsByFirstName(firstName);

    }

    @Override
    public Optional<Instructor> findInstructorByEmail(String email) {
        Optional<Instructor> inst = instructorRepository.findInstructorsByEmail(email);

        if (inst.isPresent()) {
            return inst;
        } else {
            throw new RuntimeException("Instructor not found with email: " + email);
        }
    }

}
