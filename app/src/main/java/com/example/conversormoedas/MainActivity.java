package com.example.conversormoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mViewHolder.editValor = findViewById(R.id.edit_valor);
        this.mViewHolder.textDolar = findViewById(R.id.text_dolar);
        this.mViewHolder.textEuro = findViewById(R.id.text_euro);
        this.mViewHolder.buttonCalcular = findViewById(R.id.buttonCalcular);
        this.mViewHolder.buttonCalcular.setOnClickListener((View.OnClickListener) this);
//gg
        EditText valor = findViewById(R.id.edit_valor);
        valor.getText();
    }

    private static class ViewHolder{
        EditText editValor;
        TextView textDolar;
        TextView textEuro;
        Button buttonCalcular;
    }

    public void onClick(View v) {
        if (v.getId() == R.id.buttonCalcular){
            String valor = this.mViewHolder.editValor.getText().toString();
            if ("".equals(valor)) {
                //mostra mensagem pro usuario
                Toast.makeText(this, this.getString(R.string.informe_valor),Toast.LENGTH_LONG).show();
            } else {
                Double real = Double.valueOf(valor);
                this.mViewHolder.textDolar.setText(String.format("%.2f",(real / 5)));
                this.mViewHolder.textEuro.setText(String.format("%.2f",(real / 6)));
            }
        }
    }

    private void clearValues() {
        this.mViewHolder.textEuro.setText("");
        this.mViewHolder.textDolar.setText("");
    }

}