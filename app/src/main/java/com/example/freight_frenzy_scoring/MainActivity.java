package com.example.freight_frenzy_scoring;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.math.MathUtils;

import android.view.View;

import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

	private Button autonPreloadTeam, autonPreloadDuck;
	private Button autonDuck;
	private Button autonFreightStorage, autonFreightHub;
	private Button autonParkStoragePartial, autonParkStorageFull, autonParkWarehousePartial, autonParkWarehouseFull;

	private boolean autonPreloadTeamBool, autonPreloadDuckBool;
	private boolean autonDuckBool;
	private int autonFreightStorageCount, autonFreightHubCount;
	private boolean autonParkStoragePartialBool, autonParkStorageFullBool, autonParkWarehousePartialBool, autonParkWarehouseFullBool;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		autonPreloadTeam = findViewById(R.id.autonPreloadTeam);
		autonPreloadDuck = findViewById(R.id.autonPreloadDuck);
		autonDuck = findViewById(R.id.autonDuckDeliveryButton);
		autonFreightStorage = findViewById(R.id.autonFreightScoringStorage);
		autonFreightHub = findViewById(R.id.autonFreightScoringHub);
		autonParkStoragePartial = findViewById(R.id.autonParkingStoragePartial);
		autonParkStorageFull = findViewById(R.id.autonParkingStorageFull);
		autonParkWarehousePartial = findViewById(R.id.autonParkingWarehousePartial);
		autonParkWarehouseFull = findViewById(R.id.autonParkingWarehouseFull);

		autonPreloadTeam.setOnClickListener(this);
		autonPreloadDuck.setOnClickListener(this);
		autonDuck.setOnClickListener(this);
		autonFreightStorage.setOnClickListener(this);
		autonFreightHub.setOnClickListener(this);
		autonFreightStorage.setOnClickListener(this);
		autonFreightHub.setOnClickListener(this);
		autonParkStoragePartial.setOnClickListener(this);
		autonParkStorageFull.setOnClickListener(this);
		autonParkWarehousePartial.setOnClickListener(this);
		autonParkWarehouseFull.setOnClickListener(this);

		autonPreloadTeam.setOnLongClickListener(this);
		autonPreloadDuck.setOnLongClickListener(this);
		autonDuck.setOnLongClickListener(this);
		autonFreightStorage.setOnLongClickListener(this);
		autonFreightHub.setOnLongClickListener(this);
		autonFreightStorage.setOnLongClickListener(this);
		autonFreightHub.setOnLongClickListener(this);
		autonParkStoragePartial.setOnLongClickListener(this);
		autonParkStorageFull.setOnLongClickListener(this);
		autonParkWarehousePartial.setOnLongClickListener(this);
		autonParkWarehouseFull.setOnLongClickListener(this);

		loadData();
		updateDisplay();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.autonPreloadTeam:
				autonPreloadTeamBool = true;
				break;
			case R.id.autonPreloadDuck:
				autonPreloadDuckBool = true;
				break;
			case R.id.autonDuckDeliveryButton:
				autonDuckBool = true;
				break;
			case R.id.autonFreightScoringStorage:
				autonFreightStorageCount++;
				autonFreightStorageCount = Math.max(0, autonFreightStorageCount);
				break;
			case R.id.autonFreightScoringHub:
				autonFreightHubCount++;
				autonFreightHubCount = Math.max(autonFreightHubCount, 0);
				break;
			case R.id.autonParkingStoragePartial:
				autonParkStoragePartialBool = true;
				break;
			case R.id.autonParkingStorageFull:
				autonParkStorageFullBool = true;
				break;
			case R.id.autonParkingWarehousePartial:
				autonParkWarehousePartialBool = true;
				break;
			case R.id.autonParkingWarehouseFull:
				autonParkWarehouseFullBool = true;
				break;
		}
		updateDisplay();
	}

	@Override
	public boolean onLongClick(View v) {
		switch (v.getId()) {
			case R.id.autonPreloadTeam:
				autonPreloadTeamBool = false;
				break;
			case R.id.autonPreloadDuck:
				autonPreloadDuckBool = false;
				break;
			case R.id.autonDuckDeliveryButton:
				autonDuckBool = false;
				break;
			case R.id.autonFreightScoringStorage:
				autonFreightStorageCount--;
				autonFreightStorageCount = Math.max(0, autonFreightStorageCount);
				break;
			case R.id.autonFreightScoringHub:
				autonFreightHubCount--;
				autonFreightHubCount = Math.max(0, autonFreightHubCount);
				break;
			case R.id.autonParkingStoragePartial:
				autonParkStoragePartialBool = false;
				break;
			case R.id.autonParkingStorageFull:
				autonParkStorageFullBool = false;
				break;
			case R.id.autonParkingWarehousePartial:
				autonParkWarehousePartialBool = false;
				break;
			case R.id.autonParkingWarehouseFull:
				autonParkWarehouseFullBool = false;
				break;
		}
		updateDisplay();
		return true;
	}

	private void updateDisplay() {
		autonPreloadTeam.setText(getString(R.string.auton_preloaded_team_vision_button_text) + ": " + autonPreloadTeamBool);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			if (autonPreloadTeamBool)
				autonPreloadTeam.setBackgroundColor(getColor(R.color.enabled));
			else
				autonPreloadTeam.setBackgroundColor(getColor(R.color.disabled));
		}
		autonPreloadDuck.setText(getString(R.string.auton_preloaded_duck_vision_button_text) + ": " + autonPreloadDuckBool);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			if (autonPreloadDuckBool)
				autonPreloadDuck.setBackgroundColor(getColor(R.color.enabled));
			else
				autonPreloadDuck.setBackgroundColor(getColor(R.color.disabled));
		}
		autonDuck.setText(getString(R.string.auton_duck_delivery_button_text) + ": " + autonDuckBool);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			if (autonDuckBool)
				autonDuck.setBackgroundColor(getColor(R.color.enabled));
			else
				autonDuck.setBackgroundColor(getColor(R.color.disabled));
		}
		autonFreightStorage.setText(getString(R.string.auton_freight_scoring_storage_button_text) + ": " + autonFreightStorageCount);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			if (autonFreightStorageCount != 0)
				autonFreightStorage.setBackgroundColor(getColor(R.color.enabled));
			else
				autonFreightStorage.setBackgroundColor(getColor(R.color.disabled));
		}
		autonFreightHub.setText(getString(R.string.auton_freight_scoring_hub_button_text) + ": " + autonFreightHubCount);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			if (autonFreightHubCount != 0)
				autonFreightHub.setBackgroundColor(getColor(R.color.enabled));
			else
				autonFreightHub.setBackgroundColor(getColor(R.color.disabled));
		}
		autonParkStoragePartial.setText(getString(R.string.auton_parking_storage_partial_button_text) + ": " + autonParkStoragePartialBool);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			if (autonParkStoragePartialBool)
				autonParkStoragePartial.setBackgroundColor(getColor(R.color.enabled));
			else
				autonParkStoragePartial.setBackgroundColor(getColor(R.color.disabled));
		}
		autonParkStorageFull.setText(getString(R.string.auton_parking_storage_full_button_text) + ": " + autonParkStorageFullBool);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			if (autonParkStorageFullBool)
				autonParkStorageFull.setBackgroundColor(getColor(R.color.enabled));
			else
				autonParkStorageFull.setBackgroundColor(getColor(R.color.disabled));
		}
		autonParkWarehousePartial.setText(getString(R.string.auton_parking_warehouse_partial_button_text) + ": " + autonParkWarehousePartialBool);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			if (autonParkWarehousePartialBool)
				autonParkWarehousePartial.setBackgroundColor(getColor(R.color.enabled));
			else
				autonParkWarehousePartial.setBackgroundColor(getColor(R.color.disabled));
		}
		autonParkWarehouseFull.setText(getString(R.string.auton_parking_warehouse_full_button_text) + ": " + autonParkWarehouseFullBool);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			if (autonParkWarehouseFullBool)
				autonParkWarehouseFull.setBackgroundColor(getColor(R.color.enabled));
			else
				autonParkWarehouseFull.setBackgroundColor(getColor(R.color.disabled));
		}
		saveData();
	}

	private void saveData() {
		SharedPreferences sp = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
		SharedPreferences.Editor editor = sp.edit();

		editor.putBoolean("aPT", autonPreloadTeamBool);
		editor.putBoolean("aPD", autonPreloadDuckBool);
		editor.putBoolean("aD", autonDuckBool);
		editor.putInt("aFS", autonFreightStorageCount);
		editor.putInt("aFW", autonFreightHubCount);
		editor.putBoolean("aPSP", autonParkStoragePartialBool);
		editor.putBoolean("aPSF", autonParkStorageFullBool);
		editor.putBoolean("aPWP", autonParkWarehousePartialBool);
		editor.putBoolean("aPWF", autonParkWarehouseFullBool);

		editor.apply();
	}

	public void loadData() {
		SharedPreferences sp = getSharedPreferences("sharedPrefs", MODE_PRIVATE);

		autonPreloadTeamBool = sp.getBoolean("aPT", false);
		autonPreloadDuckBool = sp.getBoolean("aPD", false);
		autonDuckBool = sp.getBoolean("aD", false);
		autonFreightStorageCount = sp.getInt("aFS", 0);
		autonFreightHubCount = sp.getInt("aFW", 0);
		autonParkStoragePartialBool = sp.getBoolean("aPSP", false);
		autonParkStorageFullBool = sp.getBoolean("aPSF", false);
		autonParkWarehousePartialBool = sp.getBoolean("aPWP", false);
		autonParkWarehouseFullBool = sp.getBoolean("aPWF", false);

	}

}