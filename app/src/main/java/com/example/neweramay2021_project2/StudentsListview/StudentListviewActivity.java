package com.example.neweramay2021_project2.StudentsListview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.example.neweramay2021_project2.R;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class StudentListviewActivity extends AppCompatActivity {
        private OkHttpClient client = new OkHttpClient();
        private ArrayList<Student> studentArrayList = new ArrayList<Student>();
        private ListView listView;
        private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_listview);
        findView();
        initAdapterView();
    }

    private void findView(){
        listView = findViewById(R.id.studentListview);
        progressBar = findViewById(R.id.progressBar);
    }

    private void initAdapterView(){
        Request request = new Request.Builder()
                .url("https://api.jsonbin.io/b/5f2773c81823333f8f1afec3/1")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                runOnUiThread(()->{
                    progressBar.setVisibility(View.VISIBLE);
                });
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.body() != null){
                    try{
                        JSONObject studentData = new JSONObject(response.body().string());
                        JSONArray studentDataArray = studentData.getJSONArray("response");

                        for(int i=0; i<studentDataArray.length(); i++){
                            JSONObject object = studentDataArray.getJSONObject(i);
                            Student student = new Student();

                            student.setStudentID(object.getString("id"));
                            student.setName(object.getString("name"));
                            student.setCourse(object.getString("course"));
                            student.setPhoto(object.getString("photo"));

                            studentArrayList.add(student);
                        }

                        runOnUiThread(() ->{
                            progressBar.setVisibility(View.GONE);
                            StudentAdapter adapter = new StudentAdapter(StudentListviewActivity.this, studentArrayList);
                            listView.setAdapter(adapter);
                        });


                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}