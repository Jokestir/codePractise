
package com.example.android.justjava;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity
        extends AppCompatActivity {

    double priceForChocoDip = 2;
    double priceForWhippedCream = 2;
    boolean containsWhippedCream;
    boolean hasChocoDip;
    EditText name;


    public double addWhippedCreamPrice(double value){
        return value + this.priceForWhippedCream;
    }


    public double addChocoDipPrice(double value) {
        return value + this.priceForWhippedCream;
    }

    public void setChocoDip(boolean value){
        this.hasChocoDip = value;
    }

    public boolean isHasChocoDip(){
        return this.hasChocoDip;
    }


    public boolean isContainsWhippedCream() {
        return containsWhippedCream;
    }

    public void setContainsWhippedCream(boolean containsWhippedCream) {
        this.containsWhippedCream = containsWhippedCream;
    }

    public static int pricePerCoffeeInDollars = 5;
    public TextView qtyTextView;
    public TextView priceView;
    public static int numberOfCoffee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        qtyTextView = (TextView) findViewById(R.id.quantity_textView);
        priceView = (TextView) findViewById(R.id.price_textView);
        name = (EditText) findViewById(R.id.nameEditText);
    }


    public void displayQty(int number){
        qtyTextView.setText(Integer.toString(number));
    }

    public void displayPrice(double number){
        priceView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    public void submitOrder(View view){
            /*int numberOfCoffes = this.numberOfCoffee;
            this.displayPrice(calculateCostOfCofees(numberOfCoffes));*/

//          String priceMessage = "Total:" + (this.numberOfCoffee * 5) + "\n" + "Thank you!";
            /*displayMessage(createOrderSummary(name.getText().toString()));*/

        String[] toArray = {"cahuja19@gmail.com"};
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, toArray);
        intent.putExtra(Intent.EXTRA_SUBJECT,getString(R.string.just_java_order_for) + this.name.getText().toString());
        intent.putExtra(Intent.EXTRA_TEXT,createOrderSummary(name.getText().toString()));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(intent,getString(R.string.send_email_via)));
        }
        else{
            Log.v("TAG",getString(R.string.no_email_app_intent_warning));
        }
    }

    public void incrementQtyByOne(View view) {
        if (this.numberOfCoffee < 100)
            this.displayQty(++this.numberOfCoffee);
        else
            Toast.makeText(this, R.string.max_cofee_cups_reached_warning,Toast.LENGTH_SHORT).show();
    }

    public void decrementQtyByOne(View view) {
        if(this.numberOfCoffee > 1)
            this.displayQty(--this.numberOfCoffee);
        else
            Toast.makeText(this, R.string.min_coffee_cups_reached_warning, Toast.LENGTH_SHORT).show();

    }

    public double calculateCostOfCofees(int numberOfCoffees){
        return (1.0 * pricePerCoffeeInDollars * numberOfCoffees);
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_textView);
        priceTextView.setText(message);
    }

    private double calculateTotalBill(){
        double base  =0;
        int qtyOfCoffee = Integer.valueOf(qtyTextView.getText().toString());
        if (qtyOfCoffee > 0)
            base += pricePerCoffeeInDollars;
        if (isHasChocoDip())
            base += priceForChocoDip;
        if (isContainsWhippedCream())
            base += priceForWhippedCream;

        return base * qtyOfCoffee;
    }

    private String createOrderSummary(String name){
        int qtyOfCoffee = Integer.valueOf(qtyTextView.getText().toString());
        String orderSummaryString = getString(R.string.name_text_colon) + name + "\n" + getString(R.string.quantity_text_colon) + qtyOfCoffee;
        if (this.isContainsWhippedCream())
            orderSummaryString += getString(R.string.whipped_cream_yes_colon);
        if (this.isHasChocoDip())
            orderSummaryString += getString(R.string.chocodip_colon_yes);
        orderSummaryString += getString(R.string.total_colon) + NumberFormat.getCurrencyInstance().format(calculateTotalBill());
        orderSummaryString = orderSummaryString + getString(R.string.danke_exclamation);
        return orderSummaryString;
    }

    public void setWhippedCream(View view) {
        CheckBox chkbox = (CheckBox) view;
        this.setContainsWhippedCream(chkbox.isChecked());
    }

    public void setChocoButton(View view) {
        CheckBox chocoBox = (CheckBox) view;
        this.setChocoDip(chocoBox.isChecked());
    }
}
