package com.denisimusit.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by denisimus on 22/03/18.
 */

public class Fragment1 extends Fragment implements View.OnClickListener {

    // метод для подключения разметки
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);


//        У метода используются три параметра.В первом параметре используется объект класса
//        LayoutInflater, который позволяет построить нужный макет, считывая информацию из указанного
//        XML -файла.Удалим строчку, которая возвращает результат и напишем свой вариант.
//        Остальные два параметра container, false используются в связке и указывают на
//        возможнось подключения фрагментов в активность через контейнер.Мы обойдёмся
//        без контейнеров, а создадим собственные блоки для фрагментов, поэтому у нас
//        используется значение false.


        View rootView =
                inflater.inflate(R.layout.fragment1, container, false);

        Button button1 = (Button) rootView.findViewById(R.id.button1);
        Button button2 = (Button) rootView.findViewById(R.id.button2);
        Button button3 = (Button) rootView.findViewById(R.id.button3);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

        return rootView;


    }

    @Override
    public void onClick(View view) {
        int buttonIndex = translateIdToIndex(view.getId());

        OnSelectedButtonListener listener = (OnSelectedButtonListener)  getActivity();
        listener.onButtonSelected(buttonIndex);

        // Временный код для получения индекса нажатой кнопки
        Toast.makeText(getActivity(), String.valueOf(buttonIndex),
                Toast.LENGTH_SHORT).show();
    }

    int translateIdToIndex(int id) {
        int index = -1;
        switch (id) {
            case R.id.button1:
                index = 1;
                break;
            case R.id.button2:
                index = 2;
                break;
            case R.id.button3:
                index = 3;
                break;
        }
        return index;
    }

    // интерфейс для передачи информацыии активности
    public interface OnSelectedButtonListener {
        void onButtonSelected(int buttonIndex);
    }
}
