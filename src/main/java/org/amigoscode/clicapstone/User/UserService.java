package org.amigoscode.clicapstone.User;


import java.util.List;
import java.util.UUID;

public class UserService {

    private UserArrayDataAccessService userArrayDataAccessService
            = new UserArrayDataAccessService();

    public List<User> findAll(){
        return userArrayDataAccessService.getUsers();
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
