package internship.app.commercial;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class CommonMethod{

    CommonMethod(Context Context, String message) {
        Toast.makeText(Context, message, Toast.LENGTH_SHORT).show();
    }

    CommonMethod(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show();
    }

    CommonMethod(Context context, Class<?> nextClass) {
        Intent intent = new Intent(context, nextClass);
        context.startActivity(intent);
    }

}
