package com.uran.exhibitapp.ui.exhibit

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.uran.exhibitapp.R
import com.uran.exhibitapp.databinding.ItemExhibitBinding
import com.uran.exhibitapp.util.DataBindingRecyclerViewAdapter
import com.uran.model.Exhibit

/*
 * @created 16/01/2022 - 5:08 PM
 * @author Ali Babayev
 * @github www.github.com/alibabayev0
*/
class ExhibitRecyclerAdapter(
    data: List<Exhibit>,
    _viewModel: ViewModel?,
    lifecycleOwner: LifecycleOwner
) : DataBindingRecyclerViewAdapter(data, _viewModel, lifecycleOwner) {
    override fun getLayoutIdForPosition(position: Int): Int {
        return when (val item = getObjForPosition(position)) {
            is Exhibit -> R.layout.item_exhibit
            else -> throw RuntimeException("unknown model: $item")
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        val item = items[position]
        val binding = holder.binding
        if (binding is ItemExhibitBinding && item is Exhibit) {
            with(binding.recyclerViewExhibitImages) {
                this.layoutManager =
                    LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
                this.adapter = ExhibitPhotoRecyclerAdapter(
                    item.images,
                    viewModel,
                    lifecycleOwner
                )
            }
        }
    }
}
