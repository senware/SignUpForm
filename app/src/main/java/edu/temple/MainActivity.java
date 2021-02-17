package edu.temple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // pointer to hold error message TextViews
                TextView emptyFieldError;

                // point to the first error message and hide it
                emptyFieldError = findViewById(R.id.firstNameErrorTextView);
                emptyFieldError.setText("");

                // point to the contents of the first name field
                String firstName = ((EditText) findViewById(R.id.firstNameEditText)).getText().toString();

                // check to see if the first name field is empty
                if (firstName.matches("")) {
                    emptyFieldError.setText(getString(R.string.firstNameErrorMsg));
                    return;
                }

                // point to the next error message and hide it
                emptyFieldError = findViewById(R.id.lastNameErrorTextView);
                emptyFieldError.setText("");

                // point to the contents of the last name field
                String lastName = ((EditText) findViewById(R.id.lastNameEditText)).getText().toString();

                // check to see if the last name field is empty
                if(lastName.matches("")) {
                    emptyFieldError.setText(getString(R.string.lastNameErrorMsg));
                    return;
                }

                // point to the next error message and hide it
                emptyFieldError = findViewById(R.id.emailErrorTextView);
                emptyFieldError.setText("");

                // point to the contents of the email field
                String email = ((EditText) findViewById(R.id.emailEditText)).getText().toString();

                // check to see if the email field is empty
                if(email.matches("")) {
                    emptyFieldError.setText(getString(R.string.emailErrorMsg));
                    return;
                }

                // hide both errors for password and password confirm fields
                emptyFieldError = findViewById(R.id.passwordErrorTextView);
                emptyFieldError.setText("");
                emptyFieldError = findViewById((R.id.passwordConfirmErrorTextView));
                emptyFieldError.setText("");

                // point to the password and password confirm field's contents
                String password = ((EditText) findViewById(R.id.passwordEditText)).getText().toString();
                String passwordConfirm = ((EditText) findViewById(R.id.passwordConfirmEditText)).getText().toString();

                // check to see if the password field is blank
                // or check to see if the password and password confirm fields don't match
                // conditions must me in this order, otherwise short-circuiting would allow both fields to be empty
                if (password.matches("") || !password.matches(passwordConfirm)) {
                    emptyFieldError = findViewById(R.id.passwordErrorTextView);
                    emptyFieldError.setText(getString(R.string.passwordErrorMsg));
                    emptyFieldError = findViewById((R.id.passwordConfirmErrorTextView));
                    emptyFieldError.setText(getString(R.string.passwordErrorMsg));
                    return;
                }

                // if no errors occur, display a little welcome message
                Toast welcome;
                // yeah this could have been easier to read, but I kind of like silly looking function calls
                welcome = Toast.makeText(getApplicationContext(), "Welcome, " + firstName + " " + lastName + "!", Toast.LENGTH_LONG);
                // display message
                welcome.show();
            }
        });
    }

}