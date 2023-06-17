package internship.app.commercial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

public class product extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<productlist> arrayList;

    String[] productnamearray = {"Keyboard","Backlight  Keyboard","Black and Grey Keyboard","White Keyboard"};
    int[] productimagearray = {R.drawable.keyboard_1,R.drawable.keyboard_2,R.drawable.keyboard_3,R.drawable.keyboard_4};
    String[] productpricearray = {"200","400","500","900"};
    String[] productunitarray = {"1 piece","1 piece","1 piece","1 piece"};
    String[] productdesarray = {"A keyboard is for putting information including letters, words and numbers into your computer. You press the individual buttons on the keyboard when you type. The number keys across the top of the keyboard are also found on the right of the keyboard. The letter keys are in the centre of the keyboard.",
            "A gaming keypad is a small, auxiliary keyboard designed only for gaming. It has a limited number of the original keys from a standard keyboard, and they are arranged in a more ergonomic fashion to facilitate quick and efficient gaming key presses.",
            "Abiding by all the norms and quality standards, we are engaged in offering a comprehensive consignment of HP Grey Black Keyboard. Designed and developed with utmost accuracy, these are highly demanded. More to this this, these are available with us in various specifications",
            "All characters are spread onto high quality, non-transparent white vinyl with intense adhesive, so these stickers aren’t going anywhere! Low thickness of material provide more pleasant typing. All labels have a protective coat to ensure their durability"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        getSupportActionBar().setTitle("Product");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.blue)));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.product_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(product.this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        arrayList = new ArrayList<>();
        for (int i=0;i<productnamearray.length;i++)
        {
            productlist List = new productlist();
            List.setName(productnamearray[i]);
            List.setPrice(productpricearray[i]);
            List.setUnits(productunitarray[i]);
            List.setDescription(productdesarray[i]);
            List.setImage(productimagearray[i]);
            arrayList.add(List);
        }
        ProductListAdapter Adapter = new ProductListAdapter(product.this,arrayList);
        recyclerView.setAdapter(Adapter);

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