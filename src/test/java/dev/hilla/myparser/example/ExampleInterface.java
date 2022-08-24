package dev.hilla.myparser.example;

public interface ExampleInterface {

    String getName();

    ExampleServerType getExampleObject();

    default int getImportance() {
        return 0;
    }
}
