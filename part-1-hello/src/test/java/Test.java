import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Set;

/**
 * @Author: sunhailong
 * @Date: 2022/7/5 16:38
 * @Desc:
 */
public class Test {
    public static void main(String[] args) throws Exception {
        LocalDate ld1 = LocalDate.now();
        LocalDate ld2 = LocalDate.of(2011, 1, 1);
        System.out.println(Period.between(ld1, ld2));

        LocalDateTime ldt1 = LocalDateTime.now();
        System.out.println(ldt1);

        LocalDateTime ldt2 = ldt1.withDayOfMonth(10);
        System.out.println(ldt2);

        LocalDateTime ldt = LocalDateTime.now();

        //API的日期格式
        DateTimeFormatter dtf1 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        String strDate1 = ldt.format(dtf1);
        System.out.println(strDate1);

        //自定义日期格式
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss E");
        String strDate2 = ldt.format(dtf2);
        System.out.println(strDate2);

        //获取所有的时区
        Set<String> set = ZoneId.getAvailableZoneIds();
//        set.forEach(System.out::println);
        System.out.println(set.size());
    }
}
