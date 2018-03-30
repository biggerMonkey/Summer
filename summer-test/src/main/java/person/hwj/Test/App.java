package person.hwj.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        int flag;
        for (flag = 0; flag < 5; flag++) {

        }
        System.out.println(flag);
        System.out.println(LocalDateTime.now().minusDays(7)
                .format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss")));
    }
}
