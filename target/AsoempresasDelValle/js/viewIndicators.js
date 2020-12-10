const idButton = document.getElementById('idCompania');
const idField = document.getElementById('idCompany');

idButton.addEventListener('click', ()=>{
    window.localStorage.setItem('idCompania', idField.value);
});