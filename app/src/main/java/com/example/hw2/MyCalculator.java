package com.example.hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.TextView;

public class MyCalculator extends AppCompatActivity {
    TextView text_Result;
    Button btn_add, btn_sub,btn_mul, btn_div;
    Button btn_result;

    String val1="";
    String val2="";
    int type=0;

    int ADD=0;
    int SUB=1;
    int MUL=2;
    int DIV=3;

    double d1=0;
    double d2=0;
    double result=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_Result=(TextView)findViewById(R.id.result);
        text_Result.setText("");

        btn_add=(Button)findViewById(R.id.add);
        btn_sub=(Button)findViewById(R.id.subtract);
        btn_mul=(Button)findViewById(R.id.multiply);
        btn_div=(Button)findViewById(R.id.divide);
        btn_result=(Button)findViewById(R.id.equal);

        btn_add.setOnClickListener(mListener);
        btn_sub.setOnClickListener(mListener);
        btn_mul.setOnClickListener(mListener);
        btn_div.setOnClickListener(mListener);
        btn_result.setOnClickListener(mListener);

        Intent intent = getIntent();
        String intent_calculate=intent.getStringExtra("calculate");

        if(intent_calculate!=null){
            double intent_result=0;

            String intent_val1="";
            String intent_val2="";

            double intent_d1=0;
            double intent_d2=0;

            if(intent_calculate.contains("+")){
                String arr_calculate[]=intent_calculate.split("\\+");

                intent_val1=arr_calculate[0];
                intent_val2=arr_calculate[1];

                intent_d1=Double.parseDouble(intent_val1);
                intent_d2=Double.parseDouble(intent_val2);
                intent_result=intent_d1+intent_d2;

                text_Result.setText(intent_d1+" + "+intent_d2+" = "+intent_result);
            }
            else if(intent_calculate.contains("-")){
                String arr_calculate[]=intent_calculate.split("-");

                intent_val1=arr_calculate[0];
                intent_val2=arr_calculate[1];

                intent_d1=Double.parseDouble(intent_val1);
                intent_d2=Double.parseDouble(intent_val2);
                intent_result=intent_d1-intent_d2;

                text_Result.setText(intent_d1+" - "+intent_d2+" = "+intent_result);
            }
            else if(intent_calculate.contains("*")){
                String arr_calculate[]=intent_calculate.split("\\*");

                intent_val1=arr_calculate[0];
                intent_val2=arr_calculate[1];

                intent_d1=Double.parseDouble(intent_val1);
                intent_d2=Double.parseDouble(intent_val2);
                intent_result=intent_d1*intent_d2;

                text_Result.setText(intent_d1+" * "+intent_d2+" = "+intent_result);
            }
            else{
                String arr_calculate[]=intent_calculate.split("/");

                intent_val1=arr_calculate[0];
                intent_val2=arr_calculate[1];

                intent_d1=Double.parseDouble(intent_val1);
                intent_d2=Double.parseDouble(intent_val2);
                intent_result=intent_d1/intent_d2;

                text_Result.setText(intent_d1+" / "+intent_d2+" = "+intent_result);
            }
        }


   }

   public void onClick_webView(View v){
       Intent intent=new Intent(this, MyWebBrowser.class);
       startActivity(intent);
   }
    final Button.OnClickListener mListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.add:
                    text_Result.setText(text_Result.getText() + "  +  ");
                    type = ADD;
                    break;

                case R.id.subtract:
                    text_Result.setText(text_Result.getText() + "  -  ");
                    type = SUB;
                    break;

                case R.id.multiply:
                    text_Result.setText(text_Result.getText() + "  *  ");
                    type = MUL;
                    break;

                case R.id.divide:
                    text_Result.setText(text_Result.getText() + "  /  ");
                    type = DIV;
                    break;

                case R.id.equal:
                    if (type == ADD) {
                        String[] arr_result = text_Result.getText().toString().split(" + ");
                        val1 = arr_result[0];
                        val2=arr_result[2];
                        d1 = Double.parseDouble(val1);
                        d2 = Double.parseDouble(val2);
                        result=d1+d2;
                        text_Result.setText(text_Result.getText() + "=" + result);
                    }
                    else if(type == SUB){
                        String[] arr_result = text_Result.getText().toString().split(" - ");
                        val1 = arr_result[0];
                        val2=arr_result[1];
                        d1 = Double.parseDouble(val1);
                        d2 = Double.parseDouble(val2);
                        result=d1-d2;
                        text_Result.setText(text_Result.getText() + "=" + result);
                    }
                    else if(type == MUL){
                        String[] arr_result = text_Result.getText().toString().split(" * ");

                        val1 = arr_result[0];
                        val2=arr_result[2];

                        d1 = Double.parseDouble(val1);
                        d2 = Double.parseDouble(val2);

                        result=d1*d2;
                        text_Result.setText(text_Result.getText() + " = " + result);
                    }

                    else{
                        String[] arr_result = text_Result.getText().toString().split(" / ");

                        val1 = arr_result[0];
                        val2=arr_result[1];

                        d1 = Double.parseDouble(val1);
                        d2 = Double.parseDouble(val2);

                        result=d1/d2;
                        text_Result.setText(text_Result.getText() + " = " + result);
                    }

                    break;
            }
        }
    };

    public void onClick(View v){
        switch(v.getId()){
            case R.id.zero:
                text_Result.setText(text_Result.getText().toString()+0); break;

            case R.id.one :
                text_Result.setText(text_Result.getText().toString()+1); break;

            case R.id.two:
                text_Result.setText(text_Result.getText().toString()+2); break;

            case R.id.three:
                text_Result.setText(text_Result.getText().toString()+3); break;

            case R.id.four:
                text_Result.setText(text_Result.getText().toString()+4); break;

            case R.id.five:
                text_Result.setText(text_Result.getText().toString()+5); break;

            case R.id.six:
                text_Result.setText(text_Result.getText().toString()+6); break;

            case R.id.seven:
                text_Result.setText(text_Result.getText().toString()+7); break;

            case R.id.eight:
                text_Result.setText(text_Result.getText().toString()+8); break;

            case R.id.nine:
                text_Result.setText(text_Result.getText().toString()+9); break;

            case R.id.dot:
                text_Result.setText(text_Result.getText().toString()+"."); break;
        }
    }
}