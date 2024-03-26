package de.telran.practice_lesson_3.pract;

public abstract class ClientAccount extends Account{
    protected String accountOwner;


    public String getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(String accountOwner) {
        if(accountOwner !=null && accountOwner.length()>0) {
            this.accountOwner = accountOwner;
        }
        else {
            System.out.println("Incorrect owner, try again.");
        }
    }
}

//    Счет клиента (ClientAccount)
//Характеристика: владелец
//        Поведение: Установить Владельца, Получить владельца.
