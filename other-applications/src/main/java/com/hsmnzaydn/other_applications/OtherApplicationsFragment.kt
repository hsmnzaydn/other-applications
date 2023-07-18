package com.hsmnzaydn.other_applications

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch


class OtherApplicationsFragment : DialogFragment(R.layout.dialog_fragment) {

    private val adapter by lazy {
        Adapter()
    }

    override fun getTheme() = R.style.RoundedCornersDialog

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        val retrofit = DataSource.retrofitProvider()
        val service = retrofit.create(DataSource.ApplicationService::class.java)
        val recylerview = view?.findViewById<RecyclerView>(R.id.rv)
        lifecycleScope.launch {
            val response = service.otherApplications()
            adapter.setData(response.data)
            val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

            recylerview?.layoutManager = layoutManager
            recylerview?.adapter = adapter
        }
        adapter.getListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(it.link))
            startActivity(browserIntent)
        }
        return view
    }

    companion object {
        fun newInstance() = OtherApplicationsFragment()

    }
}