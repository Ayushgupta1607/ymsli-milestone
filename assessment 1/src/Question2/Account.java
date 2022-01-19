package Question2;



public class Account {
private Owner owner;
private float balance;
private String number;

public Account() {}

public Account(Owner owner, float balance, String number) {
this.owner = owner;
this.balance = balance;
this.number = number;
}

public Account(Account account) {
this.owner = account.owner;
this.balance = account.balance;
this.number = account.number;
}



@Override
public String toString() {
StringBuilder builder = new StringBuilder();
builder.append("Account [owner=").append(owner).append(", balance=").append(balance).append(", number=")
.append(number).append("]");
return builder.toString();
}

public void deposit(float amt) {
this.balance += amt;
}

public void withdraw(float amt) {
this.balance -= amt;
}



public float getBalance() {
float bal = balance;
return bal;
}


}
