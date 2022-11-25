/*
** Validador de Formulario
**@author João Victor
*/

function validar(){
    let nome = frmContato.nome.value
    let fone = frmContato.fone.value
    if(nome === ""){
        alert('Preencha o campo Nome')
        frmContato.nome.focus()
        return false
    }else if(fone === ""){
        alert('Preencha o campo Fone')
        frmContato.nome.focus()
        return false
    }else{
        document.forms["frmContato"].submit()
    }
}