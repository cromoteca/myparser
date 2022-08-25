package dev.hilla.myparser.example;

public class ExampleType {

    // Use a field name that is different from the property name
    private final Integer negativeValue;

    // Alter the stored value in getter and setter
    public ExampleType(int value) {
        this.negativeValue = -value;
    }

    public int getValue() {
        return -negativeValue;
    }
}
