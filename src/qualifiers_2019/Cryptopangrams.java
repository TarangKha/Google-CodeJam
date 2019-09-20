package qualifiers_2019;

import java.util.*;
import java.io.*;

public class Cryptopangrams {

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
            Long N = scan.nextLong();
            Long L = scan.nextLong();
            List<Long> list = new ArrayList<Long>();
            for(int j = 0; j < L; j++) {
            	list.add(scan.nextLong());
            }
            String result = cryptopangrams(N,L,list);
            System.out.println("Case #" + i + ":" + " " + result);
        }
	}
	
	public static String cryptopangrams(Long N, Long L, List<Long> cipher) {
		ArrayList<Long> wordOrder = new ArrayList<Long>();
		//TreeMap<Long, Character> decoded = new TreeMap<Long, Character>();
		//HashMap<Long, Character> decoded = new HashMap<Long, Character>();
		HashSet<Long> decoded = new HashSet<Long>();
		Long[] primes = new Long[2];
		for(int i = 0; i < L; i++) {
			if(i == 0) {
				primes = primeFactorize(cipher.get(i));
				wordOrder.add(primes[0]);
				wordOrder.add(primes[1]);
				decoded.add(primes[0]);
				decoded.add(primes[1]);
			} else if(i == 1) {
				if(cipher.get(i)%primes[0] == 0) {
					wordOrder.add(cipher.get(i)/primes[0]);
					decoded.add(cipher.get(i)/primes[0]);
					swap(wordOrder);
				} else {
					wordOrder.add(cipher.get(i)/primes[1]);
					decoded.add(cipher.get(i)/primes[1]);
				}
			} else {
				wordOrder.add(cipher.get(i)/wordOrder.get(i));
				decoded.add(cipher.get(i)/wordOrder.get(i));
			}
		}
		//sort hashset
		Long[] sortedPrimes = decoded.toArray(new Long[26]);
		Arrays.sort(sortedPrimes);
		LinkedHashMap<Long, Character> translate = new LinkedHashMap<Long, Character>();
		/*
		Set<Long> entries = decoded.keySet();
		List<Long> targetList = new ArrayList<Long>(entries);
		Collections.sort(targetList);
		LinkedHashMap<Long, Character> sorted = new LinkedHashMap<Long, Character>();
		*/
		for(int i=0; i < sortedPrimes.length;i++) {
			translate.put(sortedPrimes[i], ' ');
		}
			
		char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		int iterator = 0;
		for(Long prime : translate.keySet()) {
			translate.replace(prime, ' ', alphabet[iterator]);
			iterator++;
		}
		
		String answer = new String();
		for(int i = 0; i < wordOrder.size(); i++) {
			answer = answer + (translate.get(wordOrder.get(i)));
		}
		return answer;
	}
	
	public static Long[] primeFactorize(Long n) {
		Long[] ans = new Long[2];
		for(Long i=(long) 2; i <= n/2;i++) {
			if(n%i == 0) {
				ans[0] = i;
				break;
			}
		}
		ans[1] = n/ans[0];
		return ans;
	}
	
	public static void swap(ArrayList<Long> list) {
		Long temp = list.remove(0); //remove 0 store in temp
		list.add(0, list.get(1)); //copy 1 put in 0
		list.remove(1); // remove 1
		list.add(1, temp); //put temp in 1
	}
}
