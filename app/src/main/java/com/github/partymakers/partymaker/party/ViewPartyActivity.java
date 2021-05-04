package com.github.partymakers.partymaker.party;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.github.partymakers.partymaker.R;
import com.github.partymakers.partymaker.databinding.ActivityViewPartyBinding;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ViewPartyActivity extends AppCompatActivity {
    private ActivityViewPartyBinding dataBinding;

    PartyEntity party = new PartyEntity();

    {
        party.setName("Dope af");
        party.setDescription("Long loooooooooong description");
        party.setTimestamp(new Date().getTime());
        party.setLocation("location");
        party.setTheme("theme");
        party.setDressCode("dress code");
        party.setFood(Arrays.asList("Pizza", "Kebab", "Saszety"));
        party.setDrinks(Arrays.asList("Vodka", "Tea", "void juice"));
        party.setFee("miljon cebulionów");
        party.setAllowsPartner(true);
        party.setParkingDetails("just walk, duh");
        party.setAdditionalInformation("grass is green");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_view_party);
        setContentView(dataBinding.getRoot());
        dataBinding.setParty(party);


//for the future (add "intent.putExtra("type", "edit");" to DashboardFragment.java - join button onclick)
//        Bundle bundle = getIntent().getExtras();
//
//        if (bundle.getString("type").equals("join")) {
//            dataBinding.imageButtonViewPartyEdit.setVisibility(View.GONE);
//            dataBinding.buttonsViewParty.setVisibility(View.VISIBLE);
//            //dataBinding.foodJoinInputLayout.setVisibility(View.VISIBLE);
//            //dataBinding.infoViewPartyInputLayout.setVisibility(View.VISIBLE);
//        } else if (bundle.getString("type").equals("edit")) {
//            dataBinding.imageButtonViewPartyEdit.setVisibility(View.VISIBLE);
//            dataBinding.buttonsViewParty.setVisibility(View.GONE);
//        }

        if (party.getTimestamp() != null) {
            String dateTime = SimpleDateFormat.getDateTimeInstance(DateFormat.FULL, 2).format(new Date(party.getTimestamp()));
            dataBinding.textViewPartyDateTime.setText("When: " + dateTime);
        }
    }
}
