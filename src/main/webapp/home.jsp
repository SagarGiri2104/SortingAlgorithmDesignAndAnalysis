 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<div style="background-color:#2c350;padding:15px;text-align:center;">
  <h1>DAA Project 1: Sorting</h1>
</div>

 <div class="main">
  <h2>Generate the random data for sorting</h2>
  <form action="random">
<label>Lower Limit</label>
	<input type="text" name = "lowerLimit"><br>
<label>Upper Limit</label>
	<input type="text" name = "upperLimit"><br>
	<label>Data size</label>
	<input type="text" name = "dataSize"><br>
		
		<input type="submit" value="Generate Data"> <br>
		
		Data is: <%= request.getAttribute("randomData") %>
	
</form>
    <h2>Enter data to sort:</h2>
<form action="demo">
<label>Enter values to be sorted</label>
	<input type="text" name = "data"><br>
<label>Choose the sort type</label><br>
				<input type="radio" name = "type" value="bubble">Bubble Sort</input><br>
				<input type="radio" name = "type" value="selection">Selection Sort</input><br>
				<input type="radio" name = "type" value="merge">Merge Sort</input><br>
				<input type="radio" name = "type" value="regularQuick">Regular Quick Sort</input><br>
				<input type="radio" name = "type" value="medianQuick">3 median Quick Sort</input><br>
				<input type="radio" name = "type" value="insertion">Insertion Sort</input><br>
				<input type="radio" name = "type" value="heap">Heap Sort</input><br>
				<input type="radio" name = "type" value="all">All Sorts</input><br>
		
		<input type="submit" value="Sort">
	
</form>
  </div>

</body>
</html>