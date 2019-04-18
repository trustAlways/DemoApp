package tabview.nested.demo.com.demoapp;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class DetailActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    public static final String EXTRA_POSITION = "position";
    TextToSpeech textToSpeech;
    TextView placeDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textToSpeech = new TextToSpeech(this, this);

        // Set Collapsing Toolbar layout to the screen
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        // Set title of Detail page
        // collapsingToolbar.setTitle(getString(R.string.item_title));

        int postion = getIntent().getIntExtra(EXTRA_POSITION, 0);
        Resources resources = getResources();
        collapsingToolbar.setTitle("peris");

         placeDetail = (TextView) findViewById(R.id.place_detail);

         placeDetail.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 speech();
             }
         });

        /*String[] places = resources.getStringArray(R.array.places);
        collapsingToolbar.setTitle(places[postion % places.length]);

        String[] placeDetails = resources.getStringArray(R.array.place_details);
        TextView placeDetail = (TextView) findViewById(R.id.place_detail);
        placeDetail.setText(placeDetails[postion % placeDetails.length]);

        String[] placeLocations = resources.getStringArray(R.array.place_locations);
        TextView placeLocation =  (TextView) findViewById(R.id.place_location);
        placeLocation.setText(placeLocations[postion % placeLocations.length]);

        TypedArray placePictures = resources.obtainTypedArray(R.array.places_picture);
        ImageView placePicutre = (ImageView) findViewById(R.id.image);
        placePicutre.setImageDrawable(placePictures.getDrawable(postion % placePictures.length()));

        placePictures.recycle();*/
    }


    @Override
    public void onInit(int status) {
        Log.d("Speech", "OnInit - Status ["+status+"]");

        if (status == TextToSpeech.SUCCESS) {
            Log.d("Speech", "Success!");
            textToSpeech.setLanguage(Locale.UK);
        }
    }

    private void speech() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textToSpeech.setSpeechRate(1);
            textToSpeech.speak(placeDetail.getText().toString(),
                    TextToSpeech.QUEUE_FLUSH, null, null);
            Log.d("Speechingggg -------", "Success!");

        }
    }

    @Override
    public void onBackPressed() {
        if (textToSpeech.isSpeaking())
        {
            textToSpeech.stop();
        }
        super.onBackPressed();
    }
}
