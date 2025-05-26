package gogo;

import lombok.Getter;
import lombok.Setter;

// 자바가 지원하는 어노에티션 프로세서 가능을 사용하여 만들어졌다.
// 컴파일시 어노테이션이 붙어있는 특정 소스코드에 소스코드를 만들어내는 기술이다.
// AST를 조작한다. -> 소스의 구조를 트리구조로 보여준다. API를 사용하면 소스코드를 참조만 가능하다.
// -> 하지만 수정할 수 있는 하위 클래스로 타입 캐스팅해서 어노테이션 프로세서 API를 사용하여 소스코드를 수정해버린다. (롬복은 해킹이다..)
@Getter @Setter
public class Member {
    private String name;
    private int age;
}
