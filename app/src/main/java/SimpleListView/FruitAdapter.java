package SimpleListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.neweramay2021_project2.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

// ArrayAdapter is a parent
// supre means use thw parent's constructor
class FruitAdapter extends ArrayAdapter {
    private ArrayList<String> data;
    // Context is a datatype, but don't know what is context for...
    private Context context;

    //FruitAdapte also need a constructor
    FruitAdapter (Context context, ArrayList<String> list){
        super(context, R.layout.single_row_simple_listview);
        this.data = list;
        this.context = context;
    }

//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        //View is a datatype
//        View mainView = View.inflate(context, R.layout.single_row_simple_listview, null);
//        //Don't know why need to declare the mainview
//        TextView tvString = mainView.findViewById(R.id.tvString);
//
//        String fruitString = data.get(position);
//        tvString.setText(fruitString);
//
//        return mainView;
//    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View mainView;
        String fruitString = data.get(position);
        //Don't know what is convertView
        if (convertView == null){
            mainView = View.inflate(context, R.layout.single_row_simple_listview, null);
            ViewHolder holder = new ViewHolder();
            holder.tvString = mainView.findViewById(R.id.tvString);

            holder.tvString.setText(fruitString);
            //Don't what is setTag
            mainView.setTag(holder);
        }else {
            mainView = convertView;
            //Don;t know what is the convertview and getTag;
            ViewHolder holder = (ViewHolder) convertView.getTag();
            holder.tvString.setText(fruitString);
        }

        return mainView;

    }

    public int getCount(){
        return data.size();
    }

    class ViewHolder{
        TextView tvString;
    }
}
