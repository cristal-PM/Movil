package com.example.calc;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.calc.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private static final NumberFormat currencyFormat= NumberFormat.getCurrencyInstance();
   private static final NumberFormat percentFormat=NumberFormat.getPercentInstance();
   private double billAmount=0.0;
   private double percent =0.15;
   private TextView percentTextView;
    private TextView tipTextView;
    private TextView totalTextView;
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        percentTextView=(TextView)findViewById(R.id.persentTextView);
        totalTextView=(TextView)findViewById(R.id.totalLabelTextView);
        tipTextView=(TextView) findViewById(R.id.tipLabelTextView);
        tipTextView.setText(currencyFormat.format(0));
        totalTextView.setText(currencyFormat.format(0));
        EditText amountEditText=(EditText)findViewById(R.id.amountEditText);
        amountEditText.addTextChangedListener(amountEditTextWatcher);
        SeekBar percentSeekBar=(SeekBar) findViewById(R.id.persentseekBar);
        percentSeekBar.setOnSeekBarChangeListener(seekBarListener);


        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    private void calculate(){
        percentTextView.setText(percentFormat.format(percent));
        double tip=billAmount*percent;
        double total=billAmount+tip;
        tipTextView.setText(currencyFormat.format(tip));
        totalTextView.setText(currencyFormat.format(total));
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private final SeekBar.OnSeekBarChangeListener seekBarListener= new SeekBar.OnSeekBarChangeListener(){
        public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser ){percent=progress/100.0;
            calculate();}
        public void onStartTrackingTouch(SeekBar seekBar){}
        public void onStopTrackingTouch(SeekBar seeBar){}
    };
    private final TextWatcher amountEditTextWatcher=new TextWatcher() {
        public void onTextChanged(CharSequence s, int start,int before, int count){
            try{
                billAmount=Double.parseDouble(s.toString());
                Toast toast1 = Toast.makeText(getApplicationContext(),
                                " "+billAmount, Toast.LENGTH_SHORT);

                toast1.show();

            }catch(NumberFormatException e){
                billAmount=0.0;
            }
            calculate();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
        public void beforeTextChanged(CharSequence s, int start,int count, int after){}
    };
}
