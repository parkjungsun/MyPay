package org.mypay.banking.adapter.out.external.bank;

import lombok.Data;

@Data
public class BankAccount {
    private String bankname;
    private String bankAccountNumber;
    private boolean isValid;

    public BankAccount(String bankname, String bankAccountNumber, boolean isValid) {
        this.bankname = bankname;
        this.bankAccountNumber = bankAccountNumber;
        this.isValid = isValid;
    }
}
