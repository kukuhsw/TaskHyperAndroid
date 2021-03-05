package com.hellu.taskhyperandroid.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hellu.taskhyperandroid.R
import com.hellu.taskhyperandroid.domain.model.Users
import com.hellu.taskhyperandroid.utils.show
import kotlinx.android.synthetic.main.item_users.view.*

class UserAdapter : RecyclerView.Adapter<UserAdapter.Holder>() {

    private var users: ArrayList<Users> = arrayListOf()

    fun setData(users: List<Users>){
        this.users.clear()
        this.users.addAll(users)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.Holder =
            Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_users, parent, false))

    override fun onBindViewHolder(holder: UserAdapter.Holder, position: Int) {
        val user = users[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int = users.size

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(users: Users){
            with(itemView){
                ivImageUsers.show(users.avatar)
                tvCompanyName.text = users.builtBy
                tvUserName.text = users.name
            }
        }
    }

}