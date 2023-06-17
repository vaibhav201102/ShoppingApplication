package internship.app.commercial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class Homeactivity extends AppCompatActivity {

    TextView Title,View_all;
    SharedPreferences SP;

    RecyclerView recyclerView,productrecyclerView;
    String[] Categorynamearray = {" KeyBoard"," Printer"," Mouse"," Monitor"};
    int[] Categoryimagearray = {R.drawable.keyboard, R.drawable.printer, R.drawable.mouse, R.drawable.monitor};
    ArrayList<CategoryList> CategoryarrayList;


    String[] productnamearray = {" Keyboard"," Backlight  Keyboard"," Black and Grey Keyboard"," White Keyboard"};
    int[] productimagearray = {R.drawable.keyboard_1,R.drawable.keyboard_2,R.drawable.keyboard_3,R.drawable.keyboard_4};
    String[] productpricearray = {" 200"," 400"," 500"," 900"};
    String[] productunitarray = {" 1 piece"," 1 piece"," 1 piece"," 1 piece"};
    String[] productdesarray = {" A keyboard is for putting information including letters, words and numbers into your computer. You press the individual buttons on the keyboard when you type. The number keys across the top of the keyboard are also found on the right of the keyboard. The letter keys are in the centre of the keyboard.",
    " A gaming keypad is a small, auxiliary keyboard designed only for gaming. It has a limited number of the original keys from a standard keyboard, and they are arranged in a more ergonomic fashion to facilitate quick and efficient gaming key presses.",
    " Abiding by all the norms and quality standards, we are engaged in offering a comprehensive consignment of HP Grey Black Keyboard. Designed and developed with utmost accuracy, these are highly demanded. More to this this, these are available with us in various specifications",
    " All characters are spread onto high quality, non-transparent white vinyl with intense adhesive, so these stickers aren’t going anywhere! Low thickness of material provide more pleasant typing. All labels have a protective coat to ensure their durability"};
    ArrayList<productlist> productArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);

    // ActionBar Tools
        getSupportActionBar().setTitle("Dashboard");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.blue)));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    // Initializations
      Title = findViewById(R.id.home_title);
      SP = getSharedPreferences(ConstantSP.PREF,MODE_PRIVATE);
      Title.setText("Welcome \n"+SP.getString(ConstantSP.Email,""));

    //RecyclerView for Category array
      recyclerView = findViewById(R.id.home_recycle);
      recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
      recyclerView.setItemAnimator(new DefaultItemAnimator());
      recyclerView.setNestedScrollingEnabled(false);
      CategoryarrayList = new ArrayList<>();
      for (int i=0;i<Categorynamearray.length;i++)
      {
          CategoryList list = new CategoryList();
          list.setName(Categorynamearray[i]);
          list.setImg(Categoryimagearray[i]);
          CategoryarrayList.add(list);
      }
      CategoryAdapter adapter = new CategoryAdapter(Homeactivity.this,CategoryarrayList);
      recyclerView.setAdapter(adapter);

    //RecyclerView for product array
      productrecyclerView = findViewById(R.id.home_product_recycle);
      productrecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));
      productrecyclerView.setItemAnimator(new DefaultItemAnimator());
      productrecyclerView.setNestedScrollingEnabled(false);
      productArrayList = new ArrayList<>();
      for (int i=0;i<productnamearray.length;i++)
      {
          productlist List = new productlist();
          List.setName(productnamearray[i]);
          List.setPrice(productpricearray[i]);
          List.setUnits(productunitarray[i]);
          List.setDescription(productdesarray[i]);
          List.setImage(productimagearray[i]);
          productArrayList.add(List);
      }
      ProductAdapter productAdapter = new ProductAdapter(Homeactivity.this,productArrayList);
      productrecyclerView.setAdapter(productAdapter);

    // View All
      View_all = findViewById(R.id.home_view);
      View_all.setOnClickListener(view -> new CommonMethod(Homeactivity.this,product.class));

    }
    // Action Bar

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem Item){
        int id = Item.getItemId();
        if (id == android.R.id.home){
            onBackPressed();
        }
        if (id == R.id.home_menu_logout){
            SP.edit().clear().commit();
            new CommonMethod(Homeactivity.this,MainActivity.class);

        }
        if (id == R.id.home_menu_chat){
            new CommonMethod(Homeactivity.this,chat.class);

        }
        return super.onOptionsItemSelected(Item);
    }

    @Override
    public void onBackPressed(){
        /** finish(); //Exit from current page without loosing login credentials
        finishAffinity(); //- to Exit From whole Application
        System.exit(0); // Exit From Current page but login data remain as usual**/
        alertmethod();
    }


    private void alertmethod(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Homeactivity.this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Exit App");
        builder.setMessage("Are You Sure Want To Exit");

        builder.setNegativeButton("NO", (dialogInterface, i) -> dialogInterface.dismiss());
        builder.setPositiveButton("YES", (dialogInterface, i) -> finish());
        builder.show();
    }
}