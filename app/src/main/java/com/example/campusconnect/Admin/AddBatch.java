package com.example.campusconnect.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.campusconnect.Models.BatchModel;
import com.example.campusconnect.Models.ScheduleModel;
import com.example.campusconnect.R;

import java.util.ArrayList;

public class AddBatch extends AppCompatActivity {


    EditText year, feesAmount;
    EditText m1,  m2, m3, m4, m5, t1, t2, t3, t4, t5, w1, w2, w3, w4, w5, th1, th2, th3, th4, th5, f1, f2, f3, f4, f5;
    Button save;
    String[] courseName = {"B.Tech CSE", "B.Tech ECE", "B.Tech AI","BCA", "B.Sc.", "MBBS", "LLB"};
    String[] duration = {"3 yrs", "4 yrs",  "5 yrs"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_batch);

        fetchView();

        AutoCompleteTextView acTextView = (AutoCompleteTextView) findViewById(R.id.course);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_singlechoice, courseName);

        acTextView.setThreshold(1);
        acTextView.setAdapter(adapter);

        AutoCompleteTextView acTextView2 = (AutoCompleteTextView) findViewById(R.id.duration);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.select_dialog_singlechoice, duration);
        acTextView2.setThreshold(1);
        acTextView2.setAdapter(adapter2);


        BatchModel batchModel = new BatchModel();

        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String yr = year.getText().toString();
                String fees = feesAmount.getText().toString();
                if(!yr.isEmpty() && !fees.isEmpty()){
                    batchModel.setCourseName(acTextView.getText().toString());
                    batchModel.setCourseDuration(acTextView2.toString());
                    batchModel.setCourseYear(yr);
                    batchModel.setFeesAmount(fees);

//                    ADDING SCHEDULES
                    ArrayList<ScheduleModel> schedules = new ArrayList<>();
                    schedules.get(0).setDay("Monday");
                    schedules.get(0).setSlot1(m1.getText().toString());
                    schedules.get(0).setSlot2(m2.getText().toString());
                    schedules.get(0).setSlot3(m3.getText().toString());
                    schedules.get(0).setSlot4(m4.getText().toString());
                    schedules.get(0).setSlot5(m5.getText().toString());

                    schedules.get(1).setDay("Tuesday");
                    schedules.get(1).setSlot1(t1.getText().toString());
                    schedules.get(1).setSlot2(t2.getText().toString());
                    schedules.get(1).setSlot3(t3.getText().toString());
                    schedules.get(1).setSlot4(t4.getText().toString());
                    schedules.get(1).setSlot5(t5.getText().toString());

                    schedules.get(2).setDay("Wednesday");
                    schedules.get(2).setSlot1(w1.getText().toString());
                    schedules.get(2).setSlot2(w2.getText().toString());
                    schedules.get(2).setSlot3(w3.getText().toString());
                    schedules.get(2).setSlot4(w4.getText().toString());
                    schedules.get(2).setSlot5(w5.getText().toString());

                    schedules.get(3).setDay("Thursday");
                    schedules.get(3).setSlot1(th1.getText().toString());
                    schedules.get(3).setSlot2(th2.getText().toString());
                    schedules.get(3).setSlot3(th3.getText().toString());
                    schedules.get(3).setSlot4(th4.getText().toString());
                    schedules.get(3).setSlot5(th5.getText().toString());

                    schedules.get(4).setDay("Friday");
                    schedules.get(4).setSlot1(f1.getText().toString());
                    schedules.get(4).setSlot2(f2.getText().toString());
                    schedules.get(4).setSlot3(f3.getText().toString());
                    schedules.get(4).setSlot4(f4.getText().toString());
                    schedules.get(4).setSlot5(f5.getText().toString());

//              ADDING ALL THE SCHEDULES INTO THE BATCH MODEL
                    batchModel.setSchedules(schedules);

                }
                else
                    Toast.makeText(AddBatch.this, "PLease fill the Required Details!!", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void fetchView(){
        m1=findViewById(R.id.m1);
        m2=findViewById(R.id.m2);
        m3=findViewById(R.id.m3);
        m4=findViewById(R.id.m4);
        m5=findViewById(R.id.m5);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);
        t5=findViewById(R.id.t5);
        w1=findViewById(R.id.w1);
        w2=findViewById(R.id.w2);
        w3=findViewById(R.id.w3);
        w4=findViewById(R.id.w4);
        w5=findViewById(R.id.w5);
        th1=findViewById(R.id.th1);
        th2=findViewById(R.id.th2);
        th3=findViewById(R.id.th3);
        th4=findViewById(R.id.th4);
        th5=findViewById(R.id.th5);
        f1=findViewById(R.id.f1);
        f2=findViewById(R.id.f2);
        f3=findViewById(R.id.f3);
        f4=findViewById(R.id.f4);
        f5=findViewById(R.id.f5);
        year=findViewById(R.id.year);
        feesAmount=findViewById(R.id.fees);
        save=findViewById(R.id.save);
    }
}