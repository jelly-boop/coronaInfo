package com.example.finalproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.speech.RecognizerIntent;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class Region extends AppCompatActivity {
    ImageView arrow;
    ImageView menu;
    String selectedRegion="";
    View dialogView;
    Button btnG,btnI,btnD,btnK,btnJ,btnC,btnS,btnSE,btnCN,btnKB,btnDG,btnUS,btnBS,btnKN,btnGJ,btnJB,btnJN;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.region);
        btnG=(Button)findViewById(R.id.btnG);
        btnI=(Button)findViewById(R.id.btnI);
        btnD=(Button)findViewById(R.id.btnD);
        btnK=(Button)findViewById(R.id.btnK);
        btnJ=(Button)findViewById(R.id.btnJ);
        btnC=(Button)findViewById(R.id.btnC);
        btnS=(Button)findViewById(R.id.btnS);
        btnSE=(Button)findViewById(R.id.btnSE);
        btnCN=(Button)findViewById(R.id.btnCN);

        btnKB=(Button)findViewById(R.id.btnKB);
        btnDG=(Button)findViewById(R.id.btnDG);
        btnUS=(Button)findViewById(R.id.btnUS);
        btnBS=(Button)findViewById(R.id.btnBS);
        btnKN=(Button)findViewById(R.id.btnKN);
        btnGJ=(Button)findViewById(R.id.btnGJ);
        btnJB=(Button)findViewById(R.id.btnJB);
        btnJN=(Button)findViewById(R.id.btnJN);




        arrow=(ImageView)findViewById(R.id.arrow);
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent intent = getIntent();
        String myData = intent.getStringExtra("regionString");
        try {
            JSONObject jsonObject = new JSONObject(myData);
            btnG.setText("?????? "+jsonObject.getJSONObject("??????").getString("distanceStep"));
            btnS.setText("?????? "+jsonObject.getJSONObject("??????").getString("distanceStep"));
            btnI.setText("?????? "+jsonObject.getJSONObject("??????").getString("distanceStep"));
            btnD.setText("?????? "+jsonObject.getJSONObject("??????").getString("distanceStep"));
            btnK.setText("?????? "+jsonObject.getJSONObject("??????").getString("distanceStep"));
            btnJ.setText("?????? "+jsonObject.getJSONObject("??????").getString("distanceStep"));
            btnC.setText("?????? "+jsonObject.getJSONObject("??????").getString("distanceStep"));
            btnSE.setText("?????? "+jsonObject.getJSONObject("??????").getString("distanceStep"));
            btnCN.setText("?????? "+jsonObject.getJSONObject("??????").getString("distanceStep"));

            btnKB.setText("??????"+jsonObject.getJSONObject("??????").getString("distanceStep"));
            btnDG.setText("?????? "+jsonObject.getJSONObject("??????").getString("distanceStep"));
            btnUS.setText("?????? "+jsonObject.getJSONObject("??????").getString("distanceStep"));
            btnBS.setText("??????"+jsonObject.getJSONObject("??????").getString("distanceStep"));
            btnKN.setText("?????? "+jsonObject.getJSONObject("??????").getString("distanceStep"));
            btnGJ.setText("?????? "+jsonObject.getJSONObject("??????").getString("distanceStep"));
            btnJB.setText("?????? "+jsonObject.getJSONObject("??????").getString("distanceStep"));
            btnJN.setText("?????? "+jsonObject.getJSONObject("??????").getString("distanceStep"));




        } catch (JSONException e) {
            e.printStackTrace();
        }
        menu=(ImageView)findViewById(R.id.menuIv);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               dialogView=(View) View.inflate(Region.this,R.layout.menu_dialog,null);
               AlertDialog.Builder dlg=new AlertDialog.Builder(Region.this);
               dlg.setTitle("?????? ??????");
               dlg.setView(dialogView);
               final RadioGroup rg=(RadioGroup) dialogView.findViewById(R.id.radioGroup);


               dlg.setPositiveButton("??????", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       int id=rg.getCheckedRadioButtonId();
                       RadioButton rb=(RadioButton)dialogView.findViewById(id);
                       selectedRegion=rb.getText().toString();
                       Intent intent = new Intent(Region.this, LocationInfo.class);
                       intent.putExtra("selectedRegion",selectedRegion);
                       startActivity(intent);
                   }
               });
               dlg.setNegativeButton("??????",null);

               dlg.show();
            }
        });
    }
}
