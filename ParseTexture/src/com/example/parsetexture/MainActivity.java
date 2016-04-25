package com.example.parsetexture;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    private List<ImageInfo> list;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            InputStream is = getAssets().open("flappbrid_texture.xml");
            try {
                list = new ParseTexture().parse(is);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        for(ImageInfo info : list){
            Log.i("DYL", info.toString());
        }
        
        try {
            new ParseTexture().serialize(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
