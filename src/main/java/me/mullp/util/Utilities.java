package me.mullp.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.mullp.adapters.UrlTypeAdapter;

import java.net.URL;

public final class Utilities {
  public static final Gson GSON = new GsonBuilder()
      .registerTypeAdapter(URL.class, new UrlTypeAdapter())
      .setDateFormat("EEE MMM dd yyyy HH:mm:ss 'GMT'Z (zzzz)")
      .serializeNulls()
      .create();
}
