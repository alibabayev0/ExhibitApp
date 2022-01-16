package com.uran.exhibitapp.ui.exhibit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uran.model.Exhibit
import com.uran.restexhibitsloader.ExhibitsLoaderImpl
import kotlinx.coroutines.launch

/*
 * @created 16/01/2022 - 5:35 PM
 * @author Ali Babayev
 * @github www.github.com/alibabayev0
*/
class ExhibitViewModel constructor(
    private val exhibitsLoaderImpl: ExhibitsLoaderImpl = ExhibitsLoaderImpl()
) : ViewModel() {
    private val _exhibitListLiveData = MutableLiveData<List<Exhibit>>()
    val exhibitListLiveData: LiveData<List<Exhibit>>
        get() = _exhibitListLiveData

    init {
        viewModelScope.launch {
            _exhibitListLiveData.postValue(
                exhibitsLoaderImpl.getExhibitList()
            )
        }
    }
}
