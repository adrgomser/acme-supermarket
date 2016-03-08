<%--
 * edit.jsp
 *
 * Copyright (C) 2014 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<form:form action="paise/administrator/edit.do" modelAttribute="paise">

	
	<jstl:if test="${paise.id != 0}">
	<form:hidden path="id" />
	<form:hidden path="version" />
	</jstl:if>
	
	<form:hidden path="code" />
	<form:label path="title">
		<spring:message code="paise.title" />:
	</form:label>
	<form:input path="title" />
	<form:errors cssClass="error" path="title" />
	<br />

	
	<form:label path="description">
		<spring:message code="paise.description" />:
	</form:label>
	<form:input path="description" />
	<form:errors cssClass="error" path="description" />
	<br />
	<form:label path="money">
		<spring:message code="paise.money" />:
	</form:label>
	<form:input path="money" />
	<form:errors cssClass="error" path="money" />
	<br />
	<form:label path="date">
		<spring:message code="paise.date" />:
	</form:label>
	<form:input path="date" />
	<form:errors cssClass="error" path="date" />
	<br />
	<form:hidden path="used" />
	<form:hidden path="assigned" />
	
	
	

	
	
	<jstl:if test="${paise.id== 0}">
		<input type="submit" name="save"
			value="<spring:message code="paise.create" />"
			onclick="return confirm('<spring:message code="paise.confirm.create" />')" />&nbsp;
	
	</jstl:if>
	<jstl:if test="${paise.id != 0}">
	<input type="submit" name="save"
		value="<spring:message code="paise.save" />" />&nbsp; 
		<input type="submit" name="delete"
			value="<spring:message code="paise.delete" />"
			onclick="return confirm('<spring:message code="paise.confirm.delete" />')" />&nbsp;
	</jstl:if>
	<a href="paise/administrator/list.do">
	<input type="button" name="cancel"
		value="<spring:message code="paise.cancel" />"
		onclick="javascript: relativeRedir('paise/administrator/list.do');" /></a>
	<br />

	

</form:form>
