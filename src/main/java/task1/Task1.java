package task1;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Task1 {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/users";

    private static HttpClient httpClient = HttpClients.createDefault();

    public static String createNewUser(String userJson) throws Exception {
        HttpPost request = new HttpPost(BASE_URL);
        request.setHeader("Content-Type", "application/json");
        request.setEntity(new StringEntity(userJson));

        HttpResponse response = httpClient.execute(request);
        String responseJson = EntityUtils.toString(response.getEntity());
        return responseJson;
    }

    public static String updateUser(int userId, String updatedUserJson) throws Exception {
        HttpPut request = new HttpPut(BASE_URL + "/" + userId);
        request.setHeader("Content-Type", "application/json");
        request.setEntity(new StringEntity(updatedUserJson));

        HttpResponse response = httpClient.execute(request);
        String responseJson = EntityUtils.toString(response.getEntity());
        return responseJson;
    }

    public static int deleteUser(int userId) throws Exception {
        HttpDelete request = new HttpDelete(BASE_URL + "/" + userId);

        HttpResponse response = httpClient.execute(request);
        return response.getStatusLine().getStatusCode();
    }

    public static String getAllUsers() throws Exception {
        HttpGet request = new HttpGet(BASE_URL);

        HttpResponse response = httpClient.execute(request);
        String responseJson = EntityUtils.toString(response.getEntity());
        return responseJson;
    }

    public static String getUserById(int userId) throws Exception {
        HttpGet request = new HttpGet(BASE_URL + "/" + userId);

        HttpResponse response = httpClient.execute(request);
        String responseJson = EntityUtils.toString(response.getEntity());
        return responseJson;
    }

    public static String getUserByUsername(String username) throws Exception {
        HttpGet request = new HttpGet(BASE_URL + "?username=" + username);

        HttpResponse response = httpClient.execute(request);
        String responseJson = EntityUtils.toString(response.getEntity());
        return responseJson;
    }
}