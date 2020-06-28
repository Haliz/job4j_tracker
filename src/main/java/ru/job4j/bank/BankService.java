package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!equals(user)) {
            users.put(user, new ArrayList<Account>());
        }
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
                users.put(user, accounts);
            }
        }
    }

    public User findByPassport(String passport) {
        User foundUser = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                foundUser = user;
                break;
            }
        }
        return foundUser;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        List<Account> accounts = users.get(user);
        Account rsl = null;
        for (Account account : accounts) {
            if (account.getRequisite().equals(requisite)) {
                rsl = account;
                break;
            }
        }
        return rsl;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = true;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        boolean noMoney = amount > srcAccount.getBalance();
        if (srcAccount == null || destAccount == null || noMoney) {
            rsl = false;
        } else {
            List<Account> srcAccounts = users.get(findByPassport(srcPassport));
            List<Account> destAccounts = users.get(findByPassport(destPassport));
            int srcIndex = srcAccounts.indexOf(srcAccount);
            int destIndex = destAccounts.indexOf(destAccount);
            Account newSrcAccount = new Account(srcAccount.getRequisite(), srcAccount.getBalance() - amount);
            Account newDestAccount = new Account(destAccount.getRequisite(), destAccount.getBalance() + amount);
            srcAccounts.set(srcIndex, newSrcAccount);
            destAccounts.set(destIndex, newDestAccount);
        }
        return rsl;
    }
}
