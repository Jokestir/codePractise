/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.pets;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.android.pets.Data.PetDbHelper;
import com.example.android.pets.Data.PetsContract;

/**
 * Displays list of pets that were entered and stored in the app.
 */
public class CatalogActivity extends AppCompatActivity {

    private PetDbHelper petDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        // Setup FAB to open EditorActivity
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CatalogActivity.this, EditorActivity.class);
                startActivity(intent);
            }
        });

        petDbHelper = new PetDbHelper(this);
        displayDatabaseInfo();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_catalog.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_catalog, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Insert dummy data" menu option
            case R.id.action_insert_dummy_data:
                insertDummyData();
                displayDatabaseInfo();
                return true;
            // Respond to a click on the "Delete all entries" menu option
            case R.id.action_delete_all_entries:
                // Do nothing for now
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void insertDummyData() {
        SQLiteDatabase db = petDbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PetsContract.petsNameEntry.COLUMN_PET_NAME,"Toto");
        contentValues.put(PetsContract.petsNameEntry.COLUMN_PET_BREED,"Terrier");
        contentValues.put(PetsContract.petsNameEntry.COLUMN_PET_GENDER,"Male");
        contentValues.put(PetsContract.petsNameEntry.COLUMN_PET_WEIGHT,"7");
        db.insert(PetsContract.petsNameEntry.TABLE_NAME,null,contentValues);
    }

    /**
     * Temporary helper method to display information in the onscreen TextView about the state of
     * the pets database.
     */
    private void displayDatabaseInfo() {
        // To access our database, we instantiate our subclass of SQLiteOpenHelper
        // and pass the context, which is the current activity.
        PetDbHelper mDbHelper = new PetDbHelper(this);

        // open a connection to db or create a db. similar to .open
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Perform this raw SQL query "SELECT * FROM pets"
        // to get a Cursor that contains all rows from the pets table.
        // Cursor cursor = db.rawQuery("SELECT * FROM " + PetsContract.petsNameEntry.TABLE_NAME, null);

        String[] projection = {PetsContract.petsNameEntry._ID,
                                PetsContract.petsNameEntry.COLUMN_PET_NAME,
                                PetsContract.petsNameEntry.COLUMN_PET_BREED,
                                PetsContract.petsNameEntry.COLUMN_PET_GENDER,
                                PetsContract.petsNameEntry.COLUMN_PET_WEIGHT};

        Cursor cursor = db.query(PetsContract.petsNameEntry.TABLE_NAME,projection,null,null,null,null,null);

        try {
            // Display the number of rows in the Cursor (which reflects the number of rows in the
            // pets table in the database).
            TextView displayView = (TextView) findViewById(R.id.text_view_pet);
            displayView.setText("The pets table contains " + cursor.getCount() + " pets \n\n");

            displayView.append(PetsContract.petsNameEntry._ID + "--" + PetsContract.petsNameEntry.COLUMN_PET_NAME + "--" + PetsContract.petsNameEntry.COLUMN_PET_BREED + "--" + PetsContract.petsNameEntry.COLUMN_PET_GENDER + "--" + PetsContract.petsNameEntry.COLUMN_PET_WEIGHT);
            while(cursor.moveToNext()){
                int currentID = cursor.getInt(cursor.getColumnIndex(PetsContract.petsNameEntry._ID));
                String currentPetName = cursor.getString(cursor.getColumnIndex(PetsContract.petsNameEntry.COLUMN_PET_NAME));
                String currentBreed = cursor.getString(cursor.getColumnIndex(PetsContract.petsNameEntry.COLUMN_PET_BREED));
                int currentGender = cursor.getInt(cursor.getColumnIndex(PetsContract.petsNameEntry.COLUMN_PET_GENDER));
                int currentWeight = cursor.getInt(cursor.getColumnIndex(PetsContract.petsNameEntry.COLUMN_PET_WEIGHT));

                displayView.append("\n" + currentID + "--" + currentPetName + "--" + currentBreed + "--" + currentGender + "--" + currentWeight);

            }
        } finally {
            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid.
            cursor.close();
        }
    }
}
