package com.amnah.hotobservable.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.amnah.hotobservable.databinding.FragmentTopBinding
import io.reactivex.rxjava3.subjects.ReplaySubject

class TopFragment : Fragment() {

    private lateinit var binding: FragmentTopBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTopBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.enterText.doOnTextChanged { text, _, _, _ ->
            subject.onNext(text.toString())
        }
    }
    companion object {
        val subject = ReplaySubject.create<String?>()
    }

}

