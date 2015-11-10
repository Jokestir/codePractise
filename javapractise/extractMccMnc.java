import java.io.Console;

public class extractMccMnc{


public static void main(String[] args){


	// input mcc mnc
	Console mconsole = System.console();
	String mccMnc = mconsole.readLine("Enter mccMnc:");

	//mcc is first three chars

	String mcc = mccMnc.substring(0,3);

	String mnc = mccMnc.substring(3,5);




		mconsole.printf("MCC:%s\n",mcc);
			mconsole.printf("MCC:%s\n",mnc);


/*
lesons:
=======

1. first i chars: substring(0,i)

2. last i chars : substring(l-i,l)

3. or use begins with or endswith


*/






}




}