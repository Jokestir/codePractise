import java.io.Console;

public class treeHouseVideo6{

  public static void main(String[] args){

    Console mconsole = System.console();

    String name = mconsole.readLine("Enter a name: ");

    String adjective = mconsole.readLine("Enrer an adjective:  ");

    String noun = mconsole.readLine("Enrer an noun:  ");

    String adverb = mconsole.readLine("Enrer an adverb:  ");

    String verb = mconsole.readLine("Enrer an verb:  ");

    mconsole.printf("Your TreeStory\n---------------------\n");
    mconsole.printf("%s is a %s %s.", name, adjective,noun);
    mconsole.printf("They are always %s %s .\n",adverb,verb);






  }




}
