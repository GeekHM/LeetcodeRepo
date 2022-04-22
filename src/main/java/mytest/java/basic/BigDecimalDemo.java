package mytest.java.basic;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @author whm
 * @version 2.0.0
 * @date 2022-04-22
 **/
/*
 * 十进制的小数在转化成二进制浮点数时会产生精度问题，为了解决这些问题引入了BigDecimal
 * BigDecimal 是把所有数据包括小数 全部以字符的形式存储成整数来实现的，如325.23在BigDecimal中是用32523表示的（既然小数转换会有问题，那全部用整数来计算就好了，最后再转回去）
 * BigInteger intVal：存储所有的数值字符，如：325.23的 32523（字符形式）
 * int scale：表示小数的位数
 * int precision：表示数字的个数
 * *****************************
 * 案例：unscaledValue × 10^-scale
 * 12345 / 100000 = 0.12345 // scale = 5, precision = 5
 * 12340 / 100000 = 0.1234 // scale = 5, precision = 4
 * 1 / 100000 = 0.00001 // scale = 5, precision = 1
 */
public class BigDecimalDemo {

    /*
     * 创建BigDecimal一定要用字符，如果是用非字符，要用BigDecimal.valueOf的方法
     * 禁止使用new BigDecimal(100.320)
     */
    @Test
    public void create() {
        new BigDecimal("100.320");//基于String方式创建
        BigDecimal data1 = BigDecimal.valueOf(2L);//基于long类型创建
        BigDecimal data2 = BigDecimal.valueOf(323.2);//基于double类型创建
        BigDecimal data3 = BigDecimal.valueOf(32314, 2);//323.14  第一个参数是原始数值，第二个是小数的位数
    }

    /*
     * BigDecimal的加法
     * BigDecimal是不可变的，所以在运算后会重新产生对象,要显示的去接收
     */
    @Test
    public void add() {
        BigDecimal data1 = new BigDecimal("123.12");
        BigDecimal data2 = new BigDecimal("456.33");

        data1.add(data2);//579.12

        //MathContext是用来设置有效位的(从最高位开始算) 如：123.12+456.33=579.12 那么intValue为57912、scala为2、precision为5
        //如果579.12的precision设置为3，那么intValue 57912，相当于只取579，12会被默认的方式如四舍五入或者其他方式处理。
        System.out.println(new BigDecimal("123.4", new MathContext(4, RoundingMode.HALF_UP)));//123.4
        System.out.println(new BigDecimal("125.4", new MathContext(2, RoundingMode.HALF_UP)));//1.3E+2
        System.out.println(new BigDecimal("123.4", new MathContext(2, RoundingMode.CEILING)));//1.3E+2
        System.out.println(new BigDecimal("153.4", new MathContext(1, RoundingMode.CEILING)));//2E+2

        BigDecimal decimal = data1.add(data2, new MathContext(2, RoundingMode.HALF_UP));
        System.out.println(decimal);//5.8E+2  有科学计数法的情况不影响BigDecimal的运算，使用toPlainString就可以转成数值
        System.out.println(decimal.toPlainString());//580
    }

    /*
     * BigDecimal的减法
     * BigDecimal是不可变的，所以在运算后会重新产生对象,要显示的去接收
     */
    @Test
    public void subtract() {
        BigDecimal data1 = new BigDecimal("123.22");
        BigDecimal data2 = new BigDecimal("456.13");

        BigDecimal subtract = data1.subtract(data2);//-332.91
        BigDecimal decimal = data1.subtract(data2, new MathContext(3, RoundingMode.HALF_UP));//-333 负数的四舍五入和整数是一样的（看成绝对值）

    }

    /*
     * BigDecimal的乘法
     * BigDecimal是不可变的，所以在运算后会重新产生对象,要显示的去接收
     */
    @Test
    public void multiply() {
        BigDecimal data1 = new BigDecimal("123.22");
        BigDecimal data2 = new BigDecimal("456.13");

        data1.multiply(data2);//56204.3386
        data1.multiply(data2, new MathContext(4, RoundingMode.HALF_UP));//5.620E+4
    }

