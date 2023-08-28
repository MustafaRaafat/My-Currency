package com.example.mycurrency.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mycurrency.R
import com.example.mycurrency.models.LatestDataModel

class CurrencyAdapter : RecyclerView.Adapter<CurrencyAdapter.ViewHolder>() {
    private lateinit var data: LatestDataModel.Rates

    fun setData(data: LatestDataModel.Rates) {
        this.data = data
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView
        val amount: TextView

        init {
            title = view.findViewById(R.id.tv_title)
            amount = view.findViewById(R.id.tv_amount)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_currency, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (position) {
            0 -> {
                holder.title.text = "USD"
                holder.amount.text = data.USD.toString()
            }1 -> {
                holder.title.text = "EGP"
                holder.amount.text = data.EGP.toString()
            }2 -> {
                holder.title.text = "AUD"
                holder.amount.text = data.AUD.toString()
            }3 -> {
                holder.title.text = "CAD"
                holder.amount.text = data.CAD.toString()
            }4 -> {
                holder.title.text = "PLN"
                holder.amount.text = data.PLN.toString()
            }5 -> {
                holder.title.text = "MXN"
                holder.amount.text = data.MXN.toString()
            }
        }
    }

    override fun getItemCount(): Int {
        return 6
    }
}