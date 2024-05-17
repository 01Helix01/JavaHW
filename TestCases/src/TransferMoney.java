public class TransferMoney {

    public static final int MIN_LENGTH_BANK_ACC = 8;
    public static final int MAX_LENGTH_BANK_ACC = 12;

    public static final int MIN_LENGTH_TRANSFER = 2;
    public static final int MAX_LENGTH_TRANSFER = 4;
    
    public static final int MIN_TRANSFER_AMNT = 20;
    public static final int MAX_TRANSFER_AMNT = 2000;

    public static int[] existingAcc = {123456789};

    
    // Check Account has an acceptable amount of digits
    public static boolean checkAccountLength(String argAccount){
        if(MIN_LENGTH_BANK_ACC <= argAccount.length()  &&  argAccount.length() <= MAX_LENGTH_BANK_ACC){
            return true;
        }else{
            return false;
        }
    }
    
    // Check that bank account number corresponds with the user's
    public static boolean checkAccountExisting(String argAccount){
        for(int acc : existingAcc) {
            if(argAccount.equals(acc)){
                return true;
            }
        }
        return false;
    }
    
    // Check transfer amount has acceptable amount of digits
    public static boolean checkTransferLength(String argTransfer){
        if(MIN_LENGTH_TRANSFER <= argTransfer.length()  &&  argTransfer.length() <= MAX_LENGTH_TRANSFER){
            return true;
        }else{
            return false;
        }
    }
    
    // Check that amount transfered lies within the min and max 
    public static boolean checkTransferAmount(String argTransfer){
    	int transferAmount = Integer.parseInt(argTransfer);
    	if(transferAmount <= MAX_TRANSFER_AMNT && transferAmount >= MIN_TRANSFER_AMNT) {
                return true;
        }
        return false;
    }


    public static String register(String argAccount, String argTransfer){
        if( !checkAccountLength( argAccount ) ) {
            return "Account number does not satisfy length requirement";
        }
        if( !checkAccountExisting( argAccount ) ) {
            return "Incorrect account number was entered";
        }
        
        if( !checkTransferLength( argTransfer ) ) {
            return "Transfer amount does not satisfy length requirement";
        }
        
        if( checkTransferAmount( argTransfer ) ) {
            return "Invalid transfer amount was entered";
        }
       
        //as all criteria has been satisfied, now we can safely say that
        // the registration of the incoming combo is successful.
        return "Registration Successful";
    }
}
