package com.test;



import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
public class Entry {


    @XmlAnyElement(lax = true)
    private List<Object> anything;

    @XmlElement(name="object", namespace = "http://www.example.com/publications/api")
    private ApiObject object;

    public List<Object> getAnything() {
        return anything;
    }

    public void setAnything(List<Object> anything) {
        this.anything = anything;
    }

    public ApiObject getObject() {
        return object;
    }

    public void setObject(ApiObject object) {
        this.object = object;
    }
}
