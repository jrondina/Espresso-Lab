package com.example.jamesrondina.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class ChildActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_too);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.child_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onNavigateUp();
                return true;
            case R.id.action_settings:
                Toast.makeText(ChildActivity.this, "Get some action", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_share:
                Toast.makeText(ChildActivity.this, "Share some", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.donotpress:
                Toast.makeText(ChildActivity.this, "Why'd you press dat", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.press_this:
                Toast.makeText(ChildActivity.this, "Now you're playing with power", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
