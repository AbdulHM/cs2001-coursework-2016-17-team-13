package com.example.abdul.wishlistappv1.data;

import com.example.abdul.wishlistappv1.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by simonkent on 08/12/2016.
 */

public class DummyArrayBasedDataStore implements DataStore {

    int[] imageId = {R.drawable.picture1, R.drawable.picture2, R.drawable.picture3, R.drawable.picture4, R.drawable.picture5, R.drawable.picture6, R.drawable.picture7,R.drawable.picture8,R.drawable.picture9 };
    String[] ArtistDescription = {"Come see Britney Spears live ! with WhatILike tickets. Go to www.whatIlike.co.uk","Come see Drake live ! with WhatILike tickets. Go to www.whatIlike.co.uk ","Come see Hannah Montana live ! with WhatILike tickets. Go to www.whatIlike.co.uk ", "Come see JCole Live! With WhatILike tickets Go to www.whatilike.com","Come see John Legend Live! With WhatILike tickets  Go to www.whatilike.com",
            "Come see Justin Beiber  Live! Go to www.whatilike.com", "Come see Kanye West Live! Go to www.whatilike.com" ,"Come see Lana Del Rey live ! With WhatILike tickets" ,"Come see Maroon 5 Live! Go to www.whatilike.com"};

    private DummyArrayBasedDataStore() {
        assert imageId.length == ArtistDescription.length : "Invalid arrays specified";
    }

    private static DummyArrayBasedDataStore instance = null;

    public static DummyArrayBasedDataStore getInstance() {
        if (instance==null) {
            instance = new DummyArrayBasedDataStore();
        }
        return instance;
    }

    @Override
    public List<Music> getMusicRecommendations() {
        List<Music> returnArray = new ArrayList<Music>();

        for(int i=0;i<imageId.length;i++) {
            Music music = new Music(ArtistDescription[i], imageId[i]);
            returnArray.add(music);
        }

        return returnArray;
    }
}



