class EmployeeView{
    constructor(employee){
        this.employee = employee;
        this.onDeleteFinish = null;
    }

    deleteEmployee = ()=>{
        let xhr = new XMLHttpRequest();
        xhr.addEventListener('readystatechange', ()=>{
            if(xhr.readyState === 4){
                var response = JSON.parse(xhr.responseText);
                if(response.message === 'Operacion exitosa'){
                    if(this.onDeleteFinish !== null) this.onDeleteFinish();

                }else{
                    alert('No se pudo eliminar el empleado');
                }

            }
        });
        xhr.open('DELETE', 'http://localhost:8080/AsoempresasDelValle/api/employee/delete/'+this.employee.id);
        xhr.send();
    }


    render = ()=>{
        let component = document.createElement('div');
        component.id='employee'+this.employee.id;
        component.className ='employeeComponent';
        let name = document.createElement('p');
        let delBtn = document.createElement('button');
        delBtn.innerHTML = 'X';
        delBtn.className ='delBtn';

        name.innerHTML = this.employee.user;
        component.appendChild(name);
        component.appendChild(delBtn);

        delBtn.addEventListener('click', this.deleteEmployee);
        return component;
    }
}