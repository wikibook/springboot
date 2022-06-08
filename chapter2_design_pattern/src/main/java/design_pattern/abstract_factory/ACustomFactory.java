package design_pattern.abstract_factory;

public class ACustomFactory implements AbstractFactory{

    public AbstractObject createObject() {
        return new AObject();
    }
}
