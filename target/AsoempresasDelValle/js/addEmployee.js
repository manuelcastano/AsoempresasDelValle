const nombre = document.getElementById('nombre');
const password = document.getElementById('password');
const regBtn = document.getElementById('regBtn')

const registrar = ()=>{
    let employeeObj = {
        id: 0,
        user: nombre.value,
        password: password.value
    };
    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange', ()=>{
        console.log(xhr.responseText);
        if(xhr.readyState === 4){
            console.log(xhr.responseText);
        }
    });
    xhr.open('POST', 'http://localhost:8080/AsoempresasDelValle/api/employee/create');
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify(employeeObj));
 
};

regBtn.addEventListener('click', registrar);