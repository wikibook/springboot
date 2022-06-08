package design_pattern.adapter;

public class Main {

    public static void main(String[] args){

        // 110v는 정상적으로 동작
        Radio radio = new Radio();
        connect(radio);

        /*
        220v는 110v에서 동작하지 않음
        AirConditioner airConditioner = new AirConditioner();
        connect(airConditioner);
        */

        // 220v 제품 사용을 위해 어댑터를 사용
        Computer computer = new Computer();
        PowerAdapter powerAdapter = new PowerAdapter(computer);
        connect(powerAdapter);
    }

    public static void connect(Electronic110v electronic110v){
        electronic110v.power110vOn();
    }

}
