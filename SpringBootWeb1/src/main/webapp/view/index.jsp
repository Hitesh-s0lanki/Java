<%@page language="java" %>

<html>
<head>
    <title>First Page</title>
    <link rel="stylesheet" href="global.css">
</head>
<body>

<form action="addAlien" method="POST" class="form-container">
    <h2 class="form-title">User Form</h2>

    <label for="input1" class="form-label">Student Id :</label>
    <input type="text" id="input1" name="aid" class="form-input">

    <label for="input2" class="form-label">Student Name:</label>
    <input type="text" id="input2" name="aname" class="form-input">

    <button type="submit" class="form-button">Submit</button>
</form>

</body>
</html>