package com.example.freight_frenzy_scoring;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.math.MathUtils;

import android.view.View;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Clock;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

	private TextView autonScoreText, teleopScoreText, endgameScoreText, scoreText;

	private Button autonPreloadTeam, autonPreloadDuck;
	private Button autonDuck;
	private Button autonFreightStorage, autonFreightHub;
	private Button autonParkStoragePartial, autonParkStorageFull, autonParkWarehousePartial, autonParkWarehouseFull;
	private Button teleopAllianceOne, teleopAllianceTwo, teleopAllianceThree;
	private Button teleopOtherShared, teleopOtherStorage;
	private Button endgameBalanceAlliance, endgameBalanceShared;
	private Button endgameDuck;
	private Button endgameCap;
	private Button endgameParkPartial, endgameParkFull;

	private int autonPreloadTeamCount, autonPreloadDuckCount;
	private boolean autonDuckBool;
	private int autonFreightStorageCount, autonFreightHubCount;
	private int autonParkStoragePartialCount, autonParkStorageFullCount, autonParkWarehousePartialCount, autonParkWarehouseFullCount;
	private int teleopAllianceOneCount, teleopAllianceTwoCount, teleopAllianceThreeCount;
	private int teleopOtherSharedCount, teleopOtherStorageCount;
	private boolean endgameBalanceAllianceBool, endgameBalanceSharedBool;
	private int endgameDuckCount;
	private int endgameCapCount;
	private int endgameParkPartialCount, endgameParkFullCount;

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

		teleopAllianceOne = findViewById(R.id.teleopAllianceOne);
		teleopAllianceTwo = findViewById(R.id.teleopAllianceTwo);
		teleopAllianceThree = findViewById(R.id.teleopAllianceThree);
		teleopOtherShared = findViewById(R.id.teleopOtherShared);
		teleopOtherStorage = findViewById(R.id.teleopOtherStorage);

		endgameBalanceAlliance = findViewById(R.id.endgameBalanceAlliance);
		endgameBalanceShared = findViewById(R.id.endgameBalanceShared);
		endgameDuck = findViewById(R.id.endgameDuck);
		endgameCap = findViewById(R.id.endgameCap);
		endgameParkPartial = findViewById(R.id.endgameParkPartial);
		endgameParkFull = findViewById(R.id.endgameParkFull);

		scoreText = findViewById(R.id.scoreText);
		autonScoreText = findViewById(R.id.autonScoreText);
		teleopScoreText = findViewById(R.id.teleopScoreText);
		endgameScoreText = findViewById(R.id.endgameScoreText);

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

		teleopAllianceOne.setOnClickListener(this);
		teleopAllianceTwo.setOnClickListener(this);
		teleopAllianceThree.setOnClickListener(this);
		teleopOtherShared.setOnClickListener(this);
		teleopOtherStorage.setOnClickListener(this);

		endgameBalanceAlliance.setOnClickListener(this);
		endgameBalanceShared.setOnClickListener(this);
		endgameDuck.setOnClickListener(this);
		endgameCap.setOnClickListener(this);
		endgameParkPartial.setOnClickListener(this);
		endgameParkFull.setOnClickListener(this);


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

		teleopAllianceOne.setOnLongClickListener(this);
		teleopAllianceTwo.setOnLongClickListener(this);
		teleopAllianceThree.setOnLongClickListener(this);
		teleopOtherShared.setOnLongClickListener(this);
		teleopOtherStorage.setOnLongClickListener(this);

		endgameBalanceAlliance.setOnLongClickListener(this);
		endgameBalanceShared.setOnLongClickListener(this);
		endgameDuck.setOnLongClickListener(this);
		endgameCap.setOnLongClickListener(this);
		endgameParkPartial.setOnLongClickListener(this);
		endgameParkFull.setOnLongClickListener(this);

		loadData();
		updateDisplay();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.autonPreloadTeam:
				autonPreloadTeamCount++;
				autonPreloadTeamCount = MathUtils.clamp(autonPreloadTeamCount, 0, 2);
				break;
			case R.id.autonPreloadDuck:
				autonPreloadDuckCount++;
				autonPreloadDuckCount = MathUtils.clamp(autonPreloadDuckCount, 0, 2);
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
				autonParkStoragePartialCount++;
				autonParkStoragePartialCount = MathUtils.clamp(autonParkStoragePartialCount, 0, 2);
				break;
			case R.id.autonParkingStorageFull:
				autonParkStorageFullCount++;
				autonParkStorageFullCount = MathUtils.clamp(autonParkStorageFullCount, 0, 2);
				break;
			case R.id.autonParkingWarehousePartial:
				autonParkWarehousePartialCount++;
				autonParkWarehouseFullCount = MathUtils.clamp(autonParkWarehousePartialCount, 0, 2);
				break;
			case R.id.autonParkingWarehouseFull:
				autonParkWarehouseFullCount++;
				autonParkWarehouseFullCount = MathUtils.clamp(autonParkWarehouseFullCount, 0, 2);
				break;
			case R.id.teleopAllianceOne:
				teleopAllianceOneCount++;
				teleopAllianceOneCount = Math.max(0, teleopAllianceOneCount);
				break;
			case R.id.teleopAllianceTwo:
				teleopAllianceTwoCount++;
				teleopAllianceTwoCount = Math.max(0, teleopAllianceTwoCount);
				break;
			case R.id.teleopAllianceThree:
				teleopAllianceThreeCount++;
				teleopAllianceThreeCount = Math.max(0, teleopAllianceThreeCount);
				break;
			case R.id.teleopOtherShared:
				teleopOtherSharedCount++;
				teleopOtherSharedCount = Math.max(0, teleopOtherSharedCount);
				break;
			case R.id.teleopOtherStorage:
				teleopOtherStorageCount++;
				teleopOtherStorageCount = Math.max(0, teleopOtherStorageCount);
				break;
			case R.id.endgameBalanceAlliance:
				endgameBalanceAllianceBool = true;
				break;
			case R.id.endgameBalanceShared:
				endgameBalanceSharedBool = true;
				break;
			case R.id.endgameDuck:
				endgameDuckCount++;
				endgameDuckCount = Math.max(0, endgameDuckCount);
				break;
			case R.id.endgameCap:
				endgameCapCount++;
				endgameCapCount = MathUtils.clamp(endgameCapCount, 0, 2);
				break;
			case R.id.endgameParkPartial:
				endgameParkPartialCount++;
				endgameParkPartialCount = MathUtils.clamp(endgameParkPartialCount, 0, 2);
				break;
			case R.id.endgameParkFull:
				endgameParkFullCount++;
				endgameParkFullCount = MathUtils.clamp(endgameParkFullCount, 0, 2);
				break;
		}
		updateDisplay();
	}

	@Override
	public boolean onLongClick(View v) {
		switch (v.getId()) {
			case R.id.autonPreloadTeam:
				autonPreloadTeamCount--;
				autonPreloadTeamCount = MathUtils.clamp(autonPreloadTeamCount, 0, 2);
				break;
			case R.id.autonPreloadDuck:
				autonPreloadDuckCount--;
				autonPreloadDuckCount = MathUtils.clamp(autonPreloadDuckCount, 0, 2);
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
				autonParkStoragePartialCount--;
				autonParkStoragePartialCount = MathUtils.clamp(autonParkStoragePartialCount, 0, 2);
				break;
			case R.id.autonParkingStorageFull:
				autonParkStorageFullCount--;
				autonParkStorageFullCount = MathUtils.clamp(autonParkStorageFullCount, 0, 2);
				break;
			case R.id.autonParkingWarehousePartial:
				autonParkWarehousePartialCount--;
				autonParkWarehousePartialCount = MathUtils.clamp(autonParkWarehousePartialCount, 0, 2);
				break;
			case R.id.autonParkingWarehouseFull:
				autonParkWarehouseFullCount--;
				autonParkWarehouseFullCount = MathUtils.clamp(autonParkWarehouseFullCount, 0, 2);
				break;
			case R.id.teleopAllianceOne:
				teleopAllianceOneCount--;
				teleopAllianceOneCount = Math.max(0, teleopAllianceOneCount);
				break;
			case R.id.teleopAllianceTwo:
				teleopAllianceTwoCount--;
				teleopAllianceTwoCount = Math.max(0, teleopAllianceTwoCount);
				break;
			case R.id.teleopAllianceThree:
				teleopAllianceThreeCount--;
				teleopAllianceThreeCount = Math.max(0, teleopAllianceThreeCount);
				break;
			case R.id.teleopOtherShared:
				teleopOtherSharedCount--;
				teleopOtherSharedCount = Math.max(0, teleopOtherSharedCount);
				break;
			case R.id.teleopOtherStorage:
				teleopOtherStorageCount--;
				teleopOtherStorageCount = Math.max(0, teleopOtherStorageCount);
				break;
			case R.id.endgameBalanceAlliance:
				endgameBalanceAllianceBool = false;
				break;
			case R.id.endgameBalanceShared:
				endgameBalanceSharedBool = false;
				break;
			case R.id.endgameDuck:
				endgameDuckCount--;
				endgameDuckCount = Math.max(0, endgameDuckCount);
				break;
			case R.id.endgameCap:
				endgameCapCount--;
				endgameCapCount = MathUtils.clamp(endgameCapCount, 0, 2);
				break;
			case R.id.endgameParkPartial:
				endgameParkPartialCount--;
				endgameParkPartialCount = MathUtils.clamp(endgameParkPartialCount, 0, 2);
				break;
			case R.id.endgameParkFull:
				endgameParkFullCount--;
				endgameParkFullCount = MathUtils.clamp(endgameParkFullCount, 0, 2);
				break;
		}
		updateDisplay();
		return true;
	}

	private void updateDisplay() {
		autonPreloadTeam.setText(getString(R.string.auton_preloaded_team_vision_button_text) + ": " + autonPreloadTeamCount);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			if (autonPreloadTeamCount != 0)
				autonPreloadTeam.setBackgroundColor(getColor(R.color.enabled));
			else
				autonPreloadTeam.setBackgroundColor(getColor(R.color.disabled));
		}

		autonPreloadDuck.setText(getString(R.string.auton_preloaded_duck_vision_button_text) + ": " + autonPreloadDuckCount);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			if (autonPreloadDuckCount != 0)
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

		autonParkStoragePartial.setText(getString(R.string.auton_parking_storage_partial_button_text) + ": " + autonParkStoragePartialCount);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			if (autonParkStoragePartialCount != 0)
				autonParkStoragePartial.setBackgroundColor(getColor(R.color.enabled));
			else
				autonParkStoragePartial.setBackgroundColor(getColor(R.color.disabled));
		}

		autonParkStorageFull.setText(getString(R.string.auton_parking_storage_full_button_text) + ": " + autonParkStorageFullCount);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			if (autonParkStorageFullCount != 0)
				autonParkStorageFull.setBackgroundColor(getColor(R.color.enabled));
			else
				autonParkStorageFull.setBackgroundColor(getColor(R.color.disabled));
		}

		autonParkWarehousePartial.setText(getString(R.string.auton_parking_warehouse_partial_button_text) + ": " + autonParkWarehousePartialCount);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			if (autonParkWarehousePartialCount != 0)
				autonParkWarehousePartial.setBackgroundColor(getColor(R.color.enabled));
			else
				autonParkWarehousePartial.setBackgroundColor(getColor(R.color.disabled));
		}

		autonParkWarehouseFull.setText(getString(R.string.auton_parking_warehouse_full_button_text) + ": " + autonParkWarehouseFullCount);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			if (autonParkWarehouseFullCount != 0)
				autonParkWarehouseFull.setBackgroundColor(getColor(R.color.enabled));
			else
				autonParkWarehouseFull.setBackgroundColor(getColor(R.color.disabled));
		}

		teleopAllianceOne.setText(getString(R.string.teleop_alliance_level_one_button_text) + ": " + teleopAllianceOneCount);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			if (teleopAllianceOneCount != 0)
				teleopAllianceOne.setBackgroundColor(getColor(R.color.enabled));
			else
				teleopAllianceOne.setBackgroundColor(getColor(R.color.disabled));
		}

		teleopAllianceTwo.setText(getString(R.string.teleop_alliance_level_two_button_text) + ": " + teleopAllianceTwoCount);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			if (teleopAllianceTwoCount != 0)
				teleopAllianceTwo.setBackgroundColor(getColor(R.color.enabled));
			else
				teleopAllianceTwo.setBackgroundColor(getColor(R.color.disabled));
		}

		teleopAllianceThree.setText(getString(R.string.teleop_alliance_level_three_button_text) + ": " + teleopAllianceThreeCount);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			if (teleopAllianceThreeCount != 0)
				teleopAllianceThree.setBackgroundColor(getColor(R.color.enabled));
			else
				teleopAllianceThree.setBackgroundColor(getColor(R.color.disabled));
		}

		teleopOtherShared.setText(getString(R.string.teleop_other_shared_button_text) + ": " + teleopOtherSharedCount);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			if (teleopOtherSharedCount != 0)
				teleopOtherShared.setBackgroundColor(getColor(R.color.enabled));
			else
				teleopOtherShared.setBackgroundColor(getColor(R.color.disabled));
		}

		teleopOtherStorage.setText(getString(R.string.teleop_other_storage_button_text) + ": " + teleopOtherStorageCount);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			if (teleopOtherStorageCount != 0)
				teleopOtherStorage.setBackgroundColor(getColor(R.color.enabled));
			else
				teleopOtherStorage.setBackgroundColor(getColor(R.color.disabled));
		}

		endgameBalanceAlliance.setText(getString(R.string.endgame_balance_alliance_button_text) + ": " + endgameBalanceAllianceBool);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			if (endgameBalanceAllianceBool)
				endgameBalanceAlliance.setBackgroundColor(getColor(R.color.enabled));
			else
				endgameBalanceAlliance.setBackgroundColor(getColor(R.color.disabled));
		}

		endgameBalanceShared.setText(getString(R.string.endgame_balance_shared_button_text) + ": " + endgameBalanceSharedBool);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			if (endgameBalanceSharedBool)
				endgameBalanceShared.setBackgroundColor(getColor(R.color.enabled));
			else
				endgameBalanceShared.setBackgroundColor(getColor(R.color.disabled));
		}

		endgameDuck.setText(getString(R.string.endgame_duck_delivery_button_text) + ": " + endgameDuckCount);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			if (endgameDuckCount != 0)
				endgameDuck.setBackgroundColor(getColor(R.color.enabled));
			else
				endgameDuck.setBackgroundColor(getColor(R.color.disabled));
		}

		endgameCap.setText(getString(R.string.endgame_capping_button_text) + ": " + endgameCapCount);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			if (endgameCapCount != 0)
				endgameCap.setBackgroundColor(getColor(R.color.enabled));
			else
				endgameCap.setBackgroundColor(getColor(R.color.disabled));
		}

		endgameParkPartial.setText(getString(R.string.endgame_parking_warehouse_partial_button_text) + ": " + endgameParkPartialCount);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			if (endgameParkPartialCount != 0)
				endgameParkPartial.setBackgroundColor(getColor(R.color.enabled));
			else
				endgameParkPartial.setBackgroundColor(getColor(R.color.disabled));
		}

		endgameParkFull.setText(getString(R.string.endgame_parking_warehouse_full_button_text) + ": " + endgameParkFullCount);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			if (endgameParkFullCount != 0)
				endgameParkFull.setBackgroundColor(getColor(R.color.enabled));
			else
				endgameParkFull.setBackgroundColor(getColor(R.color.disabled));
		}

		saveData();
		setScoreText();
	}

	private void saveData() {
		SharedPreferences sp = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
		SharedPreferences.Editor editor = sp.edit();

		editor.putInt("aPT", autonPreloadTeamCount);
		editor.putInt("aPD", autonPreloadDuckCount);
		editor.putBoolean("aD", autonDuckBool);
		editor.putInt("aFS", autonFreightStorageCount);
		editor.putInt("aFW", autonFreightHubCount);
		editor.putInt("aPSP", autonParkStoragePartialCount);
		editor.putInt("aPSF", autonParkStorageFullCount);
		editor.putInt("aPWP", autonParkWarehousePartialCount);
		editor.putInt("aPWF", autonParkWarehouseFullCount);

		editor.putInt("tA1", teleopAllianceOneCount);
		editor.putInt("tA2", teleopAllianceTwoCount);
		editor.putInt("tA3", teleopAllianceThreeCount);
		editor.putInt("tOS", teleopOtherSharedCount);
		editor.putInt("tS", teleopOtherStorageCount);

		editor.putInt("eD", endgameDuckCount);
		editor.putBoolean("eBA", endgameBalanceAllianceBool);
		editor.putBoolean("eBS", endgameBalanceSharedBool);
		editor.putInt("ePP", endgameParkPartialCount);
		editor.putInt("ePF", endgameParkFullCount);
		editor.putInt("eC", endgameCapCount);

		editor.apply();
	}

	private void loadData() {
		SharedPreferences sp = getSharedPreferences("sharedPrefs", MODE_PRIVATE);

		autonPreloadTeamCount = sp.getInt("aPT", 0);
		autonPreloadDuckCount = sp.getInt("aPD", 0);
		autonDuckBool = sp.getBoolean("aD", false);
		autonFreightStorageCount = sp.getInt("aFS", 0);
		autonFreightHubCount = sp.getInt("aFW", 0);
		autonParkStoragePartialCount = sp.getInt("aPSP", 0);
		autonParkStorageFullCount = sp.getInt("aPSF", 0);
		autonParkWarehousePartialCount = sp.getInt("aPWP", 0);
		autonParkWarehouseFullCount = sp.getInt("aPWF", 0);

		teleopAllianceOneCount = sp.getInt("tA1", 0);
		teleopAllianceTwoCount = sp.getInt("tA2", 0);
		teleopAllianceThreeCount = sp.getInt("tA3", 0);
		teleopOtherSharedCount = sp.getInt("tOS", 0);
		teleopOtherStorageCount = sp.getInt("tS", 0);

		endgameDuckCount = sp.getInt("eD", 0);
		endgameBalanceAllianceBool = sp.getBoolean("eBA", false);
		endgameBalanceSharedBool = sp.getBoolean("eBS", false);
		endgameParkPartialCount = sp.getInt("ePP", 0);
		endgameParkFullCount = sp.getInt("ePF", 0);
		endgameCapCount = sp.getInt("eC", 0);

	}

	private void setScoreText() {
		scoreText.setText(getString(R.string.score_text) + ": " + (getAutonScore() + getTeleopScore() + getEndgameScore()));
		autonScoreText.setText(getString(R.string.score_text) + ": " + getAutonScore());
		teleopScoreText.setText(getString(R.string.score_text) + ": " + getTeleopScore());
		endgameScoreText.setText(getString(R.string.score_text) + ": " + getEndgameScore());
	}

	private int getAutonScore() {
		int duckScore = autonDuckBool ? 10 : 0;

		int storagePartialScore = 3 * autonParkStoragePartialCount;
		int storageFullScore = 6 * autonParkStorageFullCount;
		int warehousePartialScore = 5 * autonParkWarehousePartialCount;
		int warehouseFullScore = 10 * autonParkWarehouseFullCount;
		int parkingScore = storagePartialScore + storageFullScore + warehousePartialScore + warehouseFullScore;

		int freightStorageScore = 2 * autonFreightStorageCount;
		int freightHubScore = 6 * autonFreightHubCount;
		int freightScore = freightStorageScore + freightHubScore;

		int preloadScore = (10 * autonPreloadDuckCount) + (20 * autonPreloadTeamCount);

		return duckScore + parkingScore + freightScore + preloadScore;
	}

	private int getTeleopScore() {
		int allianceFreightOneScore = 2 * teleopAllianceOneCount;
		int allianceFreightTwoScore = 4 * teleopAllianceTwoCount;
		int allianceFreightThreeScore = 6 * teleopAllianceThreeCount;
		int allianceFreightScore = allianceFreightOneScore + allianceFreightTwoScore + allianceFreightThreeScore;

		int freightStorageScore = 1 * teleopOtherStorageCount;
		int freightSharedScore = 4 * teleopOtherSharedCount;
		int otherFreightScore = freightStorageScore + freightSharedScore;

		return allianceFreightScore + otherFreightScore;
	}

	private int getEndgameScore() {
		int duckScore = 6 * endgameDuckCount;

		int balanceAllianceScore = endgameBalanceAllianceBool ? 10 : 0;
		int balanceSharedScore = endgameBalanceSharedBool ? 20 : 0;
		int balanceScore = balanceAllianceScore + balanceSharedScore;

		int parkPartialScore = 3 * endgameParkPartialCount;
		int parkFullScore = 6 * endgameParkFullCount;
		int parkScore = parkPartialScore + parkFullScore;

		int capScore = 15 * endgameCapCount;

		return duckScore + balanceScore + parkScore + capScore;
	}

}