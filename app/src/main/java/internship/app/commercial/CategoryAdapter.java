package internship.app.commercial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyHolder> {

    Context context;
    ArrayList<CategoryList>arrayList;

    public CategoryAdapter(Context homeactivity, ArrayList<CategoryList> arrayList) {
        this.context = homeactivity;
        this.arrayList = arrayList;

    }

    /**
    public CategoryAdapter(Context Homeactivity, String[] categorynamearray, int[] categoryimagearray) {
        this.context = Homeactivity;
        this.categorynamearray = categorynamearray;
        this.categoryimagearray = categoryimagearray;
    }**/

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_category,parent,false);
        return new MyHolder(view);
    }
    public class MyHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.custom_category_image);
            name = itemView.findViewById(R.id.custom_category_name);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.imageView.setImageResource(arrayList.get(position).getImg());
        holder.name.setText(arrayList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}
