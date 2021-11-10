package com.petid.petid.service;

import com.petid.petid.model.Animal;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class SmsService {

    @Value("${smso.api.url}")
    private String smsoApiUrl;

    @Value("${smso.api.key}")
    private String smsoApiKey;

    @Value("${smso.sender}")
    private String smsoSender;

    public void sendAnimalSavedSms(Animal animal){
        sendSms(animal.getName()+" se regaseste in baza de date PetId, avand ca proprietar pe "+
                        animal.getOwner().getLastName()+" "+animal.getOwner().getFirstName()+".",
                animal.getOwner().getPhone());
    }

    private void sendSms(String mesage, String number){

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(smsoApiUrl);

        try {
            List<NameValuePair> params = new ArrayList<NameValuePair>(3);
            params.add(new BasicNameValuePair("to", "+4"+number));
            params.add(new BasicNameValuePair("body", mesage));
            params.add(new BasicNameValuePair("sender", smsoSender));

            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

            httpPost.addHeader("X-Authorization", smsoApiKey);

            CloseableHttpResponse response = client.execute(httpPost);

            client.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
