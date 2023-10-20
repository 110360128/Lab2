package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText ed_name;
    private TextView tv_text, tv_name, tv_winner,tv_mmora,  tv_cmora;
    private RadioButton btn_scissor, btn_stone, btn_paper;
    private Button btn_mora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //連結xml的元件
        ed_name = findViewById(R.id.editTextText);
        tv_text = findViewById(R.id.textView);
        tv_name = findViewById(R.id.tv_name);
        tv_winner = findViewById(R.id.textView3);
        tv_mmora = findViewById(R.id.textView4);
        tv_cmora = findViewById(R.id.textView5);
        btn_scissor = findViewById(R.id.radioButton);
        btn_stone = findViewById(R.id.radioButton2);
        btn_paper = findViewById(R.id.radioButton3);
        btn_mora = findViewById(R.id.button);

        btn_mora.setOnClickListener(view ->{
            if(ed_name.length() < 1){
                tv_text.setText("請輸入玩家姓名");
            }else {
                tv_name.setText(String.format("姓名\n%s", ed_name.getText().toString()));
                if (btn_scissor.isChecked()){
                    tv_mmora.setText("我方出拳\n剪刀");
                }else if(btn_stone.isChecked()){
                    tv_mmora.setText("我方出拳\n石頭");
                }else{
                    tv_mmora.setText("我方出拳\n布");
                }

                int computer_random = (int) (Math.random()*3);

                if(computer_random == 0){
                    tv_cmora.setText("電腦出拳\n剪刀");
                }else if (computer_random == 1){
                    tv_cmora.setText("電腦出拳\n石頭");
                }else{
                    tv_cmora.setText("電腦出拳\n布");
                }

                if ((btn_scissor.isChecked() && computer_random == 2) ||
                        (btn_stone.isChecked() && computer_random == 0) ||
                        (btn_paper.isChecked() && computer_random == 1)){
                    tv_winner.setText("勝利者\n" + ed_name.getText().toString());
                    tv_text.setText("恭喜你獲勝了");
                } else if ((btn_scissor.isChecked() && computer_random == 1) ||
                        (btn_stone.isChecked() && computer_random == 2) ||
                                (btn_paper.isChecked() && computer_random == 0)){
                tv_winner.setText("勝利者\n電腦");
                tv_text.setText("可惜，電腦獲勝");
                    }else{
                        tv_winner.setText("勝利者\n平手");
                        tv_text.setText("平局，請再試一次");
                    }
                }

        });

    }
}