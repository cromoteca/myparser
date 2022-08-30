package dev.hilla.myparser.example;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ExampleType {

    // Use a field name that is different from the property name
    private final Integer negativeValue;

    // Ignored by putting an annotation on the getter
    private String hidden;

    @JsonIgnore
    private String hiddenToo;

    // Renamed by an annotation on the getter
    private String uglyName;

    // Alter the stored value in getter and setter
    public ExampleType(int value) {
        this.negativeValue = -value;
    }

    public int getValue() {
        return -negativeValue;
    }

    @JsonIgnore
    public String getHidden() {
        return hidden;
    }

    public void setHidden(String hidden) {
        this.hidden = hidden;
    }

    // Ignored by putting an annotation on the field
    public String getHiddenToo() {
        return hiddenToo;
    }

    public void setHiddenToo(String hiddenToo) {
        this.hiddenToo = hiddenToo;
    }

    @JsonProperty("beautifulName")
    public String getUglyName() {
        return uglyName;
    }

    public void setUglyName(String uglyName) {
        this.uglyName = uglyName;
    }
}
