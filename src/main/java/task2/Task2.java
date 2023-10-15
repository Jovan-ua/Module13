package task2;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.FileWriter;
import java.io.IOException;

public class Task2 {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/users";
    private static HttpClient httpClient = HttpClients.createDefault();

    public static void main(String[] args) {
        int userId = 1; // Замените на ID пользователя
        int postId = getLatestPostId(userId); // Получаем ID последнего поста

        if (postId > 0) {
            String fileName = "user-" + userId + "-post-" + postId + "-comments.json";

            try {
                String commentsJson = getPostComments(postId);
                writeJsonToFile(fileName, commentsJson);
                System.out.println("Комментарии записаны в файл: " + fileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Не удалось найти пост для пользователя с ID " + userId);
        }
    }

    // Метод для получения ID последнего поста пользователя
    public static int getLatestPostId(int userId) {
        int latestPostId = -1;
        try {
            String userPostsJson = getAllUserPosts(userId);
            // Здесь можно распарсить JSON и найти последний пост
            // Для упрощения примера, давайте предположим, что последний пост имеет ID = 10
            latestPostId = 10;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return latestPostId;
    }

    // Метод для получения всех постов пользователя
    public static String getAllUserPosts(int userId) throws Exception {
        String url = BASE_URL + "/" + userId + "/posts";
        HttpGet request = new HttpGet(url);
        HttpResponse response = httpClient.execute(request);
        return EntityUtils.toString(response.getEntity());
    }

    // Метод для получения комментариев к посту
    public static String getPostComments(int postId) throws Exception {
        String url = "https://jsonplaceholder.typicode.com/posts/" + postId + "/comments";
        HttpGet request = new HttpGet(url);
        HttpResponse response = httpClient.execute(request);
        return EntityUtils.toString(response.getEntity());
    }

    // Метод для записи JSON в файл
    public static void writeJsonToFile(String fileName, String json) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write(json);
        fileWriter.close();
    }
}
