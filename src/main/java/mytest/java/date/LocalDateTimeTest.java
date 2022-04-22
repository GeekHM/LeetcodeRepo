package mytest.java.date;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;

/**
 * @description：
 * @author: whm
 * @create: 2021-11-25 14:28
 * @version：
 **/

/**
 * 默认严格按照ISO 8601规定的日期和时间格式进行打印；注意ISO 8601规定的日期和时间分隔符是T
 * DateTimeFormatter自定义输出的格式
 * LocalDateTime提供了对日期和时间进行加减的非常简单的链式调用sad
 * 对日期和时间进行调整则使用withXxx()方法
 * LocalDateTime还有一个通用的with()方法允许我们做更复杂的运算
 * 要判断两个LocalDateTime的先后，可以使用isBefore()、isAfter()方法，对于LocalDate和LocalTime类似
 * Duration表示两个时刻之间的时间间隔。另一个类似的Period表示两个日期之间的天数cxvxcvwwww
 */
public class LocalDateTimeTest {
    //获取到明天的时间
    @Test
    public void getNowToNextDaySeconds() {
        Calendar cal = Calendar.getInstance();
        int a;
        cal.add(Calendar.DAY_OF_YEAR, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        System.out.println((cal.getTimeInMillis() - System.currentTimeMillis()) / 1000);
    }

    @Test
    public void test() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.getDayOfYear() + " " + now.getDayOfMonth() + " " + now.getDayOfWeek());
        System.out.println(now.getYear() + " " + now.getMonth() + " " + now.getDayOfWeek());
        System.out.println(now.getHour() + " " + now.getMinute() + " " + now.getSecond());
    }

    /**
     * 通过指定的日期和时间创建LocalDateTime
     */
    @Test
    public void testOf() {
        // 2020-08-11
        LocalDate localDate = LocalDate.of(2020, 8, 11);
        // 20:32:44
        LocalTime localTime = LocalTime.of(20, 32, 44);
        // 2020-08-11T20:32:44
        LocalDateTime localDateTime = LocalDateTime.of(2020, 8, 11, 20, 32, 44);
        // 2020-08-11T20:32:44
        LocalDateTime dateTime = LocalDateTime.of(localDate, localTime);
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
        System.out.println(dateTime);
    }

    /**
     * 将字符串转换为LocalDateTime就可以传入标准格式
     */
    @Test
    public void testParse() {
        // 2020-08-11T20:32:44
        LocalDateTime dateTime = LocalDateTime.parse("2020-08-11T20:32:44");
        // 2020-08-11
        LocalDate localDate = LocalDate.parse("2020-08-11");
        // 20:32:44
        LocalTime localTime = LocalTime.parse("20:32:44");
        System.out.println(dateTime);
        System.out.println(localDate);
        System.out.println(localTime);
    }

    /**
     * DateTimeFormatter自定义输出的格式
     */
    @Test
    public void testDateTimeFormatter() {
        // 2020-08-12 20:50:14
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        // 2020-08-11T20:32:44
        System.out.println(LocalDateTime.parse("2020/08/11 20:32:44", dateTimeFormatter));
        // 2020/08/12 20:54:56
        System.out.println(dateTimeFormatter.format(LocalDateTime.now()));
    }

    /**
     * LocalDateTime提供了对日期和时间进行加减的非常简单的链式调用
     */
    @Test
    public void testCalc() {
        LocalDateTime dt = LocalDateTime.of(2019, 10, 26, 20, 30, 59);
        // 2019-10-26T20:30:59
        System.out.println(dt);
        // 加1年减2月加1天 2020-08-29T20:30:59
        System.out.println(dt.plusYears(1).minusMonths(2).plusDays(3));
        // 减1小时加1分钟减1秒 2019-10-26T19:32:56
        System.out.println(dt.minusHours(1).plusMinutes(2).minusSeconds(3));
        // 2019-11-01T20:30:59
        // 注意到加6天导致月份变化
        System.out.println(dt.plusDays(6));
        // 加1秒 2019-10-26T20:31
        // 注意到加了1秒导致分钟变化
        System.out.println(dt.plusSeconds(1));
    }

    /**
     * 对日期和时间进行调整则使用withXxx()方法，例如：withHour(15)会把10:11:12变为15:11:12：
     * <p>
     * 调整年：withYear() 调整月：withMonth() 调整日：withDayOfMonth() 调整时：withHour() 调整分：withMinute() 调整秒：withSecond()
     */
    @Test
    public void testAdjustmentDateTime() {
        LocalDateTime dt = LocalDateTime.of(2019, 10, 31, 20, 30, 59);
        // 2019-10-31T20:30:59
        System.out.println(dt);
        // 2019-10-29T20:30:59
        System.out.println(dt.withDayOfMonth(29));
        // 2019-09-30T20:30:59
        // 注意到月份加减会自动调整日期，例如从2019-10-31减去1个月得到的结果是2019-09-30，因为9月没有31日。
        System.out.println(dt.withMonth(9));
    }

    /**
     * LocalDateTime还有一个通用的with()方法允许我们做更复杂的运算
     */
    @Test
    public void testComplexCalculation() {
        // 本月第一天0:00时刻 2020-08-01T00:00
        LocalDateTime firstDay = LocalDate.now().withDayOfMonth(1).atStartOfDay();
        System.out.println(firstDay);

        // 本月最后一天 2020-08-31
        LocalDate lastDay = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDay);

        // 下月第一天 2020-09-01
        LocalDate firstDayOfNextMonth = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println(firstDayOfNextMonth);
        // 本月第一个周一 2020-08-03
        LocalDate firstWeekday = LocalDate.now().with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println(firstWeekday);
    }

    /**
     * 要判断两个LocalDateTime的先后，可以使用isBefore()、isAfter()方法，对于LocalDate和LocalTime类似
     */
    @Test
    public void testBefore() {
        LocalDateTime now = LocalDateTime.now();
        // 2020-08-12T21:37:54.853
        System.out.println(now);
        LocalDateTime target = LocalDateTime.of(2020, 8, 31, 1, 1, 1);
        // true
        System.out.println(now.isBefore(target));
        // false
        System.out.println(LocalDate.now().isBefore(LocalDate.of(2019, 8, 8)));
        // true
        System.out.println(LocalTime.now().isAfter(LocalTime.of(21, 1, 1)));
    }

    /**
     * Duration表示两个时刻之间的时间间隔。另一个类似的Period表示两个日期之间的天数
     */
    @Test
    public void testDuration() {
        LocalDateTime startTime = LocalDateTime.of(2020, 5, 6, 17, 30, 15);
        LocalDateTime endTime = LocalDateTime.of(2020, 8, 12, 21, 46, 30);
        // PT2356H16M15S 表示2356小时16分钟15秒
        Duration duration1 = Duration.between(startTime, endTime);
        System.out.println(duration1.toMillis());
        // PT-2356H-16M-15S
        Duration duration2 = Duration.between(endTime, startTime);
        System.out.println(duration2);

        // P3M6D 表示3分钟6天
        Period period = Period.between(startTime.toLocalDate(), endTime.toLocalDate());
        System.out.println(period);
    }
}
