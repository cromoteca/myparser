package dev.hilla.myparser.example;

public abstract class ExampleBaseEntity implements ExampleInterface {

    @Override
    public ExampleType getExampleObject() {
        return new ExampleType(5);
    }

    protected int computeImportance() {
        return 10;
    }
}
