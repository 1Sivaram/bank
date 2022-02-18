
public class Dem
{
	public static void main(String args[])
	{
		String S=" y df";
		int len=S.length();
        int posi[]=new int[len];
        for(int i=0;i<len;i++)
        {
            if(S.charAt(i)==' ')
            {
            	System.out.println("sf");
                posi[i]=1;
            }
        }
        for(int i:posi)
        {
        	System.out.println(i);
        }
        String dummy=S.replaceAll(" ", "");
        char []arr=dummy.toCharArray();
        int length=dummy.length();
        String output="";
        for(int i=length-1;i>-1;i--)
        {
        		output=output+arr[i];
        }
        String outputString="";
        for(int i=0;i<length;i++)
        {
        	
        	if(posi[i]==1)
        	{
        		System.out.println("ho");
        		outputString+=" "+output.charAt(i);
        		
        	}
        	else
        	{
        		System.out.println("hii");
        		outputString+=output.charAt(i);
        	}
        }
        System.out.println(outputString);
        
	}
}
