package gogo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MemberTest {

    @Test
    void getterSetter() {
        Member member = new Member();
        member.setName("TEST");

        Assertions.assertEquals("TEST", member.getName());
    }

}
