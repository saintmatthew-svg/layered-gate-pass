package data.models;

public class AccessCode {
    private int id;
    private String code;
    private String visitor;
    private String description;

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getVisitor() {
        return visitor;
    }

    public String getDescription() {
        return description;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}