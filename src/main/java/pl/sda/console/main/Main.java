package pl.sda.console.main;

import pl.sda.model.User;
import pl.sda.service.DataService;
import pl.sda.service.UserService;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

//        login(scanner);
        DataService dataService = new DataService();

//        dataService.saveData();


    }

    private static void login(Scanner scanner) {
        System.out.println("Login: ");
        String login = scanner.nextLine();

        System.out.println("Password: ");
        String password = scanner.nextLine();

        User user = new User(login, password);

        UserService userService = new UserService();
        if (userService.authenticatie(user)) {
            System.out.println("Zalogowany");
        } else {
            System.out.println("Nieprawidlowe haslo.");
        }
    }
}
