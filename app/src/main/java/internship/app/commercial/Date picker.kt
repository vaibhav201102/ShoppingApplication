package internship.app.commercial

import android.app.DatePickerDialog.OnDateSetListener
import android.widget.DatePicker
import java.text.SimpleDateFormat
import java.util.*

class Date_picker {
    // Date of Birth selection and use of datepicker class
    var dateClick = OnDateSetListener { datePicker: DatePicker?, i: Int, i1: Int, i2: Int ->
        calendar.set(Calendar.YEAR, i)
        calendar.set(Calendar.MONTH, i1)
        calendar.set(Calendar.DAY_OF_MONTH, i2)
        val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        dateofbirth.setText(dateFormat.format(calendar.getTime()))
    }

    dateofbirth.setOnClickListener(android.view.View.OnClickListener (
    {
        view:android.view.View? ->   var dialog: DatePickerDialog? = DatePickerDialog(this@Signup, dateClick,
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH))
        dialog.getDatePicker().setMaxDate(System.currentTimeMillis())
        dialog.show()
    }))
}