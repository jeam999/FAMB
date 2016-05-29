package com.artofjeam.famb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

/**
 * Created by jeam999 on 30.05.2016.
 */
public class Media extends Activity implements View.OnClickListener {
    Button Prev,Pause,Next;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.media_view);
        Prev=(Button)findViewById(R.id.Prev);
        Pause=(Button)findViewById(R.id.Pause);
        Next=(Button)findViewById(R.id.Next);

        Prev.setOnClickListener(this);
        Pause.setOnClickListener(this);
        Next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Prev:
                // ОК button
                intent = new Intent(Intent.ACTION_MEDIA_BUTTON);
                synchronized (this) {
                    intent.putExtra(Intent.EXTRA_KEY_EVENT, new KeyEvent(KeyEvent.ACTION_DOWN,KeyEvent.KEYCODE_MEDIA_PREVIOUS));
                    sendOrderedBroadcast(intent, null);
                    intent.putExtra(Intent.EXTRA_KEY_EVENT, new KeyEvent(KeyEvent.ACTION_UP,     KeyEvent.KEYCODE_MEDIA_PREVIOUS));
                    sendOrderedBroadcast(intent, null);
                }
                break;
            case R.id.Pause:
                // ОК button
                intent = new Intent(Intent.ACTION_MEDIA_BUTTON);
                synchronized (this) {
                    intent.putExtra(Intent.EXTRA_KEY_EVENT, new KeyEvent(KeyEvent.ACTION_DOWN,KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE));
                    sendOrderedBroadcast(intent, null);
                    intent.putExtra(Intent.EXTRA_KEY_EVENT, new KeyEvent(KeyEvent.ACTION_UP,     KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE));
                    sendOrderedBroadcast(intent, null);
                }
                break;
            case R.id.Next:
                // ОК button
                intent = new Intent(Intent.ACTION_MEDIA_BUTTON);
                synchronized (this) {
                    intent.putExtra(Intent.EXTRA_KEY_EVENT, new KeyEvent(KeyEvent.ACTION_DOWN,KeyEvent.KEYCODE_MEDIA_NEXT));
                    sendOrderedBroadcast(intent, null);
                    intent.putExtra(Intent.EXTRA_KEY_EVENT, new KeyEvent(KeyEvent.ACTION_UP,     KeyEvent.KEYCODE_MEDIA_NEXT));
                    sendOrderedBroadcast(intent, null);
                }
                break;
        }
    }
}
