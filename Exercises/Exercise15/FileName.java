class PrintHelper extends Object
{
    public int printNum() 
    {
		System.out.println("Going to print, some number of times!");
		int howManyPrints = 0;
		while(howManyPrints < 2)
		{
			System.out.println("Printing!");
			howManyPrints++;
		}
        return howManyPrints;
    }
}

public class FileName extends Object
{
 public static void main(String[] args)
 {
    PrintHelper ph = new PrintHelper();
    int num;
    num = ph.printNum();
    System.out.println( "The method printed " + num + " times!");
 }
}
