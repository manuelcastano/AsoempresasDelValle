const date = document.getElementById('date');
const value = document.getElementById('value');
const idCompanie = document.getElementById('idCompanie');
const add = document.getElementById('add');

const anadir = () =>{
    let indicatorObj = {
        id:0,
        value: value.value,
        date: date.value,
        idCompanie: idCompanie.value
    };
    console.log(JSON.stringify(indicatorObj));

    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange', ()=>{
        if(xhr.readyState ===4){
            console.log(xhr.responseText);
        }
    });
    xhr.open('POST','http//localhost:8080/AsoempresasDelValle/api/mes/create');
    xhr.setRequestHeader('content-type', 'application/json');
    xhr.send(JSON.stringify(indicatorObj));
};

add.addEventListener('click', anadir);