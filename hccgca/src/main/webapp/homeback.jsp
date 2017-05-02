<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">   
 <head>
    <title>Back office</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="cssbackoffice/bootstrap.min.css" rel="stylesheet">
  <link href="cssbackoffice/baseback.css" rel="stylesheet">
  <link href="cssbackoffice/homeback.css" rel="stylesheet">
</head>



<body class="style_body">

 <%
 if(session.getAttribute("utilconnect")==null){
	 response.sendRedirect("connexion.jsp");
 }
 %>


<nav class="navbar navbar-default bleu_royal_clair">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="homeback.html">Back office</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="formulaire.html">Formulaire</a></li>
        <li><a href="modification_ajouter.html">Modification</a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>


<div class="container-fluid">


       <div class="row">
       <div class="col-xs-offset-1 col-xs-10 no_padding grand_rectangle margin_top_vingt">
         <table class="table table-striped">
           <thead>
             <tr>
               <th>#</th>
               <th>Type</th>
               <th>Nom</th>
               <th>Email</th>
             </tr>
           </thead>
           <tbody>
             <tr>
               <th scope="row">1</th>
               <td>Devis</td>
               <td>Otto</td>
               <td>@mdo</td>
             </tr>
             <tr>
               <th scope="row">2</th>
               <td>contact</td>
               <td>Thornton</td>
               <td>@fat</td>
             </tr>
             <tr>
               <th scope="row">3</th>
               <td>Recrutement</td>
               <td>the Bird</td>
               <td>@twitter</td>
             </tr>
           </tbody>
         </table>
         <p class="text_center no_margin bas_rectangle">
             Derniers formulaires
         </p>
       </div>

    </div>

    <div class="row">
    <div class="col-xs-offset-1 col-xs-5 no_padding grand_rectangle margin_top_vingt">
     <div class="margin_top_vingt margin_bottom_vingt">
           <a href="#" class="btn btn-info center-block bouton_modification" role="button">Ajouter</a>
           <a href="#" class="btn btn-info center-block bouton_modification" role="button">Supprimer</a>
           <a href="#" class="btn btn-info center-block bouton_modification" role="button">Modifier</a>
      </div>
           <p class="text_center no_margin bas_rectangle">
           Modifications
           </p>
    </div>


    <div class="col-xs-offset-1 col-xs-4 no_padding grand_rectangle margin_top_vingt">
      <h2 class="text_center style_nb_visiteur">1000</h2>
      <p class="text_center no_margin bas_rectangle">
       Nombre de visiteurs
      </p>
     </div>
     <div class="col-xs-offset-1 col-xs-4 no_padding grand_rectangle margin_top_vingt">
       <a href="#" class="btn btn-info center-block bouton_modification" role="button">Documentation</a>
       <p class="text_center no_margin bas_rectangle">
        Nombre de visiteurs
       </p>
      </div>

 </div>


  </div>


  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="js/bootstrap.min.js"></script>
       <!-- Include all compiled plugins (below), or include individual files as needed -->
       <script src="js/globaljs.js"></script>



</body>
</html>
