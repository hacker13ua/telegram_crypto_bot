package org.surovskiy.example;

/**
 * TODO: write javadoc
 *
 * @author Evgeniy Surovskiy
 */
public interface ICryptoService {
    String getEncryptedMessage(String message);
    String getDecryptedMessage(String message);
}
