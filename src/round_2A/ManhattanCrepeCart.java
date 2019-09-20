package round_2A;

import java.util.*;
import java.io.*;

public class ManhattanCrepeCart {

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
			int P = scan.nextInt();
			int Q = scan.nextInt();
			HashMap<String,Integer> map = new HashMap<String,Integer>();
			for(int j=0; j<P;j++) {
				Integer xCoor = scan.nextInt();
				Integer yCoor = scan.nextInt();
				String direction = scan.next();
				if(direction.equals("S")) {
					Integer temp = yCoor;
					for(int k = 0; k < yCoor;k++) {
						temp = temp-1;
						String coor = xCoor.toString() + "," + temp.toString();
						if(!map.containsKey(coor)) {
							map.put(coor, 1);
						} else {
							map.replace(coor, map.get(coor)+1);
						}
					}
				}
				if(direction.equals("N")) {
					Integer temp = yCoor;
					for(int k = yCoor+1; k <= Q;k++) {
						temp = temp+1;
						String coor = xCoor.toString() + "," + temp.toString();
						if(!map.containsKey(coor)) {
							map.put(coor, 1);
						} else {
							map.replace(coor, map.get(coor)+1);
						}
					}
					
				}
				if(direction.equals("E")) {
					Integer temp = xCoor;
					for(int k = xCoor+1; k <= Q;k++) {
						temp = temp+1;
						String coor = temp.toString() + "," + yCoor.toString();
						if(!map.containsKey(coor)) {
							map.put(coor, 1);
						} else {
							map.replace(coor, map.get(coor)+1);
						}
					}
					
				}
				if(direction.equals("W")) {
					Integer temp = xCoor;
					for(int k = 0; k < xCoor;k++) {
						temp = temp-1;
						String coor = temp.toString() + "," + yCoor.toString();
						if(!map.containsKey(coor)) {
							map.put(coor, 1);
						} else {
							map.replace(coor, map.get(coor)+1);
						}
					}
				}	
			}
			int min_xVal = Q;
			int min_yVal = Q;
			//map is populated
			Map.Entry<String, Integer> maxEntry = null;
			for(Map.Entry<String, Integer> entry : map.entrySet()) {
				if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
			    {
					maxEntry = entry;
					String[] temp = entry.getKey().split(",");
					min_xVal = Integer.parseInt(temp[0]);
					min_yVal = Integer.parseInt(temp[1]);
			    }
			}
			
			
			for(Map.Entry<String, Integer> entry : map.entrySet()) {
				if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
			    {
					if(entry.getValue() == maxEntry.getValue()) { //multiple maxes
						String[] temp = entry.getKey().split(",");
						int xVal = Integer.parseInt(temp[0]);
						int yVal = Integer.parseInt(temp[1]);
						
						if(xVal < min_xVal) {
							min_xVal = Integer.parseInt(temp[0]);
							min_yVal = Integer.parseInt(temp[1]);
							maxEntry = entry;
						}
						if(xVal == min_xVal) {
							if(yVal < min_yVal) {
								min_xVal = Integer.parseInt(temp[0]);
								min_yVal = Integer.parseInt(temp[1]);
								maxEntry = entry;
							}
						}
					}
			    }
			}
			String answer = maxEntry.getKey();
			String[] answerArray = answer.split(",");
			System.out.println("Case #" + i + ":" + " " + answerArray[0] + " " + answerArray[1]);
		}
       
	}
	/*
	public static int crepeCart(int N, int K, ArrayList<Integer> listC, ArrayList<Integer> listD) {
	}
	*/
}

