const employeeContainer = document.getElementById('employeeContainer');

const getAllEmployees = ()=>{
    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange', ()=>{
        if(xhr.readyState === 4){
            let json = xhr.responseText;
            let response = JSON.parse(json);
            console.log(response);
            employeeContainer.innerHTML = '';
            for(let i=0; i<response.length; i++){
                let employeeDTO = response[i];
                let view = new EmployeeView(employeeDTO);
                view.onDeleteFinish = ()=>{
                    employeeContainer.removeChild(document.getElementById('employee'+employeeDTO.id));
                };   

                employeeContainer.appendChild(view.render());

            }
        }
    });
    xhr.open('GET', 'http://localhost:8080/AsoempresasDelValle/api/employee/getallemployees');
    xhr.send();
}

getAllEmployees();