    /*
     * BigDecimal的除法
     * BigDecimal是不可变的，所以在运算后会重新产生对象,要显示的去接收
     * 除法一定要显示设置精度，否则会抛运算溢出的异常
     */
    @Test
    public void divide() {
        BigDecimal data1 = new BigDecimal("123.22");
        BigDecimal data2 = new BigDecimal("456.13");

//        data1.divide(data2);//不设置精度很容易抛出异常
        data1.divide(data2, 10, RoundingMode.HALF_UP);//0.2701422840
        data1.divide(data2, new MathContext(10, RoundingMode.HALF_UP));//0.2701422840
    }

    /*
     * RoundingMode的使用
     * RoundingMode.UP和BigDecimal.ROUND_UP是等价的 看api就看RoundingMode
     * UP和DOWN：向上取整、向下取整都是直接忽略负数的，按绝对值来，然后再还原符号
     * CEILING和FLOOR：有符号向上取整和有符号向下取整，即负数情况下，向上取整是往接近0的方向走
     * HALF_UP和HALF_DOWN：这个就是四舍五入了，区别就是up时5是向上，Down时5是向下   四舍五入也是不考虑符号的，按绝对值，算完后还原符号
     * HALF_EVEN：基于四舍五入情况下，在五入时考虑离当前数字最近的是不是偶数，如果是就五入，如果不是就舍去，考虑正负
     */
    @Test
    public void roundingMode() {
        BigDecimal data = new BigDecimal("123.68941");
        System.out.println(data.setScale(2, RoundingMode.UP));//123.69
        System.out.println(data.setScale(2, RoundingMode.DOWN));//123.68
        System.out.println(data.setScale(2, RoundingMode.CEILING));//123.69
        System.out.println(data.setScale(2, RoundingMode.FLOOR));//123.68
        System.out.println(data.setScale(2, RoundingMode.HALF_UP));//123.69
        System.out.println(data.setScale(2, RoundingMode.HALF_DOWN));//123.69
        System.out.println(data.setScale(2, RoundingMode.HALF_EVEN));//123.69
//        System.out.println(data.setScale(2, RoundingMode.UNNECESSARY));//有小数就报错

        BigDecimal data1 = new BigDecimal("-123.68941");
        System.out.println(data1.setScale(2, RoundingMode.UP));//-123.69
        System.out.println(data1.setScale(2, RoundingMode.DOWN));//-123.68
        System.out.println(data1.setScale(2, RoundingMode.CEILING));//-123.68
        System.out.println(data1.setScale(2, RoundingMode.FLOOR));//-123.69
        System.out.println(data1.setScale(2, RoundingMode.HALF_UP));//-123.69
        System.out.println(data1.setScale(2, RoundingMode.HALF_DOWN));//-123.69
        System.out.println(data1.setScale(2, RoundingMode.HALF_EVEN));//-123.69
    }

    /*
     * NumberFormat格式化
     */
    @Test
    public void format1() {
        NumberFormat currency = NumberFormat.getCurrencyInstance(); //建立货币格式化引用
        NumberFormat percent = NumberFormat.getPercentInstance();  //建立百分比格式化引用

//        currency.setMaximumFractionDigits(4);
        percent.setMaximumFractionDigits(3); //百分比小数点最多3位

        BigDecimal loanAmount = new BigDecimal("15000.48"); //贷款金额
        BigDecimal interestRate = new BigDecimal("0.008"); //利率
        BigDecimal interest = loanAmount.multiply(interestRate); //相乘

        System.out.println("贷款金额:\t" + currency.format(loanAmount));//贷款金额:	￥15,000.48
        System.out.println("利率:\t" + percent.format(interestRate));//利率:	 0.8%
        System.out.println("利息:\t" + currency.format(interest));//利息:	￥120.00
    }

