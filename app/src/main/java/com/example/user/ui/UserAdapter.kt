package com.example.user.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.model.UserDetails

import com.example.user.databinding.UserRowLayoutBinding

class UserAdapter:RecyclerView.Adapter<UserAdapter.ItemHolder>() {

    private var userList=ArrayList<UserDetails>()

    fun setData(list:ArrayList<UserDetails>){

        userList = list
        notifyItemChanged(list.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {

       val rowLayoutBinding = UserRowLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)

       return ItemHolder(rowLayoutBinding)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

        val details = userList[position]

        if(details!=null){

            holder.bind(details)
        }

    }

    override fun getItemCount() = userList.size

    class ItemHolder(private val binding: UserRowLayoutBinding):RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(user:UserDetails)= with(binding){

            tvFirsname.text = "First name: ${user.firstName}"
            tvLastname.text = "First name: ${user.lastName}"
            tvEmail.text = "Email: ${user.email}"

            ivAvatar.load(user.avatar){
                transformations(CircleCropTransformation())
            }
        }

    }
}