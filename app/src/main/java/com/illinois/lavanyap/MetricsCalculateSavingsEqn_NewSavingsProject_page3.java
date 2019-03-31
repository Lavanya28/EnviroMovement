package  com.illinois.lavanyap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MetricsCalculateSavingsEqn_NewSavingsProject_page3 extends Activity implements View.OnClickListener {



    private Button last_button_page3_newsavingsproject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metrics_calculate_savings_eqn__new_savings_project_page3);

        last_button_page3_newsavingsproject = (Button) findViewById(R.id.LastButtonNewProject);
        last_button_page3_newsavingsproject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),  com.illinois.lavanyap.LoginPage.class);
                startActivity(startIntent);
            }
        });
    }


    public void onClick(View v)  {
        if(v.getId() == R.id.LastButtonNewProject)  {
            startActivity(new Intent(MetricsCalculateSavingsEqn_NewSavingsProject_page3.this,  com.illinois.lavanyap.LoginPage.class));

            //TODO:
            //Change LoginPage in above line to the default home page/screen of our app!

        }
    }


}
