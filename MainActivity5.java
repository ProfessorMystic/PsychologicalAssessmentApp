package assessment.scale;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        // Initialize button and textview
        Button menuButton = findViewById(R.id.menuButton);
        TextView fscore = findViewById(R.id.finalscore);

        // Calculate the final score to display it in the review page
        int calc = (int) MainActivity4.returnScore();
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
        } diagnosis.setText(diag);

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go back to the very first layout (MainActivity) and clear the stack
                Intent intent = new Intent(MainActivity5.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
    }
}
