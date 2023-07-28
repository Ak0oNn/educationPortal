package bitlab.Spring.db;

import bitlab.Spring.Model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DBManager {
    public static List <Item> items = new ArrayList<>();
    private static long id = 7L;

    static {
        items.add(new Item(1L,"Mac Book Pro","8 GB RAM 255 GB SSD Intel Core I7",1199.99));
        items.add(new Item(2L,"Mac Book Pro","16 GB RAM 500 GB SSD Apple M1",1499.99));
        items.add(new Item(3L,"Mac Book Pro","16 GB RAM 1 TB SSD Apple M1",1799.99));
        items.add(new Item(4L,"ASUS Tuf Gaming","16 GB RAM 500 GB SSD Intel Core I7",1299.99));
        items.add(new Item(5L,"HP Laser Pro","8 GB RAM 500 GB SSD Intel Core I5",999.99));
        items.add(new Item(6L,"Lenovo Legion","32 GB RAM 512 GB SSD Intel Core I7",1399.99));
    }

    public static List<Item> getItems(){
        return items;
    }

    public static void addItem(Item item){
        item.setId(id);
        id++;
        items.add(item);
    }

    public static Item getItemById(Long id){
        return items.stream()
                .filter(item -> Objects.equals(item.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public static void deleteItemById(Long id) {
        items.removeIf(item -> Objects.equals(item.getId(), id));
    }
}
