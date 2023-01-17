package org.amigoscode.clicapstone.User;

import java.io.*;
import java.util.Scanner;
import java.util.UUID;

public class UserArrayDataAccessService implements UserDao {

    private static final User[] users;


    static {
        users = new User[]{
                new User(UUID.fromString("8ca51d2b-aaaf-4bf2-834a-e02964e10fc3"), "James"),
                new User(UUID.fromString("b10d126a-3608-4980-9f9c-aa179f5cebc3"), "Jamila")
        };
    }

    @Override
    public User[] getUsers(){
        // Working with Files
        File file = createFile("src/main/java/org/amigoscode/users.csv");
        //writeFile(file, true);

        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()){
                System.out.println(scanner.nextLine());
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
