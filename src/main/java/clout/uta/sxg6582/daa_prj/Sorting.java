package clout.uta.sxg6582.daa_prj;

import java.util.Date;

public class Sorting {
	
	public int[] BubbleSort(int[] data) {
		//Swapping
		int[] arr = data;
        int  i, j, temp;
        for(i = 0; i < arr.length; i++){
            for(j = 0; j < arr.length-1; j++){
                if(arr[j] > arr[j+1]){
                    //swap
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
		return arr;
	}
	
	public int[] BubbleSortOptimised(int[] arr) {
		//Swapping with is sorted boolean check
		Date startTime = new Date();
		
        int  i, j, temp;
        boolean reqSorting;
        for(i = 0; i < arr.length; i++){
            reqSorting = false;
            for(j = 0; j < arr.length-1; j++){
                if(arr[j] > arr[j+1]){
                    //swap
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    reqSorting = true;
                }
            }

            if(!reqSorting) break;
        }
		return arr;
	}
	
   public int[] SelectionSort(int[] arr) {
	 //move minimum index from unsorted sub-array to sorted subarray's end
       for(int  i = 0; i < arr.length-1; i++){
           int minIndex = i;
           for(int j = i+1; j < arr.length; j++){
               minIndex = arr[minIndex] > arr[j] ? j : minIndex;
           }

           int currMinimum = arr[minIndex];
           arr[minIndex] = arr[i];
           arr[i] = currMinimum;
       }
		return arr;
	}
	
	public int[] InsertionSort(int[] data) {
		//move from unsorted sub array  to  correct place in sorted subarray
		int[] arr = data;

        for(int i=0; i<arr.length; i++){
            int curr = arr[i];
            int j= i-1;
            while(j >= 0 && arr[j] > curr){
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = curr;
        }
		return arr;
	}
	
	public int[] QuickSort(int[] arr) {
	    quickSort(arr,0,(arr.length-1));
		return arr;
	}
	

    public void quickSort(int array[], int startIndex, int endIndex) {
    if (startIndex < endIndex) {
      // Select pivot position and put all the elements smaller 
      // than pivot on left and greater than pivot on right
      int pivot = partition(array, startIndex, endIndex);
      
      // Sort the elements on the left of pivot
      quickSort(array, startIndex, pivot - 1);

      // Sort the elements on the right of pivot
      quickSort(array, pivot + 1, endIndex);
    }
  }
	
	int partition(int array[], int startIndex, int lastIndex) {
	    
	    // make a pivot element
	    int pivot = array[lastIndex];
	    int i = (startIndex - 1);

	    // Put  smaller  element of pivot on the left and 
	    // greater than pivot on the right of pivot
	    for (int j = startIndex; j < lastIndex; j++) {
	      if (array[j] <= pivot) {
	        i++;
	        int temp = array[i];
	        array[i] = array[j];
	        array[j] = temp;
	      }
	    }
	    int temp = array[i + 1];
	    array[i + 1] = array[lastIndex];
	    array[lastIndex] = temp;

	    return (i + 1);
	  }

	    
	public int[] QuickSort3Median(int[] arr) {
		quickSort2(arr, 0, arr.length - 1);
		return arr;
	}
	
	public void quickSort2(int[] arr, int left, int right){
        if(left >= right)
            return;

        double median = median3way(arr, left, right);
        int partition = partition2(arr, left, right, median);
        quickSort(arr, left, partition - 1);
        quickSort(arr, partition + 1, right);
    }
    
      public int median3way(int[] arr, int left, int right) {
        int center = (left + right) / 2;
    
        if (arr[left] > arr[center])
          exchange(arr, left, center);
    
        if (arr[left] > arr[right])
        exchange(arr, left, right);
    
        if (arr[center] > arr[right])
        exchange(arr, center, right);
    
        exchange(arr, center, right - 1);
        return arr[right - 1];
      }
    
      public static void exchange(int[] arr, int firstElement, int secElement) {
        int currVal = arr[firstElement];
        arr[firstElement] = arr[secElement];
        arr[secElement] = currVal;
      }
    
      public static int partition2(int[] arr, int left, int right, double pivot) {
        int pointerL = left;
        int pointerR = right - 1;
    
        while (true) {
          while (arr[++pointerL] < pivot)
            ;
          while (arr[--pointerR] > pivot)
            ;
          if (pointerL >= pointerR)
            break;
          else
            exchange(arr, pointerL, pointerR);
        }
        exchange(arr, pointerL, right - 1);
        return pointerL;
      }
      
	public int[] MergeSort(int[] arr) {
	
	    divide(arr, 0 , arr.length-1);
		return arr;
	}
	

    void divide(int[] arr, int startIndex, int endIndex){
        if(startIndex < endIndex){
            int midIndex = ((startIndex + endIndex)/2);

            divide(arr, startIndex, midIndex);
            divide(arr, midIndex+1, endIndex);

            mergeArray(arr, startIndex, midIndex, endIndex);
        }
    }

    void mergeArray(int[] arr, int startIndex, int midIndex, int endIndex){
        
        // store into temporary array
        int leftArraySize = midIndex -startIndex+1;
        int rightArraySize = endIndex - midIndex;

        int[] leftArray = new int[leftArraySize];
        for(int i = 0; i < leftArraySize; i++){
            leftArray[i] = arr[startIndex+i];
        }

        int[] rightArray = new int[rightArraySize];
        for(int i = 0; i < rightArraySize; i++){
            rightArray[i] = arr[midIndex+1+i];
        }

        // sort the two temp array with one to one comparison
        int i = 0, j = 0, k =startIndex;
        while(i < leftArraySize && j < rightArraySize){
            if(leftArray[i] <= rightArray[j]){
                arr[k] = leftArray[i];
                i++;
            }else{
                arr[k] = rightArray[j];
                j++;
            }

            k++;
        }

        //check if more elements  left or right subarray
        while(i < leftArraySize){
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while(j < rightArraySize){
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
	
	public int[] HeapSort(int[] arr) {
		HeapSortHelper(arr);
		return arr;
	}
	
	public void HeapSortHelper(int[] arr){
		//3 steps: maxHeap, Swap, remove, repeat
        int size = arr.length;
        int last = (size/2)-1;

        //convert arr to maxheap to get largest at root for first swap and place it in the last index
        for(int i = last; i >= 0; i--){
            buildMaxHeap(arr, i, size);
        }

        for(int  i = size-1; i > 0; i--){
            //swap to place largest element to end to array and get minimum element on root
            int curr = arr[0];
            arr[0] = arr[i];
            arr[i] = curr;

            //bring largest to rootnode using maxheap 
            //and remove the lastnode by sending the i as max limit  or size
            buildMaxHeap(arr, 0, i);
        }
        
		
	}
	
	 //recursive function
    void buildMaxHeap(int[] arr, int rootIndex, int size){
    	int maxIndex = rootIndex;
        int leftNode = (2*rootIndex) +1;
        int rightNode = (2*rootIndex) +2;
    
        if(leftNode < size && arr[leftNode] > arr[maxIndex])
            maxIndex = leftNode;
    
        if(rightNode < size && arr[rightNode] > arr[maxIndex])
            maxIndex = rightNode;
    
        if(maxIndex != rootIndex){
            // int currMax = arr[maxIndex];
            // arr[maxIndex] = arr[rootIndex];
            // arr[rootIndex] = currMax;
    
            int currVal = arr[rootIndex];
            arr[rootIndex] = arr[maxIndex];
            arr[maxIndex] = currVal;
    
            buildMaxHeap(arr, maxIndex, size);
        }
      }

    }


