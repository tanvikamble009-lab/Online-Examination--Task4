public class Candidate {

    private String username;
    private String password;

    public Candidate(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean login(String enteredUsername, String enteredPassword) {

        return username.equals(enteredUsername)
                && password.equals(enteredPassword);
    }

    public void updateProfile(String newUsername, String newPassword) {

        this.username = newUsername;
        this.password = newPassword;

        System.out.println("Profile updated successfully.");
    }

    public String getUsername() {
        return username;
    }
}
