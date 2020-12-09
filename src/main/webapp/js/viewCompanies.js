const CompaniesContainer = document.getElementById('CompaniesContainer');

function deploy () {

    let EmpresObj = {
        id = 0,
        nombre = 
    }

    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange', ()=>{
        if(xhr.readyState===4){
            let json = xhr.responseText;
            let response = JSON.parse(json);
            for(let i=0; i<response.length;i++){
                let companyDTO = response[i]; 
                let view = new CompanyView(companyDTO); 
                CompaniesContainer.appendChild(view.render());
            }
        }
    });
    xhr.open('GET', );
    xhr.send();
}