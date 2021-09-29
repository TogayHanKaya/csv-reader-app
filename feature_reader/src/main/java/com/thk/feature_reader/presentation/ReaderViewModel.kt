package com.thk.feature_reader.presentation

import androidx.lifecycle.viewModelScope
import com.thk.csvreader.base.presentation.viewmodel.BaseAction
import com.thk.csvreader.base.presentation.viewmodel.BaseViewModel
import com.thk.csvreader.base.presentation.viewmodel.BaseViewState
import com.thk.feature_reader.domain.usecase.GetLineUseCase
import kotlinx.coroutines.launch

class ReaderViewModel(
    private val getLineUseCase: GetLineUseCase
) : BaseViewModel<ReaderViewModel.ViewState, ReaderViewModel.Action>(ViewState()) {

    //TODO: Add picker for files in assets
    private val fileName = "issues.csv"

    override fun onLoadData() {
        getLines()
    }

    private fun getLines() {
        viewModelScope.launch {
            getLineUseCase.execute(fileName).also { result ->
                val action = when (result) {
                    is GetLineUseCase.Result.Success ->
                        if (result.data.isEmpty()) {
                            Action.LineListLoadingFailure
                        } else {
                            Action.LineListLoadingSuccess(result.data)
                        }

                    is GetLineUseCase.Result.Error ->
                        Action.LineListLoadingFailure
                }
                sendAction(action)
            }
        }
    }

    override fun onReduceState(viewAction: Action) = when (viewAction) {
        is Action.LineListLoadingSuccess -> state.copy(
            isLoading = false,
            isError = false,
            lines = viewAction.lines
        )
        is Action.LineListLoadingFailure -> state.copy(
            isLoading = false,
            isError = true,
            lines = listOf()
        )
    }

    data class ViewState(
        val isLoading: Boolean = true,
        val isError: Boolean = false,
        val lines: List<List<String>> = listOf()
    ) : BaseViewState

    sealed class Action : BaseAction {
        class LineListLoadingSuccess(val lines: List<List<String>>) : Action()
        object LineListLoadingFailure : Action()
    }
}