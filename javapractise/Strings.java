import java.io.Console;

public class Strings{

	public static void main(String args[]){

		// take input via readline. need a console object to call this method

		Console mconsole = System.console();


		String name = mconsole.readLine("What is the name?: ");


		//length api
		int length = name.length();

		mconsole.printf("The length of the name: %d\n", length);


		//charAt api
		char fourthCharacter = name.charAt(3);

		mconsole.printf("Fourth character: %c\n",fourthCharacter );


		//substring(i-1) api

		String subString = name.substring(3);

		mconsole.printf("The substring from 4th character: %s\n", subString);

		//substring(i-1,j) api
		String msubString = name.substring(2,5);
		mconsole.printf("String api: %s\n",msubString);

	}


}