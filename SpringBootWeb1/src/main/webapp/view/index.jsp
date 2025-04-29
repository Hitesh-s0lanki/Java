<%@page language="java" %>

<html>
<head>
    <title>First Page</title>
</head>
<body style="display: flex; justify-content: center; align-items: center; height: 100vh; background-color: #f0f0f0;">

<form action="add" method="GET" style="background: white; padding: 30px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.1);">
    <h2 style="text-align: center; margin-bottom: 20px;">User Form</h2>

    <label for="input1" style="display: block; margin-bottom: 5px; font-weight: bold;">Input 1:</label>
    <input type="text" id="input1" name="input1"
           style="width: 100%; padding: 10px; margin-bottom: 15px; border: 1px solid #ccc; border-radius: 4px;">

    <label for="input2" style="display: block; margin-bottom: 5px; font-weight: bold;">Input 2:</label>
    <input type="text" id="input2" name="input2"
           style="width: 100%; padding: 10px; margin-bottom: 20px; border: 1px solid #ccc; border-radius: 4px;">

    <button type="submit"
            style="width: 100%; padding: 10px; background-color: #4CAF50; color: white; border: none; border-radius: 4px; font-size: 16px; cursor: pointer;">
        Submit
    </button>
</form>

</body>
</html>