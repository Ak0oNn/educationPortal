package DB;

import model.Item;
import model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBConnector {
    private static Connection connection;

    static{
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/SprintTask2",
                    "postgres",
                    "kenzo2015"
            );
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static List<Item> getItems(){
        List<Item> items = new ArrayList<>();
        try {
            PreparedStatement statement =connection.prepareStatement(
                    "select * from items order by id");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Item item = new Item();
                item.setId(resultSet.getLong("id"));
                item.setName(resultSet.getString("name"));
                item.setDescription(resultSet.getString("description"));
                item.setPrice(resultSet.getDouble("price"));
                items.add(item);
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return items;
    }
    public static User getUser(String email){
        User user = null;
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email = ?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                user = new User();
                user.setEmail(resultSet.getString("email"));
                user.setId(resultSet.getLong("id"));
                user.setPassword(resultSet.getString("password"));
                user.setFullName(resultSet.getString("full_name"));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
}
