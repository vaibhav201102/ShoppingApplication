package internship.app.commercial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

public class productdetail extends AppCompatActivity {

    ImageView imageView;
    TextView name,price,desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productdetail);


        imageView = findViewById(R.id.pd_image);
        name = findViewById(R.id.pd_name);
        price = findViewById(R.id.pd_price);
        desc = findViewById(R.id.pd_desc);

        Bundle bundle = getIntent().getExtras();
        name.setText(bundle.getString("name"));
        price.setText(bundle.getString("price"));
        desc.setText(bundle.getString("desc"));
        imageView.setImageResource(bundle.getInt("img"));


        getSupportActionBar().setTitle(bundle.getString("name"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.blue)));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}