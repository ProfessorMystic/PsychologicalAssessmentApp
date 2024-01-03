package assessment.scale;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {

    private int questionNum = 0;
    private int qnum = 1;
    private static double score = 0;
    private static final int LISTSIZE = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        // Retrieve the questionnaire data from the Intent
        String[] questions = getIntent().getStringArrayExtra("questions");

        // Set up radio group and buttons
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        Button nextButton = findViewById(R.id.button);

        // Disable the "Continue" button initially
        nextButton.setEnabled(false);

        // Display the first question
        displayQuestion(questions[questionNum]);

        // Update question number at the top
        TextView qnumber = findViewById(R.id.qnum);
        String qnumdisplay = qnum + "/20";
        qnumber.setText(qnumdisplay);

        // Set up a listener for the "Continue" button
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check which radio button is selected
                int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();

                // Check if a radio button is selected
                if (selectedRadioButtonId == -1) {
                    // Display a Toast message indicating that a selection is required
                    Toast.makeText(MainActivity4.this, "Please select an option", Toast.LENGTH_SHORT).show();
                } else {
                    // Process the selected radio button and update the score
                    processSelectedRadioButton(selectedRadioButtonId);

                    // Move to the next question
                    questionNum++;

                    // Check if there are more questions
                    if (questionNum < LISTSIZE) {
                        // Update the question text
                        displayQuestion(questions[questionNum]);
                        // Update question number at the top
                        qnum++;
                        String qnumdisplay = qnum + "/20";
                        qnumber.setText(qnumdisplay);
                    } else {
                        // Show review screen upon questionnaire finish
                        Intent intent = new Intent(MainActivity4.this, MainActivity5.class);
                        startActivity(intent);
                    }
                }
            }
        });

        // Set up a listener for radio group changes to enable/disable the "Continue" button
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Enable the "Continue" button when a radio button is selected
                nextButton.setEnabled(checkedId != -1);
            }
        });
    }

    private void displayQuestion(String question) {
        // Display the question
        TextView questionTextView = findViewById(R.id.questionTextView);
        questionTextView.setText(question);

        // Reset radio group
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.clearCheck();
    }

    private void processSelectedRadioButton(int selectedRadioButtonId) {
        // Determine how many points to add based on the selected radio button
        if (selectedRadioButtonId == R.id.button1) {
            // No points for Strongly Disagree
            score += 0;
            // Display a Toast message
            Toast.makeText(MainActivity4.this, "Strongly Disagree", Toast.LENGTH_SHORT).show();
        } else if (selectedRadioButtonId == R.id.button2) {
            // Add points for Disagree
            score += 1.25;
            // Display a Toast message
            Toast.makeText(MainActivity4.this, "Disagree", Toast.LENGTH_SHORT).show();
        } else if (selectedRadioButtonId == R.id.button3) {
            // Add points for Neutral
            score += 2.50;
            // Display a Toast message
            Toast.makeText(MainActivity4.this, "Neutral", Toast.LENGTH_SHORT).show();
        } else if (selectedRadioButtonId == R.id.button4) {
            // Add points for Agree
            score += 3.75;
            // Display a Toast message
            Toast.makeText(MainActivity4.this, "Agree", Toast.LENGTH_SHORT).show();
        } else if (selectedRadioButtonId == R.id.button5) {
            // Add points for Strongly Agree
            score += 5;
            // Display a Toast message
            Toast.makeText(MainActivity4.this, "Strongly Agree", Toast.LENGTH_SHORT).show();
        }
    }

    // return score and reset it to 0
    public static double returnScore(){
        double tempScore = score;
        score = 0;
        return tempScore;
    }
}
