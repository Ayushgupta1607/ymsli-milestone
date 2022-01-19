
package Question2;

public class SavingsAccount extends Account{
private float interestRate;



public SavingsAccount() {}

public SavingsAccount(float interestRate) {
super();
this.interestRate = interestRate;
}



@Override
public String toString() {
StringBuilder builder = new StringBuilder();
builder.append("SavingsAccount [interestRate=").append(interestRate).append("]");
return builder.toString();
}

public float getInterest() {
float interest = getBalance()*interestRate;
return interest;
}

}