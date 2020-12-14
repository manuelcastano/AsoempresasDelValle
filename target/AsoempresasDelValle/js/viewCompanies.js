const companiesContainer = document.getElementById('companiesContainer')
const getAllCompanies = ()=>{
let xhr = new XMLHttpRequest();
xhr.addEventListener('readystatechange', ()=>{
    if(xhr.readyState === 4){
        let json = xhr.responseText;
        let response = JSON.parse(json);
        console.log(response);
        for(let i=0; i<response.length; i++){
            let companyDTO = response[i];
            let view = new CompanyView(companyDTO);
            companiesContainer.appendChild(view.render());
        }
    }
});
    xhr.open('GET','http://localhost:8080/AsoempresasDelValle/api/company/getallcompanies');
    xhr.send();
};

getAllCompanies();