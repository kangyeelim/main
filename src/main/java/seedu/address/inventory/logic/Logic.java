package seedu.address.inventory.logic;

import seedu.address.transaction.util.TransactionList;

public interface Logic {

    CommandResult execute(String commandText) throws Exception;

    TransactionList getInventoryList() throws Exception;
}