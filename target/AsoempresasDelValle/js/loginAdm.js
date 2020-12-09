const password = document.getElementById('password');
const btValidar = document.getElementById('btValidar');

const loginAdm = ()=>{
	 
	let valido = true;
    if(valido)
        window.location.href = 'viewEmployees.html';
        
    else
        alert();
   
}

btValidar.addEventListener('click', loginAdm);
