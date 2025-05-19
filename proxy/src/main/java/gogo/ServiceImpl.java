package gogo;

public class ServiceImpl implements Service {
    @Override
    public void hello(String name) {
        System.out.println("Hello ! " + name);
    }
}
