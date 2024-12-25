<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>タイトル追加フォーム</title>
</head>
<body>
    <h1>タイトル追加フォーム</h1>
    <form action="AddTitleServlet" method="post">
        <label for="id">タイトルID:</label>
        <input type="text" id="id" name="id" maxlength="7" required><br>
        
        <label for="title">タイトル:</label>
        <input type="text" id="title" name="title" maxlength="100" required><br>
        
        <label for="genre">ジャンル:</label>
        <input type="text" id="genre" name="genre" maxlength="50" required><br>
        
        <label for="mediaType">メディアタイプ:</label>
        <input type="text" id="mediaType" name="mediaType" maxlength="5" required><br>
        
        <label for="newFlag">新作フラグ:</label>
        <input type="checkbox" id="newFlag" name="newFlag" value="true"><br>
        
        <button type="submit">追加</button>
    </form>
</body>
</html>
