package design_pattern.proxy;

public class Main {

    public static void main(String[] args){
        Service service = new Proxy();
        service.print();
    }

}
