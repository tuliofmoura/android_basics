package br.com.tuliofmoura.androidbasics.resolved.hello;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import br.com.tuliofmoura.androidbasics.R;
import br.com.tuliofmoura.androidbasics.resolved.preferences.ResolvedPreferences;

public class ResolvedFutureMainActivity extends AppCompatActivity {

    public static Intent newIntent(Context context) {
        return new Intent(context, ResolvedFutureMainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resolved_activity_future_main);
        final TextView label = findViewById(R.id.label);
        label.setText(ResolvedPreferences.getUserName(this));
    }
}
