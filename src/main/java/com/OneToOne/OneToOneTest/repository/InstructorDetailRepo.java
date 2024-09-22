package com.OneToOne.OneToOneTest.repository;


import com.OneToOne.OneToOneTest.entity.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstructorDetailRepo extends JpaRepository<InstructorDetail, Integer> {
    @Query("SELECT id FROM InstructorDetail id JOIN FETCH id.instructor i WHERE id.youtubeChannel = :youtubeChannel")
    Optional<InstructorDetail> findInstructorDetailAndInstructorByYoutubeChannel(@Param("youtubeChannel") String youtubeChannel);
}