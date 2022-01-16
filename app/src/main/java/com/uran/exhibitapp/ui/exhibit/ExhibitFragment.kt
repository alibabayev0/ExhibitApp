package com.uran.exhibitapp.ui.exhibit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.uran.exhibitapp.databinding.FragmentExhibitBinding
import com.uran.model.Exhibit

class ExhibitFragment : Fragment() {
    private var _binding: FragmentExhibitBinding? = null

    private lateinit var exhibitViewModel: ExhibitViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    // We use it for avoid memory leak.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExhibitBinding.inflate(inflater, container, false)

        exhibitViewModel =
            ViewModelProvider(this).get(ExhibitViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        exhibitViewModel.exhibitListLiveData.observe(viewLifecycleOwner, {
            setExhibitRecyclerAdapter(it)
        })
    }

    private fun setExhibitRecyclerAdapter(data: List<Exhibit>) {
        binding.recyclerViewExhibit.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewExhibit.adapter = ExhibitRecyclerAdapter(data, exhibitViewModel, viewLifecycleOwner)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
