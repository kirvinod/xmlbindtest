package com.test;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.*;
import java.io.File;

public class Test {


    public static void main(String[] args) {


        validate();

        //real api request would be protected
        String authString = "username:password";
        byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
        String authStringEnc = new String(authEncBytes);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Basic "+authStringEnc);
        HttpEntity<String> entity = new HttpEntity<String>(headers);


        //rest template to get XML
        RestTemplate rest = new RestTemplate();
        ResponseEntity<Feed> response = rest.exchange("http://crixus.kennedy.ox.ac.uk/4232.xml", HttpMethod.GET, entity, Feed.class);

        Feed feed = response.getBody();


        System.out.println(response);
        System.out.println(feed.getEntry().getObject().getId());
        System.out.println(feed.getEntry().getObject().getEmailAddress());

    }



    private static void validate() {
        try {
            //same file as online
            File file = new File("/Users/test/Desktop/sample.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Feed.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            jaxbUnmarshaller.setEventHandler(
                    new ValidationEventHandler() {
                        public boolean handleEvent(ValidationEvent event ) {
                            throw new RuntimeException(event.getMessage(),
                                    event.getLinkedException());
                        }
                    });
            Feed pojo = (Feed) jaxbUnmarshaller.unmarshal(file);

            System.out.println(pojo.getEntry());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }



}
