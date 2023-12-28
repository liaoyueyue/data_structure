import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liaoyueyue
 * Date: 2023-12-28
 * Time: 23:28
 */
public class TestTime {
    public static void main(String[] args) {
        // LocalDateTime 可以获取时间和日期
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yy年MM月dd日 HH时mm分ss秒");
        System.out.println("localDateTime = " + localDateTime.format(dateTimeFormatter));
    }
    public static void main4(String[] args) {
        // LocalTime 只能获取时间
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH时mm分ss秒");
        System.out.println("localTime = " + localTime.format(dateTimeFormatter));
    }
    public static void main3(String[] args) {
        // LocalDate 只能获取日期
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yy年MM月dd日");
        System.out.println("localDate = " + localDate.format(dateTimeFormatter));
    }
    public static void main2(String[] args) {
        // Date 此方法会根据我们的系统日期和时间返回当前值
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy年MM月dd日 HH时mm分ss秒");
        System.out.println(simpleDateFormat.format(date));
    }
    public static void main1(String[] args) {
        // Date 此方法会根据我们的系统日期和时间返回当前值
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
    }
}
