package SimpleRecycleviewJSON;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.neweramay2021_project2.R;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class Recycleview_JSON_Activity extends AppCompatActivity {
    private OkHttpClient client =new OkHttpClient();
    private ArrayList<String> username = new ArrayList<>();
    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview_json);
        findView();
        initalData();
        //setAdapter();
    }

    private void findView(){
        recyclerView = findViewById(R.id.recycleView);
        progressBar = findViewById(R.id.progressBar);
    }

    private void initalData(){
        progressBar.setVisibility(View.VISIBLE);
        Request request = new Request.Builder()
                .url("https://api.jsonbin.io/b/60d19ca18ea8ec25bd12e1d6")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                runOnUiThread(()->{
                    progressBar.setVisibility(View.GONE);
                    e.printStackTrace();
                });
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.body() != null){
                    try{
                        JSONObject resObject = new JSONObject(response.body().string());
                        JSONArray userArray = resObject.getJSONObject("record").getJSONArray("user");

                        for (int i=0; i<userArray.length(); i++){
                            username.add(userArray.getString(i));
                        }

                        runOnUiThread(()->{
                            progressBar.setVisibility(View.GONE);
                            setAdapter();
                        });

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });

    }

    private void setAdapter(){
        UsernameAdapter adapter = new UsernameAdapter(Recycleview_JSON_Activity.this, username);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}