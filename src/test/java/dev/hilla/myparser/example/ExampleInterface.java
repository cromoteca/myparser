package dev.hilla.myparser.example;

public interface ExampleInterface {

    String getName();

    ExampleType getExampleObject();

    default int getImportance() {
        return 0;
    }
}
