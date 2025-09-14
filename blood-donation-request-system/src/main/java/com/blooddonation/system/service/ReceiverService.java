package com.blooddonation.system.service;

import com.blooddonation.system.entity.Receiver;

public interface ReceiverService {
    /** Returns success/failure message; saves receiver only if available */
    String requestBlood(Receiver receiver);
}
