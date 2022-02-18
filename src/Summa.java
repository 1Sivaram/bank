import org.json.simple.JSONObject;
import info.AccountInfo;


public class Summa 
{
	public static void main(String[] args) 
	{
		JSONObject json=new JSONObject();
		AccountInfo account=new AccountInfo();
		account.setBrachName("pmk");
		account.setCustomerId(1);
		account.setBankBalance(0);
		
		json.put(1, account);
		account=(AccountInfo) json.get(1);
		System.out.println(account);
		System.out.println(json);
		
		
		
	}
}
