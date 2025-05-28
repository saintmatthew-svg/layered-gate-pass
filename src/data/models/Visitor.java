package data.models;

public class Visitor {
    private String name;
    private AccessCode accessCode;

    public String getName() {
        return name;
    }

    public AccessCode getAccessCode() {
        return accessCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccessCode(AccessCode accessCode) {
        this.accessCode = accessCode;
    }
}