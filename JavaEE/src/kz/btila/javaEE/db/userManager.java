package kz.btila.javaEE.db;

import java.util.ArrayList;

public class userManager {
    private static final ArrayList<User> users = new ArrayList<>();

    static int id = 5;

    static {
        users.add(new User(1,"Ayan","Nurgali","IT",1200000));
        users.add(new User(2,"Dulat","Saparbaev","HR",1100000));
        users.add(new User(3,"Parasat","Amanbek","PR",1000000));
        users.add(new User(4,"Akzhol","Nurmaganbet","Management",1000000));
    }
    public static ArrayList<User> getUsers(){
        return users;
    }

    public static void addUser(User user) {
        user.setId(id);
        users.add(user);
        id++;
    }

    public static void deleteUser(int id){
        for(User u:users){
            if(u.getId()==id){
                users.remove(u);
                break;
            }
        }
    }
}
