package com.mihey.hibernateconsole.view;

import com.mihey.hibernateconsole.controller.RegionController;
import com.mihey.hibernateconsole.controller.UserController;
import com.mihey.hibernateconsole.model.Region;
import com.mihey.hibernateconsole.model.User;
import com.mihey.hibernateconsole.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Scanner;

public class Login {

    private final Scanner sc = new Scanner(System.in);

    private String name;
    private String surname;
    private String regionName;
    private User user;
    private Region region;
    private final String loginMessage = "1. Login:\n" + "2. Exit";

    public Login() {
        System.out.println(loginMessage);
        int userId = 0;
        if (sc.nextLine().equals("1")) {
            System.out.println("Enter your firstname: ");
            name = sc.nextLine();
            System.out.println("Enter your lastname: ");
            surname = sc.nextLine();
            System.out.println("Enter your region: ");
            regionName = sc.nextLine();
            region = new Region(regionName);
            HibernateUtil.setSession();
            RegionController regionController = new RegionController();
            user = new User(name, surname, regionController.saveRegion(region));
            UserController userController = new UserController();
            userId = userController.saveUser(user).getId();
            new Menu().runMenu(userId);

        } else {
            System.out.println("Good by!");
        }
    }
}
