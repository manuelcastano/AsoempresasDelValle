const selection = document.getElementById('seleccion');
const fFinal = document.getElementById('FechaInicial');
const fInicial = document.getElementById('FechaFinal');
const generarBtn = document.getElementById('generarBtn');
const guardarBtn = document.getElementById('guardarBtn');
//const company = JSON.parse(window.localStorage.getItem('<<Poner aqui el nombre de la variable del local storage>>')  );

guardarBtn.addEventListener('click', ()=>{

    const aConvertir = document.body;
    html2pdf().set({
        margin:1,
        filename: 'documento.pdf',
        image: {
            type: 'jpeg',
            quality: 0.98
       },
        html2canvas: {
            scale: 3,
            letterRendering: true,
        },
        jsPDF:{
        unit:'in',
        format:'a3',
        orientation: 'portrait'
    }
    })
    .from(aConvertir)
    .save()
    .catch(err => console.log(err))
});


generar = () =>{

    
    guardarBtn.hidden = false;
}


generarBtn.addEventListener('click', generar);