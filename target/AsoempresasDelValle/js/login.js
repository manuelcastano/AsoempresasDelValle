const user = document.getElementById('user');
const password = document.getElementById('passW');
const logBtn = document.getElementById('logBtn');

log = ()=>{
    
    let paso = true;
    if(paso)
        window.location.href = 'viewCompanies.html';
    else
        alert();

}

logBtn.addEventListener('click', log);