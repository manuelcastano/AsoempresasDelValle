const password = document.getElementById('password');
const btValidar = document.getElementById('btValidar');

const loginAdm = ()=>{
	 let admObj = {
	     password: this.passW.value
	 }
	    console.log(JSON.stringify(admObj));
	    let valido = false;
	    let xhr = new XMLHttpRequest();
	    xhr.addEventListener('readystatechange', ()=>{
	    	if(xhr.readyState===4){
	    		valido = true;
	    		console.log(xhr.responseText);
	    	}
	    });
	    if(valido)
	    	window.location.href = 'viewEmployees.html';
	    else
	        alert("Usuario no identificado como Administrador");
		  
	    xhr.open('POST', 'http://localhost:8080/AsoempresasDelValle/api/employee/login')
	    xhr.setRequestHeader('Content-Type', 'application/json');
	    xhr.send(JSON.stringify(admObj));
        
   
}

btValidar.addEventListener('click', loginAdm);
