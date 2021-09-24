package com.amnah.hotobservable.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.amnah.hotobservable.databinding.FragmentBottomBinding

class BottomFragment : Fragment() {

    private lateinit var binding: FragmentBottomBinding

    //    val disposable = CompositeDisposable()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBottomBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.showTyping.text = arguments?.getString("TEXT")

    }

}