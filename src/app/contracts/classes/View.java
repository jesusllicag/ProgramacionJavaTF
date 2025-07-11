package app.contracts.classes;

import java.util.Scanner;

public abstract class View {

    protected Scanner scanner = new Scanner(System.in);

    public void println(String message) {
        System.out.println(message);
    }

    public String readInput(String message) {
        System.out.printf(message);
        return this.scanner.nextLine().trim();
    }

    public String readIgnoreEnterInput(String message, String defaultValue) {
        System.out.println(message + defaultValue);
        String input = this.scanner.nextLine().trim();
        return input.isEmpty() ? defaultValue : input;
    }

    protected String[] readSearchInputOptions(String successCases, String exitCase) {
        String[] form = new String[2];
        String input = this.readInput("Elegir una opción: ");
        if (successCases.contains(input)) {
            form[0] = input;
            form[1] = this.readInput("Ingrese patron de búsqueda:");
            return form;
        } else if (exitCase.equals(input)) {
            form[0] = input;
            return form;
        } else {
            throw new NullPointerException();
        }
    }
}
