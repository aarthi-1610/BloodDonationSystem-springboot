package com.blooddonation.system.service;

import com.blooddonation.system.entity.Donor;
import java.util.List;

public interface DonorService {
    List<Donor> getAllDonors();
    Donor saveDonor(Donor donor);

    // 👉 add these
    Donor getDonorById(Long id);
    Donor updateDonor(Long id, Donor donor);
    void deleteDonorById(Long id);
}
