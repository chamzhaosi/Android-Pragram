package SimpleListView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.neweramay2021_project2.R;

import java.util.ArrayList;

public class SimpleListviewActivity extends AppCompatActivity {

    private ArrayList<String> arraydata = new ArrayList<>();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_listview);
        findView();
        populateArrayList();
        initListview();
    }

    private void findView(){
        listView = findViewById(R.id.listview);
    }

    private void populateArrayList(){
        arraydata.add("Mango");
        arraydata.add("Rambutan");
        arraydata.add("Pineapple");
        arraydata.add("Orange");

        for (int i=0; i<50; i++){
            arraydata.add("Guava");
        }
    }

    private void initListview(){
        FruitAdapter adapter = new FruitAdapter(SimpleListviewActivity.this, arraydata);
        listView.setAdapter(adapter);
    }
}