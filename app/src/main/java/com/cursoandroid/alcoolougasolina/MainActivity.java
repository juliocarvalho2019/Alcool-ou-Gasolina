package com.cursoandroid.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        textResultado = findViewById(R.id.textResultado);

        //validar
    }

    public void calcularPreco(View view){
    //recuperar valores digitados
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();
        //Validar os campos digitados
        Boolean camposValidados = validarCampo(precoAlcool, precoGasolina);
        if(camposValidados){
            //Convertendo String para números.
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            //Fazer calculo de menor preço
            // se o valor do alcool / gazolina >= 0.7 é melhor gasolina.
            if((valorAlcool/valorGasolina) >= 0.7){
                textResultado.setText("Melhor usar gasolina!");
            }else {
                textResultado.setText("Melhor usar alcool!");
            }

        }else{
            textResultado.setText("Preencha os preços primeiro!");
        }

    }

    public Boolean validarCampo(String pAlcool, String pGazolina){
    Boolean camposValidados = true;

    if(pAlcool == null || pAlcool.equals("")){
        camposValidados = false;

    }else if(pGazolina == null || pGazolina.equals("")){
        camposValidados = false;

        }
    return camposValidados;
    }
}