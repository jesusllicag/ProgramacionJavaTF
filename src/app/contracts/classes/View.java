package app.contracts.classes;

import java.util.Scanner;

public abstract class View {
    protected Scanner scanner = new Scanner(System.in);

    public void println(String message) {
        System.out.println(message);
    }
}
