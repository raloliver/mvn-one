package br.raloliver.mvnone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

@EnableAutoConfiguration
@ComponentScan
public class App {
    public static void main(String[] args) {
        String url = "https://viacep.com.br/ws/" + args[0] + "/json/";

        try {
            CloseableHttpClient client = HttpClientBuilder.create().build();
            CloseableHttpResponse response = client.execute(new HttpGet(url));
            String json = EntityUtils.toString(response.getEntity());

            System.out.println(json);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}