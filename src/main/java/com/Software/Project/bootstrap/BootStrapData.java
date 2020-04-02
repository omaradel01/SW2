package com.Software.Project.bootstrap;

import com.Software.Project.Domain.User;
import com.Software.Project.Repoistory.IUserRepoistory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.Scanner;

@Component
public class BootStrapData implements CommandLineRunner {
    private final IUserRepoistory userRepoistory;

    public BootStrapData(IUserRepoistory userRepoistory) {
        this.userRepoistory = userRepoistory;
    }

    public void load_users() throws IOException {
        RandomAccessFile file = new RandomAccessFile("users.txt","r");
        while(file.getFilePointer() < file.length()){
            User user = new User();
            user.setUsername(file.readLine());
            user.setPassword(file.readLine());
            userRepoistory.save(user);
        }
        file.close();
    }

    public void save_users() throws IOException{
        RandomAccessFile file = new RandomAccessFile("users.txt","rw");
        file.setLength(0);
        List<User> all_users = userRepoistory.findAll();
        for(User user : all_users){
            file.writeBytes(user.getUsername());
            file.writeBytes(System.getProperty("line.separator"));
            file.writeBytes(user.getPassword());
            file.writeBytes(System.getProperty("line.separator"));
        }
        file.close();
    }

    @Override
    public void run(String... args) throws Exception {
        load_users();
        System.out.println("press 0 button to close when you have finished\n");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n != 0){
            n = scanner.nextInt();
        }
        save_users();
        System.exit(0);

        /*
        while(true){
            System.out.println("1- log in\n2-sign up\n0- exit");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            String User_name;
            String Pass;
            List<User> all_users;
            switch (choice){
                case 1:
                    scanner.nextLine();
                    System.out.print("Enter username: ");
                    User_name = scanner.nextLine();
                    System.out.print("Enter password: ");
                    Pass = scanner.nextLine();

                    all_users = userRepoistory.findAll();
                    boolean Found = false;
                    for(User tempUser : all_users){
                        if(tempUser.getUsername().equals(User_name) && tempUser.getPassword().equals(Pass)){
                            Found = true;
                            break;
                        }
                    }
                    if(Found){
                        System.out.println("Log in done successfully!");
                        scanner.nextLine();
                        System.out.println("Enter 0 to log out");
                        int temp = scanner.nextInt();
                        while (temp != 0){
                            temp = scanner.nextInt();
                        }
                    }
                    else{
                        System.out.println("Wrong username or password!");
                    }
                    break;

                case 2:
                    scanner.nextLine();
                    System.out.print("Enter username: ");
                    User_name = scanner.nextLine();
                    System.out.print("Enter password: ");
                    Pass = scanner.nextLine();
                    System.out.print("Confirm password: ");
                    String confirm_pass = scanner.nextLine();

                    all_users = userRepoistory.findAll();

                    boolean found = false;
                    for(User tempUser : all_users){
                        if(tempUser.getUsername().equals(User_name)){
                            found = true;
                            break;
                        }
                    }
                    while(found){
                        System.out.println("The username you entered was taken before, Please try another one!");
                        System.out.print("Enter username: ");
                        User_name = scanner.nextLine();
                        found = false;
                        for(User tempUser : all_users){
                            if(tempUser.getUsername().equals(User_name)){
                                found = true;
                                break;
                            }
                        }
                    }
                    while(!Pass.equals(confirm_pass)){
                        System.out.println("password does not match, try again\n");
                        System.out.print("Confirm password: ");
                        confirm_pass = scanner.nextLine();
                    }
                    User user = new User();
                    user.setUsername(User_name);
                    user.setPassword(Pass);
                    userRepoistory.save(user);
                    System.out.println("new user is added!");
                    save_user(user);
                    break;

                case 0:
                    System.exit(0);
            }
        }
        */
    }
}
