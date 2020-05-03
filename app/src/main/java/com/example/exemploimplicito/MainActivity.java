package com.example.exemploimplicito;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void verMapa(View view)
    {
        // Localização georreferenciada é possível efetuar a busca ou informar as coordenadas

        //coordenadas, onde geo:latitude,longitude; z = o nível de zoom
        Uri location = Uri.parse("geo:-23.562549,-46.655127?z=14");
        // busca de localiza&ccedil;&atilde;o : (geo:0,0?q="parametros de busca")
        //Uri localizacao= Uri.parse("geo:0,0?q=Museu+de+Arte+de+São+Paulo+Assis+Chateaubriand");


        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        startActivity(mapIntent );

    }

    public void fazerChamada(View view)
    {
        Uri uri = Uri.parse("tel:123456789");
        Intent it = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(it);

    }

    public void abrirSite(View view)
    {
        Uri uri = Uri.parse("http://www.google.com");
        Intent it = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(it);

    }
    public void enviarEmail(View view) throws UnsupportedEncodingException {

        //formata o conteúdo do email
        String uriText =
                "mailto:seuemail@gmail.com" +
                        "?subject=" + URLEncoder.encode("assunto do email", "utf-8") +
                        "&body=" + URLEncoder.encode("texto do email", "utf-8");
        Uri uri = Uri.parse(uriText);
        //inicia a Intent
        Intent it = new Intent(Intent.ACTION_SENDTO);
        //Define o conteúdo
        it.setData(uri);
        //Inicia a activity para enviar o email
        startActivity(Intent.createChooser(it, "Enviar Email"));

    }

    public void efetuarBusca(View view)
    {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        String query = "Museu de Arte de São Paulo";
        intent.putExtra(SearchManager.QUERY, query);
        startActivity(intent);


    }





}