package org.geoffchiang.lametric;

import com.google.gson.Gson;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.geoffchiang.lametric.model.Frames;

import java.io.IOException;

public class PushToLaMetric {

    private final String appId;
    private final String accessToken;

    public PushToLaMetric(String appId, String accessToken) {
        this.appId = appId;
        this.accessToken = accessToken;
    }

    public void push(Frames frames) throws IOException {
        String json = new Gson().toJson(frames);
        System.out.println(json);

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost("https://developer.lametric.com/api/V1/dev/widget/update/" + appId);
        post.addHeader("Accept", "application/json");
        post.addHeader("Cache-Control", "no-cache");
        post.addHeader("X-Access-Token", accessToken);
        post.setEntity(new StringEntity(json, "UTF8"));

        try (CloseableHttpResponse response = httpClient.execute(post)) {
            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() != HttpStatus.SC_OK) {
                throw new RuntimeException("Unexpected response code: " + statusLine.getStatusCode());
            }
        }
    }
}
