package com.openmpy.mail.domain.auth.controller;

import com.openmpy.mail.domain.auth.model.request.SendOTPRequest;
import com.openmpy.mail.domain.auth.model.response.SendOTPResponse;
import com.openmpy.mail.domain.auth.service.OTPService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Account API", description = "계정 관련 API")
@RequiredArgsConstructor
@RequestMapping("/api/v1/account")
@RestController
public class AccountController {

    private final OTPService otpService;

    @Operation(
            summary = "Email에 OTP 전송",
            description = "Email에 대해서 OTP를 전송합니다."
    )
    @GetMapping("/make-user/{email}")
    public SendOTPResponse sendOTP(
            @RequestBody @Valid SendOTPRequest request,
            @PathVariable String email
    ) {
        return otpService.sendOTP(request);
    }
}
