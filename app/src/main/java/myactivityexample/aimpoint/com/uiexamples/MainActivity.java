package myactivityexample.aimpoint.com.uiexamples;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox secHobby,firstHobby,thirdHobby;
    Switch bluetoothSwitch;
    Context con;
    RadioButton mRb,fRb;
    RadioGroup rg;
    SeekBar redBar,greenBar,blueBar;
    LinearLayout ll;

    class MyCheckListener implements CompoundButton.OnCheckedChangeListener
    {

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            String mycheckedItems="";
            for(int i=0;i<ll.getChildCount();i++)
            {
                CheckBox cb =(CheckBox) ll.getChildAt(i);
                if(cb.isChecked())
                {
                    mycheckedItems+=cb.getText();
                }

            }
            Toast.makeText(con,mycheckedItems+" is checked",Toast.LENGTH_LONG).show();



//            if(compoundButton.isChecked())
//            {
//                Toast.makeText(con,compoundButton.getText()+" is checked",Toast.LENGTH_LONG).show();
//            }
//            else{
//                Toast.makeText(con,compoundButton.getText()+" is not checked",Toast.LENGTH_LONG).show();
//
//            }
        }
    }

    class  MySeekBarChange implements SeekBar.OnSeekBarChangeListener
    {

        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            int r = redBar.getProgress();
            int g =greenBar.getProgress();
            int bv =blueBar.getProgress();
            ll.setBackgroundColor(Color.rgb(r,g,bv));

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            Toast.makeText(con,seekBar.getId()+" is started seeking",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            Toast.makeText(con,seekBar.getId()+" is stopped seeking",Toast.LENGTH_SHORT).show();

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        secHobby=(CheckBox)findViewById(R.id.secHobby);
        firstHobby=(CheckBox)findViewById(R.id.firstHobby);
        thirdHobby=(CheckBox)findViewById(R.id.thirdHobby);
        ll=(LinearLayout)findViewById(R.id.ll);
        bluetoothSwitch=(Switch)findViewById(R.id.bluetoothSwitch);
        bluetoothSwitch.setChecked(true);
        mRb=(RadioButton)findViewById(R.id.mRb);
        redBar=(SeekBar)findViewById(R.id.redSeekBar);
        MySeekBarChange sbc = new MySeekBarChange();
        redBar.setOnSeekBarChangeListener(sbc);
        greenBar=(SeekBar)findViewById(R.id.greenSeekBar);
        greenBar.setOnSeekBarChangeListener(sbc);
        blueBar=(SeekBar)findViewById(R.id.blueSeekBar);
        blueBar.setOnSeekBarChangeListener(sbc);


        con=this;
        fRb=(RadioButton)findViewById(R.id.fRb);
        rg=(RadioGroup)findViewById(R.id.rg);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                Toast.makeText(con,"Checked",Toast.LENGTH_LONG).show();
            }
        });
        bluetoothSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bluetoothSwitch.isChecked())
                Toast.makeText(con,"Turning Bluetooth On",Toast.LENGTH_LONG).show();
            }
        });

        MyCheckListener mcl = new MyCheckListener();
        secHobby.setOnCheckedChangeListener(mcl);
        firstHobby.setOnCheckedChangeListener(mcl);
        thirdHobby.setOnCheckedChangeListener(mcl);


    }
}
