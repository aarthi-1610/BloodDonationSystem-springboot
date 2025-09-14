package com.blooddonation.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.blooddonation.system.entity.Receiver;

public interface ReceiverRepository extends JpaRepository<Receiver, Long> {
}
