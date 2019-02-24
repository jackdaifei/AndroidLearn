package com.example.fly.androidlearn;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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

    private ProgressBar thirdProgress2;

    private boolean flag = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_chapter);

        Button thirdBtn = (Button) findViewById(R.id.third_btn);
        thirdBtn.setOnClickListener(this);

        Button thirdBtn2 = (Button) findViewById(R.id.third_btn_2);
        thirdBtn2.setOnClickListener(this);

        Button thirdBtn3 = (Button) findViewById(R.id.third_btn_3);
        thirdBtn3.setOnClickListener(this);

        Button thirdBtn4 = (Button) findViewById(R.id.third_btn_4);
        thirdBtn4.setOnClickListener(this);

        Button thirdBtn5 = (Button) findViewById(R.id.third_btn_5);
        thirdBtn5.setOnClickListener(this);

        Button thirdBtn6 = (Button) findViewById(R.id.third_btn_6);
        thirdBtn6.setOnClickListener(this);

        thirdEdit = (EditText) findViewById(R.id.third_edit);

        thirdImage = (ImageView) findViewById(R.id.third_image);

        thirdProgress = (ProgressBar) findViewById(R.id.third_progress);

        thirdProgress2 = (ProgressBar) findViewById(R.id.third_progress2);
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
                    if (flag) {
                        thirdImage.setImageResource(R.drawable.img_2);
                        flag = false;
                    } else {
                        thirdImage.setImageResource(R.drawable.img_1);
                        flag = true;
                    }
                    break;
                case R.id.third_btn_3:
                    if (View.VISIBLE == thirdProgress.getVisibility()) {
                        thirdProgress.setVisibility(View.GONE);
                    } else {
                        thirdProgress.setVisibility(View.VISIBLE);
                    }
                    break;
                case R.id.third_btn_4:
                    int progress = thirdProgress2.getProgress();
                    if (progress < 100) {
                        progress += 10;
                    } else {
                        progress = 0;
                    }
                    thirdProgress2.setProgress(progress);
                    break;
                case R.id.third_btn_5:
                    AlertDialog.Builder dialog = new AlertDialog.Builder(ThirdChapterActivity.this);
                    dialog.setTitle("This is Dialog.");
                    dialog.setMessage("Something important!!!");
                    dialog.setCancelable(false);
                    dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    dialog.show();
                    break;
                case R.id.third_btn_6:
                    ProgressDialog progressDialog = new ProgressDialog(ThirdChapterActivity.this);

                    progressDialog.setTitle("This is ProgressDialog.");
                    progressDialog.setMessage("Loading...");
                    progressDialog.setCancelable(true);
                    progressDialog.show();
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
