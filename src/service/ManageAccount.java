package service;

import Filecsv.AccountFile;
import model.account.Account;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageAccount {
    private final Scanner scanner = new Scanner(System.in);
    private List<Account> accounts;
    AccountFile accountFile = new AccountFile();

    public ManageAccount() {
        try {
            this.accounts = accountFile.readFromFile("account.csv");
        } catch (IOException e) {
            this.accounts = new ArrayList<>();
        }
    }

    public ManageAccount(List<Account> accounts) {
        this.accounts = new ArrayList<>();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void add(Account account) {
        accounts.add(account);
    }

    public void findPassword(String userName, String email) {
        for (int i = 0; i < accounts.size(); i++) {
            if ((userName.equals(accounts.get(i).getUserName())) && (accounts.get(i).getEmail().equals(email))) {
                System.out.println("Thông tin tài khoản cần tìm là : " + accounts.get(i));
            }
        }
    }

    public int checkUserName(String userName) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUserName().equals(userName)) {
                return i;
            }
        }
        return -1;
    }

    public int checkPassword(String password) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getPassword().equals(password)) {
                return i;
            }
        }
        return -1;
    }

}
