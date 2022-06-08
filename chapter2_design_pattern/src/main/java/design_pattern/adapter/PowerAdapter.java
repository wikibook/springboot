package design_pattern.adapter;

public class PowerAdapter implements Electronic110v{

    public Electronic220v electronic220v;

    public PowerAdapter(Electronic220v electronic220v){
        this.electronic220v = electronic220v;
    }

    @Override
    public void power110vOn() {
        electronic220v.power220vOn();
    }
}
