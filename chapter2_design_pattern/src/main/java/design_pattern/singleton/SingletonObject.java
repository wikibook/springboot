package design_pattern.singleton;

public class SingletonObject {

    private static SingletonObject singletonObject = null;

    private SingletonObject() {
    }

    public synchronized static SingletonObject getObject() {
        if (singletonObject == null) {
            singletonObject = new SingletonObject();
        }
        return singletonObject;
    }

    public void print() {
        System.out.println("Singleton Class : " + singletonObject.hashCode());
    }

}
