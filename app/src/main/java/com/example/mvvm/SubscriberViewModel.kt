package com.example.mvvm

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm.db.Subscriber
import com.example.mvvm.db.SubscriberRepository
import kotlinx.coroutines.launch

class SubscriberViewModel(private val repository: SubscriberRepository) : ViewModel(),Observable{

    val subscribers=repository.subscribers

    @Bindable
    val inputName=MutableLiveData<String?>()
    @Bindable
    val inputEmail=MutableLiveData<String?>()

    @Bindable
    val save_or_update_button=MutableLiveData<String>()

    @Bindable
    val clear_or_delete_button=MutableLiveData<String>()

    init {
        save_or_update_button.value="Save"
        clear_or_delete_button.value="Clear"
    }

    fun save_or_update_button(){
        val name:String=inputName.value!!
        val email:String=inputEmail.value!!
        insert(Subscriber(0,name,email))
        inputName.value=null
        inputEmail.value=null

    }

    fun clear_or_delete_button(){
        clearAll()
    }

    fun insert(subscriber: Subscriber)
    {
        viewModelScope.launch {
            repository.insert(subscriber)
        }

    }


    fun update(subscriber: Subscriber)
    {
        viewModelScope.launch {
            repository.update(subscriber)
        }

    }


    fun delete(subscriber: Subscriber)
    {
        viewModelScope.launch {
            repository.delete(subscriber)
        }

    }

    fun clearAll()
    {
        viewModelScope.launch {
            repository.deleteAll()
        }

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }
}