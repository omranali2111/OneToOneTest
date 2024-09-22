package com.OneToOne.OneToOneTest.service;

import com.OneToOne.OneToOneTest.entity.Instructor;
import com.OneToOne.OneToOneTest.entity.InstructorDetail;

import java.util.List;
import java.util.Optional;

public interface IinstDetSrevice {



    // Get all instructor details
    List<InstructorDetail> getAllInstructorDetails();

    // Get an instructor detail by ID
    Optional<InstructorDetail> getInstructorDetailById(int id);

    // Save or update instructor detail
    InstructorDetail saveInstructorDetail(InstructorDetail instructorDetail);

    // Update an existing instructor detail by ID
    InstructorDetail updateInstructorDetail(int id, InstructorDetail updatedInstructorDetail);

    // Delete an instructor detail by ID
    void deleteInstructorDetail(int id);

    // Custom method to find instructor detail by a specific field (for example, YouTube channel)
    Optional<InstructorDetail> findInstructorDetailAndInstructorByYoutubeChannel(String youtubeChannel);
}
