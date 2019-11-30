package sion.my.jinxiu;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import sion.my.jinxiu.bean.AddComment;
import sion.my.jinxiu.bean.AddReply;
import sion.my.jinxiu.bean.Allwords;
import sion.my.jinxiu.bean.InsertWordUserdata;
import sion.my.jinxiu.bean.JinsanTransation;
import sion.my.jinxiu.bean.JinsanTransationcn;
import sion.my.jinxiu.bean.LoginBean;
import sion.my.jinxiu.bean.MaxNumber;
import sion.my.jinxiu.bean.SelectUserBean;
import sion.my.jinxiu.bean.SelectUserWord;
import sion.my.jinxiu.bean.SelectVideo;
import sion.my.jinxiu.bean.SelectWordSentence;
import sion.my.jinxiu.bean.SendVideo;
import sion.my.jinxiu.bean.SpeakEnglish;
import sion.my.jinxiu.bean.UpdataFile;
import sion.my.jinxiu.bean.VerificationCodeBean;
import sion.my.jinxiu.bean.WordSpecificLearn;

/**
 * 作者： 梁浩文, 日期： 2019/9/24.
 * 让代码更加美观
 */
public interface JinxiuApi {
    final String serverConfig = "http://192.168.0.2:8080/Jinxiu/";
    final String alicloudapi = "http://dingxin.market.alicloudapi.com/dx/";
    final String jinsan = "http://www.iciba.com/";

    /**
     * @param map {key} {Jxphone,Jxpassword}
     * @return
     */
    @POST("Person/selectUser")
    @FormUrlEncoded
    Call<SelectUserBean> SelectUserBean(@FieldMap Map<String, String> map);


    /**
     * @param map {key}{Jxphone} 查找用户是否存在
     * @return
     */
    @POST("Person/selectPhone")
    @FormUrlEncoded
    Call<SelectUserBean> SelectPhone(@FieldMap Map<String, String> map);


    /**
     * @param map {验证码}
     * @return
     */
    @POST("sendSms")
    @FormUrlEncoded
    @Headers({"Authorization:APPCODE 779184732c054661a0f73611b7aafef4"})
    Call<VerificationCodeBean> RequestSendVerificationCode(@FieldMap Map<String, String> map);

    /**
     * @param map {key}{Jxphone，Jxpassword}
     * @return
     */
    @POST("Person/addUser")
    @FormUrlEncoded
    Call<LoginBean> AddUser(@FieldMap Map<String, String> map);

    /**
     * 参数 Jxphone
     * 查找用户的学习记录
     *
     * @param map
     * @return
     */
    @POST("Learn/SelectUserWord")
    @FormUrlEncoded
    Call<SelectUserWord> SelectWordUserdata(@FieldMap Map<String, String> map);


    /**
     * 查询第几关的单词
     *
     * @param map
     * @return
     */
    @POST("Learn/SelectNumberWords")
    @FormUrlEncoded
    Call<WordSpecificLearn> SelectWordSpecific(@FieldMap Map<String, Object> map);

    /**
     * 查询最多关数
     *
     * @return
     */
    @POST("Learn/SelectMaxNumber")
    @FormUrlEncoded
    Call<MaxNumber> SelectMaxNumber(@FieldMap Map<String, String> map);

    @GET("index.php?a=getWordMean&c=search")
    Call<JinsanTransation> selectTransation(@Query("word") String word);

    @GET("index.php?a=getWordMean&c=search")
    Call<JinsanTransationcn> selectTransation_cn(@Query("word") String word);

    @POST("Manager/selectallword")
    Call<Allwords> selectAllwords();

    //管理员权限
    @POST("Manager/insertsentence")
    @FormUrlEncoded
    Call<Void> insertSentence(@FieldMap Map<String, String> map);


    @POST("Learn/SelectWordSentence")
    @FormUrlEncoded
    Call<SelectWordSentence> selectSentence(@FieldMap Map<String, String> map);

    @POST("Learn/InsertwordUserdata")
    @FormUrlEncoded
    Call<InsertWordUserdata> insertWordUserdata(@FieldMap Map<String, String> map);


    @POST("upload/file")
    @Multipart
    Call<UpdataFile> UPDATA_FILE_CALL(@Part("phone") String phone, @Part("position") Integer position, @Part MultipartBody.Part file);

    //语音识别
    @POST("Learn/SpeakEnglish")
    @Multipart
    Call<SpeakEnglish> SelectSpeakEnglish(@Part MultipartBody.Part file);

    //进修短视频
    @POST("Video/selectVideo") //{phone nowTime }
    @FormUrlEncoded
    Call<SelectVideo> SelectVideo(@FieldMap Map<String, String> map);

    //发布父评论
    @POST("Video/addComment") //{phone nowTime }
    @FormUrlEncoded
    Call<AddComment> InsertComment(@FieldMap Map<String, String> map);


    //更新评论
    @POST("Video/loadComment") //{phone nowTime }
    @FormUrlEncoded
    Call<SelectVideo> LoadComment(@FieldMap Map<String, Integer> map);
    //  发布子评论
    @POST("Video/addReply")
    @FormUrlEncoded
    Call<AddReply> InsertReply(@FieldMap Map<String, String> map);
    //  點贊 /取消點贊
    @POST("Video/addStar")
    @FormUrlEncoded
    Call<AddReply> AddStar(@FieldMap Map<String, Object> map);
    /*发布视频*/

    @POST("upload/fileVideo")
    @Multipart
    Call<SendVideo> SendVideo(@Part List<MultipartBody.Part> files);

}
