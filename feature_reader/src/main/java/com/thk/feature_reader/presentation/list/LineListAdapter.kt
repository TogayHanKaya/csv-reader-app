package com.thk.feature_reader.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thk.commons.formatAsDate
import com.thk.csvreader.base.delegate.observer
import com.thk.feature_reader.databinding.ListItemMalformedRowBinding
import com.thk.feature_reader.databinding.ListItemRowBinding
import java.time.format.DateTimeParseException

private const val ITEM = 0
private const val MALFORMED_ITEM = 1
private const val COLUMN_COUNT = 4

class LineListAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var lines: List<List<String>> by observer(listOf()) {
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = lines.size

    override fun getItemViewType(position: Int): Int {
        return when (lines[position].size) {
            COLUMN_COUNT -> ITEM
            else -> MALFORMED_ITEM
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            MALFORMED_ITEM -> {
                val binding = ListItemMalformedRowBinding.inflate(inflater, parent, false)
                MalformedViewHolder(binding)
            }
            else -> {
                val binding = ListItemRowBinding.inflate(inflater, parent, false)
                ViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> {
                holder.bind(lines[position])
            }
            is MalformedViewHolder -> {
                holder.bind()
            }
        }
    }

    inner class ViewHolder(private val binding: ListItemRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(line: List<String>) {
            binding.firstName.text = line[0]
            binding.surName.text = line[1]
            binding.issueCount.text = line[2]

            try {
                binding.dateOfBirth.text =
                    line[3].formatAsDate("yyyy-MM-dd'T'HH:mm:ss", "dd-MM-yyyy")
            } catch (e: DateTimeParseException) {
                binding.dateOfBirth.text = line[3]
            }
        }
    }

    inner class MalformedViewHolder(private val binding: ListItemMalformedRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
        }
    }
}