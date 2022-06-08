package design_pattern.proxy;

public class ServiceImpl implements Service{

    @Override
    public void print() {
        System.out.println("내용을 출력합니다.");
    }
}
