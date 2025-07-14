package com.adaptris.jsr107.test;

import com.adaptris.testing.SingleAdapterFunctionalTest;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.HttpEntities;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefaultFunctionalTest extends SingleAdapterFunctionalTest {

    @Test
    public void test() throws Exception {
        HttpPost httpPost = new HttpPost(String.format("%s/input?key=test", getBaseAdapterUrl()));
        httpPost.setEntity(HttpEntities.create("value"));
        try (CloseableHttpResponse response = client.execute(httpPost)) {
            assertEquals(200, response.getCode());
        }

        HttpGet httpGet = new HttpGet(String.format("%s/recall?key=test", getBaseAdapterUrl()));
        try (CloseableHttpResponse response = client.execute(httpGet)) {
            assertEquals(200, response.getCode());
            assertEquals("value", EntityUtils.toString(response.getEntity()));
        }

        HttpGet httpGetRemove = new HttpGet(String.format("%s/remove?key=test", getBaseAdapterUrl()));
        try (CloseableHttpResponse response = client.execute(httpGetRemove)) {
            assertEquals(200, response.getCode());
        }

    }
}
