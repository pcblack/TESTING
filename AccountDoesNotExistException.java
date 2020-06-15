package bankingapp.src.bankingApp;

public class AccountDoesNotExistException extends Exception {
	static final long serialVersionUID = 1L;
	public  AccountDoesNotExistException(String st2){
		System.out.println(st2);
	}

}
