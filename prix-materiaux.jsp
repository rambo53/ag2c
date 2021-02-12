
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style/calculsToiture.css" /> 
        <title>prix matériaux</title>
    </head>
    <body>
        <h1><u>Prix matériaux</u></h1><br>
        
        <form action="modification" id="modif" method="GET">
            <label class="label">Nom :</label><input type="text" name="nom"><br>
            <label class="label">Prix :</label><input type="text" name="prix"><br>
            <label class="label">Stock :</label><input type="text" name="stock"><br>
            <input class="label" type="button" value="Enregistrer">
        </form>
        
        <h4><u>Liste matériaux enregistrés :</u></h4><br>
        
        <c:forEach var="materiaux" items="${liste}">
            ${materiaux.nom} ${materiaux.prix} ${materiaux.stock}
        </c:forEach>
        
        
    </body>
</html>
