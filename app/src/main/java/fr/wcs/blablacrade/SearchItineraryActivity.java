package fr.wcs.blablacrade;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SearchItineraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary);

            final EditText edit1 = (EditText) findViewById(R.id.editText1);
        final EditText edit2 = (EditText) findViewById(R.id.editText2);
        final EditText edit3 = (EditText) findViewById(R.id.editText3);
        Button buttonSearch = (Button) findViewById(R.id.push);

        // clicq action
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text1 = edit1.getText().toString();
                    String text2 = edit2.getText().toString();
                String texte = edit3.getText().toString();

                if (text1.isEmpty() || text2.isEmpty()
                        ) {
                    Toast painGrillé = Toast.makeText(getApplicationContext(), getResources().getString(R.string.form_error), Toast.LENGTH_SHORT);
                    painGrillé.show();
                }else {Intent intent = new Intent(SearchItineraryActivity.this, ViewSearchItineraryResultsListActivity.class);
                        SearchRequestModel searchRequest=new SearchRequestModel(text1, text2, texte); intent.putExtra("searchRequest", searchRequest);

                        SearchItineraryActivity.this.startActivity(intent);
                }
            }
        });

        final Calendar calandréi = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view,int ané,int moi,int joure){
                        calandréi.set(Calendar.YEAR, ané);
                        calandréi.set(Calendar.MONTH, moi);
                    calandréi.set(Calendar.DAY_OF_MONTH, joure);
                UpdateLabel(edit3, calandréi);
            }};

        edit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(SearchItineraryActivity.this,
                        dateListener,
                        calandréi.get(Calendar.YEAR),
                        calandréi.get(Calendar.MONTH),
                        calandréi.get(Calendar.DAY_OF_MONTH)
                ).show();
            }
        });
    }

            private void UpdateLabel(EditText editText, Calendar myCalendar) {
                String myFormat = "dd/MM/yyyy";


                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);

                editText.setText(sdf.format(myCalendar.getTime()));
            }
}
