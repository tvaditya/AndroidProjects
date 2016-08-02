package com.example.aditya.clientapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.aditya.clientapp.R;
import com.example.aditya.clientapp.models.Clients;

import java.util.List;

/**
 * Created by Aditya on 02/08/2016.
 */
public class ClientsAdapter extends BaseAdapter{
    List<Clients> clients;
    Context context;

    public ClientsAdapter(Context context, List<Clients> clients) {
        this.context = context;
        this.clients = clients;
    }

    @Override
    public int getCount() {
        return this.clients.size();
    }

    @Override
    public Object getItem(int i) {
        return this.clients.get(i);
    }

    @Override
    public long getItemId(int i) {
        return this.clients.get(i).getId();
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();

        Clients client = clients.get(i);
        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.clients_list, parent, false);
            holder.txtName = (TextView) convertView.findViewById(R.id.txtName);
            holder.txtPhone = (TextView) convertView.findViewById(R.id.txtPhone);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtName.setText(client.getName());
        holder.txtPhone.setText(client.getPhone());

        return convertView;
    }

    public static class ViewHolder{
        public TextView txtName;
        public TextView txtPhone;
    }
}
