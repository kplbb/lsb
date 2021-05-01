<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
.pagination {
	background-color: white;
	color: black;
	text-align: center; 
	justify-items:center;
	}
</style>
<div>
	<ul class="pagination">
	
		<c:if test="${pageMaker.prev}">
			<li class="paginate_button previous">
				<a href="LsbServlet?command=admin_product_list${pageMaker.makeQuery(pageMaker.startPage-1)}">[previous]</a> <!-- admin_product_list -->
			</li>
		</c:if>
				
		<!-- [1][2][3]... 표시 부분 -->
		<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="index">
			<a style="text-align: center; justify-items:center;" href="LsbServlet?command=admin_product_list${pageMaker.makeQuery(index)}">[${index}]</a>
		</c:forEach>
		
		<c:if test="${pageMaker.next}">
			<li class="paginate_button next">
				<a href="LsbServlet?command=admin_product_list${pageMaker.makeQuery(pageMaker.endPage+1)}">[next]</a> <!-- admin_product_list -->
			</li>
		</c:if>	
			
	</ul>
</div>




