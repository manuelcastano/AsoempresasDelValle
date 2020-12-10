class CompanyView{

    constructor(company){
        this.company = company;
    }

    goToEditor = ()=>{
        window.localStorage.setItem('company', JSON.stringify( this.company));
        window.location.href='viewIndicators.html';
    }
    render = ()=>{
        let component = document.createElement('div');
        component.className = 'companyComponent';
        let nombre = document.createElement('h2');
        nombre.className='nombreCompany';
        let delBtn = document.createElement('button');
        delBtn.innerHTML = 'X';
        delBtn.className ='delBtn';

        nombre.innerHTML = this.company.nombre;

        nombre.addEventListener('click', this.goToEditor);
        component.appendChild(nombre);
        component.appendChild(delBtn);
        
        

        return component;
    }
}