package ca.opus.www.opus

import android.content.Intent
import android.media.SoundPool
import android.os.Bundle
import android.provider.AlarmClock
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_create_song.*
import kotlinx.android.synthetic.main.activity_songlist.*
import kotlinx.android.synthetic.main.activity_tracklist.*

/**
 * Created by Rohit on 2017-11-18.
 */
class TrackViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_tracklist)

//        var intent = this.getIntent();
//        var bundle = intent.getExtras();
//
//        var song: SongRecording = bundle!!.getSerializable("song") as SongRecording;
//
//        songs.add(song);
//        songNames.add(song.name);
//
//        // set list view with song names
//        var listView = findViewById<ListView>(R.id.song_list_forms);
//
//        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, songNames);
//
//        listView.adapter = adapter;

//        song_list_forms.setOnItemClickListener({
//
//
//        })

//        newInstrumentFab.setOnClickListener({
//            //take user to instrument screen
//            val intent = Intent(this, InstrumentSelect::class.java);
//            var message = "Test";
//            intent.putExtra(AlarmClock.EXTRA_MESSAGE, message);
//            startActivity(intent);
//        })
//
//        trackToggleButton.setOnClickListener(){
//
//        }
    }

    override fun onStart() {
        super.onStart()

        setContentView(R.layout.activity_tracklist)
        //val context = applicationContext
        //val text = (application as Test).songs.size.toString()
        //val duration = Toast.LENGTH_SHORT
        //val toast = Toast.makeText(context, text, duration)
        //toast.show()
        var intent = this.getIntent();
        var bundle = intent.getExtras();

        var song: SongRecording = bundle!!.getSerializable("song") as SongRecording;

        //(application as Test).songs.add(song);
        //(application as Test).songNames.add(song.name);

        (application as Test).song = song;

        // set list view with song names
//        var listView = song_list_forms
//
//        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, );
//
//        listView.adapter = adapter;
//        adapter.notifyDataSetChanged();

        newInstrumentFab.setOnClickListener({
            //take user to instrument screen
            val intent = Intent(this, InstrumentSelect::class.java);
            var message = "Test";
            intent.putExtra(AlarmClock.EXTRA_MESSAGE, message);
            startActivity(intent);
        })

        trackToggleButton.setOnClickListener() {
            var pool = SoundPool.Builder().setMaxStreams(5).build();
            var hihat_sound = pool.load(this, R.raw.hihat, 1);
            var kick_sound = pool.load(this, R.raw.kick, 1);
            var openhat_sound = pool.load(this, R.raw.openhat, 1);
            var ride_sound = pool.load(this, R.raw.ride, 1);
            var crash_sound = pool.load(this, R.raw.crash, 1);
            var snare_sound = pool.load(this, R.raw.snare, 1);
            var tom_sound = pool.load(this, R.raw.tom, 1);
            var a_key = pool.load(this, R.raw.piano_a, 1);
            var b_key = pool.load(this, R.raw.piano_b, 1);
            var c_key = pool.load(this, R.raw.piano_c, 1);
            var d_key = pool.load(this, R.raw.piano_d, 1);
            var e_key = pool.load(this, R.raw.piano_e, 1);
            var f_key = pool.load(this, R.raw.piano_f, 1);
            var g_key = pool.load(this, R.raw.piano_g, 1);
            val context = applicationContext

            val duration = Toast.LENGTH_SHORT

            val startTimer = System.currentTimeMillis()
            var index = 0

            while (index < (application as Test).song.times.size) {
                if ((System.currentTimeMillis() - startTimer) >= (application as Test).song.times[index]) {
                    for(item in (application as Test).song.records[index]) {
                        pool.play(item, 1.toFloat(), 1.toFloat(), 0, 0, 1.toFloat())
                    }
                    index += 1;
                }
            }
        }
    }
}

