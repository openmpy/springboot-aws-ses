package com.openmpy.mail.domain.auth.service;

import com.openmpy.mail.domain.auth.model.request.SendOTPRequest;
import com.openmpy.mail.domain.auth.model.response.SendOTPResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class OTPService {

    // Repository

    public SendOTPResponse sendOTP(SendOTPRequest request) {
        String email = request.email();
        return new SendOTPResponse(email);
    }
}
