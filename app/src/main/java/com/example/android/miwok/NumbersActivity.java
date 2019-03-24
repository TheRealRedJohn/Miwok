/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // ArrayList of numbers
        ArrayList<Word> words = new ArrayList<>();

        words.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("two", "lutti", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("three", "lutti", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("four", "lutti", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("five", "lutti", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("six", "lutti", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("seven", "lutti", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("eight", "lutti", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("nine", "lutti", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("ten", "lutti", R.drawable.number_ten, R.raw.number_ten));

        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_numbers);

        final ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = (Word) listView.getItemAtPosition(position);
                mediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioResourceId());
                mediaPlayer.start();
            }
        });

    }
}
