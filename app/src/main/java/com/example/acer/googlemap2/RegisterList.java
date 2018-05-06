package com.example.acer.googlemap2;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class RegisterList extends ArrayAdapter<Register> {
    private Activity context;
    private List<Register> registerList;

    public RegisterList(Activity context,List<Register> registerList){
        super(context,R.layout.list_layout,registerList);
        this.context=context;
        this.registerList=registerList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();

        View listViewItem=inflater.inflate(R.layout.list_layout,null,true);
        TextView txtFname,txtLname,txtDate,txtGender,txtMobile,txtAltMobile,txtEmail,txtBg,txtPassword;
        txtFname=(TextView) listViewItem.findViewById(R.id.txtFname);
        txtLname=(TextView) listViewItem.findViewById(R.id.txtLname);
        txtDate=(TextView) listViewItem.findViewById(R.id.txtDate);
        txtGender=(TextView) listViewItem.findViewById(R.id.txtGender);
        txtMobile=(TextView) listViewItem.findViewById(R.id.txtMobile);
        txtAltMobile=(TextView) listViewItem.findViewById(R.id.txtAltMobile);
        txtEmail=(TextView) listViewItem.findViewById(R.id.txtEmail);
        txtBg=(TextView) listViewItem.findViewById(R.id.txtBg);
        txtPassword=(TextView) listViewItem.findViewById(R.id.txtPassword);

        Register register=registerList.get(position);

        txtFname.setText(register.getFname());
        txtLname.setText(register.getLname());
        txtDate.setText(register.getDob());
        txtGender.setText(register.getGen());
        txtMobile.setText(register.getMobile());
        txtAltMobile.setText(register.getAltmobile());
        txtEmail.setText(register.getEmail());
        txtBg.setText(register.getBg());
        txtPassword.setText(register.getPassword());

        return listViewItem;

    }
}
