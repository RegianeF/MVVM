package com.example.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var _repository = PersonRepository()

    //dados vivos que são mutaveis, passivel de ser escutado para a ..Activity
    private var _textWelcome = MutableLiveData<String>("Hello World 2") //precisa passar um parametro <> e dizer qual o tipo
    var textWelcome: LiveData<String> = _textWelcome
    //dessa maneira pode ser observado na mainActivity e não alterado o orginal
    //sempre lembrar de colocar LiveData - sem o mutable para não trocar o valor lá em activity


   /* init {
        _textWelcome.value = "Hello World"
    }
    do jeito que o professor fez
*/

    /*fun login1 (){
        _textWelcome.value = "Olá mundo"
    }*/

    private var _login = MutableLiveData<Boolean>()
    var login: LiveData<Boolean> = _login

    fun login(login: String){
        val retorno = _repository.login(login)
        _login.value = retorno
    }

}