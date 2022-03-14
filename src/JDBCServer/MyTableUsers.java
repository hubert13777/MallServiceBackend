package JDBCServer;

import java.util.HashMap;

public class MyTableUsers extends MyTable {
    public MyTableUsers(Database one) {
        setDatabase(one);
        setTableName("android_users");
        setPrimaryKey("username");
        setColumn("username", "password");
    }

    /**
     * 向user表中插入指定字段值的数据
     *
     * @return 返回true表示插入成功
     */
    public boolean dataInsert(String username, String pass) {
        if (username == null || pass == null) {
            System.out.println("字段值不能为空");
            return false;
        } else if (!conJudge()) {
            System.out.println("与数据库连接中断，添加失败！");
            return false;
        } else {
            HashMap<String,String> key_value=new HashMap<>();
            key_value.put(getPrimaryKey(), username);
            if (dataJudge(key_value)) {
                System.out.println(getTableName() + ": 已存在username=[" + username + "]的数据，添加失败！");
                return false;
            }
        }
        setSql("insert into "+getTableName()+" values (?,?);");
        int res = getDatabase().simpleImplement(getSql(), username, pass);
        if (res == -1) {
            System.out.println(getTableName() + ": 数据[" + username + "]添加失败!");
            return false;
        } else {
            System.out.println(getTableName() + ": 数据[" + username + "]添加成功");
            return true;
        }
    }
}
