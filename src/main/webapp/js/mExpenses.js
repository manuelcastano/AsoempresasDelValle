const date = document.getElementById('date');
const value = document.getElementById('value');
const idCompany = document.getElementById('idCompany');
const register = document.getElementById('register');

const registrar = ()=>{
    let indicatorObj = {
        id: 0,
        value: value.value,
        date: date.value,
        companyID: idCompany.value
    };
    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange', ()=>{
        console.log(xhr.responseText);
        if(xhr.readyState === 4){
            console.log(xhr.responseText);
        }
    });
    xhr.open('POST', 'http://localhost:8080/AsoempresasDelValle/api/mes/create');
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify(indicatorObj));
};

register.addEventListener('click', registrar);