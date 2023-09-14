package util;

import java.util.Random;

/**
 * @author Cristian R
 *
 * @description Static class to generate random email
 */
public class RandomEmailGenerator {

    /**
     *
     * @return random email STRING
     */
    public static String generateRandomEmail() {
        String[] domains = {"gmail.com", "yahoo.com", "outlook.com", "example.com", "domain.com"};
        String[] usernameWords = {"john", "alice", "jane", "bob", "testuser", "random", "david", "manuel"};

        Random random = new Random();
        String domain = domains[random.nextInt(domains.length)];
        String username = usernameWords[random.nextInt(usernameWords.length)] + random.nextInt(1000); // Add a random number to the username

        return username + "@" + domain;
    }
}
