package pvt.finalproject.apitesting;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.ThreadLocalRandom;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;


public class ApiTests {
    private static final String BASE_URL = "https://api.vk.com/method/";
    private static final String TARGET_USER_ID = "431930514";
    private static final String ACCESS_TOKEN = "a9fd035e7ddffb6133d1a2684dd8b266595484373817eefe648c0d3089d07414b9" +
            "27e96116189e8f046c4";
    private static final String API_VERSION = "5.92";
    private static final String ERROR_RESPONSE = "Received response with an error!";
    private static HttpClient client;
    private static String message_id;


    @BeforeClass
    public static void initClient() {
        client = HttpClientBuilder.create().build();
    }

    @Test(enabled = false)
    public void testMessageSending() throws URISyntaxException, IOException {
        URIBuilder builder = new URIBuilder(BASE_URL + "messages.send?");
        builder.setParameter("access_token", ACCESS_TOKEN)
                .setParameter("user_id", TARGET_USER_ID)
                .setParameter("random_id", getRandomNumber())
                .setParameter("message", "test message")
                .setParameter("v", API_VERSION);
        HttpGet request = new HttpGet(builder.build());
        HttpResponse response = client.execute(request);
        assertThat(response.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
        JSONObject responseBody = getResponseBody(response);
        assertFalse(ERROR_RESPONSE, responseBody.has("error"));
        Object message_id = responseBody.get("response");
        assertThat(message_id, instanceOf(Integer.class));
        ApiTests.message_id = String.valueOf(message_id);
    }

    @Test(enabled = false)
    public void testMessageSendingWithAttachment() throws URISyntaxException, IOException {
        URIBuilder builder = new URIBuilder(BASE_URL + "messages.send?");
        builder.setParameter("access_token", ACCESS_TOKEN)
                .setParameter("user_id", TARGET_USER_ID)
                .setParameter("random_id", getRandomNumber())
                .setParameter("message", "message with pic")
                .setParameter("attachment", "photo-43853415_456255743")
                .setParameter("v", API_VERSION);
        HttpGet request = new HttpGet(builder.build());
        HttpResponse response = client.execute(request);
        assertThat(response.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
        JSONObject responseBody = getResponseBody(response);
        assertFalse(ERROR_RESPONSE, responseBody.has("error"));
        Object message_id = responseBody.get("response");
        assertThat(message_id, instanceOf(Integer.class));
        ApiTests.message_id = String.valueOf(message_id);
    }

    @Test(enabled = false)
    public void testMessageEditing() throws URISyntaxException, IOException {
        URIBuilder builder = new URIBuilder(BASE_URL + "messages.edit?");
        builder.setParameter("access_token", ACCESS_TOKEN)
                .setParameter("peer_id", TARGET_USER_ID)
                .setParameter("message", "edited message")
                .setParameter("message_id", message_id)
                .setParameter("v", API_VERSION);
        HttpGet request = new HttpGet(builder.build());
        HttpResponse response = client.execute(request);
        assertThat(response.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
        JSONObject responseBody = getResponseBody(response);
        assertFalse(ERROR_RESPONSE, responseBody.has("error"));
        assertThat(responseBody.get("response"), equalTo(1));
    }

    @Test(enabled = false)
    public void testMessageDeleting() throws URISyntaxException, IOException {
        URIBuilder builder = new URIBuilder(BASE_URL + "messages.delete?");
        builder.setParameter("access_token", ACCESS_TOKEN)
                .setParameter("message_id", message_id)
                .setParameter("v", API_VERSION);
        HttpGet request = new HttpGet(builder.build());
        HttpResponse response = client.execute(request);
        assertThat(response.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
        JSONObject responseBody = getResponseBody(response);
        assertFalse(ERROR_RESPONSE, responseBody.has("error"));
        assertThat(responseBody.get("response"), equalTo(1));
    }

    private JSONObject getResponseBody(HttpResponse response) throws IOException {
        String jsonResponse = EntityUtils.toString(response.getEntity());
        return new JSONObject(jsonResponse);
    }

    private static String getRandomNumber() {
        int minLimit = 1;
        int maxLimit = 500;
        int randomNum = ThreadLocalRandom.current().nextInt(minLimit, maxLimit + 1);
        return String.valueOf(randomNum);
    }
}
