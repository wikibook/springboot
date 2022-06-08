package design_pattern.abstract_factory;

public class BCustomFactory implements AbstractFactory{

    public AbstractObject createObject() {
        return new BObject();
    }
}
