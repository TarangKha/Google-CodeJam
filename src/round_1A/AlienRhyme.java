package round_1A;

import java.util.*;
import java.io.*;

public class AlienRhyme {

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
            ArrayList<String> list = new ArrayList<String>();
            for(int j = 0; j < N; j++) {
            	String W = scan.next();
            	StringBuilder temp = new StringBuilder(W);
            	temp = temp.reverse();
            	list.add(temp.toString());
            }
            Collections.sort(list, Collections.reverseOrder());
            int result;
            if(list.size() <= 1) {
            	result = 0;
            } else {
            	result = alienRhyme(list);
            }
            System.out.println("Case #" + i + ":" + " " + result);
        }
	}
	
	public static int alienRhyme(ArrayList<String> list) {
		HashSet<String> set = new HashSet<String>();
		int pairs = 0;
		for(int i = 0; i < list.size()-1; i++) {
			int sizeA = list.get(i).length();
			int sizeB = list.get(i+1).length();
			int shortestWord;
			if(sizeA < sizeB) {
				shortestWord = sizeA;
			} else {
				shortestWord = sizeB;
			}
			String accentWord = "";
			int letterCounter = 0;
			for(int j = 0; j < shortestWord; j++) {
				if(list.get(i).charAt(j) == list.get(i+1).charAt(j)) {
					accentWord = accentWord + list.get(i).charAt(j);
					letterCounter++;
				} else if (letterCounter > 0){
					boolean added = false;
					while (letterCounter > 0){
						if(set.add(accentWord)){
							added = true;
						} else {
							letterCounter--;
							//[)
							accentWord = new String(accentWord.substring(0, letterCounter));
						}
					}
					if (added) {
						pairs++;
						break;
					}
				} else {
					break;
				}
			}
		}
		return pairs*2;
	}
}

//muh molon, malan, majdoc, maj, mah
