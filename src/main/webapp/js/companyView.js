class CompanyView{

    constructor(company){
        this.company = company;
    }

    goToEditor =()=>{
        window.location.href='viewIndicators.html';
        
    }

    render = ()=>{
        let component = document.createElement('div');
        component.className = 'companyComponent';
        let nombre = document.createElement('p');
        nombre.className = 'nombreC';
        let sector = document.createElement('small');

        nombre.innerHTML = this.company.name;
        sector.innerHTML = this.company.sectorID;

        component.appendChild(nombre);
        component.appendChild(sector);

        nombre.addEventListener('click', this.goToEditor);
        return component;
    }


}