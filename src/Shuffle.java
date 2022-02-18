import java.util.*;

public class Shuffle 
{

	public static void main(String[] args) 
	{
		String dum="cat";
		char []array=dum.toCharArray();
		int []arr= {1,0,2};
		int len=dum.length();
		String res="";
		
		Map<Integer,Character> map=new HashMap<>();
		for(int i=0;i<len;i++)
		{
			map.put(arr[i], array[i]);
		}
		for(int i=0;i<len;i++)
		{
			res=res+map.get(i);
		}
		System.out.println(res);
	}
}
