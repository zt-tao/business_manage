package com.neuedu.annotation;

import com.neuedu.pojo.UserInfo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationTest {

    public static void main(String[] args) {

        UserInfo userInfo=new UserInfo();
        userInfo.setUsername("zs");
        userInfo.setPassword("123456");
        System.out.println(new AnnotationTest().query(userInfo));
    }

    public void testAnnotation(){
        //UserInfo 转成sql语句
        try {
            //获取类的实例
            Class c=Class.forName("com.neuedu.pojo.UserInfo");

            //判断类上是否有Table注解
            boolean isexistsTableAnnotation=c.isAnnotationPresent(Table.class);

            if(isexistsTableAnnotation){
                //获取注解的实例
                Table table=(Table) c.getAnnotation(Table.class);
                System.out.println(table.value());
            }
            Field[] fields=c.getFields();
            for(Field field:fields){
                boolean iscolumnAnotation=field.isAnnotationPresent(Column.class);
                if(iscolumnAnotation){
                    Column annotation=(Column) field.getAnnotation(Column.class);
                    System.out.println(annotation.value());
                }
            }



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    /**
     *
     * 根据UserInfo封装sql查询语句
     * */
    public String query(UserInfo userInfo){

        StringBuffer buffer=new StringBuffer("select ");

        Class c=userInfo.getClass();
        c.isAnnotationPresent(Table.class);

        boolean isexistsTableAnnotation=c.isAnnotationPresent(Table.class);
        if(isexistsTableAnnotation){
            Table table=(Table) c.getAnnotation(Table.class);
            String tableName=table.value();//获取表名

            //获取所有属性
            Field[] fields=c.getDeclaredFields();
            for(int i=0;i<fields.length;i++){

                Field field=fields[i];
                boolean isexistsColumnAnnotation=field.isAnnotationPresent(Column.class);
                if(isexistsColumnAnnotation){
                    Column column=(Column)field.getAnnotation(Column.class);
                    String columnName=column.value();
                    buffer.append(columnName);
                    if(i!=fields.length-1){
                        buffer.append(",");
                    }else{
                        buffer.append(" ");
                    }
                }
            }

            buffer.append("from ").append(tableName);

            buffer.append(" where 1=1");
            //解析查询条件
            for(int i=0;i<fields.length;i++){
                Field field=fields[i];
                String fileName=field.getName();
                //System.out.println(fileName);

                String methodName="get"+fileName.substring(0,1).toUpperCase()+fileName.substring(1);

                try {
                    Method method=c.getMethod(methodName);
                    Object o=method.invoke(userInfo);
                    System.out.println(o);


                    if(o!=null){

                        //获取该field对应的数据库列名
                        boolean isexists=field.isAnnotationPresent(Column.class);
                        if(isexists){
                            Column column=(Column)field.getAnnotation(Column.class);
                            String columnName=column.value();
                            if(o instanceof Integer){
                                buffer.append(" and ").append(columnName).append("=").append(o);

                            }
                            buffer.append(" and ").append(columnName).append("=").append("'").append(o).append("'");
                        }

                    }

                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

        }
        return buffer.toString();
    }

}
