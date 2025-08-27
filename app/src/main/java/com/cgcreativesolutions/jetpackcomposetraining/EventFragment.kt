package com.cgcreativesolutions.jetpackcomposetraining

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cgcreativesolutions.jetpackcomposetraining.databinding.FragmentEventBinding
import com.cgcreativesolutions.jetpackcomposetraining.model.mockProposals

class EventFragment : Fragment() {

    private val binding: FragmentEventBinding by lazy {
        FragmentEventBinding.inflate(layoutInflater)
    }

    private val proposalAdapter = ProposalAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupProposalAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    private fun setupProposalAdapter() {
        binding.eventProposals.proposals.apply {
            adapter = proposalAdapter
        }
        proposalAdapter.submitList(mockProposals)
    }


}