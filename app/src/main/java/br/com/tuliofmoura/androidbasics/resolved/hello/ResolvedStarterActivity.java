package br.com.tuliofmoura.androidbasics.resolved.hello;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import br.com.tuliofmoura.androidbasics.R;
import br.com.tuliofmoura.androidbasics.resolved.preferences.ResolvedPreferences;

public class ResolvedStarterActivity extends AppCompatActivity {

    private Button button;
    private TextInputLayout inputLayout;
    private TextInputEditText inputEditText;

    public static Intent newIntent(Context context) {
        return new Intent(context, ResolvedStarterActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resolved_activity_starter);
        initViews();
    }

    private void initViews() {
        inputLayout = findViewById(R.id.starter_input_layout);
        inputEditText = findViewById(R.id.starter_input_text);
        final String name = ResolvedPreferences.getUserName(this);
        inputEditText.setText(name);
        button = findViewById(R.id.starter_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateFields()) {
                    final String name = inputEditText.getText().toString().trim();
                    navigateToHello(name);
                }
            }
        });
    }

    private boolean validateFields() {
        final String name = inputEditText.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            inputLayout.setErrorEnabled(true);
            inputLayout.setError(getString(R.string.starter_activity_name_error_message));
            return false;
        } else {
            inputLayout.setError(null);
            inputLayout.setErrorEnabled(false);
            return true;
        }
    }

    private void navigateToHello(String name) {
        startActivity(ResolvedHelloActivity.newIntent(this, name));
        finish();
    }
}
