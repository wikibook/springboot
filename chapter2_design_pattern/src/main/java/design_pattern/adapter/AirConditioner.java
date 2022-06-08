package design_pattern.adapter;

public class AirConditioner implements Electronic220v{

    @Override
    public void power220vOn() {
        System.out.println("에어컨 전원 On -- 220v");
    }
}
