const name = document.getElementsByName('employee');
const password = document.getElementsByName('password');
const button = document.getElementsByName('add');

const addEmplee = ()=>{
    let employeeObj = {
        id: 0,
        user: name.value,
        password: password.values,
    };
    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange', ()=>{
        if(xhr.readyState === 4){
            getAll();
        }
    });
    xhr.open('POST', 'inisertelink');
    xhr.setRequestHeader('Content-type', 'application/json');
    xhr.send(JSON.stringify(employeeObj));
    name.value = '';
    password.values = '';
};

button.addEventListener('click', addEmplee);