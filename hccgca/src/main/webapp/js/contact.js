window.onload=function(){

document.getElementById("valider").onclick = function() {formulaireContact()};
document.getElementById("email").onkeypress = function() {formulaireContactMail()};
document.getElementById("textarea").onkeypress = function() {formulaireContactText()};

function formulaireContact(){
   champMail=document.formulairecontact.inputemail.value;
   champEcrire=document.formulairecontact.inputecrire.value;

   bol1=false;
   bol2=false;
   bol3=false;

  for(var j=1;j<(champMail.length);j++){
    if(champMail.charAt(j)=="@"){
       bol1=true;
       console.log("un");
    }
   }

   for(var k=1;k<(champMail.length);k++){
     if(champMail.charAt(k)=="."){
        bol2=true;
        console.log("deux");
     }
    }

     if(champMail.length >5 ){
          bol3=true;
          console.log("trois");
      }

      if(bol1==true && bol2==true && bol3==true) {
        document.getElementById("email").className = "form-control";
        console.log("quatre");
    }
    else{
      document.getElementById("email").className += " input_error";
      document.getElementById("email").value="Veuillez renseigner un mail valide";
      console.log("cinq");
    }



    if(champEcrire.length < 30){
          document.getElementById("textarea").className += " input_error";
          bol=false;
          console.log("six");
      }
      else{
        document.getElementById("textarea").className = "form-control";
         bol=true;
         console.log("sept");
      }
      if(bol && bol1 && bol2 && bol3){
        bolfinal=true;
        document.formulairecontact.submit();
      }
      else{
        bolfinal=false;
      }
     return bolfinal;
}


}

//******************************************************

function formulaireContactMail(){

  champMail=document.formulairecontact.inputemail.value;

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

//***************************************************************

function formulaireContactText(){

  champTexte=document.formulairecontact.inputecrire.value;

  if(champTexte.length>30){
    document.getElementById("textarea").className = "form-control";
  }

}
