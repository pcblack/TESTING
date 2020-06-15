package bankingapp.src.bankingApp;


public class AccountExistsException extends Exception {
	static final long serialVersionUID = 1L;
	public  AccountExistsException(String st){
		System.out.println(st);
	}


}
