package org.geoffchiang.lametric;

import com.google.gson.Gson;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.geoffchiang.lametric.model.ChartFrame;
import org.geoffchiang.lametric.model.Frames;
import org.geoffchiang.lametric.model.GoalDataFrame;
import org.geoffchiang.lametric.model.TextFrame;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    private static final String LAMETRIC_DEVICE_ID = "insert your device id - should be start with com.lametric.";
    private static final String ACCESS_TOKEN = "insert your access token";
    private static final String APP_VERSION = "1";

    public static void main(String[] args) {
        Frames frames = new Frames();
        frames.add(new TextFrame(0, "Pacman", "i294"));
        frames.add(new GoalDataFrame(1, 0, 60, 100, "", "i555"));
        frames.add(new ChartFrame(2, Arrays.asList(50, 300, 200, 25, 175, 75, 325, 125)));
        String json = new Gson().toJson(frames);

//        System.out.println(json);

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost("https://developer.lametric.com/api/V1/dev/widget/update/" + LAMETRIC_DEVICE_ID + "/" + APP_VERSION);
        post.addHeader("Accept", "application/json");
        post.addHeader("Cache-Control", "no-cache");
        post.addHeader("X-Access-Token", ACCESS_TOKEN);
        post.setEntity(new StringEntity(json, "UTF8"));

        try {
            try (CloseableHttpResponse response = httpClient.execute(post)) {
                StatusLine statusLine = response.getStatusLine();
                if (statusLine.getStatusCode() == HttpStatus.SC_OK) {

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
