package cillian.android.studyapp.studyapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;

public class RemoveSubjectPopup extends Activity {

    String changedSubject;
    EditText currentSubject;

    String clickedSubject;
    int bestTime;
    int totalTime;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.remove_popup);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * .8), (int) (height * .4));

        Intent intent = getIntent();
        clickedSubject = intent.getStringExtra("clickedSubject");
        bestTime = Integer.parseInt(intent.getStringExtra("bestTime"));
        totalTime = Integer.parseInt(intent.getStringExtra("totalTime"));
        currentSubject = (EditText)findViewById(R.id.subject);
        currentSubject.setText(clickedSubject);
    }

    public void updateSubject(View v)
    {
        changedSubject = currentSubject.getText().toString();
        if(changedSubject.length() > 0) {
            SubjectHandler Shandler = new SubjectHandler(getBaseContext());
            Shandler.open();
            Shandler.updateData(clickedSubject, changedSubject, bestTime, totalTime);
            Shandler.close();
            done(v);
        }
    }

    public void deleteSubject(View v)
    {

        changedSubject = currentSubject.getText().toString();
        if(changedSubject.length() > 0) {
            SubjectHandler Shandler = new SubjectHandler(getBaseContext());
            Shandler.open();
            Shandler.removeData(changedSubject);
            Shandler.close();
            done(v);
        }
    }

    public void done(View v)
    {
        Intent intent = new Intent(this,SubjectActivity.class);
        startActivity(intent);
    }


}