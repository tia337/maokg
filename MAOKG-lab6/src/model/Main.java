package model;


import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            Dog window = new Dog();

            window.setVisible(true);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
