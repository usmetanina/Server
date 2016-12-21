package server.entity.universalEntities;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TableField {

    private Integer rowId;
    public String value;
    public boolean isPrimaryKey;
    public boolean isForeignKey;
    public ForeignKey foreignKey; // can be null
    public List<ForeignKey> variantsList;

    TableField (
                Integer rowId,
                String value,
                boolean isPrimaryKey,
                boolean isForeignKey,
                Integer foreignKeyId,
                String foreignKeyValue,
                String tableName,
                List detectedForeignKeyVariants,
                Object tmpObject
                                                ) throws IllegalAccessException {
        this.rowId = rowId;
        this.value = value;
        this.isForeignKey = isForeignKey;
        this.isPrimaryKey = isPrimaryKey;

        if (isForeignKey && detectedForeignKeyVariants != null) {
            this.foreignKey = new ForeignKey(foreignKeyId, foreignKeyValue, tableName, tmpObject);
            this.variantsList = new ArrayList<ForeignKey>();
            setVariantsList(detectedForeignKeyVariants);
        }
    }

    void setVariantsList(List detectedVariantsList) throws IllegalAccessException {

        List<String> rowDataList;

        Integer amountOfVariants = detectedVariantsList.size();

        Object valueOfField;
        String strValue;

        Integer idForForeignKey;
        String valueForForeignKey;

        // a little of reflection

        for (int i=0; i < amountOfVariants; i++) { // loop for objects in list

            Object tmpObject = detectedVariantsList.get(i); // object of class, that user chose before
            Field[] fields = tmpObject.getClass().getDeclaredFields(); // fields of this class
            fields[0].setAccessible(true);
            idForForeignKey = fields[0].getInt(tmpObject);

            valueForForeignKey = "";

            for (Field field : fields) { // loop for fields in object

                field.setAccessible(true); // this part allows to get access to private fields
                valueOfField = field.get(tmpObject); // get value of field in object

                if (valueOfField != null) {
                    strValue = valueOfField.toString();

                    if (!strValue.contains("@") && !strValue.equals("[]")) { // all foreign key fields in format of string contain this symbol
                        valueForForeignKey = valueForForeignKey + strValue + ", ";
                    }
                }
            }
            valueForForeignKey = valueForForeignKey.substring(0, valueForForeignKey.length()-2);
            this.variantsList.add( new ForeignKey(idForForeignKey, valueForForeignKey, this.foreignKey.TableName, tmpObject) );
        }

    } // void setVariantsList();
}
