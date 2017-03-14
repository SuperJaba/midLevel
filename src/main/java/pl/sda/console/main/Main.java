package pl.sda.console.main;

import pl.sda.model.User;
import pl.sda.service.DataService;
import pl.sda.service.UserService;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        login(scanner);
//        DataService dataService = new DataService();

//        dataService.saveData(xmlString);


    }

    private static void login(Scanner scanner) {

        UserService userService = new UserService();
        boolean isLogin = false;
        while (!isLogin) {
            System.out.println("Login: ");
            String login = scanner.nextLine();
            System.out.println("Password: ");
            String password = scanner.nextLine();

            User user = new User(login, password);
            isLogin = userService.authenticatie(user);
            if (isLogin) {
                System.out.println("Zalogowany");
            } else {
                System.out.println("Nieprawidlowe haslo.");
            }
        }
    }
}
