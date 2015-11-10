import java.io.Console;

public class stringChar{


	public static void main(String[] args){


					Console mconsole = System.console();

					String name = mconsole.readLine("Name:");

					int length = name.length();

					// string ka third character bata

					char thirdChar = name.charAt(2);

					mconsole.printf("thirdChar: %c\n",thirdChar);

					// lesson: charAt(i-1) to find ith character






	}




}