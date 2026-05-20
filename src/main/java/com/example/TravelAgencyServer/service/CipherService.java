package com.example.TravelAgencyServer.service;

import com.example.TravelAgencyServer.exceptions.CipherException;
import org.springframework.stereotype.Service;

import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

@Service
public class CipherService {
    private static final String BASE64_KEY = "mZ4wQZlqg0qQ7d8CzPqFf2eQ0BvF8J5Wn6yLxM9aT0E=";
    private static final int GCM_TAG_LENGTH_BITS = 128;
    private static final int GCM_IV_LENGTH_BYTES = 12;

    private final SecretKey secretKey;

    public CipherService() {
        byte[] keyBytes = Base64.getDecoder().decode(BASE64_KEY);
        this.secretKey = new SecretKeySpec(keyBytes, "AES");
    }

    public byte[] encryptData(String data) {
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");

            byte[] iv = new byte[GCM_IV_LENGTH_BYTES];
            SecureRandom secureRandom = new SecureRandom();
            secureRandom.nextBytes(iv);

            GCMParameterSpec gcmSpec = new GCMParameterSpec(GCM_TAG_LENGTH_BITS, iv);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, gcmSpec);

            byte[] encryptedData = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));

            byte[] result = new byte[iv.length + encryptedData.length];
            System.arraycopy(iv, 0, result, 0, iv.length);
            System.arraycopy(encryptedData, 0, result, iv.length, encryptedData.length);

            return result;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
                 InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException ex) {
            throw new CipherException("Ошибка шифрования", ex);
        }
    }

    public String decryptData(byte[] encryptedDataWithIv) {
        try {
            byte[] iv = new byte[GCM_IV_LENGTH_BYTES];
            byte[] encryptedData = new byte[encryptedDataWithIv.length - GCM_IV_LENGTH_BYTES];

            System.arraycopy(encryptedDataWithIv, 0, iv, 0, GCM_IV_LENGTH_BYTES);
            System.arraycopy(encryptedDataWithIv, GCM_IV_LENGTH_BYTES, encryptedData, 0, encryptedData.length);

            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            GCMParameterSpec gcmSpec = new GCMParameterSpec(GCM_TAG_LENGTH_BITS, iv);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, gcmSpec);

            byte[] decryptedBytes = cipher.doFinal(encryptedData);
            return new String(decryptedBytes, StandardCharsets.UTF_8);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
                 InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException ex) {
            throw new CipherException("Ошибка расшифрования", ex);
        }
    }
}