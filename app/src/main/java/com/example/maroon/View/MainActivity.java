package com.example.maroon.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import androidx.appcompat.widget.SearchView;
import android.widget.TextView;

import com.example.maroon.Adapter.FruitAdapter;
import com.example.maroon.FakeModel.FruitData;
import com.example.maroon.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.zarinpal.ewallets.purchase.OnCallbackRequestPaymentListener;
import com.zarinpal.ewallets.purchase.OnCallbackVerificationPaymentListener;
import com.zarinpal.ewallets.purchase.PaymentRequest;
import com.zarinpal.ewallets.purchase.ZarinPal;

import java.util.ArrayList;
import java.util.List;

import static com.example.maroon.G.Font_shabnam;
import static com.example.maroon.G.showToast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,SearchView.OnQueryTextListener {

    public static BottomNavigationView bottomNavigation;
    private SearchView searchView;
    private TextView txtTitle;
    private FruitAdapter adapter ;
    private RecyclerView recyclerFruit ;
    private LinearLayoutManager layoutManager ;
    private List<FruitData> data  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //new Line For Test Push

        ZarinPalCallback();
        init();
        initBottomNavigationView();
        fillFruitData();
        setUpRecyclerViewFruit();

    }

    //The callback is run when purchase result back from browser
    private void ZarinPalCallback() {
        if (getIntent().getData() != null) {

            ZarinPal.getPurchase(this).verificationPayment(getIntent().getData(), new OnCallbackVerificationPaymentListener() {
                @Override
                public void onCallbackResultVerificationPayment(boolean isPaymentSuccess, String refID, PaymentRequest paymentRequest) {
                    showToast("onCallbackResultVerificationPayment: " + refID);
                }
            });
        }
    }

    //Cast and Set TypeFace for Views
    private void init() {
        bottomNavigation = findViewById(R.id.bottomNavigationView);
        txtTitle = findViewById(R.id.txtTitle);
        searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(this);

        TextView searchText = (TextView) findViewById(androidx.appcompat.R.id.search_src_text);
        searchView = searchText.findViewById(R.id.searchView);

        searchText.setTypeface(Font_shabnam);
        txtTitle.setTypeface(Font_shabnam);



    }

    private void fillFruitData() {
        data = new ArrayList<>();
        data.add(new FruitData(R.drawable.angor_small,"انگور","23000 تومان"));
        data.add(new FruitData(R.drawable.golabi_small,"گلابی","12000 تومان"));
        data.add(new FruitData(R.drawable.sib_small,"سیب","15000 تومان"));
        data.add(new FruitData(R.drawable.anar_small,"انار","16000 تومان"));
        data.add(new FruitData(R.drawable.talebi_small,"طالبی","17500 تومان"));
        data.add(new FruitData(R.drawable.kivi_small,"کیوی","32000 تومان"));
        data.add(new FruitData(R.drawable.toot_small,"توت فرنگی","10000 تومان"));
        data.add(new FruitData(R.drawable.havig_small,"هویج","14000 تومان"));
        data.add(new FruitData(R.drawable.portoghal_small,"پرتقال","13500 تومان"));

    }
    private void setUpRecyclerViewFruit(){

        recyclerFruit = findViewById(R.id.recyclerFruit);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        adapter = new FruitAdapter(this , data);
        recyclerFruit.setLayoutManager(layoutManager);
        recyclerFruit.setAdapter(adapter);
    }

    //init bottomNavigationView
    private void initBottomNavigationView() {
        bottomNavigation.setSelectedItemId(R.id.action_Home);
    }

    private void zarinPalPayment() {
//        PaymentRequest payment = ZarinPal.getSandboxPaymentRequest();
        PaymentRequest payment = ZarinPal.getPaymentRequest();


        payment.setMerchantID("0139ea83-4158-aswx-1234-000c295eb8fc");
        payment.setAmount(120);
        payment.setDescription("خرید به جهت تست");
        payment.setMobile("09161234567");
        payment.setCallbackURL("return://zarinpalpayment");
        payment.isZarinGateEnable(true);


        ZarinPal.getPurchase(getApplicationContext()).startPayment(payment, new OnCallbackRequestPaymentListener() {
            @Override
            public void onCallbackResultPaymentRequest(int status, String authority, Uri paymentGatewayUri, Intent intent) {

                startActivity(intent);
            }
        });


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

        }

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.getFilter().filter(newText);
        return false;
    }

}