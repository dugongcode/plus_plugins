package dev.fluttercommunity.plus.androidalarmmanager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class AlarmFlagManager {

  private static final String FLUTTER_SHARED_PREFERENCE_KEY = "FlutterSharedPreferences";
  private static final String ALARM_FLAG_KEY = "flutter.alarmFlagKey";

  static public void set(Context context, Intent intent) {
    int callbackId = intent.getIntExtra("id", -1);
    long alarmId = getActualIdFrom(callbackId);

    SharedPreferences prefs = context.getSharedPreferences(FLUTTER_SHARED_PREFERENCE_KEY, 0);
    prefs.edit().putLong(ALARM_FLAG_KEY, alarmId).apply();
  }

  /**
   * ?�람 객체??ID�?변?�한 ID�?반환?�다.
   *
   * ?�때 `Timer`??경우??ID가 0?��?�?반환값도 0???�어 문제가 ?�다.
   */
  static private long getActualIdFrom(long callbackId) {
    return (long) Math.floor(callbackId / 1.0);
  }

}
