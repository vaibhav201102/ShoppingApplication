package internship.app.commercial;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyHolder> {

    Context context;
    ArrayList<productlist> ArrayList;

    public ProductAdapter(Context context, ArrayList<productlist> productlistArrayList) {
        this.context = context;
        this.ArrayList = productlistArrayList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_product,parent,false);
        return new MyHolder(view);
    }

    public class MyHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView name,price;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.custom_product_image);
            name = itemView.findViewById(R.id.custom_product_name);
            price = itemView.findViewById(R.id.custom_product_price);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imageView.setImageResource(ArrayList.get(position).getImage());
        holder.name.setText(ArrayList.get(position).getName());
        holder.price.setText(context.getResources().getString(R.string.price_symbol)+ArrayList.get(position).getPrice()+"/"+ArrayList.get(position).getUnits());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,productdetail.class);

                Bundle bundle = new Bundle();
                bundle.putString("name",ArrayList.get(position).getName());
                bundle.putString("price",context.getResources().getString(R.string.price_symbol)+ArrayList.get(position).getPrice()+"/"+ArrayList.get(position).getUnits());
                bundle.putString("desc",ArrayList.get(position).getDescription());
                bundle.putInt("img",ArrayList.get(position).getImage());
                intent.putExtras(bundle);

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return ArrayList.size();
    }
}
