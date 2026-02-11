package com.example.TravelAgencyServer.service;

import com.example.TravelAgencyServer.exceptions.CipherException;
import org.springframework.stereotype.Service;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Service
public class CipherService {
    String BASE64_KEY = "mZ4wQZlqg0qQ7d8CzPqFf2eQ0BvF8J5Wn6yLxM9aT0E=";

    byte[] keyBytes = Base64.getDecoder().decode(BASE64_KEY);
    SecretKey secretKey = new SecretKeySpec(keyBytes, "AES");

    public byte[] encryptData(String data) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            var byteData = data.getBytes(StandardCharsets.UTF_8);
            return cipher.doFinal(byteData);
        }
        catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            throw new CipherException("Ошибка щифрования", ex);
        }
    }

    public String decryptData(byte[] data) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            byte[] decryptedBytes = cipher.doFinal(data);
            return new String(decryptedBytes, StandardCharsets.UTF_8);
        }
        catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | IllegalBlockSizeException |
               BadPaddingException ex) {
            throw new CipherException("Ошибка щифрования", ex);
        }
    }
}
