package com.uran.exhibitapp.ui.exhibit

import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.uran.exhibitapp.R
import com.uran.exhibitapp.databinding.ItemExhibitPhotoBinding
import com.uran.exhibitapp.util.DataBindingRecyclerViewAdapter
import com.uran.exhibitapp.util.loadImageFromNetwork

/*
 * @created 16/01/2022 - 4:14 PM
 * @author Ali Babayev
 * @github www.github.com/alibabayev0
*/
class ExhibitPhotoRecyclerAdapter(
    data: List<String>,
    _viewModel: ViewModel?,
    lifecycleOwner: LifecycleOwner
) : DataBindingRecyclerViewAdapter(data, _viewModel, lifecycleOwner) {
    override fun getLayoutIdForPosition(position: Int): Int {
        return when (val item = getObjForPosition(position)) {
            is String -> R.layout.item_exhibit_photo
            else -> throw RuntimeException("unknown model: $item")
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        val item = items[position]
        val binding = holder.binding
        if (binding is ItemExhibitPhotoBinding && item is String) {
            binding.imageViewPhoto.loadImageFromNetwork(item, onSuccess = {
                binding.imageViewPhoto.visibility = View.VISIBLE
            })
        }
    }
}
