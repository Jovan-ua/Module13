package task1;

public class Main {
    public static void main(String[] args) {
        Task1 task1 = new Task1();
        try {
            String newUserJson = "{\"name\":\"Ivan\",\"username\":\"Ivanov\",\"email\":\"ivanivanov@example.com\"}";
            String createdUser = task1.createNewUser(newUserJson);
            System.out.println("Created user: " + createdUser);

            int userIdToUpdate = 1;
            String updatedUserJson = "{\"name\":\"Updated Name\",\"username\":\"updateduser\",\"email\":\"updated@example.com\"}";
            String updatedUser = task1.updateUser(userIdToUpdate, updatedUserJson);
            System.out.println("Updated user: " + updatedUser);

            int userIdToDelete = 1;
            int deleteStatus = task1.deleteUser(userIdToDelete);
            System.out.println("Delete status: " + deleteStatus);

            String allUsers = task1.getAllUsers();
            System.out.println("All users: " + allUsers);

            int userIdToGet = 1;
            String userById = task1.getUserById(userIdToGet);
            System.out.println("User id: " + userById);

            String usernameToGet = "Bret";
            String userByUsername = task1.getUserByUsername(usernameToGet);
            System.out.println("User by Name: " + userByUsername);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

