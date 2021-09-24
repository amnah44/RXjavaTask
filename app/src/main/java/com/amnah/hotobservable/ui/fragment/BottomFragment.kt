package com.amnah.hotobservable.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.amnah.hotobservable.databinding.FragmentBottomBinding
import com.amnah.hotobservable.ui.fragment.TopFragment.Companion.subject
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit

class BottomFragment : Fragment() {

    private lateinit var binding: FragmentBottomBinding

    private val disposable = CompositeDisposable()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBottomBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        disposable.add(
            subject.observeOn(AndroidSchedulers.mainThread())
                .debounce(1500, TimeUnit.MILLISECONDS)
                .subscribe { string ->
                    binding.showTyping.text = string
                }
        )
    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }

}