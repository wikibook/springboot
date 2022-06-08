package design_pattern.proxy;

public class Proxy implements Service{

    ServiceImpl service;

    @Override
    public void print() {
        System.out.println("프록시를 통해 실행");
        service = new ServiceImpl();
        service.print();
    }
}
