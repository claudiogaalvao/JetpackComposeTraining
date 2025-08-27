package com.cgcreativesolutions.jetpackcomposetraining

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cgcreativesolutions.jetpackcomposetraining.databinding.ProposalCardBinding
import com.cgcreativesolutions.jetpackcomposetraining.model.ProposalModel

class ProposalAdapter: ListAdapter<ProposalModel, ProposalAdapter.ProposalViewHolder>(DIFF_UTIL) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProposalViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ProposalViewHolder(
            ProposalCardBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(
        holder: ProposalViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position))
    }

    class ProposalViewHolder(private val binding: ProposalCardBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(proposal: ProposalModel) {
            binding.proposalTitle.text = proposal.title
            binding.proposalType.text = proposal.type.name
            binding.proposalShortDescription.text = proposal.description
        }
    }

    companion object {
        private val DIFF_UTIL =
            object : DiffUtil.ItemCallback<ProposalModel>() {
                override fun areItemsTheSame(
                    oldItem: ProposalModel,
                    newItem: ProposalModel,
                ): Boolean {
                    return oldItem == newItem
                }

                override fun areContentsTheSame(
                    oldItem: ProposalModel,
                    newItem: ProposalModel,
                ): Boolean {
                    return oldItem.id == newItem.id
                }
            }
    }
}