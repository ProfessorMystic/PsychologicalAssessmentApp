package personalitydisorder.scale;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    private int questionNum = 0;
    private double score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        // Retrieve the questionnaire data from the Intent
        String[] questions = getIntent().getStringArrayExtra("questions");

        // Set up radio group and buttons
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        Button nextButton = findViewById(R.id.button);

        TextView fscore = findViewById(R.id.finalscore);
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

                // Check if there are more questions
                if (questionNum < LISTSIZE) {
                    // Update the question text
                    TextView questionTextView = findViewById(R.id.questionTextView);
                    questionTextView.setText(questions[questionNum]);
                } else {
//                    Intent intent = new Intent(MainActivity4.this, MainActivity5.class);
//                    intent.putExtra("finalScore", score);
//                    startActivity(intent);
                    setContentView(R.layout.activity_main5);
                }
            }
        });

        // calculate the final score to display it in review page
        int calc = ((int) Math.round(score/100))*100;
        String finalText = calc + "/100";
        fscore.setText(finalText);

        // establish diagnosis
        String diag;
        TextView diagnosis = findViewById(R.id.diagnoses);
        if (calc >= 80){
            diag = "Only Christ can save you";
        } else if (calc >= 60){
            diag = "Severe: should seek a therapist";
        } else if (calc >= 40){
            diag = "Moderate: you should try meditating";
        } else if (calc >= 20){
            diag = "Mild: nothing that fish oil and self-reflecting can't help";
        } else {
            diag = "Normal: nothing to worry about";
        }

        diagnosis.setText(diag);

        // Display the first question
        TextView questionTextView = findViewById(R.id.questionTextView);
        questionTextView.setText(questions[questionNum]);
    }

    private void processSelectedRadioButton(int selectedRadioButtonId) {
        // Determine how many points to add based on the selected radio button
        switch (selectedRadioButtonId) {
            case R.id.button1:
                // No points for Strongly Disagree
                score += 0;
                break;
            case R.id.button2:
                // Add points for Disagree
                score += 1.25;
                break;
            case R.id.button3:
                // Add points for Neutral
                score += 2.50;
                break;
            case R.id.button4:
                // Add points for Agree
                score += 3.75;
                break;
            case R.id.button5:
                // Add points for Strongly Agree
                score += 5;
        }
    }

    static int LISTSIZE = 20;
}