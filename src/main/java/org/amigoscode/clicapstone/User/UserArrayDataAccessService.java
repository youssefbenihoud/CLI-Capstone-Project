package org.amigoscode.clicapstone.User;

import java.io.*;
import java.util.*;

public class UserArrayDataAccessService implements UserDao {



    @Override
    public List<User> getUsers(){
        // Working with Files
        File file = createFile("src/main/java/org/amigoscode/users.csv");
        //writeFile(file, true);

        List<User> users = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()){
                String[] values = scanner.nextLine().split(",");
                //System.out.println(values);
                UUID uuid = UUID.fromString(values[0]);
                String name = values[1];
                //System.out.print(uuid.toString()+" --> "+name);
                User user = new User(uuid, name);
                users.add(user);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return users;
    }

    private static void writeFile(File file, boolean append) {
        try {
            FileWriter fileWriter = new FileWriter(file, append);
            PrintWriter writer = new PrintWriter(fileWriter);
            writer.println("Hello");
            writer.println("World");

            writer.flush(); // make sure to flush this content
            writer.close(); // no longer need the writer
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    private static File createFile(String pathName) {
        File file = new File(pathName);
        try {
            if(!file.exists()) {
                file.createNewFile();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return file;
    }
}
