<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Item service</title>
</head>
<body>
<div align="center">
  <h2>Item Manager</h2>
  <h3><a href="addItem">Add item</a></h3>
  <table border="1" cellpadding="5">
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Count</th>
      <th>Action</th>
    </tr>
    <c:forEach items="${itemList}" var="item">
      <tr>
        <td>${item.id}</td>
        <td>${item.name}</td>
        <td>${item.count}</td>
        <td>
          <a href="edit?id=${item.id}">Edit</a>
          &nbsp;&nbsp;&nbsp;
          <a href="delete?id=${item.id}">Delete</a>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>



</body>
</html>