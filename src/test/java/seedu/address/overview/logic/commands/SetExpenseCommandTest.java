package seedu.address.overview.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.overview.ui.OverviewMessages.MESSAGE_AMOUNT_TOO_LARGE;
import static seedu.address.overview.ui.OverviewMessages.MESSAGE_INVALID_SET_AMOUNT;
import static seedu.address.overview.ui.OverviewMessages.MESSAGE_SET_EXPENSE_SUCCESS;

import java.text.DecimalFormat;

import org.junit.jupiter.api.Test;

import seedu.address.overview.logic.commands.exception.InvalidValueException;
import seedu.address.overview.model.Model;
import seedu.address.overview.model.ModelManager;
import seedu.address.testutil.TypicalOverview;

public class SetExpenseCommandTest {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");

    private Model blankOverviewModel = new ModelManager(TypicalOverview.BLANK_OVERVIEW_MODEL);

    @Test
    public void setExpenseCommand_correctInput_success() {
        SetExpenseCommand command = new SetExpenseCommand(500);
        assertTrue(command.amount == 500.0);

        try {
            assertEquals(new CommandResult(String.format(MESSAGE_SET_EXPENSE_SUCCESS,
                    DECIMAL_FORMAT.format(500.00))),
                    command.execute(blankOverviewModel));
        } catch (InvalidValueException e) {
            throw new AssertionError("This should not happen");
        }
    }

    @Test
    public void setExpenseCommand_belowRange_throwsInvalidValueException() {
        SetExpenseCommand command = new SetExpenseCommand(-20);
        try {
            command.execute(blankOverviewModel);
            throw new AssertionError("You should not be here.");
        } catch (InvalidValueException e) {
            assertEquals(new InvalidValueException(MESSAGE_INVALID_SET_AMOUNT).getMessage(), e.getMessage());
        }
    }

    @Test
    public void setExpenseCommand_aboveRange_throwsInvalidValueException() {
        SetExpenseCommand command = new SetExpenseCommand(100000000);
        try {
            command.execute(blankOverviewModel);
            throw new AssertionError("You should not be here.");
        } catch (InvalidValueException e) {
            assertEquals(new InvalidValueException(MESSAGE_AMOUNT_TOO_LARGE).getMessage(), e.getMessage());
        }
    }

    @Test
    public void testIfEqual_equalAmount_true() {
        SetExpenseCommand command1 = new SetExpenseCommand(500);
        SetExpenseCommand command2 = new SetExpenseCommand(500);
        assertEquals(command1, command2);
    }

    @Test
    public void testIfEqual_diffAmount_false() {
        SetExpenseCommand command1 = new SetExpenseCommand(500);
        SetExpenseCommand command2 = new SetExpenseCommand(700);
        assertNotEquals(command1, command2);
    }
}
