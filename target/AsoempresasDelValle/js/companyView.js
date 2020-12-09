class CompanyView{

    constructor(company){
        this.company = company;

    }

    render = ()=>{
        let component = document.createElement('div');
        let nombre = document.createElement('h2');
        let delBtn = document.createElement('button');
        delBtn.innerHTML = 'X';


        component.innerHTML = this.company.nombre;


        component.appendChild(nombre);
        component.appendChild(delBtn);
        
        

        return component;
    }
}