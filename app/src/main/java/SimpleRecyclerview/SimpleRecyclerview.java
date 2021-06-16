package SimpleRecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.neweramay2021_project2.R;

import java.util.ArrayList;

public class SimpleRecyclerview extends AppCompatActivity {

    private ArrayList <Contact> contactArrayList = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_recyclerview);
        findViews();
        initRcyclerview();
    }

    private void findViews(){
        recyclerView = findViewById(R.id.recycleview);
    }

    private void initRcyclerview(){
        contactArrayList.add(new Contact("Xiao Ming", "+7894561233"));
        contactArrayList.add(new Contact("Xiao Xin", "+1472583699"));
        contactArrayList.add(new Contact("Xiao Hua", "+7412589633"));
        contactArrayList.add(new Contact("Xiao Fu", "+9876543211"));
        contactArrayList.add(new Contact("Xiao Bai", "+9638527411"));
        contactArrayList.add(new Contact("Xiao Fang", "+1234567899"));

        for (int i=0; i<50; i++) {
            contactArrayList.add(new Contact("Cham", "0" + Integer.toString(i)));
        }

        ContactAdapter adapter = new ContactAdapter(SimpleRecyclerview.this, contactArrayList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}