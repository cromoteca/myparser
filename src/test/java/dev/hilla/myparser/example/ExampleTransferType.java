package dev.hilla.myparser.example;

public class ExampleTransferType {

    public final ExampleEntity value;

    public ExampleTransferType(ExampleEntity value) {
        this.value = value;
    }

    public ExampleEntity getValue() {
        return value;
    }
}
