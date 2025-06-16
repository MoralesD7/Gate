// Obtención de los elementos
const form = document.getElementById('Formulario');
const nombre = document.getElementById('nombre');
const apellido = document.getElementById('apellido');
const email = document.getElementById('email');
const contraseña = document.getElementById('password');
const matricula = document.getElementById('matricula');

// Expresiones regulares
const regex_nombre = /^[A-ZÁÉÍÓÚÑ][a-záéíóúñ]{1,9}( [A-ZÁÉÍÓÚÑ][a-záéíóúñ]{1,9})?$/;
const regex_apellido =/^[A-ZÁÉÍÓÚÑ][a-záéíóúñ]{1,9} [A-ZÁÉÍÓÚÑ][a-záéíóúñ]{1,9}$/;
const regex_email = /^[a-z0-9]{1,20}@[a-zA-Z0-9-]+(\.[a-zA-Z]{2,})+$/;
const regex_contraseña = /^[A-ZÁÉÍÓÚÑ][a-záéíóúñ]{7,19}$/;
const regex_matricula = /^[0-9]{10}$/;

let b_nombre = false ; 
let b_apellido = false ;
let b_email = false ;
let b_contraseña = false ;
let b_matricula = false ;

let valor_nombre = validar_nombre =()=> {
    if (regex_nombre.test(nombre.value)) {
        nombre_js.innerHTML = "";
        b_nombre = true ;
        return b_nombre ;
    } else {
        nombre_js.innerHTML = "Tu nombre(s) debe de iniciar en mayuscula y contener minimo 2 letras";
        b_nombre = false ;
        return b_nombre;
    }
 }
let valor_apellido =  validar_apellido =()=> {
    if (regex_apellido.test(apellido.value)) {
        apellido_js.innerHTML = "";
        b_apellido = true ;
        return b_apellido;
    } else {
        apellido_js.innerHTML = "Tus apellidos deben de iniciar en mayuscula y contener minimo 2 letras";
        b_apellido = false ;
        return b_apellido;
    }
 }
 let valor_email = validar_email=()=>{
     if(regex_email.test(email.value)){
         email_js.innerHTML="";
         b_email = true ; 
         return b_email;
     }else{
         email_js.innerHTML="Digita un email valido";
         b_email = false ; 
         return b_email;
     }
 }
 let valor_contraseña =  validar_contraseña=()=>{
     if(regex_contraseña.test(contraseña.value)){
         contraseña_js.innerHTML="";
         b_contraseña = true ;
         return b_contraseña ;
     }else{
         contraseña_js.innerHTML="La contraseña debe iniciar con mayuscula y tiene que ser minimo de 8 letras";
         b_contraseña = false ;
         return b_contraseña ;
     }
 }
 let valor_matricula =validar_matricula =()=> {
    if (regex_matricula.test(matricula.value)) {
        matricula_js.innerHTML = "";
         b_matricula = true ;
         return b_matricula;
    } else {
        matricula_js.innerHTML = "Tu matricula tiene que tener 10 caracteres";
         b_matricula = false ;
         return b_matricula;
    }
 }
 
form.addEventListener("submit", function(event) {
    // Ejecutar todas las funciones de validación
    const nombreValido = validar_nombre();
    const apellidoValido = validar_apellido();
    const emailValido = validar_email();
    const contraseñaValida = validar_contraseña();
    const matriculaValida = validar_matricula();
       // Solo enviamos el formulario si todo está correcto
    if (!nombreValido || !apellidoValido || !emailValido || !contraseñaValida || !matriculaValida) {
        event.preventDefault(); // Evita el envío si hay algún campo inválido
    }
});


