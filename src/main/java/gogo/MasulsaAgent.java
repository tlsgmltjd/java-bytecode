//package gogo;
//
//import net.bytebuddy.agent.builder.AgentBuilder;
//import net.bytebuddy.implementation.FixedValue;
//import net.bytebuddy.matcher.ElementMatchers;
//
//import java.lang.instrument.Instrumentation;
//
//import static net.bytebuddy.matcher.ElementMatchers.named;
//
//public class MasulsaAgent {
//    // instrumentation: 클래스가 JVM에 로드될 때 바이트코드 자체를 바꿀 수 있게 해주는 기능
//    public static void premain(String agentArgs, Instrumentation inst) {
//        new AgentBuilder.Default()
//                .type(ElementMatchers.any())
//                .transform((builder, typeDescription, classLoader, javaModule, protectionDomain)
//                        -> builder
//                        .method(named("pullOut"))
//                        .intercept(FixedValue.value("Rabbit!"))
//                ).installOn(inst);
//    }
//}
