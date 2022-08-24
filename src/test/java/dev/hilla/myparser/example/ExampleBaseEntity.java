package dev.hilla.myparser.example;

public abstract class ExampleBaseEntity implements ExampleInterface {

    @Override
    public ExampleServerType getExampleObject() {
        return new ExampleServerType(5);
    }

    protected int computeImportance() {
        return 10;
    }
}
