package sg.edu.rp.c346.id22036150.demoweather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class WeatherAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Weather> weatherList;
    public WeatherAdapter(@NonNull Context context, int resource, ArrayList<Weather> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        weatherList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tv = rowView.findViewById(R.id.tvArea);
        ImageView iv = rowView.findViewById(R.id.ivArea);

        Weather currentWeather = weatherList.get(position);

        tv.setText(currentWeather.toString());
        if (currentWeather.getForecast().contains("Partly Cloudy")) {
            Picasso.with(parent_context).load("https://www.nea.gov.sg/assets/images/icons/weather/PC.png").resize(100,100).into(iv);
        } else if (currentWeather.getForecast().contains("Fair")){
            Picasso.with(parent_context).load("https://www.nea.gov.sg/assets/images/icons/weather/FA.png").resize(100,100).into(iv);
        }
        return rowView;
    }
}
