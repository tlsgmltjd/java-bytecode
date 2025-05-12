package gogo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException {
        Class<Book> bookClass = Book.class; // 클래스 로딩 후에 힙에는 클래스 정보에 대한 인스턴스가 만들어짐. 클래스 타입으로 받아올 수 있음

        Field[] fields = bookClass.getFields();
        for (Field field : fields) {
            // public member 만 가져옴
            System.out.println(field.getName());
        }

        Field[] dFields = bookClass.getDeclaredFields();
        // 전체 맴버
        for (Field field : dFields) {
            // public member 만 가져옴
            System.out.println(field.getName());
        }

        Book book = new Book();
        Class<? extends Book> aClass = book.getClass(); // 클래스 인스턴스를 통해서도 받아올 수 있다.

        Field[] dIFields = bookClass.getDeclaredFields();
        // 전체 맴버
        for (Field field : dIFields) {
            field.setAccessible(true); // 접근할 수 없는 필드에도 접근 가능하도록 한다.
            // 클래스 인스턴스를 사용하면 해당 인스턴스의 필드 값에도 접근이 가능하다.
            System.out.println(field.get(book));
        }

        Method[] dMethod = bookClass.getDeclaredMethods();
        for (Method m : dMethod) {
            m.setAccessible(true);
            System.out.println("Method : " + m);
        }

        Constructor[] dCon = bookClass.getDeclaredConstructors();
        for (Constructor c : dCon) {
            c.setAccessible(true);
            System.out.println("Const : " + c);
        }

        Class<? super Book> superclass = bookClass.getSuperclass();
        System.out.println("Super : " + superclass);

        Class<MyBook> myBookClass = MyBook.class;
        Class<?>[] interfaces = myBookClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("Interface : " + anInterface);
        }

        Arrays.stream(bookClass.getDeclaredFields()).forEach(field -> {
            int modifiers = field.getModifiers();
            System.out.println(modifiers);
        });

        Class<?> aClass1 = Class.forName("gogo.Book"); // 클래스 파일 경로로도 받아올 수 있다.
    }
}
