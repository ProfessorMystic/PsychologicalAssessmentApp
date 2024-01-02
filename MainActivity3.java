package personalitydisorder.scale;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Button ASPDButton = findViewById(R.id.ASPD);
        Button NPDButton = findViewById(R.id.NPD);
        Button BPDButton = findViewById(R.id.BPD);
        Button HPDButton = findViewById(R.id.HPD);

        ASPDButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity3 a = new MainActivity3();
                a.setASPD();

                // Create an Intent to start MainActivity4
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);

                // Pass the questionnaire data to MainActivity4
                intent.putExtra("questions", a.getQuestions());

                startActivity(intent);
            }
        });

        NPDButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity3 n = new MainActivity3();
                n.setNPD();

                // Create an Intent to start MainActivity4
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);

                // Pass the questionnaire data to MainActivity4
                intent.putExtra("questions", n.getQuestions());

                startActivity(intent);
            }
        });

        BPDButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity3 b = new MainActivity3();
                b.setBPD();

                // Create an Intent to start MainActivity4
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);

                // Pass the questionnaire data to MainActivity4
                intent.putExtra("questions", b.getQuestions());

                startActivity(intent);
            }
        });

        HPDButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity3 h = new MainActivity3();
                h.setHPD();

                // Create an Intent to start MainActivity4
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);

                // Pass the questionnaire data to MainActivity4
                intent.putExtra("questions", h.getQuestions());

                startActivity(intent);
            }
        });
    }

    static int LISTSIZE = 20;
    String[] questions;

    public MainActivity3(){
        questions = new String[LISTSIZE];
    }

    public void setASPD(){
        String[] ASPD = {"I often deceive or manipulate others for personal gain",
                "I've consistently shown a disregard for the rights of others since adolescence",
                "I engage in criminal behaviors?", "I have a history of substance abuse",
                "I have a history of impulsivity", "I fail to plan ahead responsibly",
                "I'm consistently irritable and aggressive, with a propensity for physical fights",
                "I have a pattern of irresponsibility in work, financial, or other life areas",
                "I show a lack of remorse for hurting others, even if it was intentional",
                "I often fail to conform to social norms and rules",
                "I lack of empathy and difficulty understanding others' feelings",
                "I repeatedly violate the boundaries of others without remorse",
                "I've engaged in reckless behaviors without regard for my safety or the safety of others",
                "I have difficulty maintaining stable relationships, including friendships",
                "I experience boredom easily and seek stimulation through risky activities",
                "I blame others for my mistakes and misdeeds", "I think it's ok to cheat on your significant other",
                "I have a history of childhood conduct problems",
                "I think people who show emotions are weak", "I enjoy hurting animals"};
        for (int i = 0; i < LISTSIZE; i++){
            questions[i] = ASPD[i];
        }
    }

    public void setNPD(){
        String[] NPD = {"Do I have an excessive sense of my own importance?",
                "Am I preoccupied with fantasies of unlimited success, power, brilliance, beauty, or ideal love?",
                "Do I believe that I am special and unique and can only be understood by, or should associate with, other special or high-status people?",
                "Do I require excessive admiration from others?",
                "Have I a sense of entitlement, expecting to be recognized as superior even without achievements?",
                "Am I interpersonally exploitative, taking advantage of others to achieve my own ends?",
                "Do I lack empathy and unwilling to recognize or identify with the feelings and needs of others?",
                "Am I often envious of others or believe that others are envious of me?",
                "Do I show arrogant, haughty behaviors or attitudes?",
                "Do I expect special favors and unquestioning compliance with my expectations?",
                "Is it difficult for me to work collaboratively with others unless they submit to my way of doing things?",
                "Do I often exaggerate my achievements and talents?",
                "Have I monopolized conversations and belittled or looked down upon people I perceive as inferior?",
                "Do I have a grandiose sense of self-importance that affects my choice of friends or occupation?",
                "Am I easily angered or upset when I perceive that others do not recognize my superiority or give me the admiration I believe I deserve?",
                "Do I require excessive admiration and attention from others?",
                "Am I easily hurt or rejected, leading to feelings of anger or humiliation?",
                "Do I have a tendency to take advantage of others to achieve my own goals?",
                "Do I find it challenging to acknowledge the achievements or qualities of others, especially if they overshadow mine?",
                "Do I believe that others envy me and feel that I am deserving of special treatment?"};
        for (int i = 0; i < LISTSIZE; i++){
            questions[i] = NPD[i];
        }
    }

    public void setBPD(){
        String[] BPD = {
                "Do I have intense and unstable relationships characterized by extremes of idealization and devaluation?",
                "Am I frequently afraid of being abandoned, even if there is no evidence for it?",
                "Do I have a pattern of unstable and intense interpersonal relationships?",
                "Am I unsure of my own identity, leading to sudden changes in goals, values, and career choices?",
                "Do I experience rapid and intense mood swings?",
                "Am I prone to impulsive behaviors, such as reckless driving, substance abuse, or binge eating?",
                "Do I have recurrent suicidal behaviors, gestures, or threats, or engage in self-harming activities?",
                "Am I often unsure about my self-image and suffer from chronic feelings of emptiness?",
                "Do I have difficulty controlling my anger, leading to frequent displays of temper?",
                "Am I frequently paranoid, experiencing severe dissociation or feeling disconnected from reality?",
                "Do I often engage in frantic efforts to avoid real or imagined abandonment?",
                "Am I frequently changing my goals, values, jobs, and relationships in an attempt to avoid abandonment?",
                "Do I have chronic feelings of emptiness and boredom?",
                "Am I prone to intense and inappropriate anger, often followed by shame and guilt?",
                "Do I have a pattern of unstable and intense interpersonal relationships?",
                "Am I often engaged in impulsive, self-damaging activities, such as reckless driving or substance abuse?",
                "Do I have difficulty trusting others, even when there is no evidence for mistrust?",
                "Am I frequently preoccupied with fantasies of unlimited success, beauty, or ideal love?",
                "Do I feel emotionally numb or disconnected from my own thoughts, feelings, and actions?",
                "Am I prone to intense and inappropriate anger, often followed by shame and guilt?"};
        for (int i = 0; i < LISTSIZE; i++){
            questions[i] = BPD[i];
        }
    }

    public void setHPD(){
        String[] HPD = {"Do I often seek attention and feel uncomfortable when not the center of attention?",
                "Do I often exaggerate my emotions to draw attention to myself?",
                "Do I often express my emotions in a theatrical, exaggerated manner?",
                "Am I easily influenced by others or by the latest trends and fads?",
                "Am I easily influenced by others and tend to adopt their opinions or behaviors quickly?",
                "Do I have a tendency to be easily bored and crave excitement or novelty?",
                "Am I overly dramatic and theatrical in my speech and expression of emotions?",
                "Do I often perceive relationships as more intimate than they actually are?",
                "Do I have difficulty focusing on tasks that require attention to detail; instead focus on the overall excitement of the moment?",
                "Do I often use my physical appearance to draw attention to myself?",
                "Am I easily influenced by others or by the latest trends and fads?",
                "Do I frequently seek reassurance or approval from others?",
                "Am I prone to rapidly changing emotions and shallow expressions of emotion?",
                "Do I have difficulty maintaining long-term relationships due to attention-seeking behaviors?",
                "Am I easily bored and crave excitement or novelty?",
                "Do I often make an impression of intimacy or a close relationship quickly with people I've just met?",
                "Am I overly concerned with my physical appearance and use it to draw attention to myself?",
                "Do I often perceive relationships as more intimate than they actually are?",
                "Am I uncomfortable in situations where I am not the center of attention?",
                "Do I have a tendency to be easily influenced by others or by the latest trends and fads?"};
        for (int i = 0; i < LISTSIZE; i++){
            questions[i] = HPD[i];
        }
    }

    public String[] getQuestions(){
        String[] temp = new String[LISTSIZE];
        for (int i = 0; i < LISTSIZE; i++){
            questions[i] = temp[i];
        } return temp;
    }
}
