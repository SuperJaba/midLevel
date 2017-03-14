package pl.sda.service;

import pl.sda.model.User;

/**
 * Created by RENT on 2017-03-13.
 */
public class UserService {
    private User userFromFile = new User();
    private DataService dataService = new DataService();

    public boolean authenticatie(User user) {
        //pobieramy pasword z user, gdy mamy wiecej niz jednego usera
        //pobieramy userFromFile
        //

        userFromFile = dataService.loadData();


        return user.equals(userFromFile);
    }
}
