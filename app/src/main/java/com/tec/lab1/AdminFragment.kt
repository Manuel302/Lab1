package com.tec.lab1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.tec.lab1.databinding.FragmentAdminBinding
import java.util.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class AdminFragment : Fragment() {

    private var _binding: FragmentAdminBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAdminBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findNavController().addOnDestinationChangedListener { _, destination, arguments ->
            val mode = arguments?.getString("mode")
            if (!mode.isNullOrEmpty()) destination.label =
                mode.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        }

        binding.cursesBtn.setOnClickListener { findNavController().navigate(R.id.action_adminFragment_to_managementFragment, bundleOf("mode" to "curses")) }
        binding.careersBtn.setOnClickListener { findNavController().navigate(R.id.action_adminFragment_to_managementFragment, bundleOf("mode" to "careers")) }
        binding.professorsBtn.setOnClickListener { findNavController().navigate(R.id.action_adminFragment_to_managementFragment, bundleOf("mode" to "professors")) }
        binding.studentsBtn.setOnClickListener { findNavController().navigate(R.id.action_adminFragment_to_managementFragment, bundleOf("mode" to "students")) }
        binding.ciclesBtn.setOnClickListener { findNavController().navigate(R.id.action_adminFragment_to_managementFragment, bundleOf("mode" to "cicles")) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}