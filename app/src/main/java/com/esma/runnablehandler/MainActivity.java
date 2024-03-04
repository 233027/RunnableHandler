package com.esma.runnablehandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//Koronemetre
public class MainActivity extends AppCompatActivity {

    TextView textView;
    int number;
    Runnable runnable; // bir işlemi birden fazla kez belirttiğimiz periyotta yapmamızı sağlar
    Handler handler;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textView);
        number = 0;
        button=findViewById(R.id.button);
    }

    public void start(View view){

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                textView.setText("Time: " +  number);
                number++;
                textView.setText("Time:" + number);
                handler.postDelayed(runnable,1000);//runnable yi çalıştırmak için kullanıyoruz
            }
        };

        handler.post(runnable);
        button.setEnabled(false);// dersek butona birden fazla tıklayamayız
    }

    public void stop(View view){
        button.setEnabled(true);
        handler.removeCallbacks(runnable);//runnable ı kapat
        number=0;
        textView.setText("Time: " + number);
    }
}