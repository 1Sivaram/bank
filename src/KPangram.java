import java.util.*;
public class KPangram {
	
	private boolean kpangram(String str,int k)
	{
		Map<Character,Integer> map=new HashMap<>();
        String dummy=str.replaceAll("\\s","");
		int len=dummy.length();
        if(len<26)
        {
            return false;
        }
        char [] charArray=dummy.toCharArray();
        int count=0;
        for(int i=0;i<len;i++)
        {
        	if('a'<=charArray[i]&&charArray[i]<='z')
        	{
        		map.put(charArray[i],1);
        	}
        }
        for(Character ch:map.keySet())
        {
            count++;
        }
        count=26-count;
        System.out.println(count);
        if(k>=count)
        {
        	return true;
        }
        else
        {
        	return false;
        }
        
        
	}

	public static void main(String[] args) 
	{
		String str = "aaaaaaaaaaaaaaaaaaaaaaaaaa";
		int	k =25;
		
		
		
		KPangram kp=new KPangram();
		System.out.println(kp.kpangram(str,k));
		
        
	}

}
