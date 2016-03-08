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

<!-- Listing grid -->

<display:table pagesize="5" class="displaytag" keepStatus="true"
	name="paises" requestURI="${requestURI}" id="row">
	
	<!-- Action links -->

	<security:authorize access="hasRole('ADMIN')">
		<display:column>
			<a href="paise/administrator/edit.do?paiseId=${row.id}">
				<spring:message	code="paise.edit" />
			</a>
		</display:column>		
	</security:authorize>


	
	<!-- Attributes -->
	
	<spring:message code="paise.title" var="nameHeader" />
	<display:column property="title" title="${nameHeader}" sortable="true" />

	<spring:message code="paise.description" var="descriptionHeader" />
	<display:column property="description" title="${descriptionHeader}" sortable="false"  />
	<spring:message code="paise.money" var="moneyHeader" />
	<display:column property="money" title="${moneyHeader}" sortable="false"  />
	<spring:message code="paise.date" var="dateHeader" />
	<display:column property="date" title="${dateHeader}" sortable="false"  />
	<spring:message code="paise.used" var="usedHeader" />
	<display:column property="used" title="${usedHeader}" sortable="false"  />

</display:table>

<!-- Action links -->

<security:authorize access="hasRole('ADMIN')">
	<div>
		<a href="paise/administrator/create.do"> <spring:message
				code="paise.create" />
		</a>
	</div>
</security:authorize>
