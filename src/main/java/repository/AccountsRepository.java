package repository;

import connector.Connect;
import pojo.Account;

import pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountsRepository {


    public final static String INSERT_ACCOUNT = "INSERT INTO Accounts(userId,balance,currency) VALUES(?,?,?);";
    public final static String SELECT_ACCOUNT = "SELECT accountId, userId, balance, currency from accounts where userId = ?";
    public final static String SELECT_ACCOUNT_WITH_CURRENCY = "SELECT accountId, userId, balance, currency from accounts where userId = ? and currency = ?";
    public final static String UPDATE_ACCOUNT = "UPDATE Accounts SET balance = ? WHERE accountId = ?";


    private Connect connector = new Connect();

    public void insertAccount(Account account) throws SQLException {
        Connection conn = connector.connect();
        try {
            PreparedStatement pstmt = conn.prepareStatement(INSERT_ACCOUNT);
            pstmt.setInt(1, account.getUserId());
            pstmt.setInt(2, (int)(account.getBalance()*1000));
            pstmt.setString(3, account.getCurrency());
            pstmt.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            conn.close();
        }
    }

    public List<Account> selectAccounts(User user) throws SQLException {
        List<Account> accounts = new ArrayList<>();
        Connection conn = connector.connect();
        try (PreparedStatement pstmt = conn.prepareStatement(SELECT_ACCOUNT)) {
            pstmt.setInt(1, user.getId());
            ResultSet result = pstmt.executeQuery();

            while (result.next()) {
                Account account = new Account();
                account.setAccountId(result.getInt("accountId"));
                account.setUserId(result.getInt("userId"));
                account.setBalance(result.getInt("balance")/1000);
                account.setCurrency(result.getString("currency"));
                accounts.add(account);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            conn.close();
        }
        return accounts;
    }

    public Account selectAccount(User user, String currency) throws SQLException {

        Connection conn = connector.connect();
        try (PreparedStatement pstmt = conn.prepareStatement(SELECT_ACCOUNT_WITH_CURRENCY)) {
            pstmt.setInt(1, user.getId());
            pstmt.setString(2, currency);
            ResultSet result = pstmt.executeQuery();

            while (result.next()) {
                Account account = new Account();
                account.setAccountId(result.getInt("accountId"));
                account.setUserId(result.getInt("userId"));
                account.setBalance(result.getInt("balance")/1000);
                account.setCurrency(result.getString("currency"));
                return account;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            conn.close();
        }
        return null;
    }


    public void updateAccount(Account account, double balance) throws SQLException {
        Connection conn = connector.connect();
    try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_ACCOUNT)) {

        pstmt.setInt(1, (int)(balance*1000));
        pstmt.setInt(2, account.getAccountId());
        pstmt.executeUpdate();
        }
     catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}
}

