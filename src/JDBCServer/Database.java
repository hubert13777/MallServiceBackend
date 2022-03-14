package JDBCServer;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 * 最底层，负责连接数据库并发送SQL语句
 *
 * @author 何天辰
 * @version v1.0
 */
public class Database {
    private Connection con;
    private ResultSet rs;
    private PreparedStatement preState;

    /**
     * 连接MySQL数据库，连接信息从./mysql.properties读取
     *
     * @param path 文件所在路径
     * @return 返回true表示连接成功
     */
    public boolean jdbcConnection(String path) {
        String driver = null, url = null, username = null, password = null;
        //获取所需的连接信息
        Properties pp = new Properties();
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(path+"mysql.properties"));
            pp.load(in);
            driver = pp.getProperty("DRIVER");
            url = pp.getProperty("URL");
            username = pp.getProperty("USERNAME");
            password = pp.getProperty("PASSWORD");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("未找到配置文件!");
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件打开失败!");
            return false;
        }

        // 尝试连接
        try {
            Class.forName(driver);
            this.con = DriverManager.getConnection(url, username, password);
            if (!this.con.isClosed())
                return true;
            else return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("驱动加载失败!");
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败!");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @return 返回true表示正常关闭或原来就关闭
     */
    public boolean jdbcExit() {
        try {
            if (rs != null) rs.close();
            if (preState != null) preState.close();
            if (con != null) {
                con.close();
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 无返回数据的SQL语句
     *
     * @param sql 需要执行的SQL语句
     * @return 返回值为SQL语句改变的行数，若为-1则表明出错
     */
    protected int simpleImplement(String sql, String... param) {
        if (con == null) {
            System.out.println("未连接数据库！");
            return -1;
        }
        try {
            preState = con.prepareStatement(sql);
            for (int i = 1; i <= param.length; i++) {
                preState.setString(i, param[i - 1]);
            }
            int res = preState.executeUpdate(); //执行SQL语句
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 执行有返回数据的SQL语句
     *
     * @param sql 需要执行的SQL语句
     * @return 返回数据集ResultSet
     */
    protected ResultSet queryImplement(String sql, String... param) {
        if (con == null) {
            System.out.println("未连接数据库！");
            return null;
        }
        try {
            preState = con.prepareStatement(sql);
            for (int i = 1; i <= param.length; i++) {
                preState.setString(i, param[i - 1]);
            }
            rs = preState.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            rs = null;
        }
    }

    /**
     * 用于获取数据库中所有的表名
     *
     * @return 返回ArrayList数组，储存表名，若获取失败或数据库为空则为null
     */
    public ArrayList<String> listAllTable() {
        if (con == null) {
            System.out.println("未连接数据库！");
            return null;
        }
        ArrayList<String> tables = new ArrayList<>();
        try {
            rs = con.getMetaData().getTables(con.getCatalog(), null, null, null);
            while (rs.next()) {
                tables.add(rs.getString("TABLE_NAME"));
            }
            return tables;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败!");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 用于判断数据库中是否有指定名字的表
     *
     * @param tableName 想要寻找的表名
     * @return 返回true表示该数据库中有这个表
     */
    public boolean hasTable(String tableName) {
        try {
            rs = con.getMetaData().getTables(con.getCatalog(), null, tableName, null);
            if (rs.next()) return true;
            else return false;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败!");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
