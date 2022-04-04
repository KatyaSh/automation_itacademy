import logic.AccountService;
import logic.TransactionService;
import logic.UserService;
import pojo.Account;
import pojo.Transaction;
import pojo.User;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Locale;

public class Running {
    public static void main(String[] args) throws SQLException {
        System.out.println("**************************************************");
        User user = startFlow();
        System.out.println("ID пользователя " + user.getId());
        Account account = selectAccount(user);
        System.out.println("Валюта аккаунта " + account.getCurrency());
        Transaction transaction = selectTransaction(account);

    }

    static User startFlow() throws SQLException {
        boolean flag = true;
        User user = new User();
        UserService userService = new UserService();
        while (flag) {
            try {
                System.out.println("Выберите действие: 1 или 2 \n" +
                        "1 - Регистрация пользователя \n" +
                        "2 - Логин\n");
                String start = new Scanner(System.in).next();
                if (start.equals("1")) {
                    user.setName(setUserName());
                    user.setAddress(setUserAddress());
                    user = userService.createUser(user);
                    System.out.println("Поздравляю!! Новый пользователь создан");
                } else if (start.equals("2")) {
                    String userName = setUserName();
                    user = userService.getUserDataByName(userName);
                    System.out.println("Логин успешен!");
                } else {
                    System.out.println("[ERROR] Вы ввели недопустимое значение. Попробуйте снова");
                    continue;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            flag = false;
        }
        return user;
    }

    static Account selectAccount(User user) throws SQLException {
        boolean flag = true;
        Account account = new Account();
        AccountService accountService = new AccountService();
        while (flag) {
            try {
                System.out.println("Выберите действие: 1 или 2 \n" +
                        "1 - Добавить новый аккаунт \n" +
                        "2 - Выбрать существующий аккаунт\n");
                String start = new Scanner(System.in).next();
                if (start.equals("1")) {
                    System.out.println("Аккаунты существуют со следующими валютами: "+ accountService.getAccountsByUserID(user));
                    String currency = setAccountCurrency();
                    account = accountService.createAccount(user, currency);
                    System.out.println("Поздравляю!! Новый aккаунт с валютой " + currency + " создан");
                } else if (start.equals("2")) {
                    System.out.println("Аккаунты существуют со следующими валютами: "+ accountService.getAccountsByUserID(user));
                    String currency = setAccountCurrency();
                    account = accountService.getAccountByCurrency(user, currency);
                    System.out.println("Аккаунт с валютой " + currency + " выбран");
                } else {
                    System.out.println("[ERROR] Вы ввели недопустимое значение. Попробуйте снова");
                    continue;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            flag = false;
        }
        return account;
    }

    static Transaction selectTransaction(Account account) throws SQLException {
        boolean flag = true;
        Transaction transaction = new Transaction();
        TransactionService transactionService = new TransactionService();
        while (flag) {
            try {
                System.out.println("Выберите действие: 1 или 2 \n" +
                        "1 - Пополнить баланс \n" +
                        "2 - Снять наличные\n");
                String start = new Scanner(System.in).next();
                if (start.equals("1")) {
                    double amount = setTransactionAmount();
                    transaction = transactionService.rechargeTheBalance(account, amount);
                    System.out.println("Успешно!! Баланс пополнен на сумму " + amount);

                } else if (start.equals("2")) {
                    double amount = setTransactionAmount();
                    transaction = transactionService.withdrawСash(account, amount);
                    System.out.println("Успешно!! Получите сумму " + amount);
                } else {
                    System.out.println("[ERROR] Вы ввели недопустимое значение. Попробуйте снова");
                    continue;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            flag = false;
        }
        return transaction;
    }


    static String setUserName() {
        System.out.println("Введите Имя пользователя. Имя пользовател должно быть уникальным:");
        return new Scanner(System.in).next();
    }

    static String setUserAddress() {
        System.out.println("Введите адрес пользователя:");
        return new Scanner(System.in).next();
    }

    static String setAccountCurrency() {
        String input = null;
        boolean flag = true;
        while (flag) {
            System.out.println("Выберите валюту аккаунта: USD, EUR, BYN");
            input = new Scanner(System.in).next();
            if (checkValidCurrencyInput(input)) {
                System.out.println("[ERROR] Вы ввели недопустимое значение. Попробуйте снова");
                continue;
            }
            flag = false;
        }
        return input;
    }

    static boolean checkValidCurrencyInput(String currency) {
        if (currency.equalsIgnoreCase("USD") || currency.equalsIgnoreCase("EUR") || currency.equalsIgnoreCase("BYN")) {
            return false;
        }
        return true;
    }

    static double setTransactionAmount() {
        double amount = 0.0;
        boolean flag = true;
        while (flag) {
            System.out.println("Введите сумму транзакции:");
            amount = new Scanner(System.in).useLocale(Locale.US).nextDouble();
            if (amount < 0.0 && amount > 100000000.0) {
                System.out.println("[ERROR] Вы ввели недопустимое значение. Сумма транзакции не может быть отрицательной, и не может превышать 100’000’000");
                continue;
            }
            flag = false;
        }
        return round(amount);
    }

    static double round(double value) {
        BigDecimal roundValue = new BigDecimal(Double.toString(value));
        roundValue = roundValue.setScale(3, RoundingMode.HALF_EVEN);
        return roundValue.doubleValue();
    }

}

