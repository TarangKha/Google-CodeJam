package round_2A;

import java.util.*;
import java.io.*;

public class FairFight {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//for google submissions
    	//Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
  
		//For Eclipse Testing        
		File file = new File("input.txt");
		@SuppressWarnings("resource")
        Scanner scan = new Scanner(file);
		
		int caseNumber = scan.nextInt();
		for(int i=1;i<=caseNumber;i++) {
			int N = scan.nextInt();
			int K = scan.nextInt();
			ArrayList<Integer> listC = new ArrayList<Integer>();
			ArrayList<Integer> listD = new ArrayList<Integer>();
			for(int j=0; j<N;j++) {
				listC.add(scan.nextInt());
			}
			for(int j=0;j<N;j++) {
				listD.add(scan.nextInt());
			}
			System.out.println("Case #" + i + ":" + " " + fairFightv2(N, K,listC,listD));
		}
       
	}
	
	public static int fairFight(int N, int K, ArrayList<Integer> listC, ArrayList<Integer> listD) {
		int pairs = 0;
		for(int L = 0; L<N;L++) {
			for(int R = L; R<N;R++) {
				List<Integer> subC = listC.subList(L, R+1);
				List<Integer> subD = listD.subList(L, R+1);
				int maxC = Collections.max(subC);
				int maxD = Collections.max(subD);
				if(Math.abs(maxC - maxD) <= K) {
					pairs++;
				}
			}
		}
		return pairs;
	}
	
	public static int fairFightv2(int N, int K, ArrayList<Integer> listC, ArrayList<Integer> listD) {
		int pairs = 0;
		for(int L = 0; L<N;L++) {
			for(int R = L; R<N;R++) {
				int maxC = listC.get(0);
				for(int i = L; i <= R; i++) {
					int temp = listC.get(i);
					if(temp > maxC) {
						maxC = temp;
					}
				}
				int maxD = listD.get(0);
				for(int i = L; i <= R; i++) {
					int temp = listD.get(i);
					if(temp > maxD) {
						maxD = temp;
					}
				}
				if(Math.abs(maxC - maxD) <= K) {
					pairs++;
				}
			}
		}
		return pairs;
	}
}

/*
int pairs = 0;
for(int i=0;i<listC.size();i++) {
	for(int j=0;j<listD.size();j++) {
		if(Math.toRadians(listC.get(i)-listD.get(j)) <= K) {
			
		}
	}
}
}
*/
