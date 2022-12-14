package com.qaprosoft.carina.demo.gui.test;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class UserFactory {
    private final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";

    private final Set<String> identifiers = new HashSet<String>();

    private Random random = new Random();

    public String randomUserName() {
        StringBuilder builder = new StringBuilder();
        while(builder.toString().length() == 0) {
            int length = random.nextInt(5)+5;
            for(int i = 0; i < length; i++) {
                builder.append(lexicon.charAt(random.nextInt(lexicon.length())));
            }
            if(identifiers.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }

        return builder.toString();
    }

    public String randomPassword() {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        return sb.toString();
    }
}
