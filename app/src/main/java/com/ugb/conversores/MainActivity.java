package com.ugb.conversores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TabHost tbhConversores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tbhConversores = (TabHost)findViewById(R.id.tbhConversores);
        tbhConversores.setup();

        tbhConversores.addTab(tbhConversores.newTabSpec("M").setContent(R.id.tabMoneda).setIndicator("Moneda"));
        tbhConversores.addTab(tbhConversores.newTabSpec("L").setContent(R.id.tabLongitud).setIndicator("Longuitud"));
        tbhConversores.addTab(tbhConversores.newTabSpec("Ma").setContent(R.id.tabMasa).setIndicator("Masa"));
    }
    public void calcular(View v){
        TextView tmpVal = (TextView)findViewById(R.id.txtCantidad);
        double cantidad  = Double.parseDouble(tmpVal.getText().toString());

        Spinner spn;
        double valores[][] = {
                new double[]{1, 0.84,7.67169,24.5016,34.76,8.75,22.03,6.91,802.50,3784.05,73.43,1.39,1.32,105.98,6949.57,74.78,42.51},//monedas
                new double[]{1,0.001,100,1000,1000000,1000000000,0.0006,1.0936,3.2808,39.9701,0.00053996}, //longitud
                new double[]{1,0.00045359,0.4535923,453.5923,453592.37,0.00000004535923,0.0004464286,0.0005,0.0089285714,0.01,16} //masa
        };
        int de=0, a=0;
        double resp = 0;
        switch (tbhConversores.getCurrentTabTag()){
            case "M":
                spn = (Spinner)findViewById(R.id.cboDeM);
                de = spn.getSelectedItemPosition();
                spn = (Spinner)findViewById(R.id.cboAM);
                a = spn.getSelectedItemPosition();
                resp = valores[0][a] / valores[0][de] * cantidad;
                break;
            case "L":
                spn = (Spinner)findViewById(R.id.cboDeL);
                de = spn.getSelectedItemPosition();
                spn = (Spinner)findViewById(R.id.cboAL);
                a = spn.getSelectedItemPosition();
                resp = valores[1][a] / valores[1][de] * cantidad;
                break;
            case "Ma":
                spn = (Spinner)findViewById(R.id.cboDema);
                de = spn.getSelectedItemPosition();
                spn = (Spinner)findViewById(R.id.cboAma);
                a = spn.getSelectedItemPosition();
                resp = valores[2][a] / valores[2][de] * cantidad;
                break;

        }
        tmpVal = (TextView)findViewById(R.id.lblrespuesta);
        tmpVal.setText("Respuesta: "+ resp);
    }
}