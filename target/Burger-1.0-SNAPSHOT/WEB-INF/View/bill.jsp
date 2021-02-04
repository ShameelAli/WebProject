<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="springg" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
<%@ page pageEncoding="utf-8"%>

<html>
<body bgcolor="white">

<style>
h1 {
  background-color: black;
  color: white;
}
h2{
background-color:black;
color: white;
}
</style>
<style>
<style=display:inline>
h3 {text-align: left;}
h1 {text-align: center;}
div {text-align: center;}
h4 {text-align:right;}
b {text-align: left;}
</style>

<h1><u>Burger Point</u></h1>
<h2><u>Customer Inovice<u></h2>

<h3>Customer Name  <div> ${BuyerName} </h3>
<h3>Burger Chosen <div> ${BurgerChosen}</h3>
<h3>Burger's cost  <div> &#8377 ${sum}</h3>

<h3>Topping Customization <div> ${ToppingCustomization}</h3>
<h3>topping Cost <div> &#8377  ${toppingAdded}</h3>

<h3>Size <div> ${size}</h3>

<h1><b>Grand Total</b>  &#8377 ${GrandTotal}</h1>
<h4><button> Print Receipt</button></h4>


</html>