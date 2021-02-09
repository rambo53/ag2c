<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style/calculsToiture.css" />
        <title>total</title>
    </head>
    <body>
        <c:if test="${surfaceTotal!=null}">
        <h1><u>Total chantier : </u></h1><br>
        
        La surface totale à couvrir pour le chantier est de <b style="color:red">${surfaceTotal}</b> m2.<br>
        Il faudra <b style="color:red">${nbArdoisesTotal}</b> ardoises au total pour le chantier.<br>
        Il faudra <b style="color:red">${metreLiteauTotal}</b> mètres de liteau au total pour le chantier.<br>
        <c:if test="${metreVoligeTotal!=0}">Il faudra <b style="color:red">${metreVoligeTotal}</b> mètres de volige pour le chantier.<br></c:if>
        Il faudra prévoir <b style="color:red">${joursDeChantierTotal}</b> jours de chantier.<br><br>
        
        <h4><u>Coût chantier :</u></h4><br>
        Le chantier coûtera <b style="color:red">${coutTotalArdoises}</b> €HT en ardoises.<br>
        <c:if test="${metreVoligeTotal!=0}">Le chantier coûtera <b style="color:red">${coutTotalVolige}</b> €HT en volige.<br></c:if>
        Le chantier coûtera <b style="color:red">${coutTotalLiteau}</b> €HT en liteau.<br>
        Le chantier coûtera <b style="color:red">${coutTotalCarburant}</b> €HT en carburants.<br>
        Le chantier coûtera <b style="color:red">${coutTotalHoraire}</b> €HT en main d'oeuvre.<br>
        Le chantier coûtera <b style="color:red">${coutTotalRepas}</b> €HT en repas.<br><br>
        
        Le chantier coûtera au total <b style="color:red">${coutTotalChantier}</b> €HT.<br><br>
        
        On facturera <b style="color:red">${coutArdoiseMarge}</b> €HT en ardoises au client.<br>
        <c:if test="${metreVoligeTotal!=0}">On facturera <b style="color:red">${coutVoligeMarge}</b> €HT en volige au client.<br></c:if>
        On facturera <b style="color:red">${coutLiteauMarge}</b> €HT en liteau au client.<br>
        
        
        </c:if>
        
        <c:if test="${surfaceTotal==null}"><h1>Veuillez d'abord enregistrer un versant.</h1></c:if>
        
    </body>
</html>
