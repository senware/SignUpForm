package edu.temple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = ((EditText) findViewById(R.id.firstNameEditText)).getText().toString();
                String lastName = ((EditText) findViewById(R.id.lastNameEditText)).getText().toString();
                String email = ((EditText) findViewById(R.id.emailEditText)).getText().toString();
                String password = ((EditText) findViewById(R.id.passwordEditText)).getText().toString();
                String passwordConfirm = ((EditText) findViewById(R.id.passwordConfirmEditText)).getText().toString();

                TextView emptyFieldError;

                emptyFieldError = findViewById(R.id.firstNameErrorTextView);
                emptyFieldError.setText("");
                if (firstName.matches("")) {
                    emptyFieldError.setText(getString(R.string.firstNameErrorMsg));
                    return;
                }

                emptyFieldError = findViewById(R.id.lastNameErrorTextView);
                emptyFieldError.setText("");
                if(lastName.matches("")) {
                    emptyFieldError.setText(getString(R.string.lastNameErrorMsg));
                    return;
                }

                emptyFieldError = findViewById(R.id.emailErrorTextView);
                emptyFieldError.setText("");
                if(email.matches("")) {
                    emptyFieldError.setText(getString(R.string.emailErrorMsg));
                    return;
                }

                emptyFieldError = findViewById(R.id.passwordErrorTextView);
                emptyFieldError.setText("");
                emptyFieldError = findViewById((R.id.passwordConfirmErrorTextView));
                emptyFieldError.setText("");
                if (password.matches("") || !password.matches(passwordConfirm)) {
                    emptyFieldError = findViewById(R.id.passwordErrorTextView);
                    emptyFieldError.setText(getString(R.string.passwordErrorMsg));
                    emptyFieldError = findViewById((R.id.passwordConfirmErrorTextView));
                    emptyFieldError.setText(getString(R.string.passwordErrorMsg));
                    return;
                }
            }
        });
    }

}