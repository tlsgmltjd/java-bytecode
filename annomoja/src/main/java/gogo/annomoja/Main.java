package gogo.annomoja;

public class Main {
    public static void main(String[] args) {
        Moja moja = new MojaFactory();
        System.out.println(moja.pollOut());
    }
}
