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

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;


public class MainActivity extends AppCompatActivity {
private  MediaPlayer mediaPlayer;
    private MediaPlayer.OnCompletionListener moncompletion = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }


    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.numbersactivity);

        // Create a list of words
        final ArrayList<Word> words = new ArrayList<>();
        words.add(new com.example.android.miwok.Word("one", "lutti", R.drawable.number_one,R.raw.number_one));
        words.add(new com.example.android.miwok.Word("two", "otiiko", R.drawable.number_two,R.raw.number_two));
        words.add(new com.example.android.miwok.Word("three", "tolookosu", R.drawable.number_three,R.raw.number_three));
        words.add(new com.example.android.miwok.Word("four", "oyyisa", R.drawable.number_four,R.raw.number_four));
        words.add(new com.example.android.miwok.Word("five", "massokka", R.drawable.number_five,R.raw.number_five));
        words.add(new com.example.android.miwok.Word("six", "temmokka", R.drawable.number_six,R.raw.number_six));
        words.add(new com.example.android.miwok.Word("seven", "kenekaku", R.drawable.number_seven,R.raw.number_seven));
        words.add(new com.example.android.miwok.Word("eight", "kawinta", R.drawable.number_eight,R.raw.number_eight));
        words.add(new com.example.android.miwok.Word("nine", "wo'e", R.drawable.number_nine,R.raw.number_nine));
        words.add(new com.example.android.miwok.Word("ten", "na’aacha", R.drawable.number_ten,R.raw.number_ten));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words);


        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        ListView listView = (ListView) findViewById(R.id.List);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                releaseMediaPlayer();
                Word wor = words.get(position);
                mediaPlayer = MediaPlayer.create(MainActivity.this,wor.getAudio_id());
                mediaPlayer.start();// no need to call prepare(); create() does that for you            }
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {


                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(MainActivity.this, "i'a done", Toast.LENGTH_SHORT).show();
                    }

                });
                mediaPlayer.setOnCompletionListener(moncompletion);

            }
            /**
             * Clean up the media player by releasing its resources.
             */


            /**
             * Clean up the media player by releasing its resources.
             */

            /**
             * Clean up the media player by releasing its resources.
             */

        });
    }

    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }
}
