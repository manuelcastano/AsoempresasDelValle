const user = document.getElementById('user');
const passW = document.getElementById('passW');
const logBtn = document.getElementById('logBtn');

const log = () => {

    let userObj = {
        id:0,
        user: this.user.value,
        password: this.passW.value
    }
    console.log(JSON.stringify(userObj));
    let paso = false;

    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange', ()=>{
        if(xhr.readyState===4)
            paso = true;
    });

    if(paso)
        window.location.href = 'viewCompanies.html';
    else
        alert();

    xhr.open('POST', 'http://localhost:8080/AsoempresasDelValle/api/employee/login');
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify(userObj));
}

logBtn.addEventListener('click', log);