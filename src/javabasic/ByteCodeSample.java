package javabasic;

import java.lang.reflect.Field;

public class ByteCodeSample extends Base {
    private String code;
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        int i = 1, j = 5;
        i++;
        ++j;
        System.out.println(i);
        System.out.println(j);

        Class cl = Class.forName("javabasic.ByteCodeSample");
        ByteCodeSample obj = (ByteCodeSample) cl.newInstance();
        //获取所有属性，包括private修饰的属性，但是不包括继承过来的
        Field[] fileds = cl.getDeclaredFields();
        for (Field field : fileds) {
            System.out.println(field.getName());
        }
        System.out.println("-----------------");
        //获取所有public修饰的属性，包括继承过来的
        Field[] fileds2 = cl.getFields();
        for (Field field : fileds2) {
            System.out.println(field.getName());
        }
    }
}
