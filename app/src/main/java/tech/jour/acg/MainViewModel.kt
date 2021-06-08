package tech.jour.acg

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.orhanobut.logger.Logger
import tech.jour.acg.net.RetrofitRequest
import tech.jour.acg.utils.launch

/**
 * Created by journey on 2021/6/8.
 */
class MainViewModel : ViewModel() {

  private val _pictureUrl = MutableLiveData("")
  val pictureUrl: LiveData<String> = _pictureUrl

  fun getWallpaperMobile() {
    launch({
      val resp = RetrofitRequest.retrofit.getWallpaperMobileSuspend()
      val url = resp.raw().header("location", "")
      _pictureUrl.postValue(url)
      Logger.d(url)
    })
  }

  fun getWallpaperPC() {
    launch({
      val resp = RetrofitRequest.retrofit.getWallpaperPCSuspend()
      val url = resp.raw().header("location", "")
      _pictureUrl.postValue(url)
      Logger.d(url)
    })
  }
}