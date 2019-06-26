package com.test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
public class ApiObject {

    private String id;

    @XmlAnyElement(lax = true)
    private List<Object> anything;

    @XmlElement(name= "last-name", namespace = "http://www.example.com/publications/api")
    private String lastName;
    @XmlElement(name = "first-name", namespace = "http://www.example.com/publications/api")
    private String firstName;
    @XmlElement(name = "email-address", namespace = "http://www.example.com/publications/api")
    private String emailAddress;

    public List<Object> getAnything() {
        return anything;
    }

    public void setAnything(List<Object> anything) {
        this.anything = anything;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}