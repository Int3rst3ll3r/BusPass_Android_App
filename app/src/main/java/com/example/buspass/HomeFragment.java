package com.example.buspass;

import android.content.ComponentCallbacks2;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tabpackage.Timetable;

public class HomeFragment extends Fragment implements View.OnClickListener, ComponentCallbacks2 {
    private CardView Card_passRate,cardrenewal,cardepass,cardtimetable,cardwallet;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);

    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Card_passRate = view.findViewById(R.id.Card_passRate);

        cardrenewal = view.findViewById(R.id.cardrenewal);

        cardepass = view.findViewById(R.id.cardpass);

        cardtimetable = view.findViewById(R.id.cardtt);

        cardwallet = view.findViewById(R.id.cardwallet);

        Card_passRate.setOnClickListener(this);
        cardrenewal.setOnClickListener(this);
        cardepass.setOnClickListener(this);
        cardtimetable.setOnClickListener(this);
        cardwallet.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.Card_passRate:
                Intent intent = new Intent(getActivity(),PassRates_Activity.class);
                startActivity(intent);
                break;

            case R.id.cardrenewal:
                Intent intent1 = new Intent(getActivity(),Renewal.class);
                startActivity(intent1);
                break;

            case R.id.cardpass:
                Intent intent2 = new Intent(getActivity(),applynow.class);
                startActivity(intent2);
                break;

            case R.id.cardtt:
                Intent intent3 = new Intent(getActivity(), Timetable.class);
                startActivity(intent3);
                break;

            case R.id.cardwallet:
                Intent intent4 = new Intent(getActivity(),Wallet.class);
                startActivity(intent4);
                break;

            default:
                break;

        }

    }

    @Override
    public void onTrimMemory(int level) {
        // Determine which lifecycle or system event was raised.
        switch (level) {

            case ComponentCallbacks2.TRIM_MEMORY_UI_HIDDEN:

                /*
                   Release any UI objects that currently hold memory.

                   The user interface has moved to the background.
                */

                break;

            case ComponentCallbacks2.TRIM_MEMORY_RUNNING_MODERATE:
            case ComponentCallbacks2.TRIM_MEMORY_RUNNING_LOW:
            case ComponentCallbacks2.TRIM_MEMORY_RUNNING_CRITICAL:

                /*
                   Release any memory that your app doesn't need to run.

                   The device is running low on memory while the app is running.
                   The event raised indicates the severity of the memory-related event.
                   If the event is TRIM_MEMORY_RUNNING_CRITICAL, then the system will
                   begin killing background processes.
                */

                break;

            case ComponentCallbacks2.TRIM_MEMORY_BACKGROUND:
            case ComponentCallbacks2.TRIM_MEMORY_MODERATE:
            case ComponentCallbacks2.TRIM_MEMORY_COMPLETE:

                /*
                   Release as much memory as the process can.

                   The app is on the LRU list and the system is running low on memory.
                   The event raised indicates where the app sits within the LRU list.
                   If the event is TRIM_MEMORY_COMPLETE, the process will be one of
                   the first to be terminated.
                */

                break;

            default:
                /*
                  Release any non-critical data structures.

                  The app received an unrecognized memory level value
                  from the system. Treat this as a generic low-memory message.
                */
                break;
        }
    }
}


