package service;

import model.account.Account;

import java.util.ArrayList;
import java.util.List;

public class ManageAccount {
    private List<Account> accounts ;

    public ManageAccount() {
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
    public void add(Account account){
        accounts.add(account);
    }
    public void findPassword(String userName,String email){
        for (int i = 0; i < accounts.size(); i++) {
            if ((userName.equals(accounts.get(i).getUserName())) && (accounts.get(i).getEmail().equals(email))){
                System.out.println("Thông tin tài khoản cần tìm là : " + accounts.get(i));
            }
        }
    }
    public void login(){
        System.out.println("");
    }
}
