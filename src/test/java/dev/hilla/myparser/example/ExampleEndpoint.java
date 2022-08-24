package dev.hilla.myparser.example;

import dev.hilla.myparser.Endpoint;

@Endpoint
public class ExampleEndpoint {

    private String generateMessage(String param) {
        return param == null ? "No message"
                : String.format("Message: <%s>", param);
    }

    public String defaultMessage() {
        return generateMessage("default");
    }

    public String customMessage(String text) {
        return generateMessage(text);
    }

    public ExampleServerData getData() {
        return new ExampleServerData(new ExampleEntity());
    }

    public void setData(ExampleServerData data) {
    }
}
