package com.openmpy.mail.security;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static com.openmpy.mail.common.constants.Constants.OTP_ISSUER;
import static com.openmpy.mail.common.constants.Constants.QR_SERVER;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OTP {

    public static String generateQRCodeURL(String email, String secretKey) {
        return String.format(
                QR_SERVER,
                URLEncoder.encode(OTP_ISSUER, StandardCharsets.UTF_8),
                URLEncoder.encode(email, StandardCharsets.UTF_8),
                URLEncoder.encode(secretKey, StandardCharsets.UTF_8),
                URLEncoder.encode(OTP_ISSUER, StandardCharsets.UTF_8)
        );
    }
}
