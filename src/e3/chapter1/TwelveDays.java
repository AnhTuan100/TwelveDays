package e3.chapter1;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class TwelveDays {

    private static final ResourceBundle BUNDLE =
            ResourceBundle.getBundle("e3.chapter1.TwelveDays");

    private static final int NUM_DAYS = 12;

    static String[] DAYS = new String[NUM_DAYS];
    static String[] GIFTS = new String[NUM_DAYS];

    static {
        for (int i = 0; i < NUM_DAYS; i++) {
            DAYS[i] = BUNDLE.getString("day." + i);
            GIFTS[i] = BUNDLE.getString("gift." + i);
        }
    }

    public static void main(String[] args) {
        System.out.println(poem());
    }

    static String firstLine(int day) {
        return MessageFormat.format(BUNDLE.getString("firstLine"), DAYS[day]);
    }

    static String allGifts(int day) {
        if (day == 0) {
            return MessageFormat.format(BUNDLE.getString("and"), GIFTS[0]);
        } else {
            return GIFTS[day] + "\n" + allGifts(day - 1);
        }
    }

    static String poem() {
        String poem = firstLine(0) + GIFTS[0] + "\n\n";
        for (int day = 1; day < 12; day++) {
            poem += firstLine(day) + allGifts(day) + "\n\n";
        }
        return poem;
    }
}