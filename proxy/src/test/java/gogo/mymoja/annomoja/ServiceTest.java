package gogo.mymoja.annomoja;

import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class ServiceTest {

    // 다이나믹 프록시의 단점: 인터페이스 기반 프록시 객체만 생성 가능
    Service service = (Service) Proxy.newProxyInstance(Service.class.getClassLoader(), new Class[]{Service.class},
        new InvocationHandler() {
            Service service = new ServiceImpl();

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("before invoke");
                Object invoke = method.invoke(service, args);
                System.out.println("after invoke");
                return invoke;
            }
        }
    );

    @Test
    void test() {
        service.hello("world");
    }

    @Test
    void cglib() {
        MethodInterceptor handler = new MethodInterceptor() {
            ServiceImpl service = new ServiceImpl();

            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println("after intercept");
                Object invoke = method.invoke(service, args);
                System.out.println("before invoke");
                return invoke;
            }
        };

        ServiceImpl s = (ServiceImpl) Enhancer.create(ServiceImpl.class, handler);
        s.hello("world");
    }

}
