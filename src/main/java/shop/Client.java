package shop;

import java.util.Scanner;

public class Client {
    private String name;
    private String surname;
    private int age;
    private String phone;
    private String email;

    public Client() {
    }

    public Client(String name, String surname, int age, String phone, String email) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    public Client completionClientScanner(Scanner scanner) {
        scanner.nextLine();
        this.name = inputScsnner(scanner, "имя");
        this.surname = inputScsnner(scanner, "фамилию");
        this.age = Integer.parseInt(inputScsnner(scanner, "возраст"));
        this.phone = inputScsnner(scanner, "телефон");
        this.email = inputScsnner(scanner, "электронную почту");
        return new Client(this.name, this.surname, this.age, this.phone, this.email);
    }

    public String inputScsnner(Scanner scanner, String s) {
        System.out.printf("Введите %s:\n", s);
        //scanner.nextLine();
        return scanner.nextLine();
    }

    @Override
    public String toString() {
        return name + " " + surname + " (" + age + "," + phone + "," + email + ")";
    }
}
