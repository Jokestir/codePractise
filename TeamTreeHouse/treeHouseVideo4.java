import java.io.Console;

public class treeHouseVideo4{

  public static void main(String[] args){

    /* Multiple line comment

    name: person, thing etc.
    verb: action
    adjective: something that describes the noun

    */


    // create console object
    Console mconsole = System.console();

    String name = mconsole.readLine("What is your name:  ");

    String adjective = mconsole.readLine("\n Please enter an adjective  ");

    mconsole.printf(" \n%s is very %s \n ", name, adjective);



  }




}
