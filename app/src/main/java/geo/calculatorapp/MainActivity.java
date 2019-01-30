package geo.calculatorapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    public void onClick(View view)
    {
        Intent i;
        if(view.getId()==R.id.button1)
        {
            i=new Intent(this,StandardCal.class);
            startActivity(i);
        }
        else if(view.getId()==R.id.button)
        {
            i=new Intent(this,ScientificCal.class);
            startActivity(i);
        }
        else if(view.getId()==R.id.button2)
        {
            i=new Intent(this,UnitCoverter.class);
            startActivity(i);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_share:
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = " ";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Calculator");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
                break;
//            case id.lang:
//                Intent intent1 = new Intent(this, MainActivity_mala.class);
//                this.startActivity(intent1);
//                break;
            case R.id.action_about:
                Intent intent = new Intent(this, AboutActivity.class);
                this.startActivity(intent);
                break;
            case R.id.action_feedback:
                intent = new Intent(Intent.ACTION_SENDTO); // it's not ACTION_SEND
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback Of App Calculator");
                intent.putExtra(Intent.EXTRA_TEXT, "My Friend\n       I am very pleased to be able to use your app All in 1 Calculator and I look forward to give you a feedback on the same.");
                intent.setData(Uri.parse("mailto:geocheeramkuzhy@gmail.com")); // or just "mailto:" for blank
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this will make such that when user returns to your app, your app is displayed, instead of the email app.
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
