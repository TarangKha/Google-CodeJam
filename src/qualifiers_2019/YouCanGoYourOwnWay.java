package qualifiers_2019;

import java.util.*;
import java.io.*;

public class YouCanGoYourOwnWay {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//for google submissions
    	//Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
  
		//For Eclipse Testing        
		File file = new File("input.txt");
		@SuppressWarnings("resource")
        Scanner scan = new Scanner(file);
		
		int caseNumber = scan.nextInt();
        for (int i = 1; i <= caseNumber; i++){
            int N = scan.nextInt();
            String P = scan.next();
            String result = youCanGoYourOwnWay(P);
            System.out.println("Case #" + i + ":" + " " + result);
        }
		
	}
	
	public static String youCanGoYourOwnWay(String sequence) {
		char[] mirror = sequence.toCharArray();
		for(int i = 0; i < mirror.length; i++) {
			if(mirror[i] == 'E') {
				mirror[i] = 'S';
			} else {
				mirror[i] = 'E';
			}
		}
		return new String(mirror);
	}
}
