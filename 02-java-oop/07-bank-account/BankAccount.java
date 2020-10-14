import java.lang.Math;
public class BankAccount{

    String acctNumber; //account number
    double chkgBalance = 0; //checking balance
    double svgsBalance = 0; //savings balance
    double amount =0;

    private static int numOfAccounts = 0;
    private static double amtTotal = 0.0;

    public BankAccount(){
        // In the constructor, call the private method so that each user has a random ten digit account.
        this.acctNumber = String.valueOf(randomNum());
        //In the constructor, be sure to increment the account count.
        numOfAccounts++;
    }

    public BankAccount(String acctNumber, double chkgBalance, double svgsBalance){
        // In the constructor, call the private method so that each user has a random ten digit account.
        this.acctNumber = String.valueOf(randomNum());
        this.chkgBalance = chkgBalance;
        this.svgsBalance = svgsBalance;
        //In the constructor, be sure to increment the account count.
        numOfAccounts++;

    }
 
    //getters
public double getchkgBalance(){
return this.chkgBalance;
}

public double getSvgsBalance(){
    return this.svgsBalance;
}

    //setters
public void setChkgBalance(double chkgBalance){
    this.chkgBalance += chkgBalance;
}

public void setSvgsBalance(double svgsBalance){
    this.svgsBalance += svgsBalance;
}


    //Create a private method that returns a random ten digit account number.
    private long randomNum(){
        Long random = (long) Math.floor(Math.random()*9000000000L);
        return random;
    }

    //Create a method that will allow a user to deposit money into either the checking or saving, be sure to add to total amount stored.
    private void  svgsDeposit(double amount){
        setSvgsBalance(amount);
        amtTotal = getSvgsBalance() + getchkgBalance();
    }

    private void chkgDeposit(double ammount){
        setChkgBalance(amount);
        amtTotal = getSvgsBalance() + getchkgBalance();
    }

    //Create a method to withdraw money from one balance. Do not allow them to withdraw money if there are insufficient funds.
    public String svgsWithdrawal(double amount){
        if (getSvgsBalance() < 0.0 || getSvgsBalance() < amount){
            return "Insufficient Funds";
        }else{
            setSvgsBalance(getSvgsBalance() - amount);
            
            return String.valueOf(amount);
        }
    }//end of svgsWithdrawal

    //Create a method to see the total money from the checking and saving.
    public double retTotalAmt(){
        double totalAmt = getSvgsBalance() + getchkgBalance();
        return totalAmt;
    }

}// end of BankAccount.java