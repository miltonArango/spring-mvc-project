package edu.project.services.security;

/**
 * Created by Marango on 11/03/2017.
 *
 */
public interface EncryptionService {
    String encryptString(String input);
    boolean checkPassword(String plainPassword, String encryptedPassword);
}
