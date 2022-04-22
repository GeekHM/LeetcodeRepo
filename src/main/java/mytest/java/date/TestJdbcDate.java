package mytest.java.date;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-06-22 15:35
 **/
public class TestJdbcDate {
    public static void main(String[] args) {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@192.168.183.61:1521/pdb";
        String username = "WOM"; //用户名
        String password = "WOM"; //密码
        String sql = "select * from TWOM_JOB_LOG where beg_tm > ?";
        Connection connection = null;
        PreparedStatement prepareStatement = null;
        ResultSet resultSet = null;

        try {
            //1、加载驱动Oracle的jdbc驱动包
            Class.forName(driver);

            //3、建立连接 ：制定连接到哪里去jdbc:oracle:thin:  ip地址 : 端口号 : <数据库名>
            connection = DriverManager.getConnection(url, username, password);

            //4、创建statement对象，便于执行静态sql语句
            prepareStatement = connection.prepareStatement(sql);

            //动态执行SQL语句
            String date = "2020/7/17 14:30:05";
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
            Date utilDate = dateFormat.parse(date);
            prepareStatement.setDate(1, new java.sql.Date(utilDate.getTime()));

            //5、执行查询或更新操作
            resultSet = prepareStatement.executeQuery();

            //6、结果处理 方式一
            while (resultSet.next()) {
                int empno = resultSet.getInt("job_id");
                String ename = resultSet.getString("job_nm");
                System.out.println(empno + " " + ename);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            //7、关闭连接
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
