<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">    
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Back office</title>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<link href="cssbackoffice/bootstrap.min.css" rel="stylesheet">
  <link href="cssbackoffice/baseback.css" rel="stylesheet">
  <link href="@{cssbackoffice/connexion.css" rel="stylesheet">
</script>
</head>

<body class="style_body">

  <div class="containeur">
    <section>
      <form name="formulaireconnexion" action="connexion">
        <h4 class="center_horizontal">Connexiona</h4>
        <input type="text" class="form-control " name="identifiant" placeholder="Identifiant">
        <input type="password" class="form-control" name="password" placeholder="Mot de passe">
        <div class="row center_horizontal">
          <div class="btn-group">
              <input class="btn btn-primary button_pers_small center_horizontal" value="test" type="submit">
          </div>
        </div>
      </form>
    </section>
  </div>


  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="js/bootstrap.min.js"></script>



</body>
</html>
 