package gogo.mymoja.annomoja;

import java.lang.annotation.*;

// 어노테이션은 기본적으로 주석과 같아서 바이트 코드 로딩시 읽어오지 않는다.
// 런타임에서도 어노테이션을 유지하고 싶다면 @Retention(RetentionPolicy.RUNTIME) 해당 어노테이션을 선언한다.
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
@Inherited // 상위 클래스에서 어노테이션 조회가 가능
public @interface MyAnnotation {
    String value() default "신희성";
    int number() default 0;
}
