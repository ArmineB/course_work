<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Sony
  Date: 03/12/2017
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomePage</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<br>
<div style="text-align: center; color: #313642; font-family: Arial, Helvetica, sans-serif; font-size: 40px; font-weight: bold;">My Petrol Expenditure</div>
<br>
<div class="container">

    <table class="table table-hover">
        <thead>
        <tr>
            <th>Date</th>
            <th>Petrol Brand</th>
            <th>Mileage(in miles)</th>
            <th>Price For One Gallon</th>
            <th>Gallons quantity</th>
            <th>Cost</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${expenditureList}" var = "item">

            <tr>
                <td>${item.date}</td>
                <td>${item.brand}</td>
                <td>${item.mileage}</td>
                <td>${item.price}$</td>
                <td>${item.g_quantity}</td>
                <td>${item.cost}$</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<br>
<br>
<div style="margin-left: 100px;">
<h3 style="color: #313642">Add new record</h3>
<br>
<form action="/add" method="post">
    <div class="form-group">
    <label for="exampleInputEmail1">Date</label>
    <input style="width:200px !important ;" type="text" class="form-control" id="exampleInputEmail1"  placeholder="Enter Date" name="date">
</div>
    <div class="form-group">
        <label for="exampleInputPassword1">Brand</label>
        <input style="width:200px !important ;"  type="text" class="form-control" id="exampleInputPassword1" placeholder="Enter brand" name="brand">
    </div>
    <div class="form-group">
        <label for="exampleInputEmail1">Mileage</label>
        <input style="width:200px !important ;"  type="text" class="form-control" id="mileage"  placeholder="Enter mileage" name="mileage">
    </div>
    <div class="form-group">
        <label for="exampleInputEmail1">Gallon's Quantity</label>
        <input style="width:200px !important ;"  type="text" class="form-control" id="quantity"  placeholder="Enter gallon's quantity" name="quantity">
    </div>
    <div class="form-group">
        <label for="exampleInputEmail1">Price</label>
        <input  style="width:200px !important ;" type="text" class="form-control" id="price"  placeholder="Enter price($)" name="price">
    </div>
    <div class="form-group">
        <label for="exampleInputEmail1">Cost</label>
        <input style="width:200px !important ;"  type="text" class="form-control" id="cost" placeholder="Enter cost($)" name="cost">
    </div>
    <button type="submit" class="btn btn-primary">Add</button>
    <br>
    <br>
</form>

    <h3 style="color: #313642">Compute mileage between gas stations on following dates</h3>
    <br>
<form action="/milBetween" method="post">
    <div class="form-group">
        <label for="exampleInputEmail1">Initial Date</label>
        <input style="width:200px !important ;"  type="text" class="form-control" id="date1"  placeholder="Enter Initial Date" name="date1">
    </div>
    <div class="form-group">
        <label for="exampleInputEmail1">Final Date</label>
        <input style="width:200px !important ;"  type="text" class="form-control" id="date2"  placeholder="Enter Final Date" name="date2">
    </div>
    <button type="submit" class="btn btn-primary">Compute</button>
    <br>
</form>
<br>
    <h3 style="color: #313642">Compute mileage per gallon</h3>
    <br>
    <form action="/milPerGal" method="post">
        <div class="form-group">
            <label for="exampleInputEmail1">Petrol brand</label>
            <input style="width:200px !important ;"  type="text" class="form-control" id="petBrand"  placeholder="Enter Brand" name="petBrand">
        </div>

        <button type="submit" class="btn btn-primary">Compute</button>
        <br>
    </form>

    <br>
    <h3 style="color: #313642">Compute cost mileage per mile</h3>
    <br>
    <form action="/costPerMile" method="post">
        <div class="form-group">
            <label for="exampleInputEmail1">Petrol brand</label>
            <input style="width:200px !important ;"  type="text" class="form-control" id="petBrand2"  placeholder="Enter Brand" name="petBrand2">
        </div>

        <button type="submit" class="btn btn-primary">Compute</button>
        <br>
    </form>

    <br>
    <h3 style="color: #313642">Compute one day cost</h3>
    <br>
    <form action="/oneDayCost" method="post">
        <div class="form-group">
            <label for="exampleInputEmail1">Date</label>
            <input style="width:200px !important ;"  type="text" class="form-control" id="date3"  placeholder="Enter Date" name="date3">
        </div>

        <button type="submit" class="btn btn-primary">Compute</button>
        <br>
    </form>

    <br>
    <h3 style="color: #313642">Compute time spent per gallon</h3>
    <br>
    <form action="/timeSpent" method="post">
        <div class="form-group">
            <label for="exampleInputEmail1">Brand</label>
            <input style="width:200px !important ;"  type="text" class="form-control" id="petBrand3"  placeholder="Enter Brand" name="petBrand3">
        </div>

        <button type="submit" class="btn btn-primary">Compute</button>
        <br>
    </form>
</div>
</body>
</html>
