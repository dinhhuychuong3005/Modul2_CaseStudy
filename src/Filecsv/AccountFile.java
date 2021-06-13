package Filecsv;

import model.account.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccountFile implements WriteReadFile<Account> {
    @Override
    public void writeToFile(String path, List<Account> list) throws IOException {
        FileWriter fw = new FileWriter(path);
        BufferedWriter bf = new BufferedWriter(fw);
        String str = "Username,Password,email\n";
        for (Account e : list) {
            str += e.getUserName() + "," + e.getPassword() + "," + e.getEmail() + "\n";
        }
        bf.write(str);
        bf.close();
        fw.close();
    }

    @Override
    public List<Account> readFromFile(String path) throws IOException {
        List<Account> accounts = new ArrayList<>();
        FileReader fr = new FileReader(path);
        BufferedReader bf = new BufferedReader(fr);
        String line = bf.readLine();
        while ((line = bf.readLine()) != null) {
            String[] value = line.split(",");
            accounts.add(new Account(value[0], value[1], value[2]));
        }
        return accounts;
    }
}
