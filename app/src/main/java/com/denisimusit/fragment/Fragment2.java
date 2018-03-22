package com.denisimusit.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by denisimus on 22/03/18.
 */

public class Fragment2 extends Fragment{

    private TextView mInfoTextView;
    private ImageView mCatImageView;
    private String[] mCatDescriptionArray;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View rootView =
                inflater.inflate(R.layout.fragment2, container, false);
        mInfoTextView = (TextView) rootView.findViewById(R.id.textView);
        mCatImageView = (ImageView) rootView.findViewById(R.id.imageView);

        // загружаем массив из ресурсов
        mCatDescriptionArray = getResources().getStringArray(R.array.cats);

        return rootView;
    }

    //метод, который будет менять содержимое фрагмента в зависимости от индекса нажатой кнопки
    public void setDescription(int buttonIndex) {
        String catDescription = mCatDescriptionArray[buttonIndex];
        mInfoTextView.setText(catDescription);

        switch (buttonIndex) {
            case 1:
                mCatImageView.setImageResource(R.drawable.ic_attach_file_black_48dp);
                break;
            case 2:
                mCatImageView.setImageResource(R.drawable.ic_attach_money_black_48dp);
                break;
            case 3:
                mCatImageView.setImageResource(R.drawable.ic_border_all_black_48dp);
                break;

            default:
                break;
        }

    }
}
