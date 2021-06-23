package com.example.neweramay2021_project2.StudentsListview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.neweramay2021_project2.R;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class StudentAdapter extends ArrayAdapter {
    private ArrayList<Student> studentsList = new ArrayList<>();
    private Context context;

    public StudentAdapter(Context context, ArrayList<Student> list){
        super(context, R.layout.single_row_student_listview);
        this.studentsList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View mainView = View.inflate(context, R.layout.single_row_student_listview, null);

        TextView tvStudentID = mainView.findViewById(R.id.tvStudentID);
        TextView tvName = mainView.findViewById(R.id.tvName);
        TextView tvCourse = mainView.findViewById(R.id.tvCourse);
        ImageView ivPsnPhoto = mainView.findViewById(R.id.ivpsnPhoto);

        Student studentInfo = studentsList.get(position);

        tvStudentID.setText(studentInfo.getStudentID());
        tvName.setText(studentInfo.getName());
        tvCourse.setText(studentInfo.getCourse());

//        Glide.with(context)
//                .load(studentInfo.getPhoto()
//                .placeholder(R.drawable.android01)
//                .into(ivPsnPhoto);

        Picasso.get()
                .load(studentInfo.getPhoto())
                .placeholder(R.drawable.android01)
                .into(ivPsnPhoto);


        return mainView;

//        View mainView;
//        Student studentInfo = studentsList.get(position);
//
//        if (convertView != null){
//            mainView = View.inflate(context, R.layout.single_row_student_listview, null);
//            ViewHolder holder = new ViewHolder();
//
//            holder.tvStudentID = mainView.findViewById(R.id.tvStudentID);
//            holder.tvName = mainView.findViewById(R.id.tvName);
//            holder.tvCourse = mainView.findViewById(R.id.tvCourse);
//
//            holder.tvStudentID.setText(studentInfo.getStudentID());
//            holder.tvName.setText(studentInfo.getName());
//            holder.tvCourse.setText(studentInfo.getCourse());
//
//            mainView.setTag(holder);
//        }else{
//            mainView = convertView;
//
//            ViewHolder holder = (ViewHolder) convertView.getTag();
//
//            holder.tvStudentID.setText(studentInfo.getStudentID());
//            holder.tvName.setText(studentInfo.getName());
//            holder.tvCourse.setText(studentInfo.getCourse());
//        }
//        return mainView;
    }



    @Override
    public int getCount() {
        return studentsList.size();
    }

//    public class ViewHolder{
//        private TextView tvStudentID,tvName, tvCourse;
//    }
}
