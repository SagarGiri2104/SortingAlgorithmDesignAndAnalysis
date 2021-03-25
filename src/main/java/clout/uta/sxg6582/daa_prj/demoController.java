package clout.uta.sxg6582.daa_prj;

import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//preference : annotations

@Controller
public class demoController {
	private static final String bubbleSort = "bubble";
	private static final String selectionSort = "selection";
	private static final String insertionSort = "insertion";
	private static final String mergeSort = "merge";
	private static final String quickSort = "regularQuick";
	private static final String quickMedianSort = "medianQuick";
	private static final String heapSort = "heap";
	private static final String all = "all";

	@RequestMapping("/demo")
	public ModelAndView process(HttpServletRequest request,HttpServletResponse response)
	{
		
		String data = request.getParameter("data");
		String type= request.getParameter("type");
		String[] arr = data.split( "[\\s,]+" ) ;
		int[] dataArray = new int[arr.length];

		for(int i = 0; i<arr.length;i++) {
			
			dataArray[i] = Integer.parseInt(arr[i]);
		}
		
		Sort sort = getSortedData(type,dataArray);
		
		StringBuffer s = new StringBuffer();
		if(sort.getData()!=null) {
			for(int i =0 ;i<sort.getData().length;i++) {
				if(i == sort.getData().length-1)
				s.append(sort.getData()[i]);
				else
					s.append(sort.getData()[i] + ",");
			}
		}

		ModelAndView mv = new ModelAndView();
		mv.setViewName("demo.jsp");
		mv.addObject("sortedData",s);
		mv.addObject("sortType",sort.getType());
		mv.addObject("runTime",sort.getRunTime());
		mv.addObject("bubbleTime",sort.getBubbleTime());
		mv.addObject("selectionTime",sort.getSelectionTime());
		mv.addObject("insertionTime",sort.getInsertionTime());
		mv.addObject("mergeTime",sort.getMergeTime());
		mv.addObject("quickTime",sort.getQuickTime());
		mv.addObject("quickMedianTime",sort.getQuickMedianTime());
		mv.addObject("heapTime",sort.getHeapTime());

		return mv;

	}
	
