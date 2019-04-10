package org.surovskiy.example;

/**
 * TODO: write javadoc
 *
 * @author Evgeniy Surovskiy
 */
public class SimpleCryptoService implements ICryptoService {
    public static final int FREQUENCY = 2;
    private final static String DELIMETER = "ола";

    @Override
    public String getEncryptedMessage(String message) {
        final char[] chars = message.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            stringBuilder.append(chars[i]);
            if (i % FREQUENCY == 0 && i != chars.length - 1) {
                stringBuilder.append(DELIMETER);
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String getDecryptedMessage(String message) {
        return message.replace(DELIMETER, "");
    }

}
