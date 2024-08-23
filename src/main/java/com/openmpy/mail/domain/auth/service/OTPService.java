package com.openmpy.mail.domain.auth.service;

import com.openmpy.mail.common.code.ErrorCode;
import com.openmpy.mail.common.exception.CustomException;
import com.openmpy.mail.common.validator.EmailValidator;
import com.openmpy.mail.domain.auth.model.request.SendOTPRequest;
import com.openmpy.mail.domain.auth.model.response.SendOTPResponse;
import com.openmpy.mail.domain.repository.UserRepository;
import com.openmpy.mail.domain.repository.entity.User;
import com.openmpy.mail.security.OTP;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.openmpy.mail.common.constants.Constants.INVITE_QR_TEMPLATE;
import static com.openmpy.mail.common.constants.Constants.SECRET;

@Slf4j
@RequiredArgsConstructor
@Service
public class OTPService {

    private final UserRepository userRepository;
    private final MailService mailService;

    public SendOTPResponse sendOTP(SendOTPRequest request) {
        String email = request.email();
        if (!EmailValidator.isValidEmail(email)) {
            throw new CustomException(ErrorCode.NOT_VALID_EMAIL_REQUEST);
        }

        User user = userRepository.findByEmail(email).orElseGet(() -> userRepository.save(
                User.builder()
                        .email(email)
                        .isValid(false)
                        .build()
        ));

        log.info("Get From DB {}", user.getEmail());

        if (!user.getIsValid()) {
            // OTP 전송
            String link = OTP.generateQRCodeURL(email, SECRET);
            Map<String, String> data = Map.of(
                    "email", email,
                    "link", link
            );

            mailService.sendTemplatedEmail(INVITE_QR_TEMPLATE, data, email);
        }
        return new SendOTPResponse(email);
    }
}