	private Sort getSortedData(String type, int[] data) {
		Sorting sorting = new Sorting();
		Sort sort = new Sort();
		int[] sortedData = new int[data.length];
	
		// TODO Auto-generated method stub
		if(type!=null && !type.equals(all)) {
		if(type.equalsIgnoreCase(bubbleSort)) {
			long startTime = System.nanoTime();
			 sortedData = sorting.BubbleSort(data);
			 long endTime = System.nanoTime();
		     long time = (endTime - startTime);
		 	 sort.setType(bubbleSort);
		 	 sort.setData(sortedData);
		 	 sort.setRunTime(time);

		}
		else if(type.equalsIgnoreCase(selectionSort)) {
			long startTime = System.nanoTime();
			 sortedData = sorting.SelectionSort(data);
			 long endTime = System.nanoTime();
		     long time = (endTime - startTime);
		     sort.setType(selectionSort);
		 	 sort.setData(sortedData);
		 	 sort.setRunTime(time);

		}
		else if(type.equalsIgnoreCase(insertionSort)) {
			long startTime = System.nanoTime();
			 sortedData = sorting.InsertionSort(data);
			 long endTime = System.nanoTime();
		     long time = (endTime - startTime);
		     sort.setType(insertionSort);
		 	 sort.setData(sortedData);
		 	 sort.setRunTime(time);

		}
		else if(type.equalsIgnoreCase(quickSort)) {
			long startTime = System.nanoTime();
			 sortedData = sorting.QuickSort(data);
			 long endTime = System.nanoTime();
		     long time = (endTime - startTime);
		     sort.setType(quickSort);
		 	 sort.setData(sortedData);
		 	 sort.setRunTime(time);

		}
		else if(type.equalsIgnoreCase(quickMedianSort)) {
			long startTime = System.nanoTime();
			 sortedData = sorting.QuickSort3Median(data);
			 long endTime = System.nanoTime();
		     long time = (endTime - startTime);
		     sort.setType(quickMedianSort);
		 	 sort.setData(sortedData);
		 	 sort.setRunTime(time);

		}
		else if(type.equalsIgnoreCase(mergeSort)) {
			long startTime = System.nanoTime();
			 sortedData = sorting.MergeSort(data);
			 long endTime = System.nanoTime();
		     long time = (endTime - startTime);
		     sort.setType(mergeSort);
		 	 sort.setData(sortedData);
		 	 sort.setRunTime(time);

		}
		else if(type.equalsIgnoreCase(heapSort)) {
			long startTime = System.nanoTime();
			 sortedData = sorting.HeapSort(data);
			 long endTime = System.nanoTime();
		     long time = (endTime - startTime);
		     sort.setType(heapSort);
		 	 sort.setData(sortedData);
		 	 sort.setRunTime(time);

		}
		}
		else {
			 sort.setType(all);
			 int[] temp = data.clone();
			 long startTime = System.nanoTime();
			 sortedData = sorting.BubbleSort(data);
			 long endTime = System.nanoTime();
		     long time = (endTime - startTime);
		 	 sort.setData(sortedData);
		 	 sort.setBubbleTime(time);
		 	 
			 int[] temp1 = temp.clone();
			 startTime = System.nanoTime();
			 sortedData = sorting.SelectionSort(temp);
			 endTime = System.nanoTime();
			 time = (endTime - startTime);
			 sort.setSelectionTime(time);
		 	 
		 	int[] temp2 = temp1.clone();
			 startTime = System.nanoTime();
			 sortedData = sorting.InsertionSort(temp1);
			 endTime = System.nanoTime();
			 time = (endTime - startTime);
		 	 sort.setInsertionTime(time);
		 	 
		 	int[] temp3 = temp2.clone();
			 startTime = System.nanoTime();
			 sortedData = sorting.MergeSort(temp2);
			 endTime = System.nanoTime();
			 time = (endTime - startTime);
		 	 sort.setMergeTime(time);
		 	 
		 	int[] temp4 = temp3.clone();
			 startTime = System.nanoTime();
			 sortedData = sorting.QuickSort(temp3);
			 endTime = System.nanoTime();
			 time = (endTime - startTime);
		 	 sort.setQuickTime(time);
		 	 
		 	int[] temp5 = temp4.clone();
			 startTime = System.nanoTime();
			 sortedData = sorting.HeapSort(temp4);
			 endTime = System.nanoTime();
			 time = (endTime - startTime);
		 	 sort.setHeapTime(time);
		 	 
			 startTime = System.nanoTime();
			 sortedData = sorting.QuickSort3Median(temp5);
			 endTime = System.nanoTime();
			 time = (endTime - startTime);
		 	 sort.setQuickMedianTime(time);
		 
		}
		return sort;
	}

	@RequestMapping("/random")
	public ModelAndView randomNumberGenerator(HttpServletRequest request,HttpServletResponse response)
	{
		int lowerLimit = Integer.parseInt(request.getParameter("lowerLimit"));
		int upperLimit = Integer.parseInt(request.getParameter("upperLimit"));
		int size = Integer.parseInt(request.getParameter("dataSize"));
		StringBuffer s = new StringBuffer();
		Random rd = new Random(); // creating Random object
	      int[] arr = new int[size];
	      for (int i = 0; i < size; i++) {
	         arr[i] = rd.nextInt((upperLimit - lowerLimit) + 1) + lowerLimit; 
	         if(i==size-1) {
	        	 s.append(arr[i]);
	         }
	         else
	         {
	        	 s.append(arr[i] + ",");
	         }
	      }
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home.jsp");
		mv.addObject("randomData",s);

		return mv;

	}
	
	@RequestMapping("home")
	public String home() {
		System.out.println("running home");
		return "home.jsp";
	}
}
