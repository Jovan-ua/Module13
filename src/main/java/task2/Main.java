package task2;

public class Main {
    public static void main(String[] args) {
        Task2 task2 = new Task2();
        int userId = 1;
        int postId = task2.getLatestPostId(userId);

        if (postId > 0) {
            String fileName = "user-" + userId + "-post-" + postId + "-comments.json";

            try {
                String commentsJson = task2.getPostComments(postId);
                task2.writeJsonToFile(fileName, commentsJson);
                System.out.println("Comments write if nile: " + fileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Dont find post user id " + userId);
        }
    }

}
