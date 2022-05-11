package basething.reflectdemo;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test1 {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        //获得类
        Class<?> methodClassClass = MethodClass.class;
        //反射获得实例对象
        Object obj = methodClassClass.newInstance();
        //获取方法
        Method[] declaredMethods = methodClassClass.getDeclaredMethods();
        Method[] methods = methodClassClass.getMethods();

        //获取methodClass类的add方法
        Method add = methodClassClass.getMethod("add", int.class, int.class);
        Object res = add.invoke(obj, 1, 2);
        System.out.println(res);

        //getMethods()方法获取的所有方法
        System.out.println("getMethods获取的方法：");
        for(Method m : methods){
            System.out.println(m);
        }
        //getDeclaredMethods()方法获取的所有方法
        System.out.println("getDeclaredMethods获取的方法：");
        for (Method m : declaredMethods) {
            System.out.println(m);
        }

        System.out.println("------------反射创建数组------------");

        Class<?> aClass = Class.forName("java.lang.String");
        Object array = Array.newInstance(aClass, 5);
        //添加元素
        Array.set(array, 0, "hello");
        Array.set(array, 1, "Java");
        Array.set(array, 2, "fuck");
        Array.set(array, 3, "lao");
        Array.set(array, 4, "wang");
        System.out.println(Array.get(array, 2));
        System.out.println(Array.get(array, 3));
        System.out.println(Array.get(array, 4));
    }
}
class MethodClass{
    public final int fuck = 1;

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a + b;
    }
}
