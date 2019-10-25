package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;

import seedu.address.reimbursement.model.Reimbursement;

public class TypicalReimbursements {
    public static final Reimbursement ALICE_REIMBURSEMENT_20
            = new ReimbursementBuilder(TypicalTransactions.ALICE_TRANSACTION_10)
            .withDeadline("02-Dec-2019")
            .build();
    public static final Reimbursement ALICE_REIMBURSEMENT_30
            = new ReimbursementBuilder(TypicalTransactions.ALICE_TRANSACTION_12)
            .withDeadline("01-Nov-2019")
            .build();
    public static final Reimbursement ELLE_REIMBURSEMENT_100
            = new ReimbursementBuilder(TypicalTransactions.ELLE_TRANSACTION_11)
            .build();

    private TypicalReimbursements() {
    } // prevents instantiation

    public static ArrayList<Reimbursement> getTypicalReimbursements() {
        return new ArrayList<>(Arrays.asList(ALICE_REIMBURSEMENT_20, ALICE_REIMBURSEMENT_30, ELLE_REIMBURSEMENT_100));
    }

}
