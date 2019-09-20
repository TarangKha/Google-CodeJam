package qualifiers_2019;

import java.util.*;
import java.io.*;

public class ForgoneSolution {

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
            int[] result = forgoneSolution(N);
            System.out.println("Case #" + i + ":" + " " + result[0] + " " + result[1]);
        }
		
	}
	
	public static int[] forgoneSolution(int n) {
		ArrayList<Integer> div = new ArrayList<Integer>();
		int value = n;
		int currentDigit = 1;
		int numOfDigits = 0;
		
		//moves currentDigit to highest digit placement;
		while(value >= currentDigit) {
			currentDigit = currentDigit*10;
			numOfDigits++;
		}
		currentDigit = currentDigit/10;
		
		//populates Div with Highest digit in [0]
		for(int i = 0; i < numOfDigits; i++) {
			div.add(value/currentDigit);
			value = value%currentDigit;
			currentDigit = currentDigit/10;
		}
		
		int firstAns = 0;
		
		for(int i = 0, j = numOfDigits-1; i < numOfDigits;i++,j--) {
			if(div.get(i) == 4) {
				firstAns = (int) (firstAns + Math.pow(10,j));
			}
		}
		int secondAns = n - firstAns;
		
		int[] ans = new int[2];
		ans[0] = firstAns;
		ans[1] = secondAns;
		
		return ans;
	}
}
