import java.io.Console;

public class stringSub{

	public static void main(String[] args){

		Console mconsole = System.console();

		String name = mconsole.readLine("Name: ");

		// find the first three characters

		String firstThree = name.substring(0,3);

		mconsole.printf("firstThree chars: %s\n",firstThree);

		// lesson: first i characters: substring(0,i)


		// last three chars

		String lastThree = name.substring(name.length()-3,name.length());

		mconsole.printf("The last three chars:%s\n",lastThree);

		// lesson: last i characters substring(l-i,l)
	}





}