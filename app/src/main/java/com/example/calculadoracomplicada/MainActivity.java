package com.example.calculadoracomplicada;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Stack;


public class MainActivity extends AppCompatActivity {

    Button botao_soma;
    Button botao_mult;
    TextView resultado;
    EditText inserir;
    Boolean primeiro = true;
    private Stack<String> stack1 = new Stack<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao_soma = findViewById(R.id.botao_soma);
        botao_mult = findViewById(R.id.botao_mult);
        resultado = findViewById(R.id.resultado);
        inserir = findViewById(R.id.inserir);


    }


    public void irsoma(View f) {
        if (primeiro) {
            stack1.add(String.valueOf(inserir.getText()));
            primeiro = false;
        } else {
            stack1.add(String.valueOf(inserir.getText()));
        }
        char[] a, b;
        int[] c = new int[30];
        String passando = "";
        String temp2 = "", temp1 = "";
        String pop2;
        pop2 = stack1.pop();
        String pop1 = stack1.pop();
        a = pop1.toCharArray();
        b = pop2.toCharArray();
        for (int i = pop1.length() - 1; i >= 0; i--) {
            temp1 = temp1 + a[i];
        }
        for (int i = pop2.length() - 1; i >= 0; i--) {
            temp2 = temp2 + b[i];
        }
        a = temp1.toCharArray();
        b = temp2.toCharArray();
        for (int i = 0; i < pop1.length(); i++) {
            c[i] = c[i] + Character.getNumericValue(a[i]);
        }
        for (int i = 0; i < pop2.length(); i++) {
            c[i] = c[i] + Character.getNumericValue(b[i]);
            c[i + 1] = c[i + 1] + (c[i] / 10);
            c[i] = c[i] - (10 * (c[i] / 10));
        }
        if (pop1.length() > pop2.length()) {
            if (c[pop1.length()] != 0) {
                passando += Integer.toString(c[pop1.length()]);
            }
            for (int i = pop1.length() - 1; i >= 0; i--) {
                passando = passando + Integer.toString(c[i]);
            }
        } else {
            if (c[pop2.length()] != 0) {
                passando += Integer.toString(c[pop2.length()]);
            }
            for (int i = pop2.length() - 1; i >= 0; i--) {
                passando = passando + Integer.toString(c[i]);
            }
        }
        stack1.push(passando);
        resultado.setText(stack1.peek());
        primeiro = true;

    }



    public void irmult(View f) {
        if (primeiro) {
            stack1.add(String.valueOf(inserir.getText()));
            primeiro = false;
        } else {
            stack1.add(String.valueOf(inserir.getText()));
        }
        char[] a, b;
        int[] c = new int[30];
        String passando = "";
        String pop2 = stack1.pop();
        String pop1 = stack1.pop();
        b = pop2.toCharArray();
        a = pop1.toCharArray();
        for (int i = pop1.length() - 1; i >= 0; i--) {
            for (int j = pop2.length() - 1; j >= 0; j--) {
                c[j + i] = c[j + i] + Character.getNumericValue(a[i]) * Character.getNumericValue(b[j]);
                if (j + i - 1 >= 0) {
                    c[j + i - 1] = c[j + i - 1] + (c[j + i] / 10);
                    c[j + i] = c[j + i] - (10 * (c[j + i] / 10));
                }
            }
        }
        for (int i = 0; i <= pop2.length() + pop1.length() - 2; i++) {
            passando = passando + Integer.toString(c[i]);
        }
        stack1.push(passando);
        resultado.setText(stack1.peek());
        primeiro = true;
    }
}