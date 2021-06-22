package SimpleRecycleviewJSON;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.neweramay2021_project2.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

class UsernameAdapter extends RecyclerView.Adapter<UsernameAdapter.ViewHolder> {
    private ArrayList<String> list = new ArrayList<>();
    private Context context;

    public UsernameAdapter(Context context, ArrayList<String> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_row_username_recycleview, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull UsernameAdapter.ViewHolder holder, int position) {
        String name = list.get(position);

        holder.tvUsername.setText(name);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvUsername;

        public ViewHolder(View itemView){
            super(itemView);

            tvUsername = itemView.findViewById(R.id.tvUsername);
        }
    }
}
