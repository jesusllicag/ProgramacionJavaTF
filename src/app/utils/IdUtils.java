package app.utils;

import java.security.SecureRandom;

public class IdUtils {

    public static String randomCode() {
        final int lng = 5;
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        final SecureRandom random = new SecureRandom();

        StringBuilder sb = new StringBuilder(lng);
        for (int i = 0; i < lng; i++) {
            int index = random.nextInt(chars.length());
            sb.append(chars.charAt(index));
        }
        return sb.toString();
    }
}
