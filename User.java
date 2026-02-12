package librarymodel;

public abstract class User {
    protected String id;
    protected String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Add this getter method
    public String getName() {
        return name;
    }

    // Optional: Add ID getter too
    public String getId() {
        return id;
    }

    public abstract void performRole();
}

