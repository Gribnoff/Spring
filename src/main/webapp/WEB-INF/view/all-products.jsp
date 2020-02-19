<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
    <body>
        <h1>Products list</h1>
        <table>
            <thead>
                <tr>
                    <td>ID</td>
                    <td>Title</td>
                    <td>Cost</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${products}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.title}</td>
                        <td>${item.cost}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>

