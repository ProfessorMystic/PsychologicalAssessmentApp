package assessment.scale;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {

    private int questionNum = 0;
    private int qnum = 1;
    private double score = 0;
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

                // Process the selected radio button and update the score
                processSelectedRadioButton(selectedRadioButtonId);

                // Move to the next question
                questionNum++;

                // Update question number at the top
                qnum++;
                String qnumdisplay = qnum + "/20";
                qnumber.setText(qnumdisplay);

                // Check if there are more questions
                if (questionNum < LISTSIZE) {
                    // Update the question text
                    displayQuestion(questions[questionNum]);
                } else {
                    // Show review screen upon questionnaire finish
                    setContentView(R.layout.activity_main5);
                    Button button6 = findViewById(R.id.button6);
                    TextView fscore = findViewById(R.id.finalscore);

                    // Calculate the final score to display it in the review page
                    int calc = (int) score;
                    String finalText = calc + "/100";
                    fscore.setText(finalText);

                    // Establish diagnosis
                    String diag;
                    TextView diagnosis = findViewById(R.id.diagnoses);
                    if (calc >= 80) {
                        diag = "Only Christ can save you";
                    } else if (calc >= 60) {
                        diag = "Severe: should seek a therapist";
                    } else if (calc >= 40) {
                        diag = "Moderate: you should try meditating";
                    } else if (calc >= 20) {
                        diag = "Mild: practice self-awareness";
                    } else {
                        diag = "Normal: nothing to worry about";
                    }

                    diagnosis.setText(diag);
                    button6.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Start the MainActivity when the button is clicked
                            setContentView(R.layout.activity_main);
                        }
                    });
                }
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
        } else if (selectedRadioButtonId == R.id.button2) {
            // Add points for Disagree
            score += 1.25;
        } else if (selectedRadioButtonId == R.id.button3) {
            // Add points for Neutral
            score += 2.50;
        } else if (selectedRadioButtonId == R.id.button4) {
            // Add points for Agree
            score += 3.75;
        } else if (selectedRadioButtonId == R.id.button5) {
            // Add points for Strongly Agree
            score += 5;
        }
    }
}
