package Tutorial04;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.neweramay2021_project2.MainActivity;
import com.example.neweramay2021_project2.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ContactListviewActivity extends AppCompatActivity {

    private ArrayList<Contact_Listview> data = new ArrayList<>();
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_listview);
        findViews();
        initContactList();
        setContactAdapter();
        setListeners();
    }

    public void findViews(){
        listview = findViewById(R.id.listview);
    }

    public void initContactList(){
        data.add(new Contact_Listview("Cham", "+60789456123"));
        data.add(new Contact_Listview("Ali", "+60123456789"));
        data.add(new Contact_Listview("Ming", "+60741852963"));
        data.add(new Contact_Listview("Lim", "+6369258147"));
        data.add(new Contact_Listview("Khoo", "+6987456321"));
        data.add(new Contact_Listview("Home", "+6069511537"));
    }

    public void setContactAdapter(){
        ContactListAdapter adapter = new ContactListAdapter(ContactListviewActivity.this, data);
        listview.setAdapter(adapter);
    }

//    @SuppressLint("MissingSuperCall")
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull @NotNull String[] permissions, @NonNull @NotNull int[] grantResults) {
//        if(requestCode == 101)
//        {
//            if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
//            {
//                setListeners();
//            }
//        }
//    }

    public void setListeners(){
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String userClickPhone = data.get(position).getPhone().toString();
                Toast.makeText(ContactListviewActivity.this, "Phone: " + userClickPhone, Toast.LENGTH_SHORT).show();

                if(Build.VERSION.SDK_INT > 22)
                {
                    if (ActivityCompat.checkSelfPermission(ContactListviewActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(ContactListviewActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 101);
                        return;
                    }
                    Intent phoneCall = new Intent(Intent.ACTION_CALL);
                    phoneCall.setData(Uri.parse("tel:" + userClickPhone));
                    startActivity(phoneCall);

//                }else {
//                    Intent phoneCall = new Intent(Intent.ACTION_CALL);
//                    phoneCall.setData(Uri.parse("tel:" + userClickPhone));
//                    startActivity(phoneCall);
                }
            }
        });
    }
}