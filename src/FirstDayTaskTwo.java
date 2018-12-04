import java.util.*;
import java.text.*;

public class FirstDayTaskTwo {
    public static void main(String[] args) {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        System.out.println(dateFormat.format(new Date()));
    }
}