package tech.jour.acg.net

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Streaming
import retrofit2.http.Url
import tech.jour.acg.utils.Constants

/**
 * Created by journey on 2017/12/29.
 */
interface RetrofitService {

  @Streaming
  @GET
  suspend fun getCaptchaSuspend(@Url url: String): ResponseBody

  @GET(Constants.BALANCE)
  fun getBalance(): Call<ResponseBody>

  @GET
  fun getTopicsByNode(@Url url: String): Call<ResponseBody>

  @GET
  suspend fun getTopicsByNodeSuspend(@Url url: String): ResponseBody

  // https://open.pixivic.net/wallpaper/pc/random?size=large&domain=https://i.pixiv.cat&webp=0&detail=1
  @GET(Constants.PC)
  suspend fun getWallpaperPCSuspend(
    @Query("size") size: String = "large",//可选（ original ｜ large ｜ medium ｜ squareMedium ），图片大小
    @Query("domain") domain: String = "https://i.pixiv.cat",//反向代理域名前缀，默认值是https://i.pixiv.cat
    @Query("webp") webp: Int = 1,//是否 webp 图片 url，仅在 size=large 时候有效
    @Query("detail") detail: Int = 1,//是否在重定向 url 中返回详细信息
  ): Response<ResponseBody>

  @GET(Constants.MOBILE)
  suspend fun getWallpaperMobileSuspend(
    @Query("size") size: String = "large",
    @Query("domain") domain: String = "https://i.pixiv.cat",
    @Query("webp") webp: Int = 1,
    @Query("detail") detail: Int = 1,
  ): Response<ResponseBody>

}