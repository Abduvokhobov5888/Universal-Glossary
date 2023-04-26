package com.codearteam.lugat_v2.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.codearteam.lugat_v2.database.table.TableAdabiyot;
import com.codearteam.lugat_v2.database.table.TableAkt;
import com.codearteam.lugat_v2.database.table.TableFizika;
import com.codearteam.lugat_v2.database.table.TableGeografiya;
import com.codearteam.lugat_v2.database.table.TableIqtisodiyot;
import com.codearteam.lugat_v2.database.table.TableMatematika;
import com.codearteam.lugat_v2.database.table.TablePsixologiya;
import com.codearteam.lugat_v2.database.table.TableTarix;

@Database(entities = {TableAdabiyot.class, TableAkt.class, TableFizika.class, TableGeografiya.class, TableIqtisodiyot.class, TableMatematika.class, TablePsixologiya.class, TableTarix.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "database.db";

    private static AppDatabase INSTANCE;

    private static final Object sLock = new Object();

    public abstract ScienceDao scienceDao();

    public static AppDatabase getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DATABASE_NAME)
                        .createFromAsset("locale_lugat.db")
                        .allowMainThreadQueries()
                        .build();
            }
            return INSTANCE;
        }
    }
}