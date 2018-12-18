package com.example.aspire.photo_retrofit.Memory_Dialog;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aspire.photo_retrofit.R;
import com.example.aspire.photo_retrofit.memory_Data.Memory_Dao;
import com.example.aspire.photo_retrofit.memory_Data.Memory_DataBae;
import com.example.aspire.photo_retrofit.memory_Data.Memory_Model;


public class Memory_MessageDialog {

    private Context context;

    public Memory_MessageDialog(Context context) {
        this.context = context;
    }

    public void addNewMessage(int dialog_layout){
        LayoutInflater inflater = LayoutInflater.from(context);
        View subView = inflater.inflate(dialog_layout, null);

        final EditText nameField = (EditText)subView.findViewById(R.id.date);
        nameField.setVisibility(View.INVISIBLE);
        final EditText nameField1 = (EditText)subView.findViewById(R.id.title);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("ဘာအေၾကာင္း အရာပါလဲ ခင္ဗ်ာ? \uD83D\uDE0A");
        builder.setView(subView);
        builder.create();
        builder.setPositiveButton("အိုေက \uD83D\uDE09", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                final String title = nameField1.getText().toString();
                if(TextUtils.isEmpty(title)){
                    Toast.makeText(context, "အစီအစဥ္ ေလး ေတာ့ ထည့္ ပါ ဦ း ဗ် \uD83D\uDE01 ", Toast.LENGTH_LONG).show();
                }
                else{

                    Memory_Model content = new Memory_Model(title);

                    //add new message to database
                    Memory_Dao messageDao = (Memory_Dao) Memory_DataBae.getInstance(context).data();
                    messageDao.insertMemory(content);
                    Log.d("Memory",content+" Aung");
                }
            }
        });
        builder.setNegativeButton("မလုပ္ေတာ့ပါ \uD83D\uDE05", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(context, "Cancel", Toast.LENGTH_LONG).show();
            }
        });
        builder.show();
    }
}
