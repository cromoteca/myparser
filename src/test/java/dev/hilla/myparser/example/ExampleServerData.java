package dev.hilla.myparser.example;

public class ExampleServerData {

    public final ExampleEntity value;
    public final ExampleEntity serverOnlyValue;

    public ExampleServerData(ExampleEntity value, ExampleEntity serverOnlyValue) {
        this.value = value;
        this.serverOnlyValue = serverOnlyValue;
    }

    public ExampleEntity getValue() {
        return value;
    }

    public ExampleEntity getServerOnlyValue() {
        return serverOnlyValue;
    }
}
