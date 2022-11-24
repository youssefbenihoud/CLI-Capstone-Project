package org.amigoscode.clicapstone.User;


import java.util.UUID;

public class UserService {

    private UserDao userDao = new UserDao();

    public User[] findAll(){
        return userDao.getUsers();
    }

    // find User by UUID
    public User getUserById(UUID userID){
        for(User user: findAll()){
            if(user.getId().equals(userID)){
                return user;
            }
        }

        return null;
    }
}
