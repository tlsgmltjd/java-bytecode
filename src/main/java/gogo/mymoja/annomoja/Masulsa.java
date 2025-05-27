package gogo.mymoja.annomoja;

public class Masulsa {
    // jvm option: -javaagent:/Users/huiseongshin/Project/BackEnd/java-bytecode/build/libs/java-bytecode-1.0-SNAPSHOT.jar
    // 위 옵션은 해당 위치의 Agent jar 파일을 JVM 실행할 때 먼저 호출하게 한다.

    // javaagent는 JVM이 실행될 때 Agent jar파일을 먼저 로딩하여 클래스 로딩 시점에 바이트 코드를 조작할 수 있게 한다. (메모리 내에서 변경한다. 실제 바이트 코드 파일을 변경하지 않고) Transparent
    public static void main(String[] args) {
        System.out.println(new Moja().pullOut());
    }
}
