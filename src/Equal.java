
public class Equal {
	public boolean arrayStringsAreEqual(String[] word1, String[] word2) 
    {
        String newWord1="";
        String newWord2="";
        int len=word1.length;
        int len1=word2.length;
        
        for(int i=0;i<len;i++)
        {
            newWord1+=word1[i];
        }
        for(int i=0;i<len1;i++)
        {
            newWord2+=word2[i];
        }
        if(newWord1.equals(newWord2))
        {
            return true;
        }
        return false;
    }

	public static void main(String[] args) 
	{
		Equal eq=new Equal();
		String [] word1={"abc","ab"};
		String [] word2={"abcab"};
		System.out.println(eq.arrayStringsAreEqual(word1,word2));
	}

}
