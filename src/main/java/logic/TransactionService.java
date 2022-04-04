package logic;

import pojo.Account;
import pojo.Transaction;
import repository.AccountsRepository;
import repository.TransactionsRepository;

import java.sql.SQLException;

public class TransactionService {
    TransactionsRepository transactionsRepository = new TransactionsRepository();

    public Transaction rechargeTheBalance(Account account, double amount) throws SQLException {
        double newBalance = account.getBalance() + amount;
        AccountsRepository accountsRepository = new AccountsRepository();
        if (checkOfBalance(newBalance)) {
            accountsRepository.updateAccount(account, newBalance);
        }
        if (!checkOfBalance(newBalance)) {
            throw new IllegalArgumentException("\"[ERROR]  Баланс не может быть отрицательным, баланс не может превышать 2’000’000’000\"" +
                    "Транзакция не будет выполнена");
        }
        transactionsRepository.insertTransaction(account, amount);
        return transactionsRepository.selectTransaction(account);
    }

    public Transaction withdrawСash(Account account, double amount) throws SQLException {
        double newBalance = account.getBalance() - amount;
        AccountsRepository accountsRepository = new AccountsRepository();
        if (checkOfBalance(newBalance)) {
            accountsRepository.updateAccount(account, newBalance);
        }
        if (!checkOfBalance(newBalance)) {
            throw new IllegalArgumentException("\"[ERROR]  Баланс не может быть отрицательным, баланс не может превышать 2’000’000’000\"" +
                    "Транзакция не будет выполнена");
        }
        transactionsRepository.insertTransaction(account, amount*(-1));
        return transactionsRepository.selectTransaction(account);
    }

    private boolean checkOfBalance(double balance) {
        if (balance < 0 && balance > 2000000000) {
            System.out.println("[ERROR] Вы ввели недопустимое значение. Баланс не может быть отрицательным, баланс не может превышать 2’000’000’000");
            return false;
        }
        return true;
    }

}
