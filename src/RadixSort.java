import java.util.Arrays;
/**************************************************************
Author: Megan Jane Thompson
Purpose: This program uses radixSort algorithm to sort an
		 ArrayList of Integers in increasing order. If the 
		 ArrayList contains an odd number, an error message
		 is printed.
 **************************************************************/ 
public class RadixSort {
	/*
	 * Main Method
	 */
	public static void main(String[] args) { 
		int[] arr = {24, 12, 4, 366, 48, 66, 8, 14, 52};
		int currVal = 0;
		for(int i = 0; i < arr.length; ++i) {
			currVal = arr[i];
			if(currVal % 2 != 0) {												//checks array list for odd numbers
				System.out.println("*** Abort*** At least one key with odd digit.");	//error message if list contains odd number
				System.exit(1);													//exit program if list contains odd number
			}
		}
		printList(arr, "Input");												//prints pre-sorted array list
		radixSort(arr);															//call to radixSort()
		printList(arr, "Output");												//print sorted list
	} 

	
	/* This method takes in an array list of integers and uses 
	 * the radixSort algorithm to sort them in increasing order.
	 * If the list contains an odd number, an error message 
	 * is printed and the program is exited.
	 * 
	 * @param arr  ,the array list of integers to be sorted.
	 */
	public static void radixSort(int[] arr) {
		int i;
		int maxVal = arr[0];													//obtains first digit as first maxVal
		for(i = 1; i < arr.length; ++i) {
			if(arr[i] > maxVal) {												//checks if current element > maxVal
				maxVal = arr[i];												//if true, change maxVal to current element
			}
		}
		for(int powerVal = 1; maxVal/powerVal > 0; powerVal *= 10){				//loops through longest number's digits
			int sorted[] = new int[arr.length];  								//array for sorted list
	        int cnt[] = new int[10]; 											//array for 1 - 9 occurrences
	        Arrays.fill(cnt,0);													//initializes all elements of cnt[] to 0
	   
	        for(i = 0; i < arr.length; ++i){ 
	            ++cnt[(arr[i]/powerVal) % 10]; 									//increment occurrence in cnt[]
	        }
	        for(i = 1; i < cnt.length; i++){									//realign cnt[]
	            cnt[i] += cnt[i - 1]; 											
	        }
	        for(i = arr.length - 1; i >= 0; --i){ 								//build adjusted array
	        	sorted[cnt[(arr[i]/powerVal) % 10] - 1] = arr[i]; 
	            --cnt[(arr[i]/powerVal) % 10]; 
	        } 
	        for(i = 0; i < arr.length; i++) {									//copy to arr[]
	            arr[i] = sorted[i]; 
	        }
		}
	}
		
	
	/* This method takes in an array list of integers and
	 * prints the list.
	 * 
	 * @param arr    ,the array list of integers to be printed.
	 * @param status ,the status of which array is being printed.
	 */
	public static void printList(int[] arr, String status) {
		System.out.print("" + status + ": ");
		for(int i = 0; i < arr.length-1; ++i) {
			System.out.print("" + arr[i] + ", ");
		}
		System.out.println(arr[arr.length-1]);
	}
}
