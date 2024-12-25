<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>会員追加</title>
</head>
<body>
    <h1>会員追加フォーム</h1>
    <form action="AddMemberServlet" method="post">
        <label for="id">会員ID:</label>
        <input type="text" id="id" name="id" maxlength="6" required><br>
        
        <label for="name">氏名:</label>
        <input type="text" id="name" name="name" maxlength="50" required><br>
        
        <label for="phone">電話番号:</label>
        <input type="text" id="phone" name="phone" maxlength="13" required><br>
        
        <button type="submit">追加</button>
    </form>
</body>
</html>
