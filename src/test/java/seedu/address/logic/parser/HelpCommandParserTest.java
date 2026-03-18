package seedu.address.logic.parser;

import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.HelpCommand;

public class HelpCommandParserTest {

    private HelpCommandParser parser = new HelpCommandParser();

    @Test
    public void parse_emptyArg_returnsHelpCommandNoArg() {
        assertParseSuccess(parser, "     ", new HelpCommand());
    }

    @Test
    public void parse_validCommandWord_returnsHelpCommandWithArg() {
        assertParseSuccess(parser, AddCommand.COMMAND_WORD, new HelpCommand(AddCommand.COMMAND_WORD));
    }

    @Test
    public void parse_validCommandWordWithWhitespace_returnsHelpCommandWithArg() {
        assertParseSuccess(parser, "  add  ", new HelpCommand(AddCommand.COMMAND_WORD));
    }

    @Test
    public void parse_unknownCommandWord_returnsHelpCommandWithArg() {
        assertParseSuccess(parser, "unknownCommand", new HelpCommand("unknownCommand"));
    }

}
