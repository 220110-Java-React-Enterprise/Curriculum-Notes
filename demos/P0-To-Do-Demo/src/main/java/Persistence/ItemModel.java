package Persistence;

public class ItemModel {
    private Integer itemId;
    private String message;
    private Boolean completed;
    private Integer userId; //FK pointing to the PK in UserModel

    public ItemModel() {
    }

    public ItemModel(Integer itemId, String message, Boolean completed, Integer userId) {
        this.itemId = itemId;
        this.message = message;
        this.completed = completed;
        this.userId = userId;
    }

    public ItemModel(String message, Boolean completed, Integer userId) {
        this.message = message;
        this.completed = completed;
        this.userId = userId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        String check = " ";
        if(completed == true) {
            check = "X";
        }
        return "[" + check + "] - " + message ;
    }
}
