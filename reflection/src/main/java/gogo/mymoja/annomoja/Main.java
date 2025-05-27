package gogo.mymoja.annomoja;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        Class<?> bookClass = Class.forName("gogo.mymoja.annomoja.Book");
        Constructor<?> constructor = bookClass.getConstructor(String.class);
        Book book = (Book) constructor.newInstance("Test");
        System.out.println(book);

        Field A = Book.class.getDeclaredField("A");
        System.out.println(A.get(null)); // static 필드기 때문에 가능.
        A.set(null, "AAÆ");
        System.out.println(A.get(null));

        Field B = Book.class.getDeclaredField("B");
        B.setAccessible(true);
        System.out.println(B.get(book));
        B.set(book, "BBBBB");
        System.out.println(B.get(book));

        Method c = Book.class.getDeclaredMethod("c");
        c.setAccessible(true);
        c.invoke(book);

        Method sum = Book.class.getDeclaredMethod("sum", int.class, int.class);
        sum.setAccessible(true);
        int result = (int) sum.invoke(book, 1, 2);
        System.out.println(result);
    }
}
