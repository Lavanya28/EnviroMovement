package  com.illinois.lavanyap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MotivationDescription_NewSavingsProject_page2 extends Activity implements View.OnClickListener {


    private Button next_button_page2_newsavingsproject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivation_description__new_savings_project_page2);

        next_button_page2_newsavingsproject = (Button) findViewById(R.id.NextButton_Page2_NewSavingsProject);
        next_button_page2_newsavingsproject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), MetricsCalculateSavingsEqn_NewSavingsProject_page3.class);
                startActivity(startIntent);
            }
        });
    }


    public void onClick(View v)  {
        if(v.getId() == R.id.NextButton_Page2_NewSavingsProject)  {
            startActivity(new Intent(MotivationDescription_NewSavingsProject_page2.this, MetricsCalculateSavingsEqn_NewSavingsProject_page3.class));
        }
    }

}
