package repository;

import connector.Connect;
import pojo.Account;
import pojo.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionsRepository {
    private Connect connector = new Connect();
    public final static String INSERT_TRANSACTION = "INSERT INTO Transactions (accountId,amount) VALUES(?,?)";
    public final static String SELECT_TRANSACTION = "SELECT transactionId, accountId, amount FROM Transactions "
            + "where accountId = ?";

    public void insertTransaction(Account account, double amount) throws SQLException {
        Connection conn = connector.connect();
        try {
            PreparedStatement pstmt = conn.prepareStatement(INSERT_TRANSACTION);
            pstmt.setInt(1, account.getAccountId());
            pstmt.setInt(2, (int)(amount*1000));
            pstmt.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            conn.close();
        }
    }

    public Transaction selectTransaction(Account account) throws SQLException {
        Connection conn = connector.connect();
        try (PreparedStatement pstmt = conn.prepareStatement(SELECT_TRANSACTION)) {
            pstmt.setInt(1, account.getAccountId());
            ResultSet result = pstmt.executeQuery();
            Transaction transaction = new Transaction();
            while (result.next()) {
                transaction.setTransactionId(result.getInt("transactionId"));
                transaction.setAccountId(result.getInt("accountId"));
                transaction.setAmount(result.getInt("amount")/1000);
                return transaction;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            conn.close();
        }
        return null;
    }
}
