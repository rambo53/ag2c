<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<br>
        <h4><u>Versant ${nomVersant}:</u></h4><br>
        La surface à couvrir est de <b style="color:red">${surface}</b> m2.<br>
        Le pureau est de <b style="color:red">${pureau}</b> cm.<br>
        Il y aura <b style="color:red">${nbLiteau}</b> longueurs de liteaux.<br>
        Il faudra <b style="color:red">${metreLiteau}</b> m de liteaux pour ce versant.<br>
        <c:if test="${longueurVolige!=0}">Il faudra <b style="color:red">${longueurVolige}</b> m de volige.<br></c:if> 
        Il y aura <b style="color:red">${nbArdoiseAuM2} </b> ardoises par m2.<br>
        Il faudra <b style="color:red">${nbTotalArdoise} </b> ardoises pour ce versant.<br>
        Il faudra <b style="color:red">${jourDeChantier} </b> jours de chantier pour ce versant.<br><br>
        <hr>
