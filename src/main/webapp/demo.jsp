 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<% Object type =  request.getAttribute("sortType");%>
 <%  if( type != "all") { %>
   	Below is the result of <%= request.getAttribute("sortType") %> Sort <br>
	Sorted data: <%= request.getAttribute("sortedData") %><br>
	Execution Time : <%= request.getAttribute("runTime") %> nanoseconds
  <%  }
   else{%>
	    Below is the result of all sorting types<br>
		Sorted data: <%= request.getAttribute("sortedData") %><br>
		Bubble Sort Execution Time : <%= request.getAttribute("bubbleTime") %> nanoseconds <br>
		Selection Sort Execution Time : <%= request.getAttribute("selectionTime") %> nanoseconds <br>
		Insertion Sort Execution Time : <%= request.getAttribute("insertionTime") %> nanoseconds <br>
		Regular Quick Sort Execution Time : <%= request.getAttribute("quickTime") %> nanoseconds <br>
		3 Median Quick Sort Execution Time : <%= request.getAttribute("quickMedianTime") %> nanoseconds <br>
		Heap Sort Execution Time : <%= request.getAttribute("heapTime") %> nanoseconds  <br>
		Merge SortExecution Time : <%= request.getAttribute("mergeTime") %> nanoseconds <br>
   <%}%>

</body>
</html>