package com.blooddonation.system.service.impl;

import com.blooddonation.system.entity.Donor;
import com.blooddonation.system.repository.DonorRepository;
import com.blooddonation.system.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonorServiceImpl implements DonorService {

    @Autowired
    private DonorRepository donorRepository;

    @Override
    public List<Donor> getAllDonors() {
        return donorRepository.findAll();
    }

    @Override
    public Donor saveDonor(Donor donor) {
        return donorRepository.save(donor);
    }

    // 👉 new methods
    @Override
    public Donor getDonorById(Long id) {
        return donorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid donor id: " + id));
    }

    @Override
    public Donor updateDonor(Long id, Donor updated) {
        Donor existing = getDonorById(id);
        existing.setName(updated.getName());
        existing.setBloodGroup(updated.getBloodGroup());
        existing.setAge(updated.getAge());
        existing.setCity(updated.getCity());
        return donorRepository.save(existing);
    }

    @Override
    public void deleteDonorById(Long id) {
        donorRepository.deleteById(id);
    }
}
