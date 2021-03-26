<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="container">
		<h2>상세 페이지</h2>
		<hr>
		<form>
		<input name="bno" type="hidden" value="${detail.bno}">
		<table border="1">
			<tbody>
				<tr>
					<td>제목</td>
					<td><input name="title" type="text" value="${detail.title}"></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><input name="writer" type="text" value="${detail.writer}"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea name="content" rows="20" cols="50" >${detail.content}</textarea></td>
				</tr>
				
			</tbody>
		</table>
		<input type="submit" value="수정하기" formaction="update">
		<input type="submit" value="삭제하기" formaction="delete">
		</form>
	</div>
</body>
</html>