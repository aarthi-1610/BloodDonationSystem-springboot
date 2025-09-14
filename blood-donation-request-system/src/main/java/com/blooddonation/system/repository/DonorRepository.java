package com.blooddonation.system.repository;

import com.blooddonation.system.entity.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DonorRepository extends JpaRepository<Donor, Long> {

    // Exact city match
    List<Donor> findByBloodGroupIgnoreCaseAndCityIgnoreCase(String bloodGroup, String city);

    // Fallback: any city
    List<Donor> findByBloodGroupIgnoreCase(String bloodGroup);
    

        // This will auto-generate SQL like: SELECT COUNT(*) > 0 FROM donor WHERE LOWER(blood_group) = LOWER(?)
        boolean existsByBloodGroupIgnoreCase(String bloodGroup);
    

}
