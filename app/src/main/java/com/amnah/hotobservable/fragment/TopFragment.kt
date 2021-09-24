package com.amnah.hotobservable.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.amnah.hotobservable.DataObserve
import com.amnah.hotobservable.databinding.FragmentTopBinding
import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.ReplaySubject
import java.util.concurrent.TimeUnit

class TopFragment : Fragment() {

    private lateinit var binding: FragmentTopBinding
    lateinit var data: DataObserve
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTopBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        data = activity as DataObserve

        val observable = ReplaySubject.create<String> { emitter ->
            binding.enterText.doOnTextChanged { text, start, before, count ->
                emitter.onNext(text.toString())
            }
        }.debounce(1500, TimeUnit.MILLISECONDS)
        observable.subscribe(
            { t ->
                data.getData(t)

            },
            { e ->

                Log.i("Amnah", e.message.toString())
            }
        )
    }


}

