package gogo.di;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ContainerService {

    public static <T> T getObject(Class<T> classType) {
        T instance = createInstance(classType);

        Arrays.stream(classType.getDeclaredFields()).forEach(field -> {
            Inject annotation = field.getAnnotation(Inject.class);
            if (annotation != null) {
                Class<?> fieldType = field.getType();
                Object filedInstance = createInstance(fieldType);
                field.setAccessible(true);
                try {
                    field.set(instance, filedInstance);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        return instance;
    }

    private static <T> T createInstance(Class<T> classType) {
        try {
            return classType.getConstructor(null).newInstance();
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

}
