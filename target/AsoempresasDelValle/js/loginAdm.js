const password = document.getElementById('password');
const btValidar = document.getElementById('btValidar');

const loginAdm = ()=>{
	 let admObj = {
	     password: this.passW.value
	 }
	    console.log(JSON.stringify(admObj));
	    let paso = true;
	    let xhr = new XMLHttpRequest();
	    xhr.addEventListener('readystatechange', ()=>{
	        console.log(xhr.responseText);
	    });
		  
	    xhr.open('POST', 'http://localhost:8080/AsoempresasDelValle/api/employee/login')
	    xhr.setRequestHeader('Content-Type', 'application/json');
	    xhr.send(JSON.stringify(admObj));
        window.location.href = 'viewEmployees.html';
   
}

btValidar.addEventListener('click', loginAdm);
