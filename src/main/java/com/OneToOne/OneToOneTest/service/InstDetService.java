package com.OneToOne.OneToOneTest.service;

import com.OneToOne.OneToOneTest.entity.InstructorDetail;
import com.OneToOne.OneToOneTest.repository.InstructorDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstDetService implements  IinstDetSrevice{


    private final InstructorDetailRepo instructorDetailRepository;

    // Constructor-based Dependency Injection
    @Autowired
    public InstDetService(InstructorDetailRepo instructorDetailRepository) {
        this.instructorDetailRepository = instructorDetailRepository;
    }

    @Override
    public List<InstructorDetail> getAllInstructorDetails() {
        return instructorDetailRepository.findAll();
    }

    @Override
    public Optional<InstructorDetail> getInstructorDetailById(int id) {
        return instructorDetailRepository.findById(id);
    }


    @Override
    public InstructorDetail saveInstructorDetail(InstructorDetail instructorDetail) {
        return instructorDetailRepository.save(instructorDetail);
    }

    @Override
    public InstructorDetail updateInstructorDetail(int id, InstructorDetail updatedInstructorDetail) {
        Optional<InstructorDetail> existingDetailOptional = instructorDetailRepository.findById(id);

        if (existingDetailOptional.isPresent()) {
            InstructorDetail existingDetail = existingDetailOptional.get();
            existingDetail.setYoutubeChannel(updatedInstructorDetail.getYoutubeChannel());
            existingDetail.setHobby(updatedInstructorDetail.getHobby());

            return instructorDetailRepository.save(existingDetail);
        } else {
            throw new RuntimeException("InstructorDetail not found with id: " + id);
        }
    }
    @Override
    public void deleteInstructorDetail(int id) {
        if (instructorDetailRepository.existsById(id)) {
            instructorDetailRepository.deleteById(id);
        } else {
            throw new RuntimeException("InstructorDetail not found with id: " + id);
        }
    }
    @Override
    public Optional<InstructorDetail> findInstructorDetailAndInstructorByYoutubeChannel(String youtubeChannel) {
        return instructorDetailRepository.findInstructorDetailAndInstructorByYoutubeChannel(youtubeChannel);
    }
}