    /*
     * DecimalFormat格式化
     * 默认使用RoundingMode.HALF_EVEN  向最近的偶数位四舍五入
     * 一般使用DecimalFormat，不使用NumberFormat
     */
    @Test
    public void format2() {
        //使用0做占位符
        //占位符比实际数字多
        new DecimalFormat("00.00").format(3.14567);//结果：03.15
        new DecimalFormat("0.000").format(3.14);//结果：3.140
        new DecimalFormat("00.000").format(3.14);//结果：03.140
        //占位符比实际数字少
        new DecimalFormat("00.00").format(13.14567);//结果：13.15
        new DecimalFormat("0.000").format(13.14567);//结果：13.146
        new DecimalFormat("0.00").format(13.14567);//结果：13.15

        //使用#做占位符
        //占位符比实际数字多
        new DecimalFormat("##.##").format(3.14567);//结果：3.15
        new DecimalFormat("#.###").format(3.14);//结果：3.14
        new DecimalFormat("##.###").format(3.14);//结果：3.14
        //占位符比实际数字少
        new DecimalFormat("#.###").format(13.145678);//结果：13.146
        new DecimalFormat("##.##").format(13.14567);//结果：13.15
        new DecimalFormat("#.##").format(13.14567);//结果：13.15

        //可以修改格式化策略
        new DecimalFormat().setRoundingMode(RoundingMode.HALF_UP);
    }

    /*
     * 比较
     */
    @Test
    public void compare() {
        BigDecimal data1 = new BigDecimal("123.22");
        BigDecimal data2 = new BigDecimal("456.13");

        boolean isEquals = data1.equals(data2);
        int i = data1.compareTo(data2);//data1>data2:1; data1=data2:0; data1<data2:-1
    }

    /*
     * 工作中一些场景
     */
    @Test
    public void demo() {
        BigDecimal decimal = new BigDecimal("10.1000");
        decimal.toPlainString();//会输出10.1000
        decimal.stripTrailingZeros().toPlainString();//stripTrailingZeros会扣去末尾的0，toPlainString是以正常数值返回
    }

    /*
     * 开发常用数学公式
     */
    @Test
    public void math() {
        System.out.println(Math.sqrt(16)); //求平方根：4.0
        System.out.println(Math.cbrt(8)); //求立方根：2.0
        System.out.println(Math.pow(3, 2)); //求次方9.0
        System.out.println(Math.max(2.3, 4.5));//求两数中大的那个数：4.5
        System.out.println(Math.min(2.3, 4.5));//求两数中小的那个数：2.3
        System.out.println(Math.abs(-10.4)); //求绝对值10.4

        /**
         * ceil天花板的意思，就是逢余进一
         */
        System.out.println(Math.ceil(-10.1)); // -10.0
        System.out.println(Math.ceil(10.7)); // 11.0
        System.out.println(Math.ceil(-0.7)); // -0.0
        System.out.println(Math.ceil(0.0)); // 0.0
        System.out.println(Math.ceil(-0.0)); // -0.0
        System.out.println(Math.ceil(-1.7)); // -1.0

        /**
         * floor地板的意思，就是逢余舍一
         */
        System.out.println(Math.floor(-10.1)); // -11.0
        System.out.println(Math.floor(10.7)); // 10.0
        System.out.println(Math.floor(-0.7)); // -1.0
        System.out.println(Math.floor(0.0)); // 0.0
        System.out.println(Math.floor(-0.0)); // -0.0

        /**
         * rint 四舍五入，返回double值 注意.5的时候会取偶数 异常的尴尬=。=
         */
        System.out.println(Math.rint(10.1)); // 10.0
        System.out.println(Math.rint(10.7)); // 11.0
        System.out.println(Math.rint(11.5)); // 12.0
        System.out.println(Math.rint(10.5)); // 10.0
        System.out.println(Math.rint(10.51)); // 11.0
        System.out.println(Math.rint(-10.5)); // -10.0
        System.out.println(Math.rint(-11.5)); // -12.0
        System.out.println(Math.rint(-10.51)); // -11.0
        System.out.println(Math.rint(-10.6)); // -11.0
        System.out.println(Math.rint(-10.2)); // -10.0

        /**
         * round 四舍五入，float时返回int值，double时返回long值
         */
        System.out.println(Math.round(10)); // 10
        System.out.println(Math.round(10.1)); // 10
        System.out.println(Math.round(10.7)); // 11
        System.out.println(Math.round(10.5)); // 11
        System.out.println(Math.round(10.51)); // 11
        System.out.println(Math.round(-10.5)); // -10
        System.out.println(Math.round(-10.51)); // -11
        System.out.println(Math.round(-10.6)); // -11
        System.out.println(Math.round(-10.2)); // -10
    }

    @Test
    public void test() {

    }
}
