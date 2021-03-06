package cillian.android.studyapp.studyapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;

public class NewSubjectPopup extends Activity {

    String potentialSubject;
    EditText newSubject;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.subject_popup);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * .6), (int) (height * .4));

        newSubject = (EditText)findViewById(R.id.potentialSubject);
    }

    public void addSubject(View v)
    {
        potentialSubject = newSubject.getText().toString();
        if(potentialSubject.length() > 0) {
            SubjectHandler Shandler = new SubjectHandler(getBaseContext());
            Shandler.open();
            Shandler.insertData(potentialSubject);
            Shandler.close();
            done(v);
        }
    }

    public void done(View v)
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
