/*
* This is the class for the local database
* In this activity, we will use the feature - local database
* the user can search the number of garbage have been recycled in the
* specified month
* */

package com.example.recycling;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.recycling.database.AppDatabase;
import com.example.recycling.database.Data;
import com.example.recycling.database.DataDao;
import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class RecycleStatActivity extends AppCompatActivity {
    private DownloadManager.Request request;
    private long downloadID;
    private AppDatabase database;
    private DataDao dao;
    private Spinner areas;
    private Spinner months;
    private TextView result;
    private Button searchButton;

    /*
    * When the download complete, this function will be called
    * */
    private BroadcastReceiver onDownloadComplete = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            long id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);

            if (downloadID == id) {
                searchButton.setEnabled(true);
                Toast.makeText(RecycleStatActivity.this, "Download Completed", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_stat);

        searchButton = findViewById(R.id.search_data);
        searchButton.setEnabled(false);

        /*
        * find the references to these component
        * */
        areas = findViewById(R.id.spinner_locations);
        months = findViewById(R.id.spinner_months);
        result = findViewById(R.id.search_result);

        /*
        * set a default selection for each Spinner
        * */
        areas.setSelection(0);
        months.setSelection(0);

        /*
        * set up the download object
        * */
        request = new DownloadManager.Request(Uri.parse("https://data.smartdublin.ie/dataset/0dca8dc6-8013-47a2-bf13-ab835b6c6c52/resource/a11f3323-f88f-4c2e-997d-44f2571eb17f/download/monthly-tonnage-report-mrf.csv"));
        /*
        * give a name to the downloaded file
        * */
        request.setTitle("data.csv");
        request.setDescription("Downloading database from server");

        /*
        * make the notification visible
        * */
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
        /*
        * save the downloaded data to somewhere in the device
        * */
        request.setDestinationUri(Uri.fromFile(new File(getExternalFilesDir(null), "data.csv")));
        /*
        * allow download data in any network
        * */
        request.setRequiresCharging(false);
        request.setAllowedOverMetered(true);
        request.setAllowedOverRoaming(true);

        /*
        * register a function when the download complete
        * */
        registerReceiver(onDownloadComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));

        /*
        * create the database
        * */
        database = Room
                .databaseBuilder(getApplicationContext(), AppDatabase.class, "stat")
                .allowMainThreadQueries()
                .build();

        /*
        * create the dao if the database
        * */
        dao = database.dataDao();
    }

    /*
    * the function the update the local database
    * */
    public void updateDatabase(View view) {
        /*
        * create a download manager
        * */
        DownloadManager manager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        downloadID = manager.enqueue(request);

        try {
            /*
            * read the download file
            * and then import it into the database
            * */
            File csvfile = getExternalFilesDir(null);
            CSVReader reader = null;
            if (csvfile != null) {
                reader = new CSVReader(new FileReader(csvfile.getAbsolutePath() + "/data.csv"));
            }

            /*
            * read each line from the file
            * create an entity in the table
            * */
            String[] nextLine;
            if (reader != null) {
                while ((nextLine = reader.readNext()) != null) {
                    Data data = new Data();
                    int len = nextLine.length;

                    if (nextLine[0].equals("Row Labels")) {
                        continue;
                    }

                    /*
                    * we check if the required fields are exists in the CSV file
                    * if not, we set a null value in the table
                    * */
                    data.setArea(nextLine[0]);

                    if (len > 1 && !nextLine[1].isEmpty())
                        data.setJan(Integer.parseInt(nextLine[1]));
                    else
                        data.setJan(0);

                    if (len > 2 && !nextLine[2].isEmpty())
                        data.setFeb(Integer.parseInt(nextLine[2]));
                    else
                        data.setFeb(0);

                    if (len > 3 && !nextLine[3].isEmpty())
                        data.setMar(Integer.parseInt(nextLine[3]));
                    else
                        data.setMar(0);

                    if (len > 4 && !nextLine[4].isEmpty())
                        data.setApr(Integer.parseInt(nextLine[4]));
                    else
                        data.setApr(0);

                    if (len > 5 && !nextLine[5].isEmpty())
                        data.setMay(Integer.parseInt(nextLine[5]));
                    else
                        data.setMay(0);

                    if (len > 6 && !nextLine[6].isEmpty())
                        data.setJun(Integer.parseInt(nextLine[6]));
                    else
                        data.setJun(0);

                    if (len > 7 && !nextLine[7].isEmpty())
                        data.setJul(Integer.parseInt(nextLine[7]));
                    else
                        data.setJul(0);

                    if (len > 8 && !nextLine[8].isEmpty())
                        data.setAug(Integer.parseInt(nextLine[8]));
                    else
                        data.setAug(0);

                    if (len > 9 && !nextLine[9].isEmpty())
                        data.setSep(Integer.parseInt(nextLine[9]));
                    else
                        data.setSep(0);

                    if (len > 10 && !nextLine[10].isEmpty())
                        data.setOct(Integer.parseInt(nextLine[10]));
                    else
                        data.setOct(0);

                    if (len > 11 && !nextLine[11].isEmpty())
                        data.setNov(Integer.parseInt(nextLine[11]));
                    else
                        data.setNov(0);

                    if (len > 12 && !nextLine[12].isEmpty())
                        data.setDec(Integer.parseInt(nextLine[12]));
                    else
                        data.setDec(0);

                    database.dataDao().insertData(data);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(onDownloadComplete);
    }

    /*
    * when the user search the data
    * this function is called
    * */
    public void searchData(View view) {
        /*
        * get the value of two Spinner
        * */
        String area = areas.getSelectedItem().toString();
        String month = months.getSelectedItem().toString();

        /*
        * get the result from local database
        * */
        List<Data> data = database.dataDao().findByMonthAndArea("%" + area + "%");

        switch (month) {
            case "Jan":
                result.setText(String.valueOf(data.get(0).getJan()));
                break;
            case "Feb":
                result.setText(String.valueOf(data.get(0).getFeb()));
                break;
            case "Mar":
                result.setText(String.valueOf(data.get(0).getMar()));
                break;
            case "Apr":
                result.setText(String.valueOf(data.get(0).getApr()));
                break;
            case "May":
                result.setText(String.valueOf(data.get(0).getMay()));
                break;
            case "Jun":
                result.setText(String.valueOf(data.get(0).getJun()));
                break;
            case "Jul":
                result.setText(String.valueOf(data.get(0).getJul()));
                break;
            case "Aug":
                result.setText(String.valueOf(data.get(0).getAug()));
                break;
            case "Sep":
                result.setText(String.valueOf(data.get(0).getSep()));
                break;
            case "Oct":
                result.setText(String.valueOf(data.get(0).getOct()));
                break;
            case "Nov":
                result.setText(String.valueOf(data.get(0).getNov()));
                break;
            case "Dec":
                result.setText(String.valueOf(data.get(0).getDec()));
                break;
        }
    }
}
