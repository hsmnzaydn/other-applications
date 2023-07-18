package com.hsmnzaydn.other_applications

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation

internal class Adapter : RecyclerView.Adapter<Adapter.DataAdapterViewHolder>() {
    private var adapterClickListener: ((Data) -> Unit?)? = null
    private var tutorials: List<Data> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataAdapterViewHolder {

        val layout = R.layout.row_app

        val view = LayoutInflater
            .from(parent.context)
            .inflate(layout, parent, false)

        return DataAdapterViewHolder(view, adapterClickListener)
    }

    fun getListener(adapterClickListener: (Data) -> Unit) {
        this.adapterClickListener = adapterClickListener
    }

    fun setData(experts: List<Data>) {
        this.tutorials = experts
        notifyDataSetChanged()
    }

    class DataAdapterViewHolder(itemView: View, private val adapterClickListener: ((Data) -> Unit?)?) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(
            item: Data,
        ) {
            itemView.setOnClickListener {
                adapterClickListener?.invoke(item)
            }
            val image = itemView.findViewById<AppCompatImageView>(R.id.ivApp)
            val textView = itemView.findViewById<AppCompatTextView>(R.id.tvTitle)
            image.load(item.imagePath) {
                crossfade(true)
                transformations(CircleCropTransformation())
            }
            textView.text = item.name
        }
    }


    override fun onBindViewHolder(holder: DataAdapterViewHolder, position: Int) {
        holder.bind(tutorials[position])
    }

    override fun getItemCount(): Int = tutorials.size
}