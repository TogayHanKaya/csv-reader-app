package com.thk.feature_reader.presentation

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.thk.commons.visible
import com.thk.csvreader.base.presentation.extension.observe
import com.thk.csvreader.base.presentation.fragment.InjectionFragment
import com.thk.feature_reader.R
import com.thk.feature_reader.databinding.FragmentReaderBinding
import com.thk.feature_reader.presentation.list.LineListAdapter
import com.thk.feature_reader.test.EspressoIdlingResource
import org.kodein.di.generic.instance

class ReaderFragment : InjectionFragment(R.layout.fragment_reader) {

    private val binding by viewBinding(FragmentReaderBinding::bind)

    private val viewModel: ReaderViewModel by instance()

    private val lineListAdapter: LineListAdapter by instance()

    private val stateObserver = Observer<ReaderViewModel.ViewState> {
        lineListAdapter.lines = it.lines
        EspressoIdlingResource.decrement()
        binding.progressBar.visible = it.isLoading
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe(viewModel.stateLiveData, stateObserver)
        setupList()

        if (viewModel.stateLiveData.value?.lines == null) {
            binding.progressBar.visible()
            EspressoIdlingResource.increment()
            viewModel.loadData()
        }
    }

    private fun setupList() {
        val context = requireContext()
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = lineListAdapter
        }
    }
}