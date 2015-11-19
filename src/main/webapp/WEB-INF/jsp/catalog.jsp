<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<head><title>Catalog</title>
</head>
<body>


<div id="table">
        <H3>Catalog</H3>
       <p> <a href='<c:url value="/upload"/>'> Upload file</a>     </p>
       <p> <a href='<c:url value="/downloading"/>' download> Download file</a>  </p>
    <table cellpadding="0" cellspacing="0" border="1" align="left" height="20%">
            <tr>
                <td width="100"><b>Title</b></td>
                <td width="100"><b>Artist</b></td>
                <td width="100"><b>Country</b></td>
                <td width="100"><b>Company</b></td>
                <td width="100"><b>Price</b></td>
                <td width="100"><b>Year</b></td>
            </tr>
     <c:forEach var="p" items="${cd}">
                      <tr>
                          <td><c:out value="${p.title}"/></td>
                          <td><c:out value="${p.artist}"/></td>
                          <td><c:out value="${p.country}"/></td>
                          <td><c:out value="${p.company}"/></td>
                          <td><c:out value="${p.price}"/></td>
                          <td><c:out value="${p.year}"/></td>
                      </tr>
        </c:forEach>
</table>
</div>
</body>
</html>