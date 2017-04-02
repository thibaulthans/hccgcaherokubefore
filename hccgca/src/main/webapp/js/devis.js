window.onload=function(){

document.getElementById("valider").onclick = function() {formulaireDevis()};
document.getElementById("email").onkeypress = function() {formulaireDevisMail()};
document.getElementById("nom").onkeypress = function() {formulaireDevisNom()};
document.getElementById("prenom").onkeypress = function() {formulaireDevisPrenom()};
document.getElementById("montantfacture").oninput = function() {montantdirect()};


//**********************************************
function formulaireDevis(){

   champMail=document.formulairedevis.inputemail.value;
   champPrenom=document.formulairedevis.inputprenom.value;
   champNom=document.formulairedevis.inputnom.value;
   champMontant=document.formulairedevis.inputmontant.value;

   bol1=false;
   bol2=false;
   bol3=false;

  for(var j=1;j<(champMail.length);j++){
    if(champMail.charAt(j)=="@"){
       bol1=true;
    }
   }

   for(var k=1;k<(champMail.length);k++){
     if(champMail.charAt(k)=="."){
        bol2=true;
     }
    }

     if(champMail.length >5 ){
          bol3=true;
      }

    if(bol1==true && bol2==true && bol3==true) {
        document.getElementById("email").className = "form-control";
    }
    else{
      document.getElementById("email").className += " input_error";
      document.getElementById("email").value="Veuillez renseigner un mail valide";
    }

      if(champPrenom.length >=2 && champPrenom!=="Champ invalide"){
           document.getElementById("prenom").className="form-control";
           bol4=true;
       }
       else{
         document.getElementById("prenom").className += " input_error";
         document.getElementById("prenom").value="Champ invalide";
         bol4=false;
       }

       if(champNom.length >=2 && champNom!=="Champ invalide"){
           document.getElementById("nom").className = "form-control";
            bol5=true;
        }
        else{
          document.getElementById("nom").className += " input_error";
          document.getElementById("nom").value="Champ invalide";
          bol5=false;
        }

     if(document.formulairedevis.select_secteur_activite.selectedIndex==0){
       bol6=false;
       document.getElementById("select_un").className += " input_error";
       document.getElementById("select_un").options[0].innerHTML="Sélectionnez un secteur d'activité"
     }
     else{
       bol6=true;
       document.getElementById("select_un").className = "form-control";
       document.getElementById("select_un").options[0].innerHTML="Secteur d'activité"
     }

     if(document.formulairedevis.select_chiffre_affaire.selectedIndex==0){
       bol7=false;
       document.getElementById("select_deux").className += " input_error";
       document.getElementById("select_deux").options[0].innerHTML="Sélectionnez un chiffre d'affaire"
     }
     else{
       bol7=true;
       document.getElementById("select_deux").className = "form-control";
       document.getElementById("select_deux").options[0].innerHTML="Chiffre d'affaire"
     }

     if(document.formulairedevis.select_nb_salarie.selectedIndex==0){
       bol8=false;
       document.getElementById("select_trois").className += " input_error";
       document.getElementById("select_trois").options[0].innerHTML="Sélectionnez un nombre de salarie"
     }
     else{
       bol8=true;
       document.getElementById("select_trois").className = "form-control";
       document.getElementById("select_trois").options[0].innerHTML="Nombre de salarié"
     }

     if(document.formulairedevis.select_mission.selectedIndex==0){
       bol9=false;
       document.getElementById("select_quatre").className += " input_error";
       document.getElementById("select_quatre").options[0].innerHTML="Sélectionnez une mission"
     }
     else{
       bol9=true;
       document.getElementById("select_quatre").className = "form-control";
       document.getElementById("select_quatre").options[0].innerHTML="Mission"
     }

     if(champMontant >500 && champMontant<200000 && champMontant!=="Champ invalide"){
         document.getElementById("montantfacture").className = "form-control";
          bol10=true;
      }
      else{
        document.getElementById("montantfacture").className += " input_error";
        document.getElementById("montantfacture").value="Champ invalide";
        bol10=false;
      }


      if(bol1 && bol2 && bol3 && bol4 && bol5 && bol6 && bol7 && bol8 && bol9 && bol10){
        bolfinal=true;
        document.formulairedevis.submit();
        console.log("true");
      }
      else{
        bolfinal=false;
        console.log("false");
        document.getElementById("reponse_formulaire").textContent="Texte";
      }
     return bolfinal;
}

}



//***********Contrôle mail*************

function formulaireDevisMail(){

  bolun=false;
  boldeux=false;

  champMail=document.formulairedevis.inputemail.value;
 for(var j=1;j<(champMail.length);j++){
   if(champMail.charAt(j)=="@"){
      bolun=true;
   }
  }

  for(var k=1;k<(champMail.length);k++){
    if(champMail.charAt(k)=="."){
       boldeux=true;
    }
   }

    if(champMail.length >5 ){
         boltrois=true;
     }

   if(bolun==true && boldeux==true && boltrois==true) {
       document.getElementById("email").className = "form-control";
   }

}

//************Contrôle nom***************

function formulaireDevisNom(){

  champNom=document.formulairedevis.inputnom.value;

  if(champNom.length >=1 && champNom!=="Champ invalide"){
      document.getElementById("nom").className = "form-control";
   }

}

//***********Contrôle prenom**************

function formulaireDevisPrenom(){

  champPrenom=document.formulairedevis.inputprenom.value;

  if(champPrenom.length >=1 && champPrenom!=="Champ invalide"){
       document.getElementById("prenom").className="form-control";
   }

}

//*************************************************************************************

document.querySelector('select[name="select_secteur_activite"]').onchange = function() {selectactivite()};


function selectactivite(){
   if(document.getElementById("valider").onclick){
    if(document.formulairedevis.select_secteur_activite.selectedIndex!=0){
      document.getElementById("select_un").className = "form-control";
  }
}
}

//******************************************************************************************

document.querySelector('select[name="select_chiffre_affaire"]').onchange = function() {selectchiffreaffaire()};


function selectchiffreaffaire(){
   if(document.getElementById("valider").onclick){
    if(document.formulairedevis.select_chiffre_affaire.selectedIndex!=0){
      document.getElementById("select_deux").className = "form-control";
  }
}
}

//***************************************************************************************

document.querySelector('select[name="select_nb_salarie"]').onchange = function() {selectnbsalarie()};


function selectnbsalarie(){
   if(document.getElementById("valider").onclick){
    if(document.formulairedevis.select_nb_salarie.selectedIndex!=0){
      document.getElementById("select_trois").className = "form-control";
  }
}
}

//*******************************************************************************************

document.querySelector('select[name="select_mission"]').onchange = function() {selectmission()};


function selectmission(){
   if(document.getElementById("valider").onclick){
    if(document.formulairedevis.select_mission.selectedIndex!=0){
      document.getElementById("select_quatre").className = "form-control";
  }
}
}

//**************************************************************

function montantdirect(){
  console.log("a");
    champMontant=document.formulairedevis.inputmontant.value;
   if(document.getElementById("valider").onclick){
       console.log("b");
    if(champMontant >500 && champMontant<200000 && champMontant!=="Champ invalide"){
        console.log("c");
      document.getElementById("montantfacture").className = "form-control";
  }
}
}
