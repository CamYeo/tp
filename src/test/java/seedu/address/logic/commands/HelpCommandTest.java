package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.HelpCommand.MESSAGE_UNKNOWN_COMMAND;
import static seedu.address.logic.commands.HelpCommand.SHOWING_HELP_MESSAGE;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;

public class HelpCommandTest {
    private Model model = new ModelManager();
    private Model expectedModel = new ModelManager();

    @Test
    public void execute_help_success() {
        CommandResult expectedCommandResult = new CommandResult(SHOWING_HELP_MESSAGE, true, false);
        assertCommandSuccess(new HelpCommand(), model, expectedCommandResult, expectedModel);
    }

    @Test
    public void execute_helpAdd_showsAddUsage() {
        CommandResult expectedCommandResult = new CommandResult(AddCommand.MESSAGE_USAGE);
        assertCommandSuccess(new HelpCommand(AddCommand.COMMAND_WORD), model, expectedCommandResult, expectedModel);
    }

    @Test
    public void execute_helpEdit_showsEditUsage() {
        CommandResult expectedCommandResult = new CommandResult(EditCommand.MESSAGE_USAGE);
        assertCommandSuccess(new HelpCommand(EditCommand.COMMAND_WORD), model, expectedCommandResult, expectedModel);
    }

    @Test
    public void execute_helpDelete_showsDeleteUsage() {
        CommandResult expectedCommandResult = new CommandResult(DeleteCommand.MESSAGE_USAGE);
        assertCommandSuccess(new HelpCommand(DeleteCommand.COMMAND_WORD), model, expectedCommandResult, expectedModel);
    }

    @Test
    public void execute_helpFind_showsFindUsage() {
        CommandResult expectedCommandResult = new CommandResult(FindCommand.MESSAGE_USAGE);
        assertCommandSuccess(new HelpCommand(FindCommand.COMMAND_WORD), model, expectedCommandResult, expectedModel);
    }

    @Test
    public void execute_helpClear_showsClearUsage() {
        CommandResult expectedCommandResult = new CommandResult(ClearCommand.MESSAGE_USAGE);
        assertCommandSuccess(new HelpCommand(ClearCommand.COMMAND_WORD), model, expectedCommandResult, expectedModel);
    }

    @Test
    public void execute_helpList_showsListUsage() {
        CommandResult expectedCommandResult = new CommandResult(ListCommand.MESSAGE_USAGE);
        assertCommandSuccess(new HelpCommand(ListCommand.COMMAND_WORD), model, expectedCommandResult, expectedModel);
    }

    @Test
    public void execute_helpExit_showsExitUsage() {
        CommandResult expectedCommandResult = new CommandResult(ExitCommand.MESSAGE_USAGE);
        assertCommandSuccess(new HelpCommand(ExitCommand.COMMAND_WORD), model, expectedCommandResult, expectedModel);
    }

    @Test
    public void execute_helpHelp_showsHelpUsage() {
        CommandResult expectedCommandResult = new CommandResult(HelpCommand.MESSAGE_USAGE);
        assertCommandSuccess(new HelpCommand(HelpCommand.COMMAND_WORD), model, expectedCommandResult, expectedModel);
    }

    @Test
    public void execute_helpUnknownCommand_showsUnknownCommandMessage() {
        String unknownCommand = "unknownCommand";
        CommandResult expectedCommandResult =
                new CommandResult(String.format(MESSAGE_UNKNOWN_COMMAND, unknownCommand));
        assertCommandSuccess(new HelpCommand(unknownCommand), model, expectedCommandResult, expectedModel);
    }
}
