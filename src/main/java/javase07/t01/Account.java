package javase07.t01;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@SuppressWarnings("unused")
@Getter
@EqualsAndHashCode
public class Account {
    private Double money;
    private Long number;

    @SuppressWarnings("WeakerAccess")
    public Account(Long number, Double money){
        this.number = number;
        this.money = money;
    }

    @SuppressWarnings("WeakerAccess")
    public Account(Long number){
        this(number, 1000.00);
    }

    @SuppressWarnings("UnusedReturnValue")
    public Account put(Double money){
        this.money += money;
        return this;
    }

    @SuppressWarnings("UnusedReturnValue")
    public synchronized Account withdraw(Double money){
        this.money -= money;
        return this;
    }

    public synchronized Account withdrawToAnotherAccount(Double money, Account anotherAccount){
        this.withdraw(money);
        anotherAccount.put(money);
        return this;
    }
}
