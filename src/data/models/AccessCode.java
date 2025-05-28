package data.models;

public class AccessCode {
    private final int id;
    private String code;
    private final Visitors visitor;
    private String description;

    public AccessCode(int id, String code, Visitors visitor, String description) {
        this.id = id;
        this.code = code;
        this.visitor = visitor;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public Visitors getVisitor() {
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