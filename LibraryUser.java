public class LibraryUser {
    private String name;
    private int userId;


    public LibraryUser(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }


    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    // Method to display user info
    public void displayInfo() {
        System.out.println("User " + name + " | ID: " + userId);
    }
}
