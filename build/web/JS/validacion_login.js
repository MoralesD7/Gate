// Obtención de los elementos
const form = document.getElementById('Formulario');
const nombre = document.getElementById('nombre');
const apellido = document.getElementById('apellido');
const email = document.getElementById('email');
const contraseña = document.getElementById('contraseña');
const matricula = document.getElementById('matricula');

// Expresiones regulares
const regex_nombre = /^[A-ZÁÉÍÓÚÑ][a-záéíóúñ]{1,19}$/;
const regex_apellido = /^[A-ZÁÉÍÓÚÑ][a-záéíóúñ]{1,19}$/;
const regex_email = /^[a-z0-9]{1,20}@[a-zA-Z0-9-]+(\.[a-zA-Z]{2,})+$/;
const regex_contraseña = /^[A-ZÁÉÍÓÚÑ][a-záéíóúñ]{7,19}$/;
const regex_matricula = /^[0-9]{10}$/;

validar_nombre =()=> {
    if (regex_nombre.test(nombre.value)) {
        nombre_js.innerHTML = "";
    } else {
        nombre_js.innerHTML = "Tu nombre necesita empezar almenos con una masyucula y minimo 2 letras";
    }
 }
 validar_apellido =()=> {
    if (regex_apellido.test(apellido.value)) {
        apellido_js.innerHTML = "";
    } else {
        apellido_js.innerHTML = "Tu apellido necesita empezar almenos con una masyucula y minimo 2 letras";
    }
 }
 validar_email=()=>{
     if(regex_email.test(email.value)){
         email_js.innerHTML="";
     }else{
         email_js.innerHTML="Digita un email valido";
     }
 }
  validar_contraseña=()=>{
     if(regex_contraseña.test(contraseña.value)){
         contraseña_js.innerHTML="";
     }else{
         contraseña_js.innerHTML="La contraseña debe iniciar con mayuscula y tiene que ser minimo de 8 letras";
     }
 }
 validar_matricula =()=> {
    if (regex_matricula.test(matricula.value)) {
        matricula_js.innerHTML = "";
    } else {
        matricula_js.innerHTML = "Tu matricula tiene que tener 10 numeros";
    }
 }


nombre.addEventListener("input", validar_nombre);
apellido.addEventListener("input",validar_apellido);
email.addEventListener("input",validar_email);
contraseña.addEventListener("input",validar_contraseña);
matricula.addEventListener("input",validar_matricula);


