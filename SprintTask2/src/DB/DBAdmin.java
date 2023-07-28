package DB;

import model.Brand;
import model.Item;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBAdmin {
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/SprintTask2",
                    "postgres",
                    "kenzo2015"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static List<Item> getAdmin(){
        List<Item> items = new ArrayList<>();
        try {
            PreparedStatement statement =connection.prepareStatement(
                    "select i.id, i.name, b.name as brand_name, b.country, i.description, i.price from items i " +
                            "inner join brands b on i.brand_id = b.id");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Item item = new Item();
                item.setId(resultSet.getLong("id"));
                item.setName(resultSet.getString("name"));
                item.setDescription(resultSet.getString("description"));
                item.setPrice(resultSet.getDouble("price"));


                Brand brand = new Brand();
                brand.setName(resultSet.getString("brand_name"));
                brand.setCountry(resultSet.getString("country"));

                item.setBrand(brand);
                items.add(item);
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return items;
    }
    public static List<Brand> getBrand(){
        List<Brand> brands = new ArrayList<>();
        try {
            PreparedStatement statement =connection.prepareStatement(
                    "select * from brands order by id");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Brand brand = new Brand();
                brand.setId(resultSet.getLong("id"));
                brand.setName(resultSet.getString("name"));
                brand.setCountry(resultSet.getString("country"));
                brands.add(brand);
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return brands;
    }
    public static void addItem (Item item){
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "insert into items(name, brand_id, price, description) "
                            + "values (?,?,?,?)");
            statement.setString(1, item.getName());
            statement.setLong(2, item.getBrand().getId());
            statement.setDouble(2,item.getPrice());
            statement.setString(3,item.getDescription());
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void deleteItemById(long id){
        try {
            PreparedStatement statement =connection.prepareStatement(
                    " delete from items where id = ?");
            statement.setLong(1,id);
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
//    public static Item getItemById(long id){
//        Item item = null
//        try {
//            PreparedStatement statement = connection.prepareStatement(
//                    " select * from items where id = ?");
//                statement.setLong(1,id);
//                ResultSet resultSet = statement.executeQuery();
//                if (resultSet.next()){
//                    item = new Item();
//                    item.setId(resultSet.getLong("id"));
//                    item.setName(resultSet.getString("name"));
//                    item.setDescription(resultSet.getString("description"));
//                    item.setPrice(resultSet.getDouble("price"));
//
//            }
//        }catch (Exception e ){
//            e.printStackTrace();
//        }
//        return  item;
//    }
    public static Brand getBrandById(long id){
        Brand brand = null;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "select * from brands where id = ?");
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                brand = new Brand();
                brand.setId(resultSet.getLong("id"));
                brand.setName(resultSet.getString("name"));
                brand.setCountry(resultSet.getString("country"));
            }
            statement.close();
        }catch (Exception e ){
            e.printStackTrace();
        }
        return brand;
    }
}

