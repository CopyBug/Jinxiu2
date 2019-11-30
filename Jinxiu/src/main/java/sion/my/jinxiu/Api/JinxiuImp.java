package sion.my.jinxiu.Api;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sion.my.jinxiu.JinxiuApi;
import sion.my.jinxiu.bean.Allwords;
import sion.my.jinxiu.bean.InsertWordUserdata;
import sion.my.jinxiu.bean.JinsanTransation;
import sion.my.jinxiu.bean.JinsanTransationcn;
import sion.my.jinxiu.bean.LoginBean;
import sion.my.jinxiu.bean.MaxNumber;
import sion.my.jinxiu.bean.SelectUserBean;
import sion.my.jinxiu.bean.SelectUserWord;
import sion.my.jinxiu.bean.SelectWordSentence;
import sion.my.jinxiu.bean.SpeakEnglish;
import sion.my.jinxiu.bean.UpdataFile;
import sion.my.jinxiu.bean.VerificationCodeBean;
import sion.my.jinxiu.bean.WordSentence;
import sion.my.jinxiu.bean.WordSpecificLearn;
import sion.my.jinxiu.listning.JinxiuListning;
import sion.my.jinxiu.until.NetRequest;

/**
 * 作者： 梁浩文, 日期： 2019/9/24.
 * 让代码更加美观
 */
public class JinxiuImp {

    /**
     * 查找用户名{登录}
     *
     * @param Jxphone
     * @param Jxpassword
     * @param jinxiuListning
     */
    public static void selectUser(String Jxphone, String Jxpassword, final JinxiuListning<SelectUserBean> jinxiuListning) {
        Map<String, String> selectUserMap = new HashMap<>();
        selectUserMap.put("Jxphone", Jxphone);
        selectUserMap.put("Jxpassword", Jxpassword);
        JinxiuApi apiMethod = NetRequest.getApiMethod(NetRequest.getRetrofit(JinxiuApi.serverConfig), JinxiuApi.class);
        apiMethod.SelectUserBean(selectUserMap).enqueue(new Callback<SelectUserBean>() {
            @Override
            public void onResponse(Call<SelectUserBean> call, Response<SelectUserBean> response) {
                if (response.code() == 200) {
                    SelectUserBean userBean = response.body();
                    if (userBean != null) {
                        jinxiuListning.SuccessRequest(userBean);
                    }
                } else {
                    jinxiuListning.OtherError(response.code() + "");
                }
            }

            @Override
            public void onFailure(Call<SelectUserBean> call, Throwable t) {
                jinxiuListning.FailRequest(t);
            }
        });
    }

    /**
     * 验证码请求
     *
     * @param Jxphone
     * @param jinxiuListning
     */
    public static void RequestSendVerificationCode(String Jxphone, final JinxiuListning<Integer> jinxiuListning) {
        final int Code = new Random().nextInt(8999) + 1000;
        final String tpl_id = "TP1711063";
        final String param = "code:" + Code;
        Map<String, String> map = new HashMap<>();
        map.put("mobile", Jxphone);
        map.put("tpl_id", tpl_id);
        map.put("param", param);
        JinxiuApi apiMethod = NetRequest.getApiMethod(NetRequest.getRetrofit(JinxiuApi.alicloudapi), JinxiuApi.class);
        apiMethod.RequestSendVerificationCode(map).enqueue(new Callback<VerificationCodeBean>() {
            @Override
            public void onResponse(Call<VerificationCodeBean> call, Response<VerificationCodeBean> response) {
                if (response.code() == 200) {
                    jinxiuListning.SuccessRequest(Code);
                } else {
                    jinxiuListning.OtherError("服务器未响应");
                }
            }

            @Override
            public void onFailure(Call<VerificationCodeBean> call, Throwable t) {
                jinxiuListning.FailRequest(t);
            }
        });
    }

