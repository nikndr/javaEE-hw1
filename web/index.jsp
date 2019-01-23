<%--
  Created by IntelliJ IDEA.
  User: nickmargal
  Date: 2019-01-22
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>${title}</title>
  <style>
    body {font-family: Arial, Helvetica, sans-serif;}
    form {border: 3px solid #f1f1f1;}

    input[type=text], input[type=password] {
      width: 100%;
      padding: 12px 20px;
      margin: 8px 0;
      display: inline-block;
      border: 1px solid #ccc;
      box-sizing: border-box;
    }

    button {
      background-color: #4CAF50;
      color: white;
      padding: 14px 20px;
      margin: 8px 0;
      border: none;
      cursor: pointer;
      width: 100%;
    }

    button:hover {
      opacity: 0.8;
    }


    .container {
      padding: 16px;
    }

    span.psw {
      float: right;
      padding-top: 16px;
    }

  </style>
</head>
<body>

<h2>${data}</h2>

<form action="/check" method="post">

  <div class="container">
    <label for="username"><b>Username</b></label>
    <input id="username" type="text" placeholder="Enter Username" name="login" required>

    <label for="password"><b>Password</b></label>
    <input id="password" type="password" placeholder="Enter Password" name="password" required>

    <button type="submit">Login</button>

  </div>
</form>

</body>
</html>


