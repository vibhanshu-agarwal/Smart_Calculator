package calculator;

import java.util.List;

public class CommandValidator implements Validator {
    //Make this class a singleton
    private static CommandValidator instance;

    private String input;
    private final List<String> validCommands = List.of("/help",
            "/exit");

    private CommandValidator() {

    }

    public static CommandValidator getInstance() {
        if (instance == null) {
            instance = new CommandValidator();
        }
        return instance;
    }

    private boolean isValid() {
        //If the input is a command type but an invalid command,
        // print "Unknown command" and continue
        return !input.startsWith("/") || validCommands.contains(input);
    }

    @Override
    public boolean validate(String input) {
        this.input = input;
        return isValid();
    }
}
