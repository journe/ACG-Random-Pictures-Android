package tech.jour.acg

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.util.CoilUtils
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import okhttp3.OkHttpClient

/**
 * Created by journey on 2018/1/26.
 */

class MyApplication : Application(), ImageLoaderFactory {
  companion object {
    @JvmStatic
    lateinit var instance: MyApplication
  }

  override fun onCreate() {
    super.onCreate()
    instance = this
    Logger.addLogAdapter(object :
      AndroidLogAdapter(
        PrettyFormatStrategy.newBuilder().tag("ACG").build()
      ) {
      override fun isLoggable(priority: Int, tag: String?): Boolean {
        return BuildConfig.DEBUG
      }
    })
  }

  override fun newImageLoader(): ImageLoader {
    return ImageLoader.Builder(applicationContext)
      .crossfade(true)
      .okHttpClient {
        OkHttpClient.Builder()
          .cache(CoilUtils.createDefaultCache(applicationContext))
          .build()
      }
      .build()
  }
}

