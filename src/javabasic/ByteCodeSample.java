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
        Field[] fileds = cl.getDeclaredFields();
        for (Field field : fileds) {
            System.out.println(field.getName());
        }
    }
}
