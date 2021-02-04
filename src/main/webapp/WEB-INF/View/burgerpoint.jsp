
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>


<style>

body {
 background-image: url("img/img.jpg");
 background-size:cover;
}
h1 {text-align: center;}


p{text-align: center;}
t{vertical-align:right}
div {vertical-align: middle;}

</style>
<body>

<form:form modelAttribute="customer" method="post" class="form-horizontal" action="/Burger/checkb.com" >

<h1><b><u><i> Place Your Order at Burger Point.</i></u></b></h1>
<b><form:errors path="firstname" style="color:Red;" bgcolor="#b0c4de"></form:errors></b>
<h3>
</b><label><u>Customer Name</label></u>  <b><input type = "text" style="border:2px solid Tomato;"  name = "firstname"></b>
</h3>

<b><form:errors path="burger" style="color:Red;" bgcolor="#b0c4de"></form:errors></b>
<h2><u><label>Pick your favorite Burger</label></u></h2>

<h3>
<div>
    <label><b>FishBurger</label><t><p><b> Rs 60  <input type="checkbox" id="fishburger" name="burger" value="60"></b></p></t>

    <label>ChickenBurger</label><p><b>Rs 50 <input type="checkbox" id="chickenburger" name="burger" value="50"></b></p>

    <label>ClassicBurger</label><p><b>Rs 100 <input type="checkbox" id="classicburger" name="burger" value="100"></b></p>

    <label>DoubleBurger</label><p><b>Rs 150 <input type="checkbox" id="doubleburger" name="burger" value="150"></b></p>

    <label><b>Fries</label></b><p><b>Rs 40 <input type="checkbox" id="fries" name="burger" value="40"></b></p>

</div>
</h3>
<b><form:errors path="customization" style="color:Red;" bgcolor="#b0c4de"></form:errors></b>
<h3><u><label>Customizations if any</label></u></h3>

    <label>NO Onion</label><input type="checkbox" id="noonion" name="customization" value="No-Onion">
    <label>With Cheez</label><input type="checkbox" id="withcheez" name="customization" value="Extra Cheez">
    <label>Mayonese</label><input type="checkbox" id="Mayonese" name="customization" value="Mayonese">
    <label>NO Ketchup</label><input type="checkbox" id="noketchup" name="customization" value="Ketchup">
    <label>NO Tomato</label><input type="checkbox" id="notomato" name="customization" value="No Tomato">
    <label>Pickle</label><input type="checkbox" id="pickle" name="customization" value="Added Pickle"><br>


<h3><u>Select Size</u></h3>
<b><form:errors path="burgerSize" style="color:Red;" bgcolor="#b0c4de"></form:errors></b>
    <label>Regular</label><input type="radio" id="regular" name="burgerSize" value="Regular">
    <br>
    <br>
    <label>Large + &#8377 30</label><input type="radio" id="large" name="burgerSize" value="Large">

<h1><input type="submit" value="Place Order"></h1>




</body>
</form:form>
</html>