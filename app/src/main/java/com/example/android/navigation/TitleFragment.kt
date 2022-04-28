package com.example.android.navigation

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {
    private lateinit var binding: FragmentTitleBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)
        setHasOptionsMenu(true) //options menu için
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //navContoller defition
        super.onViewCreated(view, savedInstanceState)
        binding.playButton.setOnClickListener { view:View->
            view.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())
        }
    }
    //Options Menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }
    //seçilen options menu ögesiyle aynı kimliğe sahip fragment'a gitmesi için.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.
        onNavDestinationSelected(item,requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }


}