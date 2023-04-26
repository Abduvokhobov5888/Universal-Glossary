package com.codearteam.lugat_v2.database;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Query;
import com.codearteam.lugat_v2.model.TableModel;


@Dao
public interface ScienceDao {

    @Query("SELECT * FROM TableAdabiyot")
    public abstract DataSource.Factory<Integer, TableModel> tableAdabiyot();

    @Query("SELECT * FROM TableAkt")
    public abstract DataSource.Factory<Integer, TableModel> tableAkt();

    @Query("SELECT * FROM TableFizika")
    public abstract DataSource.Factory<Integer, TableModel> tableFizika();

    @Query("SELECT * FROM TableGeografiya")
    public abstract DataSource.Factory<Integer, TableModel> tableGeografiya();

    @Query("SELECT * FROM TableIqtisodiyot")
    public abstract DataSource.Factory<Integer, TableModel> tableIqtisodiyot();

    @Query("SELECT * FROM TableMatematika")
    public abstract DataSource.Factory<Integer, TableModel> tableMatematika();

    @Query("SELECT * FROM TablePsixologiya")
    public abstract DataSource.Factory<Integer, TableModel> tablePsixologiya();

    @Query("SELECT * FROM TableTarix")
    public abstract DataSource.Factory<Integer, TableModel> tableTarix();



    @Query("SELECT * FROM TableAdabiyot WHERE LOWER(atama) LIKE '%' || :search || '%' ")
    public abstract DataSource.Factory<Integer, TableModel> searchAdabiyot(String search);

    @Query("SELECT * FROM TableAkt WHERE LOWER(atama) LIKE '%' || :search || '%'")
    public abstract DataSource.Factory<Integer, TableModel> searchAkt(String search);

    @Query("SELECT * FROM TableFizika WHERE LOWER(atama) LIKE '%' || :search || '%'")
    public abstract DataSource.Factory<Integer, TableModel> searchFizika(String search);

    @Query("SELECT * FROM TableGeografiya WHERE LOWER(atama) LIKE '%' || :search || '%'")
    public abstract DataSource.Factory<Integer, TableModel> searchGeografiya(String search);

    @Query("SELECT * FROM TableIqtisodiyot WHERE LOWER(atama) LIKE '%' || :search || '%'")
    public abstract DataSource.Factory<Integer, TableModel> searchIqtisodiyot(String search);

    @Query("SELECT * FROM TableMatematika WHERE LOWER(atama) LIKE '%' || :search || '%'")
    public abstract DataSource.Factory<Integer, TableModel> searchMatematika(String search);

    @Query("SELECT * FROM TablePsixologiya WHERE LOWER(atama) LIKE '%' || :search || '%'")
    public abstract DataSource.Factory<Integer, TableModel> searchPsixologiya(String search);

    @Query("SELECT * FROM TableTarix WHERE LOWER(atama) LIKE '%' || :search || '%'")
    public abstract DataSource.Factory<Integer, TableModel> searchTarix(String search);


}
