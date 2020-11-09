package com.practise.jpa.service.security;

public interface EncryptionService {
    String encryptString(String input);
    boolean checkPassword(String PlainPassword,String encryptedPassword);
}
