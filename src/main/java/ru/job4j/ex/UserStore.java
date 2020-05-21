package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User foundUser = null;
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                foundUser = user;
                break;
            }
        }
            if (foundUser == null) {
                throw new UserNotFoundException("User not found.");
            }
        return foundUser;
    }

        public static boolean validate(User user) throws UserInvalidException {
            if (user.getUsername().length() <= 2) {
                throw new UserInvalidException("The username too short");
            } else  if (user.isValid()) {
                return true;
            } else throw new UserInvalidException("Invalid user");
        }

    public static void main(String[] args) {
        try {
            User[] users = {
                    new User("Petr Arsentev", true)
            };
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (Exception e) {
                e.printStackTrace();
            }
    }
}

