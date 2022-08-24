package dev.hilla.myparser.example;

public class ExampleEntity extends ExampleBaseEntity {

    private final ExampleServerType data;

    public ExampleEntity() {
        data = new ExampleServerType(8);
    }

    public ExampleEntity(ExampleServerType data) {
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

    public ExampleServerType getData() {
        return data;
    }
}
