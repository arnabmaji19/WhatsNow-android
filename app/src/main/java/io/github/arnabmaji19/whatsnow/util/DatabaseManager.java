package io.github.arnabmaji19.whatsnow.util;

//Singleton class for managing database operations

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class DatabaseManager {

    private static DatabaseManager instance = new DatabaseManager();
    private final static String SCHEDULES_LIST_COLLECTION = "schedules_list";
    private final static String TAG = "DatabaseManager";

    private FirebaseFirestore database;

    private DatabaseManager() {
        database = FirebaseFirestore.getInstance();
    }

    public CollectionReference getSchedulesListCollection() {
        return database.collection(SCHEDULES_LIST_COLLECTION);
    }

    public Task<QuerySnapshot> getScheduleCollection(String scheduleId) {
        return database.collection(scheduleId)
                .get();
    }

    public static DatabaseManager getInstance() {
        return instance;
    }


}
