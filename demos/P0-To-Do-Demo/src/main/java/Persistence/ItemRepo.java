package Persistence;

import Utils.ConnectionManager;
import Utils.CustomLinkedList;
import Utils.CustomListInterface;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class ItemRepo implements DataSourceCRUD<ItemModel>{
    @Override
    public Integer create(ItemModel itemModel) throws SQLException, IOException {
        String sql = "INSERT INTO items (message, completed, user_id) VALUES (?, ?, ?)";
        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, itemModel.getMessage());
        pstmt.setBoolean(2, itemModel.getCompleted());
        pstmt.setInt(3, itemModel.getUserId());

        pstmt.executeUpdate();
        ResultSet rs = pstmt.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }

        return null;
    }

    @Override
    public ItemModel read(Integer id) throws SQLException, IOException {
        String sql = "SELECT * FROM items WHERE item_id = ?";
        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
        pstmt.setInt(1, id);

        ResultSet rs = pstmt.executeQuery();
        if(rs.next()) {
            ItemModel item = new ItemModel();
            item.setItemId(rs.getInt("item_id"));
            item.setMessage(rs.getString("message"));
            item.setCompleted(rs.getBoolean("completed"));
            item.setUserId(rs.getInt("user_id"));
            return item;
        }
        return null;
    }

    @Override
    public ItemModel update(ItemModel itemModel) throws SQLException, IOException {
        String sql = "UPDATE items SET message = ?, completed = ? WHERE item_id = ?";
        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
        pstmt.setString(1, itemModel.getMessage());
        pstmt.setBoolean(2, itemModel.getCompleted());
        pstmt.setInt(3, itemModel.getItemId());
        pstmt.executeUpdate();

        return itemModel;
    }

    @Override
    public void delete(Integer id) throws SQLException, IOException {
        String sql = "DELETE FROM items WHERE item_id = ?";
        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }

    public List<ItemModel> getAllItemsByUserId(Integer id) throws SQLException, IOException {
        String sql = "SELECT * FROM items WHERE user_id = ?";
        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
        pstmt.setInt(1, id);

        ResultSet rs = pstmt.executeQuery();
        List<ItemModel> itemsList = new LinkedList<>();

        while(rs.next()) {
            ItemModel item = new ItemModel();
            item.setItemId(rs.getInt("item_id"));
            item.setMessage(rs.getString("message"));
            item.setCompleted(rs.getBoolean("completed"));
            item.setUserId(rs.getInt("user_id"));
            itemsList.add(item);
        }

        return itemsList;

    }


}
