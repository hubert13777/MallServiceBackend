package JDBCServer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public abstract class MyTable {
    private Database database = null;
    private String sql;
    private String tableName = null;
    private String primaryKey = null;
    private ArrayList<String> column = new ArrayList<>();

    protected void setDatabase(Database database) {
        this.database = database;
    }

    protected void setSql(String sql) {
        this.sql = sql;
    }

    protected void setTableName(String tableName) {
        this.tableName = tableName;
    }

    protected Database getDatabase() {
        return database;
    }

    protected String getSql() {
        return sql;
    }

    protected String getTableName() {
        return tableName;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    protected void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public ArrayList<String> getColumn() {
        return column;
    }

    protected void setColumn(String... str) {
        column.clear();
        Collections.addAll(column, str);
    }

    /**
     * 判断与数据库的连接是否存在
     *
     * @return 返回true说明连接正常
     */
    protected boolean conJudge() {
        if (getDatabase() == null) return false;
        else return true;
    }

    /**
     * 判断表是否存在
     *
     * @return 返回true表示存在
     */
    protected boolean tableJudge() {
        if (database == null) {
            System.out.println("未连接数据库！");
            return false;
        }
        if (!getDatabase().hasTable(getTableName())) return false;
        else return true;
    }

    /**
     * 检测表中是否含有此字段名
     *
     * @param key 等待检查的字段名
     * @return 返回true表示存在此字段名
     */
    protected boolean columnJudge(String key) {
        if (database == null) {
            System.out.println("未连接数据库！");
            return false;
        } else if (!tableJudge()) {
            System.out.println("不存在该表！");
            return false;
        }
        return getColumn().contains(key);
    }

    /**
     * 判断是否存在指定键值对的数据
     *
     * @param key_value 要查询的键值对，Map形式
     * @return 返回true则说明数据存在
     */
    public boolean dataJudge(HashMap<String, String> key_value) {
        ResultSet temp = dataSelect(key_value);
        try {
            if (temp == null || !temp.next()) return false;   //没有数据
            else return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 删除指定字段值的数据
     *
     * @param key   字段名
     * @param value 主键的字段值
     * @return 返回true表示删除成功
     */
    public boolean dataDeleteSearch(String key, String value) {
        // 检查是否存在连接、表和数据
        if (!conJudge()) {
            System.out.println("未连接数据库！");
            return false;
        } else if (!tableJudge()) {
            System.out.println("不存在该表！");
            return false;
        } else {
            HashMap<String, String> key_value = new HashMap<>();
            key_value.put(key, value);
            if (!dataJudge(key_value)) {
                System.out.println(getTableName() + ": 表中没有 " + key + " 为 [" + value + "] 的数据!");
                return false;
            }
        }

        setSql("delete from " + tableName + " where " + key + "=?;");
        int res = getDatabase().simpleImplement(getSql(), value);
        if (res == -1) {
            System.out.println("删除失败！");
            return false;
        } else {
            System.out.println(getTableName() + ": [" + value + "]删除成功");
            return true;
        }
    }

    /**
     * 删除表中所有数据
     *
     * @return 返回true表示删除成功
     */
    public boolean dataDeleteAll() {
        // 检查是否存在连接和表
        if (!conJudge()) {
            System.out.println("未连接数据库！");
            return false;
        } else if (!tableJudge()) {
            System.out.println("不存在该表！");
            return false;
        }
        setSql("delete from " + tableName + ";");
        int res = getDatabase().simpleImplement(getSql());
        if (res == -1) return false;
        else return true;
    }

    /**
     * 返回指定键值对的数据，键值对可以有多对
     *
     * @param key_value 要查询的键值对，Map形式
     * @return 返回true说明存在这条数据
     */
    public ResultSet dataSelect(HashMap<String, String> key_value) {
        // 检查是否存在连接和表
        if (!conJudge()) {
            System.out.println("未连接数据库！");
            return null;
        } else if (!tableJudge()) {
            System.out.println("不存在该表！");
            return null;
        }

        //获取所有键值对
        int size = key_value.size();
        String[] key = new String[size], value = new String[size];
        int i = 0;
        for (Iterator iter = key_value.entrySet().iterator(); iter.hasNext(); ) {
            Map.Entry elem = (Map.Entry) iter.next();
            key[i] = (String) elem.getKey();
            value[i] = (String) elem.getValue();
            i++;
        }

        for (i = 0; i < size; i++) {
            if (!columnJudge(key[i])) {
                System.out.println("表中不存在此字段!");
                return null;
            }
        }

        String temp = "select * from " + getTableName() + " where ";
        for (i = 0; i < size - 1; i++) {
            temp = temp + key[i] + "=? and ";
        }
        temp = temp + key[size - 1] + "=?;";
        setSql(temp);
        ResultSet rs = getDatabase().queryImplement(getSql(), value);
        return rs;
    }

    /**
     * 返回的ResultSet包括表中所有数据
     *
     * @return 返回一个数据集，null表示出错，为空表示没有数据
     */
    public ResultSet dataSelectAll() {
        // 检查是否存在连接和表
        if (!conJudge()) {
            System.out.println("未连接数据库！");
            return null;
        } else if (!tableJudge()) {
            System.out.println("不存在该表！");
            return null;
        }
        setSql("select * from " + getTableName() + ";");
        ResultSet rs = getDatabase().queryImplement(getSql());
        return rs;
    }

    /**
     * 用来打印表中所有数据
     *
     * @return 返回false表示打印出错
     */
    public boolean dataPrint() {
        // 检查是否存在连接和表
        if (!conJudge()) {
            System.out.println("未连接数据库！");
            return false;
        } else if (!tableJudge()) {
            System.out.println("不存在该表！");
            return false;
        }
        sql = "select * from " + getTableName();
        ResultSet rs = getDatabase().queryImplement(sql);
        try {
            int count = getColumn().size();
            String[] temp = new String[count + 1];
            System.out.println("[表 " + getTableName() + "]");
            for (int i = 1; i <= getColumn().size(); i++) System.out.printf("------------");
            System.out.println();
            for (int i = 0; i < count; i++) {
                System.out.printf(getColumn().get(i));
                int len = getColumn().get(i).length();
                for (len = len + 1; len <= 12; len++) System.out.printf(" ");
            }
            System.out.println();
            for (int i = 1; i <= getColumn().size(); i++) System.out.printf("------------");
            System.out.println();
            // 输出表中数据
            while (rs.next()) {
                for (int i = 0; i < count; i++) {
                    temp[i] = rs.getString(getColumn().get(i));
                    if (temp[i] != null) System.out.printf("%-12s", temp[i]);
                    else System.out.printf("            ");  //当MySQL中数据为null时的输出
                }
                System.out.println();
            }
            for (int i = 1; i <= getColumn().size(); i++) System.out.printf("------------");
            System.out.println();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
