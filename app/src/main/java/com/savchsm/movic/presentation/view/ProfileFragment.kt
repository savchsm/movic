package com.savchsm.movic.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.savchsm.movic.R
import com.savchsm.movic.databinding.FragmentProfileBinding
import com.savchsm.movic.presentation.viewmodel.ProfileViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class ProfileFragment : Fragment() {

    private var binding: FragmentProfileBinding? = null
    private val viewModel: ProfileViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        viewModel.getProfileData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupObservers()
    }

    private fun setupUI() = binding?.apply {
        Glide.with(this.root)
            .load("")
            .placeholder(R.drawable.def_profile_ic)
            .into(profileImg)

        btnEdit.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_editProfileFragment)
        }
    }

    private fun setupObservers() {
        viewModel.profile.observe(viewLifecycleOwner) { profile ->
            profile?.let {
                binding?.apply {
                    tvName.text = "${profile.name} ${profile.surname}"
                    tvEmail.text = profile.email

                    Glide.with(this.root)
                        .load(it.image)
                        .placeholder(R.drawable.def_profile_ic)
                        .into(profileImg)
                }
            }
        }
    }
}