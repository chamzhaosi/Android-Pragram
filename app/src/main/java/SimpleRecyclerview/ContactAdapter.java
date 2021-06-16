package SimpleRecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.neweramay2021_project2.R;

import org.jetbrains.annotations.NotNull;

import java.lang.invoke.ConstantCallSite;
import java.util.ArrayList;

class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    private ArrayList<Contact> contactList;
    private Context context;

    public ContactAdapter(Context context, ArrayList<Contact> list){
        this.contactList = list;
        this.context = context;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from(context).inflate(R.layout.single_row_contact, parent, false);

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_row_contact, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ContactAdapter.ViewHolder holder, int position) {
        Contact contact = contactList.get(position);

        holder.tvName.setText(contact.getName());
        holder.tvPhoneNumber.setText(contact.getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvName, tvPhoneNumber;

        public ViewHolder (View itemView){
            super(itemView);

            tvName = itemView.findViewById(R.id.name);
            tvPhoneNumber = itemView.findViewById(R.id.phone);
        }
    }

}
