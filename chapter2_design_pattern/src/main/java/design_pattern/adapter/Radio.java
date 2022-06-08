package design_pattern.adapter;

public class Radio implements Electronic110v{

    @Override
    public void power110vOn() {
        System.out.println("라디오 전원 On -- 110v");
    }
}
