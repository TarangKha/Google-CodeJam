package qualifiers_2018;

import java.util.*;
import java.io.*;


public class SavingTheUniverseAgain {
   
	public static void main(String[] args) throws FileNotFoundException{
    	//for google submissions
    	//Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
  
		//For Eclipse Testing
		File file = new File("C:\\Users\\Tarang Khandpur\\Documents\\LIFE Summer 2018\\Coding-Prep\\eclipse-workspace\\Google-CodeJam\\src\\qualifiers_2018\\input.txt");
        
		@SuppressWarnings("resource")
        Scanner scan = new Scanner(file);
        
        int caseNumber = scan.nextInt();
        for (int i = 1; i <= caseNumber; i++){
            int D = scan.nextInt();
            String P = scan.next();
            int result = alienAttack(D, P, 0);
            if (result == -1){
                System.out.println("Case #" + i + ":" + " IMPOSSIBLE");    
            } else {
                System.out.println("Case #" + i + ":" + " " + result);
            }
        }
    }
    
    public static int alienAttack(int d, String p, int swapsCount){
        int damage = 1;
        int health = d;
        for(int i = 0; i < p.length(); ++i){
            if(p.charAt(i) == 'S'){
                health = health - damage;
            } else {
                damage = damage*2;
            }
            if(health < 0){
                String hacked = hack(i, p);
                if (!hacked.equals(p)){
                	System.out.println("\n" + "new: " + hacked + " old: " + p);
                    return alienAttack(d, hacked, ++swapsCount);
                } else { 
                    return -1; //impossible flag
                }
            }
        }
        return swapsCount;
    }
    
    public static String hack(int endIndex, String attackPattern){
        char[] p = attackPattern.toCharArray();
        String hacked;
        for(int i = 0; i <= endIndex-1; i++){
            if(p[i] == 'C' && p[i+1] == 'S'){
                p[i] = 'S';
                p[i+1] = 'C';
                hacked = new String(p);
                return hacked;
            }
        }
        return attackPattern;
    }
}
