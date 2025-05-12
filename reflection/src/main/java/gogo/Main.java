package gogo;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException {

        Class<Book> bookClass = Book.class;
        Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
            Arrays.stream(f.getAnnotations()).forEach(a -> {
                if (a instanceof MyAnnotation) {
                    MyAnnotation a1 = (MyAnnotation) a;
                    System.out.println("number: " + a1.number()); // 999
                }
            });
        });

    }
}
