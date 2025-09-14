package com.blooddonation.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blooddonation.system.entity.Receiver;
import com.blooddonation.system.repository.DonorRepository;
import com.blooddonation.system.repository.ReceiverRepository;
import com.blooddonation.system.service.ReceiverService;

@Service
public class ReceiverServiceImpl implements ReceiverService {

    @Autowired
    private ReceiverRepository receiverRepository;

    @Autowired
    private DonorRepository donorRepository;

    @Override
    public String requestBlood(Receiver receiver) {
        boolean available = donorRepository
                .existsByBloodGroupIgnoreCase(receiver.getBloodGroup());

        if (available) {
            receiverRepository.save(receiver);
            return "✅ Blood Available. Receiver details saved.";
        } else {
            return "❌ Sorry! Requested blood group is not available.";
        }
    }
}
