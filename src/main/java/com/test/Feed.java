package com.test;

import javax.xml.bind.annotation.*;
import java.util.List;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Feed {

    @XmlAnyElement(lax = true)
    private List<Object> anything;

    @XmlElement(name="entry")
    private Entry entry;

    public List<Object> getAnything() {
        return anything;
    }

    public void setAnything(List<Object> anything) {
        this.anything = anything;
    }

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }
}
