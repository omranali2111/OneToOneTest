package com.OneToOne.OneToOneTest.service;

import com.OneToOne.OneToOneTest.entity.Instructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface IinstService  {

    // Method to get all instructors
    List<Instructor> getAllInstructors();

    // Method to get an instructor by ID
    Optional<Instructor> getInstructorById(int id);

    // Method to save or update an instructor
    Instructor saveInstructor(Instructor instructor);

    // Method to update an existing instructor
    Instructor updateInstructor(int id, Instructor updatedInstructor);

    // Method to delete an instructor by ID
    void deleteInstructor(int id);

    // Custom method to find instructors by first name
    List<Instructor> findInstructorsByFirstName(String firstName);

    // Custom method to find instructors by email
    Optional<Instructor> findInstructorByEmail(String email);
}
