package app.contracts.classes;

public abstract class Validator {

    protected String validate(boolean[] rules, String[] messages) {
        for (int i = 0; i < messages.length; i++) {
            if (!rules[i]) {
                return messages[i];
            }
        }
        return "OK";
    }

}
