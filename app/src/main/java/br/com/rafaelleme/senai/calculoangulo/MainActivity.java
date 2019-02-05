package br.com.rafaelleme.senai.calculoangulo;

import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtValorAngulo;
    RadioButton rbSeno;
    RadioButton rbCosceno;
    RadioButton rbTangente;
    Button btCalcular;
    private int opcao = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtValorAngulo = findViewById(R.id.edtValorAngulo);
        rbSeno = findViewById(R.id.rbSeno);
        rbCosceno = findViewById(R.id.rbCosceno);
        rbTangente = findViewById(R.id.rbTangente);
        btCalcular = findViewById(R.id.btCalcular);

        rbSeno.setOnClickListener(this);
        rbCosceno.setOnClickListener(this);
        rbTangente.setOnClickListener(this);
        btCalcular.setOnClickListener(this);
    }

    public double calcularSeno(double angulo){
       return Math.sin(Math.sin(Math.toRadians(angulo)));
    }

    public double calcularCosceno(double angulo){
        return Math.sin(Math.sin(Math.toRadians(angulo)));
    }

    public double calcularTangente(double angulo){
        return Math.sin(Math.sin(Math.toRadians(angulo)));
    }

    public void calcular(){
        AlertDialog digAlert;
        double angulo, valorCalculado;
        String titulo;
        angulo = Double.valueOf(edtValorAngulo.getText().toString());

        if(opcao == 1){
            titulo = "Calculo de Seno";
            valorCalculado = calcularSeno(angulo);
        }else if(opcao == 2){
            titulo = "Calculo de Cosseno";
            valorCalculado = calcularCosceno(angulo);
        }else{
            titulo = "Calculo de Tangente";
            valorCalculado = calcularTangente(angulo);
        }

        digAlert = new AlertDialog.Builder(this).create();
        digAlert.setTitle(titulo);
        String valorFormatado = String.format("%.2f",valorCalculado);
        digAlert.setMessage(String.valueOf(valorFormatado));
        digAlert.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rbSeno:
            opcao = 1;
            rbCosceno.setChecked(false);
            rbTangente.setChecked(false);
            break;

            case R.id.rbCosceno:
                opcao = 2;
                rbSeno.setChecked(false);
                rbTangente.setChecked(false);
                break;

            case R.id.rbTangente:
                opcao = 3;
                rbCosceno.setChecked(false);
                rbSeno.setChecked(false);
                break;

            case  R.id.btCalcular:
                if (validar()) {
                    calcular();
                }
                break;
        }

    }

    private boolean validar(){

        if(edtValorAngulo.getText().toString().equals("")){

            edtValorAngulo.setError("Campo obrigatório !");
            return false;
        }else {
            double valorAngulo = Double.valueOf(edtValorAngulo.getText().toString());
            if(valorAngulo >= 0 && valorAngulo <= 360){
                return true;
            }else{
                edtValorAngulo.setError("O valor deve estar entre 0 e 360");
                return false;

            }

        }
    }

}
