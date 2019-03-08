package xuhongtaoweek.bw.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.library.AutoFlowLayout;
import com.example.library.FlowAdapter;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {

    private EditText ev;
    private Button bu;
    private AutoFlowLayout af;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ev = findViewById(R.id.ev);
        bu = findViewById(R.id.bu);
        af = findViewById(R.id.af);
        final ArrayList<String > list=new ArrayList<>();
        findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.clear();
                af.removeAllViews();
            }
        });

        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                String trim = ev.getText().toString().trim();

                list.add(trim);
                af.setAdapter(new FlowAdapter(list) {

                    private TextView text;

                    @Override
                    public View getView(int i) {
                        View view = View.inflate(Main3Activity.this, R.layout.item, null);
                        text = view.findViewById(R.id.text_item);
                        text.setText(list.get(i));
                        list.clear();

                        return view;
                    }
                });
            }
        });
    }
}
