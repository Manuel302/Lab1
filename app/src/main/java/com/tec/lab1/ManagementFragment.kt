package com.tec.lab1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.tec.lab1.databinding.FragmentManagementBinding
import com.tec.lab1.services.IMaintenanceService
import com.tec.lab1.services.ServiceLocator

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ManagementFragment : Fragment() {

    private var _binding: FragmentManagementBinding? = null
    private lateinit var service: IMaintenanceService
    private lateinit var columns: Array<String>
    private lateinit var data: Array<Array<String>>


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentManagementBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        service = ServiceLocator.getMaintenanceService()
        fetchData()
        updateTableData(columns, data)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun updateTableData(columns: Array<String>, data: Array<Array<String>>) {
        val dataTable = view?.findViewById<View>(R.id.data_table) as TableLayout
        dataTable.addView(createColumns(columns))
        for (row in data) {
            dataTable.addView(createRow(row))
        }
    }

    private fun createColumns(data: Array<String>): TableRow {
        val row = TableRow(context)
        for (cell in data) {
            val textView = TextView(context)
            textView.text = cell
            textView.textSize = 18f
            textView.isAllCaps = true
            row.addView(textView)
        }
        return row
    }

    private fun createRow(data: Array<String>): TableRow {
        val row = TableRow(context)
        for (cell in data) {
            val textView = TextView(context)
            textView.text = cell
            row.addView(textView)
        }
        return row
    }

    private fun fetchData() {
        columns = service.getColumns()
        data = service.getData()
    }
}