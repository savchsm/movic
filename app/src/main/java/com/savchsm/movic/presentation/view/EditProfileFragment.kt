package com.savchsm.movic.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.savchsm.movic.R
import com.savchsm.movic.databinding.FragmentEditProfileBinding
import com.savchsm.movic.domain.models.Profile
import com.savchsm.movic.presentation.viewmodel.EditProfileViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class EditProfileFragment : Fragment() {

    private var binding: FragmentEditProfileBinding? = null
    private val viewModel: EditProfileViewModel by viewModel()

    private var currentProfileImg: String? = null
    private val pickMedia =
        registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
            uri?.let {
                currentProfileImg = it.toString()
                showProfileImage(it.toString())
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditProfileBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupObservers()
    }

    private fun setupUI() = binding?.apply {
        topAppBar.apply {
            setNavigationOnClickListener { viewModel.checkDataChanged(getFilledProfile()) }
            setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.done -> {
                        viewModel.saveProfileData(getFilledProfile())
                        true
                    }

                    else -> false
                }
            }
        }

        btnEditProfileImg.setOnClickListener {
            pickMedia.launch(
                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
            )
        }
    }

    private fun setupObservers() {
        viewModel.profile.observe(viewLifecycleOwner) { profile ->
            profile?.let {
                binding?.apply {
                    textFieldName.editText?.setText(it.name)
                    textFieldSurname.editText?.setText(it.surname)
                    textFieldEmail.editText?.setText(it.email)
                    showProfileImage(it.image)
                }
            }
        }

        viewModel.condition.observe(viewLifecycleOwner) {
            if (it) findNavController().navigateUp() else showDialog()
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            viewModel.checkDataChanged(getFilledProfile())
        }
    }

    private fun showDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setIcon(R.drawable.baseline_save_24)
            .setTitle(resources.getString(R.string.dialog_title))
            .setMessage(resources.getString(R.string.dialog_message))
            .setNegativeButton(resources.getString(R.string.decline)) { _, _ ->
                findNavController().navigateUp()
            }
            .setPositiveButton(resources.getString(R.string.accept)) { _, _ ->
                viewModel.saveProfileData(getFilledProfile())
            }
            .show()
    }

    private fun showProfileImage(uri: String) = binding?.let {
        Glide.with(it.root)
            .load(uri)
            .placeholder(R.drawable.def_profile_ic)
            .into(it.profileImg)
    }

    private fun getFilledProfile(): Profile = Profile(
        id = "MY_PROFILE",
        name = binding?.textFieldName?.editText?.text.toString(),
        surname = binding?.textFieldSurname?.editText?.text.toString(),
        image = currentProfileImg ?: viewModel.profile.value?.image.toString(),
        email = binding?.textFieldEmail?.editText?.text.toString(),
    )
}