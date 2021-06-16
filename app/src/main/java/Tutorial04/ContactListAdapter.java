package Tutorial04;

import android.content.Context;
import android.sax.TextElementListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.neweramay2021_project2.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

class ContactListAdapter extends ArrayAdapter {

    private ArrayList<Contact_Listview> list = new ArrayList<>();
    private Context context;

    ContactListAdapter (Context context, ArrayList<Contact_Listview> list){
        super (context, R.layout.single_row_contact_listview);
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View mainView = View.inflate(context, R.layout.single_row_contact_listview, null);
        TextView tvUsername = mainView.findViewById(R.id.tvUsername);
        TextView tvPhonenumber = mainView.findViewById(R.id.tvPhone);

        Contact_Listview ContactData = list.get(position);

        tvUsername.setText(ContactData.getName());
        tvPhonenumber.setText(ContactData.getPhone());

        return mainView;
    }

    @NonNull
    @Override
    public int getCount() {
        return list.size();
    }

    class ViewHolder {
        TextView tvUsername, tvPhonenumber;
    }
}
