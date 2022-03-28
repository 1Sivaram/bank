import info.UserDetails;
import logic.ApiLayer;
import logic.DBLogic;
import myException.CustomException;
public class Dummy 
{
	public static void main(String[] args) 
	{
		DBLogic db=new DBLogic();
		ApiLayer api = new ApiLayer(true);
//		try {
//			UserDetails ud=db.getUserDetails(1);
//			System.out.println(ud.getPassword());
//			System.out.println(api.getCustomerAccounts(1));
//		} catch (CustomException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
}
