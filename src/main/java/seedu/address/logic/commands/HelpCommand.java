package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.Map;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.Model;

/**
 * Format full help instructions for every command for display.
 */
public class HelpCommand extends Command {

    public static final String COMMAND_WORD = "help";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Shows program usage instructions.\n"
            + "Parameters: [COMMAND_WORD]\n"
            + "Example: " + COMMAND_WORD + "\n"
            + "Example: " + COMMAND_WORD + " add";

    public static final String SHOWING_HELP_MESSAGE = "Opened help window.";

    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command: %1$s\n" + MESSAGE_USAGE;

    private static final Map<String, String> COMMAND_USAGES = Map.ofEntries(
            Map.entry(AddCommand.COMMAND_WORD, AddCommand.MESSAGE_USAGE),
            Map.entry(EditCommand.COMMAND_WORD, EditCommand.MESSAGE_USAGE),
            Map.entry(DeleteCommand.COMMAND_WORD, DeleteCommand.MESSAGE_USAGE),
            Map.entry(FindCommand.COMMAND_WORD, FindCommand.MESSAGE_USAGE),
            Map.entry(ClearCommand.COMMAND_WORD, ClearCommand.MESSAGE_USAGE),
            Map.entry(ListCommand.COMMAND_WORD, ListCommand.MESSAGE_USAGE),
            Map.entry(ExitCommand.COMMAND_WORD, ExitCommand.MESSAGE_USAGE),
            Map.entry(COMMAND_WORD, MESSAGE_USAGE)
    );

    private final String commandToHelp;

    /**
     * Creates a HelpCommand that opens the help window.
     */
    public HelpCommand() {
        this.commandToHelp = "";
    }

    /**
     * Creates a HelpCommand that shows the usage for the specified {@code commandToHelp}.
     */
    public HelpCommand(String commandToHelp) {
        requireNonNull(commandToHelp);
        this.commandToHelp = commandToHelp;
    }

    @Override
    public CommandResult execute(Model model) {
        if (commandToHelp.isEmpty()) {
            return new CommandResult(SHOWING_HELP_MESSAGE, true, false);
        }
        if (COMMAND_USAGES.containsKey(commandToHelp)) {
            return new CommandResult(COMMAND_USAGES.get(commandToHelp));
        }
        return new CommandResult(String.format(MESSAGE_UNKNOWN_COMMAND, commandToHelp));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof HelpCommand)) {
            return false;
        }

        HelpCommand otherHelpCommand = (HelpCommand) other;
        return commandToHelp.equals(otherHelpCommand.commandToHelp);
    }

    @Override
    public int hashCode() {
        return commandToHelp.hashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("commandToHelp", commandToHelp)
                .toString();
    }
}
