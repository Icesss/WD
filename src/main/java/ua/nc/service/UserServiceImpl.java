package ua.nc.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ua.nc.db.UserDB;
import ua.nc.entity.User;
import ua.nc.entity.enums.Role;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Pavel on 18.04.2016.
 */
public class UserServiceImpl implements UserService {
    @Override
    public User getUser(String email) {
        //here will be UserDAO
/*        User user = new User();
        user.setName("netcracker");
        user.setEmail("netcracker@gmail.com");
        user.setPassword("827ccb0eea8a706c4c34a16891f84e7b");
        Set<Role> roles = new HashSet<Role>();
        roles.add(Role.ROLE_ADMIN);
        roles.add(Role.ROLE_STUDENT);
        user.setRoles(roles);*/
        User user = new User();
        try {
            UserDB userDB = new UserDB();
            user = userDB.findByEmail(email);
            user.setRoles(userDB.findRoleByEmail(email));
        } catch (Exception e) {
            System.out.println("Broke bd");
            throw new UsernameNotFoundException("error", e);
        }
        return user;
    }

}
