package com.example.freight_frenzy_scoring;

import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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
				autonFreightHubCount++;
				break;
			case R.id.autonFreightScoringHub:
				autonFreightHubCount++;
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
				autonFreightHubCount--;
				break;
			case R.id.autonFreightScoringHub:
				autonFreightHubCount--;
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
	}

}