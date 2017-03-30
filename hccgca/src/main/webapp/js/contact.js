window.onload=function(){

document.getElementById("valider").onclick = function() {formulaireContact()};

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



    if(champEcrire.length < 20){
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
      }
      else{
        bolfinal=false;
      }
     return bolfinal;
}


}
