package com.addjve.pasteapp.services;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

// https://stackoverflow.com/questions/41107/how-to-generate-a-random-alpha-numeric-string

@Service
public class HashGeneratorRandomBase64TokenImpl implements HashGenerator {
    //generateRandomBase64Token(16) -> EEcCCAYuUcQk7IuzdaPzrg
    @Override
    public String generateHash(int byteLength) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] token = new byte[byteLength];
        secureRandom.nextBytes(token);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(token); //base64 encoding
    }
}
