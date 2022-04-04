package logic;

import pojo.Account;
import pojo.User;
import repository.AccountsRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountService {
    AccountsRepository accountsRepository = new AccountsRepository();


    public Account createAccount(User user, String currency) throws SQLException {
        Account account = new Account();
        List<Account> accounts = accountsRepository.selectAccounts(user);
        if (accounts.isEmpty() || checkOfExistingCurrency(accounts, currency)) {
            account.setUserId(user.getId());
            account.setCurrency(currency);
            account.setBalance(0);
            accountsRepository.insertAccount(account);
        }
        if(!checkOfExistingCurrency(accounts, currency)){
        throw new IllegalArgumentException("Аккаует с такой валютой уже существует");
        }
        return accountsRepository.selectAccount(user, currency);
    }

    public Account getAccountByCurrency(User user, String currency) throws SQLException {
        Account existingAccount = accountsRepository.selectAccount(user, currency);
        if(existingAccount == null){
            throw new IllegalArgumentException("Аккаунта с такой валютой не существует. Добавьте новый аккаунт.");
        }
        return existingAccount;
    }

    public ArrayList getAccountsByUserID(User user) throws SQLException {
        Account account = new Account();
        List<Account> accounts = accountsRepository.selectAccounts(user);
        ArrayList existingCurrencies = new ArrayList<>();
        for (Account item : accounts) {
            String currency = item.getCurrency();
            existingCurrencies.add(currency);
        }
        return existingCurrencies;
    }


    private boolean checkOfExistingCurrency(List<Account> userAccounts, String currency) {
        for (Account item : userAccounts) {
            if (item.getCurrency().equals(currency)) {
                return false;
            }
        }
        return true;
    }
}
