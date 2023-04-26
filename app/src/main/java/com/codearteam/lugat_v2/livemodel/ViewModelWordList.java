package com.codearteam.lugat_v2.livemodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import com.codearteam.lugat_v2.database.AppDatabase;
import com.codearteam.lugat_v2.model.TableModel;

public class ViewModelWordList extends AndroidViewModel {
    private static final int PAGE_SIZE = 10;

    private AppDatabase appDatabase;

    private MutableLiveData<String> searchText ;

    public ViewModelWordList(@NonNull Application application) {
        super(application);
        appDatabase = AppDatabase.getInstance(this.getApplication());
        searchText = new MutableLiveData<>();
        searchText.setValue("");
    }



    public LiveData<PagedList<TableModel>> getDataList(int fan) {
        switch (fan) {
            case 0:
                return Transformations.switchMap(
                        searchText, (Function<String, LiveData<PagedList<TableModel>>>) input -> {
                            if (input.isEmpty()) {
                                return new LivePagedListBuilder(appDatabase.scienceDao().tableAdabiyot(), PAGE_SIZE).build();
                            } else {
                                return new LivePagedListBuilder(appDatabase.scienceDao().searchAdabiyot(input), PAGE_SIZE).build();
                            }
                        });
            case 1:
                return Transformations.switchMap(
                        searchText, (Function<String, LiveData<PagedList<TableModel>>>) input -> {
                            if (input.isEmpty()) {
                                return new LivePagedListBuilder(appDatabase.scienceDao().tableAkt(), PAGE_SIZE).build();
                            } else {
                                return new LivePagedListBuilder(appDatabase.scienceDao().searchAkt(input), PAGE_SIZE).build();
                            }
                        });

            case 2:
                return Transformations.switchMap(
                        searchText, (Function<String, LiveData<PagedList<TableModel>>>) input -> {
                            if (input.isEmpty()) {
                                return new LivePagedListBuilder(appDatabase.scienceDao().tableFizika(), PAGE_SIZE).build();
                            } else {
                                return new LivePagedListBuilder(appDatabase.scienceDao().searchFizika(input), PAGE_SIZE).build();
                            }
                        });
            case 3:
                return Transformations.switchMap(
                        searchText, (Function<String, LiveData<PagedList<TableModel>>>) input -> {
                            if (input.isEmpty()) {
                                return new LivePagedListBuilder(appDatabase.scienceDao().tableGeografiya(), PAGE_SIZE).build();
                            } else {
                                return new LivePagedListBuilder(appDatabase.scienceDao().searchGeografiya(input), PAGE_SIZE).build();
                            }
                        });

            case 4:
                return Transformations.switchMap(
                        searchText, (Function<String, LiveData<PagedList<TableModel>>>) input -> {
                            if (input.isEmpty()) {
                                return new LivePagedListBuilder(appDatabase.scienceDao().tableIqtisodiyot(), PAGE_SIZE).build();
                            } else {
                                return new LivePagedListBuilder(appDatabase.scienceDao().searchIqtisodiyot(input), PAGE_SIZE).build();
                            }
                        });
            case 5:
                return Transformations.switchMap(
                        searchText, (Function<String, LiveData<PagedList<TableModel>>>) input -> {
                            if (input.isEmpty()) {
                                return new LivePagedListBuilder(appDatabase.scienceDao().tableMatematika(), PAGE_SIZE).build();
                            } else {
                                return new LivePagedListBuilder(appDatabase.scienceDao().searchMatematika(input), PAGE_SIZE).build();
                            }
                        });
            case 6:
                return Transformations.switchMap(
                        searchText, (Function<String, LiveData<PagedList<TableModel>>>) input -> {
                            if (input.isEmpty()) {
                                return new LivePagedListBuilder(appDatabase.scienceDao().tablePsixologiya(), PAGE_SIZE).build();
                            } else {
                                return new LivePagedListBuilder(appDatabase.scienceDao().searchPsixologiya(input), PAGE_SIZE).build();
                            }
                        });
            case 7:
                return Transformations.switchMap(
                        searchText, (Function<String, LiveData<PagedList<TableModel>>>) input -> {
                            if (input.isEmpty()) {
                                return new LivePagedListBuilder(appDatabase.scienceDao().tableTarix(), PAGE_SIZE).build();
                            } else {
                                return new LivePagedListBuilder(appDatabase.scienceDao().searchTarix(input), PAGE_SIZE).build();
                            }
                        });

        }

        return null;
    }

    public void setFilter(String search) {
        searchText.setValue(search);
    }
}

