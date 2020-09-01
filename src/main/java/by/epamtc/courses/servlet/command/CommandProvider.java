package by.epamtc.courses.servlet.command;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {

    private Map<CommandName, Command> commands = new HashMap<>();

    public CommandProvider() {
        commands.put(CommandName.LOGIN, new LoginCommand());
        commands.put(CommandName.REGISTRATION, new RegistrationCommand());
        commands.put(CommandName.LOG_OUT, new LogoutCommand());
        commands.put(CommandName.PROFILE, new ProfileCommand());
    }

    public Command getCommand(String command) {
        String commandNameUpper = command.toUpperCase();
        CommandName commandName = CommandName.valueOf(commandNameUpper);
        return commands.get(commandName);
    }
}
