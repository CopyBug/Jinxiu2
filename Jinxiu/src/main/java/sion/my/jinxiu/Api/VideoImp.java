package sion.my.jinxiu.Api;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sion.my.jinxiu.JinxiuApi;
import sion.my.jinxiu.bean.AddComment;
import sion.my.jinxiu.bean.AddReply;
import sion.my.jinxiu.bean.ReplyInsertBean;
import sion.my.jinxiu.bean.SelectUserBean;
import sion.my.jinxiu.bean.SelectVideo;
import sion.my.jinxiu.bean.SendVideo;
import sion.my.jinxiu.bean.SendWordComment;
import sion.my.jinxiu.bean.UpdataFile;
import sion.my.jinxiu.bean.WordStars;
import sion.my.jinxiu.listning.Jinxiu2Listining;
import sion.my.jinxiu.listning.JinxiuListning;
import sion.my.jinxiu.until.NetRequest;

/**
 * 作者： 梁浩文, 日期： 2019/10/12.
 * 让代码更加美观
 */
public class VideoImp {
//    音视频查询
public static void selectVideo(String phone, String nowtime, final Jinxiu2Listining<SelectVideo> jinxiuListning) {
    Map<String, String> selectUserMap = new HashMap<>();
    selectUserMap.put("phone", phone);
    selectUserMap.put("nowTime", nowtime);
    JinxiuApi apiMethod = NetRequest.getApiMethod(NetRequest.getRetrofit(JinxiuApi.serverConfig), JinxiuApi.class);
    apiMethod.SelectVideo(selectUserMap).enqueue(new Callback<SelectVideo>() {
        @Override
        public void onResponse(Call<SelectVideo> call, Response<SelectVideo> response) {
            if(response.code()==200){
                if(response.body()!=null){
                    jinxiuListning.SuccessRequest(response.body());
                }else{
                    jinxiuListning.FailRequest("服务器放回数据失败");
                }
            }
        }

        @Override
        public void onFailure(Call<SelectVideo> call, Throwable t) {
            jinxiuListning.FailRequest(t.getMessage());
        }
    });
}
public static void insertComment(SendWordComment wordComment,final Jinxiu2Listining<String> addCommentJinxiu2Listining){
    Map<String, String> insertComment = new HashMap<>();
    insertComment.put("phone", wordComment.getmPhone());
    insertComment.put("from_phone", wordComment.getFromPhone());
    insertComment.put("content", wordComment.getContext());
    insertComment.put("source_id", wordComment.getSource());
    JinxiuApi apiMethod = NetRequest.getApiMethod(NetRequest.getRetrofit(JinxiuApi.serverConfig), JinxiuApi.class);
    apiMethod.InsertComment(insertComment).enqueue(new Callback<AddComment>() {
        @Override
        public void onResponse(Call<AddComment> call, Response<AddComment> response) {
            if(response.code()==200){
                if(response.body()!=null){
                    if(response.body().isBean()){
                        addCommentJinxiu2Listining.SuccessRequest("评论成功");
                    }else{
                        addCommentJinxiu2Listining.FailRequest("评论失败");
                    }
                }
            }
        }

        @Override
        public void onFailure(Call<AddComment> call, Throwable t) {
            addCommentJinxiu2Listining.FailRequest(t.getMessage());
        }
    });
}




