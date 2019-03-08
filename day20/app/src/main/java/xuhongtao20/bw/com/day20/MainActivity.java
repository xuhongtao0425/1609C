package xuhongtao20.bw.com.day20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.back).setOnClickListener(this);
        findViewById(R.id.tijiao).setOnClickListener(this);
        textView = findViewById(R.id.text);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                Toast.makeText(this, "我是返回按钮,此页面finish", Toast.LENGTH_SHORT).show();
textView.setVisibility(View.GONE);
                break;
            case R.id.tijiao:
                Toast.makeText(this, "我是提交按钮", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
