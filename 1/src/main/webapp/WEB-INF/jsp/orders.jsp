<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>orders</title>
</head>

<script type="text/javascript" src="js/jquery-1.7.2.min.js" > </script>

<script type="text/javascript">
	$(document).ready(function() {
		$(".FH_button").click(function() {
			var id = $(this).attr("data-id");
			var url = 'send.htm';
			$.post(url, $("#Form_" + id).serialize(), function(data) {
				$("#div_" + id).text(data);
			});
		});
	});

</script>


<body>
	<table>
		<c:forEach items="${orders}" var="order" varStatus="status">
			<tr>
				<td>${order.oid}</td>
				<td>
					<form id="Form_${status.index}">
						<input type="hidden" name="tid" id="tid" value="${order.oid}"/>
						<input type="text" name="outId" />
						<input type="button" name="${status.index}Button" class="FH_button" data-id="${status.index}" value="发货"/>
					</form>
				</td>
				<td><div id="div_${status.index}"></div>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
