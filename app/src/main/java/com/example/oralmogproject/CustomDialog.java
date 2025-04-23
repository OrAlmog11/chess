package com.example.oralmogproject;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

public class CustomDialog extends Dialog implements View.OnClickListener {
    Button btnOk;
    Context context;


    public CustomDialog(@NonNull Context context) {
        super(context);

        setContentView(R.layout.custom_dialog);
        this.context = context;

        btnOk = findViewById(R.id.btnOk);
        btnOk.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        if(btnOk == view)
        {
            ((GameActivity)context).finish();

        }
    }
    @Override
    public void dismiss() {
        super.dismiss();
        ((GameActivity) context).finish();
    }
}
