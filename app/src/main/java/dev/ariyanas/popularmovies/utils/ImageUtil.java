package dev.ariyanas.popularmovies.utils;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageUtil {
    final static String BASE_IMAGE_PATH = "https://image.tmdb.org/t/p/w220_and_h330_face";

    public static void loadImage(ImageView imgView, String imgPath) {
        Picasso.get().load(BASE_IMAGE_PATH + imgPath)
                .fit().centerCrop()
                .into(imgView);
    }
}
