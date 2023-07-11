package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.input);

        editText.setShowSoftInputOnFocus(false);

        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getString(R.string.display).equals(editText.getText().toString())){
                    editText.setText("");
                }
            }
        });
    }
    private void updateText (String strToAdd){
        String oldStr = editText.getText().toString();
        int cursorPosition = editText.getSelectionStart();
        String leftStr = oldStr.substring(0,cursorPosition);
        String rightStr = oldStr.substring(cursorPosition);
        if (getString(R.string.display).equals(editText.getText().toString())){
            editText.setText(strToAdd);
            editText.setSelection(cursorPosition+1);
        }else {
            editText.setText(String.format("%s%s%s",leftStr,strToAdd,rightStr));
            editText.setSelection(cursorPosition+1);
        }


    }
    public void zerobut (View view){
        updateText("0");
    }
    public void onebut (View view){
        updateText("1");
    }
    public void twobut (View view){
        updateText("2");
    }
    public void threebut (View view){
        updateText("3");
    }
    public void fourbut (View view){
        updateText("4");
    }
    public void fivebut (View view){
        updateText("5");
    }
    public void sixbut (View view){
        updateText("6");
    }
    public void sevenbut (View view){
        updateText("7");
    }
    public void eightbut (View view){
        updateText("8");
    }
    public void ninebut (View view){
        updateText("9");
    }
    public void addbut (View view){
        boolean T = !editText.getText().toString().substring(editText.getText().length() - 1).equals("+");
        if (T) {
            updateText("+");
        }
    }
    public void subbut (View view){
        boolean T = !editText.getText().toString().substring(editText.getText().length() - 1).equals("-");
        if (T) {
            updateText("-");
        }
    }
    public void multiplybut (View view){
        boolean T = !editText.getText().toString().substring(editText.getText().length() - 1).equals("*");
        if(T){
            updateText("*");
        }
    }
    public void dividebut (View view){
        boolean T = !editText.getText().toString().substring(editText.getText().length() - 1).equals("/");
        if (T) {
            updateText("/");
        }
    }
    public void exponentbut (View view){
        updateText("^");
    }
    public void clearbut (View view){ editText.setText("");}
    public void bracketbut (View view){
        int openpar = 0;
        int closepar = 0;
        int curPosition = editText.getSelectionStart();
        int textLength = editText.getText().length();
        for (int i = 0; i<textLength ; i++){
            if (editText.getText().toString().charAt(i) == '('){
                openpar +=1 ;
            }
            if (editText.getText().toString().charAt(i) == ')'){
                closepar +=1 ;
            }
        }
        if (openpar==closepar || editText.getText().toString().substring(textLength-1,textLength).equals("(")){
            updateText("(");
        }
        else if (closepar < openpar && !editText.getText().toString().substring(textLength-1,textLength).equals("(")){
            updateText(")");
        }
        editText.setSelection(curPosition+1);
    }
    public void equalsbut (View view){
        String userExp = editText.getText().toString();
        Expression expression = new Expression(userExp);
        String result = String.valueOf(expression.calculate());
        editText.setText(result);
        editText.setSelection(result.length());
    }
    public void backspacebut (View view){
        int curPosition = editText.getSelectionStart();
        int textLength = editText.length();
        if (curPosition !=0 && textLength != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) editText.getText();
            selection.replace(curPosition-1,curPosition,"");
            editText.setText(selection);
            editText.setSelection(curPosition-1);
        }
    }
    public void plusminusbut (View view){
        boolean T = !editText.getText().toString().substring(editText.getText().length() - 1).equals("-");
        if (T){updateText("-");}
    }
    public void pointbut (View view){
        boolean T = !editText.getText().toString().contains(".");
        if ((editText.getText().toString().lastIndexOf(".")<editText.getText().toString().
                lastIndexOf("+"))||(editText.getText().toString().lastIndexOf(".")<
                editText.getText().toString().lastIndexOf("-"))||(editText.getText().toString()
                .lastIndexOf(".")<editText.getText().toString().lastIndexOf("*"))||
                (editText.getText().toString().lastIndexOf(".")<editText.getText().toString()
                        .lastIndexOf("/"))||(editText.getText().toString().lastIndexOf(".")
                <editText.getText().toString().lastIndexOf("^"))) {
            updateText(".");
        }
        else if (T){
            updateText(".");
        }
    }
}