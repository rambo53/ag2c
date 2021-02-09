
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/application.js"></script>
        <title>calculs</title>
        <link rel="stylesheet" type="text/css" href="style/calculsToiture.css" /> 
       
    </head>
    <body>
        <h1><u>Calculs.</u></h1><br>
        
        <p id="toiture"><img src="images/toiture.jpg"></p><br>
        
         <form action="calculs" method="GET">
             Nom/numero versant : <input type="text" class="champ" name="nomVersant"><br><br>
             
            Type de toiture :<br>
            <input type="radio" name="forme" value="rectangle"> rectangle<br>
            <input type="radio" name="forme" value="triangle"> triangle<br>
            <input type="radio" name="forme" value="quatreVersants"> quatre versants<br><br>
            
            <label>Longueur rampant (en mètres) : </label> <input type="text" class="champ" name="rampant"><br>
            <label>Longueur facade (en mètres) :  </label> <input type="text" class="champ" name="facade"><br>
            <label>Longueur faitage (en mètres) : </label> <input type="text" class="champ" name="faitage" value="0"><br><br>
            
            <label>Nombre de velux : </label> <input type="text" class="champ" name="nbVelux" value="0"><br>
            <label>Hauteur velux (en mètres) : </label> <input type="text" class="champ" name="hauteurVelux" value="0"><br>
            <label>Largeur velux (en mètres) : </label> <input type="text" class="champ" name="largeurVelux" value="0"><br><br>
  
            
            <label>Hauteur ardoise (en cm) :  </label> <input type="text" class="champ" name="hauteurArdoise"><br>
            <label>Largeur ardoise (en cm) :  </label> <input type="text" class="champ" name="largeurArdoise"><br>
            <label>Longueur crochet (en cm) : </label> <input type="text" class="champ" name="longueurCrochet"><br>
            <label>Diametre crochet (en cm) : </label> <input type="text" class="champ" name="diametreCrochet"><br><br>
            
            Il y aura t'il de la volige :<br>
            <input type="radio" name="volige" value="oui"> oui<br>
            <input type="radio" name="volige" value="non"> non<br>
            
            <br><input type="reset" id="efface" value="Effacer champs"> 
        </form>
        
        <form action="total" method="GET">
            <input type="submit" id="total" value="Total chantier">
        </form>
        <input type="button" id="calculs" value="Calculs"> 
        <h2></h2>
    </body>
</html>
