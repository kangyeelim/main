package seedu.address.transaction.logic.commands;

/**
 * Represents a sort command with hidden internal logic and the ability to be executed.
 * It is also a {@code Command} and inherits from it.
 */
public abstract class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    @Override
    public String toString() {
        return COMMAND_WORD;
    }

}
