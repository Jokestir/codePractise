import java.io.Console;

public class treeHouseVideo7{

// the aim is to block teens younger than 13 from your app

  public static void main(String[] args){

    Console mconsole = System.console();


  // ask user his age.

    String userAgeAsString = mconsole.readLine("Whats your age:  ");

    int userAge = Integer.parseInt(userAgeAsString);

    // exit api in System object. It exits the current app. Input is exit code type. Zero suggests it was intentional. Non zero exit code is non-intentional
    if (userAge < 13 ){
      mconsole.printf("Sorry. You need to be atleat 13 to use this app");
      System.exit(0);
    }


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
