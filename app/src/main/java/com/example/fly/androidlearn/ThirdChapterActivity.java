package com.example.fly.androidlearn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import org.apache.commons.lang3.StringUtils;

public class ThirdChapterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText thirdEdit;

    private ImageView thirdImage;

    private ProgressBar thirdProgress;

    private boolean flag = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_chapter);

        Button thirdBtn = (Button) findViewById(R.id.third_btn);
        thirdBtn.setOnClickListener(this);

        Button thirdBtn2 = (Button) findViewById(R.id.third_btn_2);
        thirdBtn2.setOnClickListener(this);

        thirdEdit = (EditText) findViewById(R.id.third_edit);

        thirdImage = (ImageView) findViewById(R.id.third_image);

        thirdProgress = (ProgressBar) findViewById(R.id.third_progress);
    }

    @Override
    public void onClick(View v) {
        try {
            switch (v.getId()) {
                case R.id.third_btn:
                    String msg = thirdEdit.getText().toString();
                    if (StringUtils.isNotBlank(msg)) {
                        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "没有输入任何东西", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.third_btn_2:
                    thirdProgress.setVisibility(View.VISIBLE);
                    if (flag) {
                        thirdImage.setImageResource(R.drawable.img_2);
                        flag = false;
                    } else {
                        thirdImage.setImageResource(R.drawable.img_1);
                        flag = true;
                    }
                    thirdProgress.setVisibility(View.GONE);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
