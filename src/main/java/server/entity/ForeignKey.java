package server.entity;

public class ForeignKey {
    public Integer id;
    public String value;
    public String TableName;
    public Object tmpObject;

    ForeignKey(Integer id, String value, String tableName, Object tmpObject) throws IllegalAccessException {
        this.id = id;
        this.value = value;
        this.TableName = tableName;
        this.tmpObject = tmpObject;
    }

}
