package dev.hilla.myparser.example;

public class ExampleEntity extends ExampleBaseEntity {

    private final ExampleType data;

    public ExampleEntity() {
        data = new ExampleType(8);
    }

    public ExampleEntity(ExampleType data) {
        this.data = data;
    }

    @Override
    public String getName() {
        return "Example entity";
    }

    @Override
    public int getImportance() {
        return computeImportance();
    }

    public ExampleType getData() {
        return data;
    }
}
