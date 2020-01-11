/*
* the class of the WeatherActivity
* the last activity in the main user interface
* */

package com.example.recycling;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import tk.plogitech.darksky.forecast.APIKey;
import tk.plogitech.darksky.forecast.DarkSkyClient;
import tk.plogitech.darksky.forecast.ForecastException;
import tk.plogitech.darksky.forecast.ForecastRequest;
import tk.plogitech.darksky.forecast.ForecastRequestBuilder;
import tk.plogitech.darksky.forecast.GeoCoordinates;
import tk.plogitech.darksky.forecast.Latitude;
import tk.plogitech.darksky.forecast.Longitude;

public class WeatherActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor airTemp;
    private Sensor humidity;
    private Sensor pressure;
    private TextView textViewTemp;
    private TextView textViewHumidity;
    private TextView textViewPressure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        /*
        * create a sensor manager
        * we get the usable sensor from the sensor manager
        * */
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        airTemp = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        humidity = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        pressure = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);

        /*
        * get the reference of each user interface component
        * */
        textViewTemp = findViewById(R.id.temperature);
        textViewHumidity = findViewById(R.id.humidity);
        textViewPressure = findViewById(R.id.pressure);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        /*
        * update the weather
        * */
        updateWeather();
    }

    private void updateWeather() {
        /*
        * we use third-party library yo accees the dark sky api
        * */
        String apiKey = "ae6a76d9d2a422cd7efb48155608e3e5";
        ForecastRequest request = new ForecastRequestBuilder()
                .key(new APIKey(apiKey))
                .location(new GeoCoordinates(new Longitude(6.2603), new Latitude(53.3498)))
                .build();

        DarkSkyClient client = new DarkSkyClient();
        try {
            /*
            * we parse the data return from the dark sky api
            * */
            String forecast = client.forecastJsonString(request);
            JSONObject jsonObject = new JSONObject(forecast);
            JSONObject current = jsonObject.getJSONObject("currently");
            String temperature = current.getString("temperature");
            String humidity = current.getString("humidity");

            /*
            * update the user interface
            * */
            textViewTemp.setText(temperature);
            textViewHumidity.setText(humidity);
        } catch (ForecastException | JSONException e) {
            e.printStackTrace();
        }

    }

    /*
    * every time the sensor detects a change
    * it will call this function
    * */
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        switch (sensorEvent.sensor.getType()) {
//            case Sensor.TYPE_AMBIENT_TEMPERATURE:
//                textViewTemp.setText(sensorEvent.values[0] + " °C");
//                break;
//            case Sensor.TYPE_RELATIVE_HUMIDITY:
//                textViewHumidity.setText(sensorEvent.values[0] + " %");
//                break;
            case Sensor.TYPE_PRESSURE:
                textViewPressure.setText(sensorEvent.values[0] + " hPa");
                break;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    /*
    * re-register the sensor then the activity wake up
    * */
    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, airTemp, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, pressure, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, humidity, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}
