package gogo.mymoja.annomoja;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // TYPE으로 지정하면, Interface, Class, Enum에 붙힐 수 있다. 하지만 인터페이스에만 붙히기를 원한다. -> 프로세서에서 검증
@Retention(RetentionPolicy.CLASS) // 바이트코드 레벨, 런타임 레벨에 해당 어노테이션을 활용할 필요가 없어서 SOURCE level
public @interface Magic {
}
