package blusalt.challenge.billingservice.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class Common {

    public static String  generateRef(int count) {
        return RandomStringUtils.random(count);
    }

    public static String  generateRef(int count, String prepend) {
        return prepend.concat(RandomStringUtils.randomNumeric(count));
    }
}
