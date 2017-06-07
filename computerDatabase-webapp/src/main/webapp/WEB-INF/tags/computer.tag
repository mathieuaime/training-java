<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ tag language="java" pageEncoding="ISO-8859-1"%>

<%@ attribute name="computer" required="true"
	type="com.excilys.computerdatabase.models.Computer"%>
	
<%@ attribute name="isAdmin" required="true"
	type="java.lang.Boolean"%>

<tr>
	<c:if test="${isAdmin}">
		<td class="editMode"><input type="checkbox" name="cb" class="cb"
			value="${computer.id}"></td>
	</c:if>
	<td><a href="editComputer?id=${computer.id}" onclick="">${computer.name}</a></td>
	<td>${computer.introduced}</td>
	<td>${computer.discontinued}</td>
	<td>${computer.company.name}</td>
</tr>