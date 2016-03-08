<%--
 * action-1.jsp
 *
 * Copyright (C) 2013 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<form:form action="consumer/administrator/assign.do" modelAttribute="consumer">
    <form:hidden path="id"/>
    <form:hidden path="version"/>
    <form:hidden path="userAccount"/>
	<form:hidden path="name"/>
	<form:hidden path="surname"/>
	<form:hidden path="email"/>
	<form:hidden path="phone"/>
	<form:hidden path="shoppingCart"/>
	<form:hidden path="order"/>
	<form:hidden path="comment"/>
	<form:hidden path="customization"/>
	<form:label path="paises">
		<spring:message code="consumer.paise" />:
	</form:label>
	<form:select id="paises2" path="paises">
		<form:option value="0" label="----" />		
		<form:options items="${paises2}" itemValue="id" itemLabel="title" />
	</form:select>
	<form:errors cssClass="error" path="paises" />
	<br />
	
		<input type="submit" name="save"
			value="<spring:message code="consumer.assign" />"
			onclick="return confirm('<spring:message code="consumer.confirm.assign" />')" />&nbsp;
	
	<a href="">
	<input type="button" name="cancel"
		value="<spring:message code="category.cancel" />"
		onclick="javascript: relativeRedir('Acme-Supermarket');" /></a>
	
	

</form:form>
	
	