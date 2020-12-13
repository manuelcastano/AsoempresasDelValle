const user = document.getElementById('user');
const passW = document.getElementById('passW');
const logBtn = document.getElementById('logBtn');

const log = () => {

    let userObj = {
        id:0,
        user: user.value,
        password: passW.value
    }
    console.log(JSON.stringify(userObj));
    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange', ()=>{
        if(xhr.readyState===4){
            let response = JSON.stringify(xhr.responseText);
            console.log(response);
            if(response.includes('exitosa')){
                if(passW.value == 'admin'){
                    window.location.href = 'viewEmployees.html';
                }else{
                    window.location.href = 'viewCompanies.html';
                }
            }else{
                alert('Usuario o contraseña incorrecta');
            }
            
        }
    });
    if(passW.value == 'admin'){
        xhr.open('POST', 'http://localhost:8080/AsoempresasDelValle/api/employee/loginA');
    }else{
        xhr.open('POST', 'http://localhost:8080/AsoempresasDelValle/api/employee/login');
    }
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify(userObj));
}

logBtn.addEventListener('click', log);