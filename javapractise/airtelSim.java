import java.io.Console;

public class airtelSim{

	public static void main(String[] args){

		Console mconsole = System.console();

		String mccmnc = mconsole.readLine("MCCMNC");

		if(mccmnc.startsWith("404") && mccmnc.endsWith("45")){

			mconsole.printf("Airtel SIM hai");

		}



}
}