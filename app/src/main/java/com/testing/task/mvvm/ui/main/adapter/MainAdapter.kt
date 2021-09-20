package com.testing.task.mvvm.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.testing.task.mvvm.R
import com.testing.task.mvvm.data.model.Drink
import kotlinx.android.synthetic.main.item_layout.view.*

class MainAdapter(
    private val users: ArrayList<Drink?>?
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: Drink) {
            itemView.textViewUserName.text = user.strDrink
            itemView.textViewUserEmail.text = user.strCategory
            Glide.with(itemView.imageViewAvatar.context)
                .load(user.strImageSource).diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(itemView.imageViewAvatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = users!!.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(users?.get(position)!!)

    fun addData(list: ArrayList<Drink?>?) {
        list?.let { users!!.addAll(it) }
    }

}