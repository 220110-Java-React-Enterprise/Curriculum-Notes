public class MyPOJOClass {
    //What is a POJO? - Plain Old Java Object
    //Private fields, no args constructor, public getters and setters

    private Integer id;
    private String name;
    private String username;
    private String password;


    public MyPOJOClass() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
