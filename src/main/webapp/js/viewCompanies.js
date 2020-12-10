const container = document.getElementById('CompaniesContainer');

const allCompanies = ()=>{

	    let xhr = new XMLHttpRequest();
	    xhr.addEventListener('readystatechange', ()=>{
	    	if(xhr.readyState===4){
	    		let json = xhr.responseText;
	    		let response = JSON.parse(json);
	    		console.log(response);
	    		for(let i =0; i<response.lenght;i++){
	    			let companieDTO = response[i];
	    			let view = new companyView(companieDTO)
	    			container.appendChild(view.render());
	    		}
	    	}
	    });
	 ;
		  
	    xhr.open('GET', 'http://localhost:8080/AsoempresasDelValle/api/company/getallcompanies');
	    xhr.send());  
}