    //    刷新该视频
    public static void updataVideo(Integer title,final Jinxiu2Listining<SelectVideo> jinxiuListning) {
        Map<String, Integer> selectUserMap = new HashMap<>();
        selectUserMap.put("title_id", title);

        JinxiuApi apiMethod = NetRequest.getApiMethod(NetRequest.getRetrofit(JinxiuApi.serverConfig), JinxiuApi.class);
        apiMethod.LoadComment(selectUserMap).enqueue(new Callback<SelectVideo>() {
            @Override
            public void onResponse(Call<SelectVideo> call, Response<SelectVideo> response) {
                if(response.code()==200){
                    if(response.body()!=null){
                        jinxiuListning.SuccessRequest(response.body());
                    }else{
                        jinxiuListning.FailRequest("服务器放回数据失败");
                    }
                }
            }

            @Override
            public void onFailure(Call<SelectVideo> call, Throwable t) {
                jinxiuListning.FailRequest(t.getMessage());
            }
        });
    }
    //添加子回复
    public static void insertReply(ReplyInsertBean bean, final Jinxiu2Listining<AddReply> replyJinxiu2Listining) {
        Map<String, String> addReplyInfo = new HashMap<>();
        addReplyInfo.put("phone",bean.getPhone());
        addReplyInfo.put("content",bean.getContent());
        addReplyInfo.put("reply_id",bean.getReply_id());
        addReplyInfo.put("comment_id",bean.getComment_id());
        addReplyInfo.put("from_uid",bean.getFrom_uid());
        JinxiuApi apiMethod = NetRequest.getApiMethod(NetRequest.getRetrofit(JinxiuApi.serverConfig), JinxiuApi.class);
        apiMethod.InsertReply(addReplyInfo).enqueue(new Callback<AddReply>() {
            @Override
            public void onResponse(Call<AddReply> call, Response<AddReply> response) {
                if(response.code()==200){
                    if(response.body()!=null){
                        if(response.body().isBean()){
                            replyJinxiu2Listining.SuccessRequest(response.body());
                        }else{
                            replyJinxiu2Listining.FailRequest("评论失败");

                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<AddReply> call, Throwable t) {
                replyJinxiu2Listining.FailRequest(t.getMessage());
            }
        });
    }
//    點贊

    //添加愛心
    public static void insertStar(WordStars wordStars, final Jinxiu2Listining<AddReply> replyJinxiu2Listining) {
        Map<String, Object> addStar = new HashMap<>();
        addStar.put("phone",wordStars.getPhone());
        addStar.put("title_id",wordStars.getTitle_id());
        addStar.put("to_id",wordStars.getTo_id());
        addStar.put("from_id",wordStars.getFrom_id());
        addStar.put("islike",wordStars.isIslike());
        JinxiuApi apiMethod = NetRequest.getApiMethod(NetRequest.getRetrofit(JinxiuApi.serverConfig), JinxiuApi.class);
        apiMethod.AddStar(addStar).enqueue(new Callback<AddReply>() {
            @Override
            public void onResponse(Call<AddReply> call, Response<AddReply> response) {
                if(response.code()==200){
                    if(response.body()!=null){
                        if(response.body().isBean()){
                            replyJinxiu2Listining.SuccessRequest(response.body());
                        }else{
                            replyJinxiu2Listining.FailRequest("慢點");

                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<AddReply> call, Throwable t) {
                replyJinxiu2Listining.FailRequest(t.getMessage());
            }
        });
    }
    /*发布视频*/
    public static void sendVideo(SelectVideo.BeanBean.WordWritingsBean writingsBean, File file,final Jinxiu2Listining<SendVideo> sendVideoJinxiu2Listining) {
        List<MultipartBody.Part> partList=new ArrayList<>();
        final RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        partList.add( MultipartBody.Part.createFormData("file", file.getName(), requestFile));
        partList.add(MultipartBody.Part.createFormData("phone",writingsBean.getPhone()));
        partList.add( MultipartBody.Part.createFormData("title",writingsBean.getTitle()));
        partList.add( MultipartBody.Part.createFormData("context",writingsBean.getContext()));
        partList.add(MultipartBody.Part.createFormData("yb",writingsBean.getYb()));
        partList.add(MultipartBody.Part.createFormData("position",writingsBean.getPosition()));


        JinxiuApi apiMethod = NetRequest.getApiMethod(NetRequest.getRetrofit(JinxiuApi.serverConfig), JinxiuApi.class);

        apiMethod.SendVideo(partList).enqueue(new Callback<SendVideo>() {
            @Override
            public void onResponse(Call<SendVideo> call, Response<SendVideo> response) {
                if (response.code() == 200) {
                    if (response.body() != null) {
                        if (response.body().getResultBean()!=null) {
                            if(response.body().getResultBean().isBean()){
                            sendVideoJinxiu2Listining.SuccessRequest(response.body());
                            }else{
                                sendVideoJinxiu2Listining.FailRequest("发布失败");
                            }
                        } else {
                            sendVideoJinxiu2Listining.FailRequest("发布失败");
                        }
                    } else {
                        sendVideoJinxiu2Listining.FailRequest("发布失败");
                    }
                }
            }

            @Override
            public void onFailure(Call<SendVideo> call, Throwable t) {
                sendVideoJinxiu2Listining.FailRequest(t.getMessage());
            }
        });
    }

}
