package tech.jour.acg.ui

import androidx.lifecycle.ViewModel
import com.orhanobut.logger.Logger
import tech.jour.acg.net.RetrofitRequest
import tech.jour.acg.utils.launch

/**
 * Created by journey on 2021/6/8.
 */
class FirstViewModel : ViewModel() {

  fun getWallpaperMobile() {
    launch({
      val resp = RetrofitRequest.retrofit.getWallpaperMobileSuspend()
      Logger.d(resp.raw().header("location",""))
    })
  }
}