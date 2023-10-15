package task3;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class Task3 {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/users";
    private static HttpClient httpClient = HttpClients.createDefault();

    public static void main(String[] args) {
        int userId = 1;

        try {
            String openTasksJson = getOpenTasks(userId);
            System.out.println("Opens user tsaks " + userId + ":\n" + openTasksJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String getOpenTasks(int userId) throws Exception {
        String url = BASE_URL + "/" + userId + "/todos";
        HttpGet request = new HttpGet(url);
        HttpResponse response = httpClient.execute(request);
        String tasksJson = EntityUtils.toString(response.getEntity());


        JSONArray tasksArray = new JSONArray(tasksJson);
        StringBuilder openTasks = new StringBuilder();

        for (int i = 0; i < tasksArray.length(); i++) {
            JSONObject task = tasksArray.getJSONObject(i);
            boolean completed = task.getBoolean("completed");

            if (!completed) {
                openTasks.append(task.toString()).append("\n");
            }
        }

        return openTasks.toString();
    }
}
