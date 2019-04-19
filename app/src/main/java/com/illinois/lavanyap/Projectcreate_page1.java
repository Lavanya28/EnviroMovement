package  com.illinois.lavanyap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class Projectcreate_page1 extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.projectcreate);

        EditText projectid = (EditText)findViewById(R.id.c_projectname);



    }

}



