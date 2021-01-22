package com.example.brainviretest.ui

import android.R
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.brainviretest.databinding.DateChildLytBinding
import com.example.brainviretest.model.Rates
import com.example.brainviretest.utils.Utilities
import com.google.gson.Gson
import org.json.JSONObject


class ListExpandableAdapter(val context: Context, val entrySet: Map<String, Rates>)
    : RecyclerView.Adapter<ListExpandableAdapter.DateViewHolder>() {





    class DateViewHolder(val binding: DateChildLytBinding) :RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = DateChildLytBinding.inflate(inflater, parent, false)

        return DateViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DateViewHolder, position: Int){

        val  view = holder.binding;

        view.listTitle.text = Utilities.formatData(entrySet.keys.elementAt(position))

        val rates = entrySet.values.elementAt(position)

        view.cad.text = rates.cAD.toString()
        view.hkd.text = rates.hKD.toString()
        view.isk.text = rates.iSK.toString()
        view.php.text = rates.pHP.toString()
        view.dkk.text = rates.dKK.toString()
        view.huf.text = rates.hUF.toString()
        view.czk.text = rates.cZK.toString()
        view.gbp.text = rates.gBP.toString()
        view.ron.text = rates.rON.toString()
        view.sek.text = rates.sEK.toString()
        view.idr.text = rates.iDR.toString()
        view.inr.text = rates.iNR.toString()
        view.rub.text = rates.rUB.toString()
        view.brl.text = rates.bRL.toString()
        view.hrk.text = rates.hRK.toString()
        view.jpy.text = rates.jPY.toString()
        view.thb.text = rates.tHB.toString()
        view.chf.text = rates.cHF.toString()
        view.eur.text = rates.eUR.toString()
        view.myr.text = rates.mYR.toString()
        view.bgn.text = rates.bGN.toString()
        view.trY.text = rates.tRY.toString()
        view.cny.text = rates.cNY.toString()
        view.nok.text = rates.nOK.toString()
        view.nzd.text = rates.nZD.toString()
        view.zar.text = rates.zAR.toString()
        view.usd.text = rates.uSD.toString()
        view.mxn.text = rates.mXN.toString()
        view.sgd.text = rates.sGD.toString()
        view.aud.text = rates.aUD.toString()
        view.ils.text = rates.iLS.toString()
        view.krw.text = rates.kRW.toString()
        view.pln.text = rates.pLN.toString()





    }


    override fun getItemCount(): Int {
        return entrySet.keys.size
    }


}