package com.example.myapplication001;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView show,show2;
    private Button btn1,btn2,btn3,btn4,btn5,btn6;
    String[] food1 ={"炒飯","炒麵","水餃","拉麵","炒泡麵","麻醬麵","鍋燒意麵","井飯","義大利麵","焗烤飯","碗粿","麵線","牛排","燒烤","咖哩飯","牛肉麵","火鍋","沙拉","三明治","定食","麥當勞","肯德基","丹丹漢堡","7-11便利商店",
            "披薩","漢堡","燉飯"};
    int[] def = new int[99];
    Random good = new Random();
    boolean r=false,book=false;
    int c=0;
    int d=0;
int u=27;
String q="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        { for (int a = 0 ; a < u-1 ; a++){

            def[a] = (int) (Math.floor(Math.random() *(u-1)))+1;



            for (int j = 0; j < a; j++)
            {
                if (def[j] == def[a])
                {
                    a--;
                    break;
                }
            }
        }}
        for(int i=0;i<u;i++){
            q+=food1[i]+"\n";


        }
        show2 = (TextView)findViewById(R.id.show2);
        show = (TextView)findViewById(R.id.show);
        btn1 = (Button)findViewById(R.id.button);
        btn2= (Button)findViewById(R.id.button2);
        btn3= (Button)findViewById(R.id.button3);
        btn4= (Button)findViewById(R.id.button4);
        btn5= (Button)findViewById(R.id.button5);
        btn6= (Button)findViewById(R.id.button6);
        btn2.setVisibility(View.INVISIBLE);
        btn3.setVisibility(View.INVISIBLE);
        btn5.setVisibility(View.INVISIBLE);
        btn6.setVisibility(View.INVISIBLE);
        show2.setVisibility(View.INVISIBLE);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn5.setVisibility(View.INVISIBLE);
                btn6.setVisibility(View.INVISIBLE);
                btn1.setVisibility(View.INVISIBLE);
                btn2.setVisibility(View.VISIBLE);
                btn3.setVisibility(View.VISIBLE);
                show.setText(food1[def[0]]);
                if(r){
                    r=false;
                    show.setText(food1[def[c]]);



                }
            }
        });









        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn5.setVisibility(View.VISIBLE);
                btn6.setVisibility(View.VISIBLE);
                btn2.setVisibility(View.INVISIBLE);
                btn3.setVisibility(View.INVISIBLE);
                btn1.setVisibility(View.VISIBLE);


            }


        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c++;
                if(c<u) {
                    btn1.setVisibility(View.VISIBLE);
                    btn2.setVisibility(View.INVISIBLE);
                    btn3.setVisibility(View.INVISIBLE);
                    show.setText("不滿意嗎?\n那就在選一次吧~");

                    r = true;
                }
                if(c>=u){

                    btn1.setVisibility(View.VISIBLE);
                    btn2.setVisibility(View.INVISIBLE);
                    btn3.setVisibility(View.INVISIBLE);
                    { for (int a = 0 ; a < u-1 ; a++){

                        def[a] = (int) (Math.floor(Math.random() * u-1))+1;



                        for (int j = 0; j < a; j++)
                        {
                            if (def[j] == def[a])
                            {
                                a--;
                                break;
                            }
                        }
                    }}
                    c=0;
                    show.setText("菜單裡已經沒有了\n要不要重頭再來?");
                }




            }


        });


        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(book){
                    book=false;
                }else {
                    book=true;
                }

if(book){
    show2.setVisibility(View.VISIBLE);
    btn2.setVisibility(View.INVISIBLE);
    btn3.setVisibility(View.INVISIBLE);
    btn1.setVisibility(View.INVISIBLE);
    show.setVisibility(View.INVISIBLE);
    btn5.setVisibility(View.INVISIBLE);
    btn6.setVisibility(View.INVISIBLE);
    btn4.setText("上一頁");

    show2.setText(q);

}else{
    show2.setVisibility(View.INVISIBLE);
    show.setVisibility(View.VISIBLE);
    btn1.setVisibility(View.VISIBLE);
    btn4.setText("菜單");
    show.setText("你好!今天想吃什麼呢?");
}








            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.google.com.tw/maps/search/"+food1[def[c]]+"/@23.852845,121.3054048,8.75z?hl=zh-TW");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.google.com.tw/search?sxsrf=ALeKk00250cO4KOJg8vFFrpwZc6AULsNhQ%3A1596076989012&source=hp&ei=vDMiX4m1O5uJr7wPj92wyAQ&q="+food1[def[c]]+"&oq="+food1[def[c]]+"&gs_lcp=CgZwc3ktYWIQAzICCAAyBQgAELEDMgUIABCxAzIFCAAQsQMyAggAMgIIADICCAAyAggAMgIIADICCAA6CAgAELEDEIMBUNQWWOsdYPwgaABwAHgAgAE1iAHlApIBATeYAQCgAQGqAQdnd3Mtd2l6&sclient=psy-ab&ved=0ahUKEwiJg9mP-vPqAhWbxIsBHY8uDEkQ4dUDCAk&uact=5");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });


    }




}


