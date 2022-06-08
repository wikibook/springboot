package design_pattern.singleton;

public class Main {
    public static void main(String[] args){

        MyObject myObject1 = new MyObject("클래스 1");
        myObject1.print();

        MyObject myObject2 = new MyObject("클래스 2");
        myObject2.print();
    }
}
