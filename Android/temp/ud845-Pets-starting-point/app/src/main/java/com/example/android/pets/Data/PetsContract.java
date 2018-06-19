package com.example.android.pets.Data;

import android.net.Uri;
import android.provider.BaseColumns;


/* Contract class will contain schema
   Easier to change schema. Only 1 place
   Remove spelling errors while using SQL commands
*/

public final class PetsContract {

    private PetsContract(){};

    public static final String CONTENT_AUTHORITY = "com.example.android.pets";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_PETS = "pets";

    public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_PETS);



    /*Inner class for each table in database
    * Class implements BaseColumns
    * Contains table name, column name and constants
    * */
    public static final class petsNameEntry implements BaseColumns{
        public static final String TABLE_NAME = "petsname";
        public static final String _ID = "_id";
        public static final String COLUMN_PET_NAME = "name";
        public static final String COLUMN_PET_WEIGHT = "weight";
        public static final String COLUMN_PET_GENDER = "gender";
        public static final String COLUMN_PET_BREED = "breed";

        public static final int GENDER_MALE = 1;
        public static final int GENDER_FEMALE = 2;
        public static final int GENDER_UNKNOWN = 0;
    }

}
