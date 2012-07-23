package org.jcrop.utils;

public class JsFunction implements java.io.Serializable {

    public JsFunction(String name, String body) {
        super();
        this.name = name;
        this.body = body;
    }

    private String name;

    private String body;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return body;
    }
}
