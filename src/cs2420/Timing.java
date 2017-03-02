package cs2420;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

/**
 * 
 *
 * @author Chloe Josien, Kylee Fluckiger
 * @date 2/27/2017
 */
public class Timing {

	private static final String COMMA= ",";
	private static final String NEWLINE = "\n";
	
	private static final String FILE_HEADER_RANDOM = "100_000, 200_000, 300_000, 400_000, 500_000, " +
					"600_000, 700_000, 800_000, 900_000, 1_000_000";
	private static final String FILE_HEADER_SORTED = "100, 200, 300, 400, 500, 600, 700, 800, 900, 1_000";

	public static void main(String[] args) {
		
		FileWriter file = null;
				
		try {
			
			/*
			 * TODO: CHANGE HERE to name output file.
			 */
			file = new FileWriter("insertRandomizedTreeSet.csv");
			
			/*
			 * TODO: CHANGE HERE to pick the correct header for your uses.
			 */
			file.append(FILE_HEADER_RANDOM.toString());
			file.append(NEWLINE);
			
			//Timers.
			long start = 0;
			long end = 0;
			long totalTime = 0;
			
			/*
			 * TODO: CHANGE HERE to change number of averaging trials.
			 */
			int runsForAverage = 50;
		
			BinarySearchTree<Integer> bst = new BinarySearchTree<>();
			TreeSet<Integer> ts = new TreeSet<>();
			
			//Use these sizes for randomized set testing.
			int[] sizesForRandom = {100_000, 200_000, 300_000, 400_000, 500_000,
					600_000, 700_000, 800_000, 900_000, 1_000_000};
			
			//Use these sizes for sorted set testing, to prevent stack overflow.
			int[] sizesForSorted = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1_000};
			
			
			
			//---- TIMING CODE----//
			
			
			
			/*
			 * TODO: CHANGE HERE for which size array you are using.
			 */
			for(int sizeIndex=0; sizeIndex<sizesForRandom.length; sizeIndex++) {
				
				totalTime = 0;
				
				//Generate a randomized set to add from.
				ArrayList<Integer> randomizedSet = new ArrayList<>();
				for(int randomIndex=0; randomIndex<sizesForRandom[sizeIndex]; randomIndex++) {
					randomizedSet.add(randomIndex);
				}
				Collections.shuffle(randomizedSet);
				
				
				//Averaging for loop.
				for(int run=0; run<runsForAverage; run++) {
					
					//Timer for adding.
					start = System.nanoTime();
										
					/*
					 * For loop for adding.
					 * 
					 * TODO: CHANGE HERE for which size array you are using,
					 * 		 and uncomment the function (sorted or random)
					 * 		 you wish to test.
					 */
					for(int element=0; element<sizesForRandom[sizeIndex]; element++) {
						
						//Add in sorted order using the run index.
						//bst.add(element);
						
						//Add in random order.
						//bst.add(randomizedSet.get(element));
						
						//Add to tree set.
						ts.add(randomizedSet.get(element));
													
					}
					
					/*
					 * Timer for contains().
					 * 
					 * TODO: Un/comment this to test contains.
					 */
					//start = System.nanoTime();
					
					/*
					 * For loop for timing the contains method.
					 * 
					 * TODO: CHANGE HERE for which size array you are using, as well
					 * 		 as which function you would like to execute.
					 */
//					for(int element=0; element<sizesForSorted[sizeIndex]; element++) {
//						
//						//Test contains in sorted order using the run index.
//						bst.contains(element);
//						
//						//Test contains in random order.
//						//bst.contains(randomizedSet.get(element));
//						
//					}

					
					end = System.nanoTime();
					
					totalTime += (end-start);
					
				}
				
				
				/*
				 * TODO: CHANGE HERE for which size array you are using.
				 */
				System.out.println(sizesForRandom[sizeIndex] + " " + Long.toString(totalTime/runsForAverage));
				
				file.append(Long.toString(totalTime/runsForAverage));
				file.append(COMMA);
				
			}
			
			file.append(NEWLINE);
			
		//IO error catching.
		} catch (Exception e) {
			System.out.println("Error1");
			e.printStackTrace();
		} finally {
			
			//Close the file.
			try {
				
				file.flush();
				file.close();
				
			}
			catch (IOException e) {
				System.out.println("Error2");
			}
		}
		
	}

}