    /**
     * 查找用户名{验证用户是否存在}
     *
     * @param Jxphone
     * @param jinxiuListning
     */
    public static void selectUser(String Jxphone, final JinxiuListning<SelectUserBean> jinxiuListning) {
        Map<String, String> selectUserMap = new HashMap<>();
        selectUserMap.put("Jxphone", Jxphone);
        JinxiuApi apiMethod = NetRequest.getApiMethod(NetRequest.getRetrofit(JinxiuApi.serverConfig), JinxiuApi.class);
        apiMethod.SelectPhone(selectUserMap).enqueue(new Callback<SelectUserBean>() {
            @Override
            public void onResponse(Call<SelectUserBean> call, Response<SelectUserBean> response) {
                if (response.code() == 200) {
                    SelectUserBean userBean = response.body();
                    if (userBean != null) {
                        jinxiuListning.SuccessRequest(userBean);
                    }
                } else {
                    jinxiuListning.OtherError(response.code() + "");
                }
            }

            @Override
            public void onFailure(Call<SelectUserBean> call, Throwable t) {
                jinxiuListning.FailRequest(t);
            }
        });
    }

    /**
     * 添加用户
     *
     * @param Jxphone
     * @param Jxpassword
     * @param jinxiuListning
     */
    public static void addUser(String Jxphone, String Jxpassword, final JinxiuListning<LoginBean> jinxiuListning) {
        Map<String, String> addUserMap = new HashMap<>();
        addUserMap.put("phone", Jxphone);
        addUserMap.put("password", Jxpassword);


        JinxiuApi apiMethod = NetRequest.getApiMethod(NetRequest.getRetrofit(JinxiuApi.serverConfig), JinxiuApi.class);
        apiMethod.AddUser(addUserMap).enqueue(new Callback<LoginBean>() {
            @Override
            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
                if (response.code() == 200) {
                    if (response.body() != null) {
                        jinxiuListning.SuccessRequest(response.body());
                    } else {
                        jinxiuListning.OtherError("服务器异常");
                    }
                } else {
                    jinxiuListning.OtherError("服务器异常");
                }
            }

            @Override
            public void onFailure(Call<LoginBean> call, Throwable t) {
                jinxiuListning.FailRequest(t);
            }
        });
    }


    /**
     * 获取用户人的背单词记录
     *
     * @param Jxphone
     * @param jinxiuListning
     */
    public static void selectWordUserdata(String Jxphone, final JinxiuListning<SelectUserWord> jinxiuListning) {
        Map<String, String> addUserMap = new HashMap<>();
        addUserMap.put("Jxphone", Jxphone);
        JinxiuApi apiMethod = NetRequest.getApiMethod(NetRequest.getRetrofit(JinxiuApi.serverConfig), JinxiuApi.class);
        apiMethod.SelectWordUserdata(addUserMap).enqueue(new Callback<SelectUserWord>() {
            @Override
            public void onResponse(Call<SelectUserWord> call, Response<SelectUserWord> response) {
                if (response.code() == 200) {
                    if (response.body() != null) {
                        jinxiuListning.SuccessRequest(response.body());
                    } else {
                        jinxiuListning.OtherError("服务器异常");
                    }
                } else {
                    jinxiuListning.OtherError("服务器异常");
                }
            }

            @Override
            public void onFailure(Call<SelectUserWord> call, Throwable t) {
                jinxiuListning.FailRequest(t);
            }
        });
    }

    /**
     * 获取第几关的单词
     *
     * @param Jxphone
     * @param number
     * @param jinxiuListning
     */
    public static void selectnumber_Learn(String Jxphone, Integer number, final JinxiuListning<WordSpecificLearn> jinxiuListning) {
        Map<String, Object> addUserMap = new HashMap<>();
        addUserMap.put("Jxphone", Jxphone);
        addUserMap.put("NumberWord", number);
        JinxiuApi apiMethod = NetRequest.getApiMethod(NetRequest.getRetrofit(JinxiuApi.serverConfig), JinxiuApi.class);
        apiMethod.SelectWordSpecific(addUserMap).enqueue(new Callback<WordSpecificLearn>() {
            @Override
            public void onResponse(Call<WordSpecificLearn> call, Response<WordSpecificLearn> response) {
                if (response.code() == 200) {
                    WordSpecificLearn body = response.body();
                    if (body != null) {
                        jinxiuListning.SuccessRequest(body);
                    } else {
                        jinxiuListning.FailRequest(new Throwable("服务器无响应"));
                    }
                } else {
                    jinxiuListning.FailRequest(new Throwable("服务器无响应"));
                }
            }

            @Override
            public void onFailure(Call<WordSpecificLearn> call, Throwable t) {
                jinxiuListning.FailRequest(t);
            }
        });


    }


    /**
     * 查询一共多少关
     *
     * @param Jxphone
     * @param jinxiuListning
     */
    public static void selectMaxNumber(String Jxphone, final JinxiuListning<MaxNumber> jinxiuListning) {
        Map<String, String> addUserMap = new HashMap<>();
        addUserMap.put("Jxphone", Jxphone);
        JinxiuApi apiMethod = NetRequest.getApiMethod(NetRequest.getRetrofit(JinxiuApi.serverConfig), JinxiuApi.class);
        apiMethod.SelectMaxNumber(addUserMap).enqueue(new Callback<MaxNumber>() {
            @Override
            public void onResponse(Call<MaxNumber> call, Response<MaxNumber> response) {
                if (response.code() == 200) {
                    jinxiuListning.SuccessRequest(response.body());
                } else {
                    jinxiuListning.FailRequest(new Throwable("服务器无响应"));
                }
            }

            @Override
            public void onFailure(Call<MaxNumber> call, Throwable t) {
                jinxiuListning.FailRequest(t);
            }
        });
    }

    //    获取金山翻译API
    public static void selectJinsanTransation(String word,boolean iscn, final JinxiuListning jinsanTransationJinxiuListning) {
        if(iscn){
            JinxiuApi apiMethod = NetRequest.getApiMethod(NetRequest.getRetrofit(JinxiuApi.jinsan), JinxiuApi.class);
            // http://www.iciba.com/index.php?a=getWordMean&c=search&word=help
            Call<JinsanTransationcn> jinsanTransationcnCall = apiMethod.selectTransation_cn(word);
            try {
                Response<JinsanTransationcn> execute = jinsanTransationcnCall.execute();
                if (execute.code() == 200) {
                    if (execute.body() != null) {
                        jinsanTransationJinxiuListning.SuccessRequest(execute.body());
                    }else{
                        jinsanTransationJinxiuListning.OtherError("找不到内容");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                jinsanTransationJinxiuListning.OtherError(e.getMessage());
            }
        }else{
            JinxiuApi apiMethod = NetRequest.getApiMethod(NetRequest.getRetrofit(JinxiuApi.jinsan), JinxiuApi.class);
            // http://www.iciba.com/index.php?a=getWordMean&c=search&word=help
            Call<JinsanTransation> jinsanTransationCall = apiMethod.selectTransation(word);
            try {
                Response<JinsanTransation> execute = jinsanTransationCall.execute();
                if (execute.code() == 200) {
                    if (execute.body() != null) {
                        jinsanTransationJinxiuListning.SuccessRequest(execute.body());
                    }else{
                        jinsanTransationJinxiuListning.OtherError("找不到内容");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                jinsanTransationJinxiuListning.OtherError(e.getMessage());
            }
        }



    }

    //获取所有的单词
    public static void selelctAllword(final JinxiuListning<Allwords> listning) {
        JinxiuApi apiMethod = NetRequest.getApiMethod(NetRequest.getRetrofit(JinxiuApi.serverConfig), JinxiuApi.class);
        try {
            Response<Allwords> execute = apiMethod.selectAllwords().execute();
            if (execute.code() == 200) {
                if (execute.body() != null) {
                    listning.SuccessRequest(execute.body());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //插入单词列句
    public static void insertSentece(WordSentence wordSentence) {
        JinxiuApi apiMethod = NetRequest.getApiMethod(NetRequest.getRetrofit(JinxiuApi.serverConfig), JinxiuApi.class);
        Map<String, String> map = new HashMap<>();
        map.put("word", wordSentence.getWord());
        map.put("network_cn", wordSentence.getNetwork_cn());
        map.put("number_en", wordSentence.getNetwork_en());
        map.put("tts_mp3", wordSentence.getTts_mp3());
        try {
            apiMethod.insertSentence(map).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //查询单词的Sentence
    public static void SelectWordSentence(String phone, String word, final JinxiuListning<SelectWordSentence> wordSentenceJinxiuListning) {
        JinxiuApi apiMethod = NetRequest.getApiMethod(NetRequest.getRetrofit(JinxiuApi.serverConfig), JinxiuApi.class);
        Map<String, String> map = new HashMap<>();
        map.put("phone", phone);
        map.put("word", word);
        apiMethod.selectSentence(map).enqueue(new Callback<SelectWordSentence>() {
            @Override
            public void onResponse(Call<SelectWordSentence> call, Response<SelectWordSentence> response) {
                if (response.code() == 200) {
                    if (response.body() != null) {
                        wordSentenceJinxiuListning.SuccessRequest(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<SelectWordSentence> call, Throwable t) {
                wordSentenceJinxiuListning.FailRequest(t);
            }
        });

    }

    //修改单词状态[背诵单词]
    public static void InsertWordUserdata(String phone, String word, String wordcode, final JinxiuListning<Boolean> listning) {
        Map<String, String> map = new HashMap<>();
        map.put("phone", phone);
        map.put("word", word);
        map.put("wordcode", wordcode);
        JinxiuApi apiMethod = NetRequest.getApiMethod(NetRequest.getRetrofit(JinxiuApi.serverConfig), JinxiuApi.class);
        apiMethod.insertWordUserdata(map).enqueue(new Callback<InsertWordUserdata>() {
            @Override
            public void onResponse(Call<InsertWordUserdata> call, Response<InsertWordUserdata> response) {
                if (response.code() == 200) {
                    if (response.body() != null) {
                        listning.SuccessRequest(response.body().isBean());
                    }
                }
            }

            @Override
            public void onFailure(Call<InsertWordUserdata> call, Throwable t) {
                listning.FailRequest(t);
            }
        });
    }

    /**
     * 上传图片
     *
     * @param phone
     * @param position
     * @param file
     */
    public static void UpdataFile(String phone, Integer position, File file, final JinxiuListning<UpdataFile> jinxiuListning) {
        JinxiuApi apiMethod = NetRequest.getApiMethod(NetRequest.getRetrofit(JinxiuApi.serverConfig), JinxiuApi.class);

        final RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(), requestFile);
        apiMethod.UPDATA_FILE_CALL(phone,position,body).enqueue(new Callback<UpdataFile>() {
            @Override
            public void onResponse(Call<UpdataFile> call, Response<UpdataFile> response) {
                if (response.code() == 200) {
                    if (response.body() != null) {
                        if ("上传成功".equals(response.body().getResultBean().getBean())) {
                            jinxiuListning.SuccessRequest(response.body());
                        }

                    }
                }
            }

            @Override
            public void onFailure(Call<UpdataFile> call, Throwable t) {
                jinxiuListning.FailRequest(t);
            }
        });
    }
public static void speechRecognitionInquire(File file, final JinxiuListning<SpeakEnglish> listning){
        if(file!=null){
            JinxiuApi apiMethod = NetRequest.getApiMethod(NetRequest.getRetrofit(JinxiuApi.serverConfig), JinxiuApi.class);
             final RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(), requestFile);
            apiMethod.SelectSpeakEnglish(body).enqueue(new Callback<SpeakEnglish>() {
                @Override
                public void onResponse(Call<SpeakEnglish> call, Response<SpeakEnglish> response) {

                        if(response.code()==200){
                            if(response.body()!=null){
                                if(response.body().getCode()==200){
                                    listning.SuccessRequest(response.body());
                                }else{
                                    listning.OtherError("无法识别");
                                }
                            }
                        }

                }

                @Override
                public void onFailure(Call<SpeakEnglish> call, Throwable t) {
                    listning.OtherError(t.getMessage());
                }
            });
        }
}
}
