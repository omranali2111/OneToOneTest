package com.OneToOne.OneToOneTest.repository;

import com.OneToOne.OneToOneTest.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstructorRepo extends JpaRepository<Instructor, Integer> {
    @Query(value = "SELECT * FROM instructor WHERE first_name = :firstName", nativeQuery = true)
    List<Instructor> findInstructorsByFirstName(@Param("firstName") String firstName);

    @Query(value = "SELECT * FROM instructor WHERE email = :email", nativeQuery = true)
    Optional<Instructor> findInstructorsByEmail(@Param("email") String firstName);



}