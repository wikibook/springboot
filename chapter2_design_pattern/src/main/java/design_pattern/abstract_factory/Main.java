package design_pattern.abstract_factory;

public class Main {

    public static void main(String[] args){
        AbstractFactory abstractFactory = new ACustomFactory();
        AbstractObject abstractObject = abstractFactory.createObject();
        abstractObject.print();

        System.out.println("===========================");

        abstractFactory = new BCustomFactory();
        abstractObject = abstractFactory.createObject();
        abstractObject.print();
    }
}
