package sion.my.jinxiu.bean;

import java.util.List;

/**
 * 作者： 梁浩文, 日期： 2019/10/12.
 * 让代码更加美观
 */
public class SelectVideo {


    /**
     * rephone : 13018600506
     * code : 200
     * bean : [{"wordWritings":{"id":8,"source":"http://lhw-base.oss-cn-beijing.aliyuncs.com/video/3f4e1dbc6264cac4a412573b1bd0b1a5.mp4","phone":"13018600506","title":"word","context":"sdhadad","ctime":"1570824310355","jxUser":{"rephone":null,"code":200,"bean":null,"id":79,"phone":"13018600506","username":"1301860****","password":"123456","wordcount":30,"position":"广东省-东莞市-沙田镇","imgbackground":"https://lhw-base.oss-cn-beijing.aliyuncs.com/images/default/backgroundimgag.jpg","imghead":"http://lhw-base.oss-cn-beijing.aliyuncs.com/images/2019/10/07/15704495809052307.png","allwordcount":null,"error":"Success"},"title_id":0,"wordStars":[{"id":9,"from_id":"0","phone":"13018600506","to_id":"0","title_id":0}]},"wordComments":[{"id":5,"source_id":"http://lhw-base.oss-cn-beijing.aliyuncs.com/video/3f4e1dbc6264cac4a412573b1bd0b1a5.mp4","content":"一樓","from_uid":"123131","ctime":"1570824310355","phone":"15627538274","jxUser":{"rephone":null,"code":200,"bean":null,"id":81,"phone":"15627538274","username":"1562753****","password":"123456","wordcount":30,"position":"广东省-东莞市-沙田镇","imgbackground":"https://lhw-base.oss-cn-beijing.aliyuncs.com/images/default/backgroundimgag.jpg","imghead":"https://lhw-base.oss-cn-beijing.aliyuncs.com/images/default/icon_user.png","allwordcount":null,"error":"Success"},"wordStars":[{"id":7,"from_id":"123131","phone":"13018600506","to_id":"0","title_id":0}],"replies":[{"id":4,"comment_id":"http://lhw-base.oss-cn-beijing.aliyuncs.com/video/3f4e1dbc6264cac4a412573b1bd0b1a5.mp4","reply_id":"0","content":"一樓(A)","from_uid":"123131","to_uid":"21323131","c_time":"1570824310355","phone":"13247519715","jxUser":{"rephone":null,"code":200,"bean":null,"id":80,"phone":"13247519715","username":"1324751****","password":"123456","wordcount":30,"position":"广东省-东莞市-沙田镇","imgbackground":"https://lhw-base.oss-cn-beijing.aliyuncs.com/images/default/backgroundimgag.jpg","imghead":"http://lhw-base.oss-cn-beijing.aliyuncs.com/images/2019/10/08/1570521399236322.jpg","allwordcount":null,"error":"Success"},"wordStars":[{"id":6,"from_id":"123131","phone":"13018600506","to_id":"21323131","title_id":0}]},{"id":5,"comment_id":"http://lhw-base.oss-cn-beijing.aliyuncs.com/video/3f4e1dbc6264cac4a412573b1bd0b1a5.mp4","reply_id":"21323131","content":"一樓(A)(A)","from_uid":"123131","to_uid":"213231354","c_time":"1570824310355","phone":"13247519715","jxUser":{"rephone":null,"code":200,"bean":null,"id":80,"phone":"13247519715","username":"1324751****","password":"123456","wordcount":30,"position":"广东省-东莞市-沙田镇","imgbackground":"https://lhw-base.oss-cn-beijing.aliyuncs.com/images/default/backgroundimgag.jpg","imghead":"http://lhw-base.oss-cn-beijing.aliyuncs.com/images/2019/10/08/1570521399236322.jpg","allwordcount":null,"error":"Success"},"wordStars":[{"id":8,"from_id":"123131","phone":"13018600506","to_id":"213231354","title_id":0}]}]}]}]
     * error : Success
     */

    private String rephone;
    private int code;
    private String error;
    private List<BeanBean> bean;

    public String getRephone() {
        return rephone;
    }

    public void setRephone(String rephone) {
        this.rephone = rephone;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<BeanBean> getBean() {
        return bean;
    }

    public void setBean(List<BeanBean> bean) {
        this.bean = bean;
    }

    public static class BeanBean {
        /**
         * wordWritings : {"id":8,"source":"http://lhw-base.oss-cn-beijing.aliyuncs.com/video/3f4e1dbc6264cac4a412573b1bd0b1a5.mp4","phone":"13018600506","title":"word","context":"sdhadad","ctime":"1570824310355","jxUser":{"rephone":null,"code":200,"bean":null,"id":79,"phone":"13018600506","username":"1301860****","password":"123456","wordcount":30,"position":"广东省-东莞市-沙田镇","imgbackground":"https://lhw-base.oss-cn-beijing.aliyuncs.com/images/default/backgroundimgag.jpg","imghead":"http://lhw-base.oss-cn-beijing.aliyuncs.com/images/2019/10/07/15704495809052307.png","allwordcount":null,"error":"Success"},"title_id":0,"wordStars":[{"id":9,"from_id":"0","phone":"13018600506","to_id":"0","title_id":0}]}
         * wordComments : [{"id":5,"source_id":"http://lhw-base.oss-cn-beijing.aliyuncs.com/video/3f4e1dbc6264cac4a412573b1bd0b1a5.mp4","content":"一樓","from_uid":"123131","ctime":"1570824310355","phone":"15627538274","jxUser":{"rephone":null,"code":200,"bean":null,"id":81,"phone":"15627538274","username":"1562753****","password":"123456","wordcount":30,"position":"广东省-东莞市-沙田镇","imgbackground":"https://lhw-base.oss-cn-beijing.aliyuncs.com/images/default/backgroundimgag.jpg","imghead":"https://lhw-base.oss-cn-beijing.aliyuncs.com/images/default/icon_user.png","allwordcount":null,"error":"Success"},"wordStars":[{"id":7,"from_id":"123131","phone":"13018600506","to_id":"0","title_id":0}],"replies":[{"id":4,"comment_id":"http://lhw-base.oss-cn-beijing.aliyuncs.com/video/3f4e1dbc6264cac4a412573b1bd0b1a5.mp4","reply_id":"0","content":"一樓(A)","from_uid":"123131","to_uid":"21323131","c_time":"1570824310355","phone":"13247519715","jxUser":{"rephone":null,"code":200,"bean":null,"id":80,"phone":"13247519715","username":"1324751****","password":"123456","wordcount":30,"position":"广东省-东莞市-沙田镇","imgbackground":"https://lhw-base.oss-cn-beijing.aliyuncs.com/images/default/backgroundimgag.jpg","imghead":"http://lhw-base.oss-cn-beijing.aliyuncs.com/images/2019/10/08/1570521399236322.jpg","allwordcount":null,"error":"Success"},"wordStars":[{"id":6,"from_id":"123131","phone":"13018600506","to_id":"21323131","title_id":0}]},{"id":5,"comment_id":"http://lhw-base.oss-cn-beijing.aliyuncs.com/video/3f4e1dbc6264cac4a412573b1bd0b1a5.mp4","reply_id":"21323131","content":"一樓(A)(A)","from_uid":"123131","to_uid":"213231354","c_time":"1570824310355","phone":"13247519715","jxUser":{"rephone":null,"code":200,"bean":null,"id":80,"phone":"13247519715","username":"1324751****","password":"123456","wordcount":30,"position":"广东省-东莞市-沙田镇","imgbackground":"https://lhw-base.oss-cn-beijing.aliyuncs.com/images/default/backgroundimgag.jpg","imghead":"http://lhw-base.oss-cn-beijing.aliyuncs.com/images/2019/10/08/1570521399236322.jpg","allwordcount":null,"error":"Success"},"wordStars":[{"id":8,"from_id":"123131","phone":"13018600506","to_id":"213231354","title_id":0}]}]}]
         */

        private WordWritingsBean wordWritings;
        private List<WordCommentsBean> wordComments;
        private String lifeSource;

        public String getLifeSource() {
            return lifeSource;
        }

        public void setLifeSource(String lifeSource) {
            this.lifeSource = lifeSource;
        }

        public WordWritingsBean getWordWritings() {
            return wordWritings;
        }

        public void setWordWritings(WordWritingsBean wordWritings) {
            this.wordWritings = wordWritings;
        }

        public List<WordCommentsBean> getWordComments() {
            return wordComments;
        }

        public void setWordComments(List<WordCommentsBean> wordComments) {
            this.wordComments = wordComments;
        }

        public static class WordWritingsBean {
            /**
             * id : 8
             * source : http://lhw-base.oss-cn-beijing.aliyuncs.com/video/3f4e1dbc6264cac4a412573b1bd0b1a5.mp4
             * phone : 13018600506
             * title : word
             * context : sdhadad
             * ctime : 1570824310355
             * jxUser : {"rephone":null,"code":200,"bean":null,"id":79,"phone":"13018600506","username":"1301860****","password":"123456","wordcount":30,"position":"广东省-东莞市-沙田镇","imgbackground":"https://lhw-base.oss-cn-beijing.aliyuncs.com/images/default/backgroundimgag.jpg","imghead":"http://lhw-base.oss-cn-beijing.aliyuncs.com/images/2019/10/07/15704495809052307.png","allwordcount":null,"error":"Success"}
             * title_id : 0
             * wordStars : [{"id":9,"from_id":"0","phone":"13018600506","to_id":"0","title_id":0}]
             */
            private String star;
            private String yb;
            private String position;

            public String getPosition() {
                return position;
            }

            public void setPosition(String position) {
                this.position = position;
            }

            public String getYb() {
                return yb;
            }

            public void setYb(String yb) {
                this.yb = yb;
            }

            public String getStar() {
                return star;
            }

            public void setStar(String star) {
                this.star = star;
            }

            private int id;
            private String source;
            private String phone;
            private String title;
            private String context;
            private String ctime;
            private JxUserBean jxUser;
            private int title_id;
            private List<WordStarsBean> wordStars;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContext() {
                return context;
            }

            public void setContext(String context) {
                this.context = context;
            }

            public String getCtime() {
                return ctime;
            }

            public void setCtime(String ctime) {
                this.ctime = ctime;
            }

            public JxUserBean getJxUser() {
                return jxUser;
            }

            public void setJxUser(JxUserBean jxUser) {
                this.jxUser = jxUser;
            }

            public int getTitle_id() {
                return title_id;
            }

            public void setTitle_id(int title_id) {
                this.title_id = title_id;
            }

            public List<WordStarsBean> getWordStars() {
                return wordStars;
            }

            public void setWordStars(List<WordStarsBean> wordStars) {
                this.wordStars = wordStars;
            }

            public static class JxUserBean {
                /**
                 * rephone : null
                 * code : 200
                 * bean : null
                 * id : 79
                 * phone : 13018600506
                 * username : 1301860****
                 * password : 123456
                 * wordcount : 30
                 * position : 广东省-东莞市-沙田镇
                 * imgbackground : https://lhw-base.oss-cn-beijing.aliyuncs.com/images/default/backgroundimgag.jpg
                 * imghead : http://lhw-base.oss-cn-beijing.aliyuncs.com/images/2019/10/07/15704495809052307.png
                 * allwordcount : null
                 * error : Success
                 */

                private String rephone;
                private int code;
                private Object bean;
                private int id;
                private String phone;
                private String username;
                private String password;
                private int wordcount;
                private String position;
                private String imgbackground;
                private String imghead;
                private Object allwordcount;
                private String error;

                public String getRephone() {
                    return rephone;
                }

                public void setRephone(String rephone) {
                    this.rephone = rephone;
                }

                public int getCode() {
                    return code;
                }

                public void setCode(int code) {
                    this.code = code;
                }

                public Object getBean() {
                    return bean;
                }

                public void setBean(Object bean) {
                    this.bean = bean;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getPhone() {
                    return phone;
                }

                public void setPhone(String phone) {
                    this.phone = phone;
                }

                public String getUsername() {
                    return username;
                }

                public void setUsername(String username) {
                    this.username = username;
                }

                public String getPassword() {
                    return password;
                }

                public void setPassword(String password) {
                    this.password = password;
                }

                public int getWordcount() {
                    return wordcount;
                }

                public void setWordcount(int wordcount) {
                    this.wordcount = wordcount;
                }

                public String getPosition() {
                    return position;
                }

                public void setPosition(String position) {
                    this.position = position;
                }

                public String getImgbackground() {
                    return imgbackground;
                }

                public void setImgbackground(String imgbackground) {
                    this.imgbackground = imgbackground;
                }

                public String getImghead() {
                    return imghead;
                }

                public void setImghead(String imghead) {
                    this.imghead = imghead;
                }

                public Object getAllwordcount() {
                    return allwordcount;
                }

                public void setAllwordcount(Object allwordcount) {
                    this.allwordcount = allwordcount;
                }

                public String getError() {
                    return error;
                }

                public void setError(String error) {
                    this.error = error;
                }
            }

            public static class WordStarsBean {
                /**
                 * id : 9
                 * from_id : 0
                 * phone : 13018600506
                 * to_id : 0
                 * title_id : 0
                 */

                private int id;
                private String from_id;
                private String phone;
                private String to_id;
                private int title_id;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getFrom_id() {
                    return from_id;
                }

                public void setFrom_id(String from_id) {
                    this.from_id = from_id;
                }

                public String getPhone() {
                    return phone;
                }

                public void setPhone(String phone) {
                    this.phone = phone;
                }

                public String getTo_id() {
                    return to_id;
                }

                public void setTo_id(String to_id) {
                    this.to_id = to_id;
                }

                public int getTitle_id() {
                    return title_id;
                }

                public void setTitle_id(int title_id) {
                    this.title_id = title_id;
                }
            }
        }

        public static class WordCommentsBean {
            /**
             * id : 5
             * source_id : http://lhw-base.oss-cn-beijing.aliyuncs.com/video/3f4e1dbc6264cac4a412573b1bd0b1a5.mp4
             * content : 一樓
             * from_uid : 123131
             * ctime : 1570824310355
             * phone : 15627538274
             * jxUser : {"rephone":null,"code":200,"bean":null,"id":81,"phone":"15627538274","username":"1562753****","password":"123456","wordcount":30,"position":"广东省-东莞市-沙田镇","imgbackground":"https://lhw-base.oss-cn-beijing.aliyuncs.com/images/default/backgroundimgag.jpg","imghead":"https://lhw-base.oss-cn-beijing.aliyuncs.com/images/default/icon_user.png","allwordcount":null,"error":"Success"}
             * wordStars : [{"id":7,"from_id":"123131","phone":"13018600506","to_id":"0","title_id":0}]
             * replies : [{"id":4,"comment_id":"http://lhw-base.oss-cn-beijing.aliyuncs.com/video/3f4e1dbc6264cac4a412573b1bd0b1a5.mp4","reply_id":"0","content":"一樓(A)","from_uid":"123131","to_uid":"21323131","c_time":"1570824310355","phone":"13247519715","jxUser":{"rephone":null,"code":200,"bean":null,"id":80,"phone":"13247519715","username":"1324751****","password":"123456","wordcount":30,"position":"广东省-东莞市-沙田镇","imgbackground":"https://lhw-base.oss-cn-beijing.aliyuncs.com/images/default/backgroundimgag.jpg","imghead":"http://lhw-base.oss-cn-beijing.aliyuncs.com/images/2019/10/08/1570521399236322.jpg","allwordcount":null,"error":"Success"},"wordStars":[{"id":6,"from_id":"123131","phone":"13018600506","to_id":"21323131","title_id":0}]},{"id":5,"comment_id":"http://lhw-base.oss-cn-beijing.aliyuncs.com/video/3f4e1dbc6264cac4a412573b1bd0b1a5.mp4","reply_id":"21323131","content":"一樓(A)(A)","from_uid":"123131","to_uid":"213231354","c_time":"1570824310355","phone":"13247519715","jxUser":{"rephone":null,"code":200,"bean":null,"id":80,"phone":"13247519715","username":"1324751****","password":"123456","wordcount":30,"position":"广东省-东莞市-沙田镇","imgbackground":"https://lhw-base.oss-cn-beijing.aliyuncs.com/images/default/backgroundimgag.jpg","imghead":"http://lhw-base.oss-cn-beijing.aliyuncs.com/images/2019/10/08/1570521399236322.jpg","allwordcount":null,"error":"Success"},"wordStars":[{"id":8,"from_id":"123131","phone":"13018600506","to_id":"213231354","title_id":0}]}]
             */

            private int id;
            private String source_id;
            private String content;
            private String from_uid;
            private String ctime;
            private String phone;
            private JxUserBeanX jxUser;
            private String from_phone;
            private List<WordStarsBeanX> wordStars;
            private List<RepliesBean> replies;
            private String star;

            public String getStar() {
                return star;
            }

            public void setStar(String star) {
                this.star = star;
            }

            public String getFrom_phone() {
                return from_phone;
            }

            public void setFrom_phone(String from_phone) {
                this.from_phone = from_phone;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getSource_id() {
                return source_id;
            }

            public void setSource_id(String source_id) {
                this.source_id = source_id;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getFrom_uid() {
                return from_uid;
            }

            public void setFrom_uid(String from_uid) {
                this.from_uid = from_uid;
            }

            public String getCtime() {
                return ctime;
            }

            public void setCtime(String ctime) {
                this.ctime = ctime;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public JxUserBeanX getJxUser() {
                return jxUser;
            }

            public void setJxUser(JxUserBeanX jxUser) {
                this.jxUser = jxUser;
            }

            public List<WordStarsBeanX> getWordStars() {
                return wordStars;
            }

            public void setWordStars(List<WordStarsBeanX> wordStars) {
                this.wordStars = wordStars;
            }

            public List<RepliesBean> getReplies() {
                return replies;
            }

            public void setReplies(List<RepliesBean> replies) {
                this.replies = replies;
            }

            public static class JxUserBeanX {
                /**
                 * rephone : null
                 * code : 200
                 * bean : null
                 * id : 81
                 * phone : 15627538274
                 * username : 1562753****
                 * password : 123456
                 * wordcount : 30
                 * position : 广东省-东莞市-沙田镇
                 * imgbackground : https://lhw-base.oss-cn-beijing.aliyuncs.com/images/default/backgroundimgag.jpg
                 * imghead : https://lhw-base.oss-cn-beijing.aliyuncs.com/images/default/icon_user.png
                 * allwordcount : null
                 * error : Success
                 */

                private Object rephone;
                private int code;
                private Object bean;
                private int id;
                private String phone;
                private String username;
                private String password;
                private int wordcount;
                private String position;
                private String imgbackground;
                private String imghead;
                private Object allwordcount;
                private String error;

                public Object getRephone() {
                    return rephone;
                }

                public void setRephone(Object rephone) {
                    this.rephone = rephone;
                }

                public int getCode() {
                    return code;
                }

                public void setCode(int code) {
                    this.code = code;
                }

                public Object getBean() {
                    return bean;
                }

                public void setBean(Object bean) {
                    this.bean = bean;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getPhone() {
                    return phone;
                }

                public void setPhone(String phone) {
                    this.phone = phone;
                }

                public String getUsername() {
                    return username;
                }

                public void setUsername(String username) {
                    this.username = username;
                }

                public String getPassword() {
                    return password;
                }

                public void setPassword(String password) {
                    this.password = password;
                }

                public int getWordcount() {
                    return wordcount;
                }

                public void setWordcount(int wordcount) {
                    this.wordcount = wordcount;
                }

                public String getPosition() {
                    return position;
                }

                public void setPosition(String position) {
                    this.position = position;
                }

                public String getImgbackground() {
                    return imgbackground;
                }

                public void setImgbackground(String imgbackground) {
                    this.imgbackground = imgbackground;
                }

                public String getImghead() {
                    return imghead;
                }

                public void setImghead(String imghead) {
                    this.imghead = imghead;
                }

                public Object getAllwordcount() {
                    return allwordcount;
                }

                public void setAllwordcount(Object allwordcount) {
                    this.allwordcount = allwordcount;
                }

                public String getError() {
                    return error;
                }

                public void setError(String error) {
                    this.error = error;
                }
            }

            public static class WordStarsBeanX {
                /**
                 * id : 7
                 * from_id : 123131
                 * phone : 13018600506
                 * to_id : 0
                 * title_id : 0
                 */

                private int id;
                private String from_id;
                private String phone;
                private String to_id;
                private int title_id;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getFrom_id() {
                    return from_id;
                }

                public void setFrom_id(String from_id) {
                    this.from_id = from_id;
                }

                public String getPhone() {
                    return phone;
                }

                public void setPhone(String phone) {
                    this.phone = phone;
                }

                public String getTo_id() {
                    return to_id;
                }

                public void setTo_id(String to_id) {
                    this.to_id = to_id;
                }

                public int getTitle_id() {
                    return title_id;
                }

                public void setTitle_id(int title_id) {
                    this.title_id = title_id;
                }
            }

            public static class RepliesBean {
                /**
                 * id : 4
                 * comment_id : http://lhw-base.oss-cn-beijing.aliyuncs.com/video/3f4e1dbc6264cac4a412573b1bd0b1a5.mp4
                 * reply_id : 0
                 * content : 一樓(A)
                 * from_uid : 123131
                 * to_uid : 21323131
                 * c_time : 1570824310355
                 * phone : 13247519715
                 * jxUser : {"rephone":null,"code":200,"bean":null,"id":80,"phone":"13247519715","username":"1324751****","password":"123456","wordcount":30,"position":"广东省-东莞市-沙田镇","imgbackground":"https://lhw-base.oss-cn-beijing.aliyuncs.com/images/default/backgroundimgag.jpg","imghead":"http://lhw-base.oss-cn-beijing.aliyuncs.com/images/2019/10/08/1570521399236322.jpg","allwordcount":null,"error":"Success"}
                 * wordStars : [{"id":6,"from_id":"123131","phone":"13018600506","to_id":"21323131","title_id":0}]
                 */
                private String star;

                public String getStar() {
                    return star;
                }

                public void setStar(String star) {
                    this.star = star;
                }

                private int id;
                private String comment_id;
                private String reply_id;
                private String content;
                private String from_uid;
                private String to_uid;
                private String c_time;
                private String phone;
                private JxUserBeanXX jxUser;
                private List<WordStarsBeanXX> wordStars;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getComment_id() {
                    return comment_id;
                }

                public void setComment_id(String comment_id) {
                    this.comment_id = comment_id;
                }

                public String getReply_id() {
                    return reply_id;
                }

                public void setReply_id(String reply_id) {
                    this.reply_id = reply_id;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getFrom_uid() {
                    return from_uid;
                }

                public void setFrom_uid(String from_uid) {
                    this.from_uid = from_uid;
                }

                public String getTo_uid() {
                    return to_uid;
                }

                public void setTo_uid(String to_uid) {
                    this.to_uid = to_uid;
                }

                public String getC_time() {
                    return c_time;
                }

                public void setC_time(String c_time) {
                    this.c_time = c_time;
                }

                public String getPhone() {
                    return phone;
                }

                public void setPhone(String phone) {
                    this.phone = phone;
                }

                public JxUserBeanXX getJxUser() {
                    return jxUser;
                }

                public void setJxUser(JxUserBeanXX jxUser) {
                    this.jxUser = jxUser;
                }

                public List<WordStarsBeanXX> getWordStars() {
                    return wordStars;
                }

                public void setWordStars(List<WordStarsBeanXX> wordStars) {
                    this.wordStars = wordStars;
                }

                public static class JxUserBeanXX {
                    /**
                     * rephone : null
                     * code : 200
                     * bean : null
                     * id : 80
                     * phone : 13247519715
                     * username : 1324751****
                     * password : 123456
                     * wordcount : 30
                     * position : 广东省-东莞市-沙田镇
                     * imgbackground : https://lhw-base.oss-cn-beijing.aliyuncs.com/images/default/backgroundimgag.jpg
                     * imghead : http://lhw-base.oss-cn-beijing.aliyuncs.com/images/2019/10/08/1570521399236322.jpg
                     * allwordcount : null
                     * error : Success
                     */

                    private Object rephone;
                    private int code;
                    private Object bean;
                    private int id;
                    private String phone;
                    private String username;
                    private String password;
                    private int wordcount;
                    private String position;
                    private String imgbackground;
                    private String imghead;
                    private Object allwordcount;
                    private String error;

                    public Object getRephone() {
                        return rephone;
                    }

                    public void setRephone(Object rephone) {
                        this.rephone = rephone;
                    }

                    public int getCode() {
                        return code;
                    }

                    public void setCode(int code) {
                        this.code = code;
                    }

                    public Object getBean() {
                        return bean;
                    }

                    public void setBean(Object bean) {
                        this.bean = bean;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getPhone() {
                        return phone;
                    }

                    public void setPhone(String phone) {
                        this.phone = phone;
                    }

                    public String getUsername() {
                        return username;
                    }

                    public void setUsername(String username) {
                        this.username = username;
                    }

                    public String getPassword() {
                        return password;
                    }

                    public void setPassword(String password) {
                        this.password = password;
                    }

                    public int getWordcount() {
                        return wordcount;
                    }

                    public void setWordcount(int wordcount) {
                        this.wordcount = wordcount;
                    }

                    public String getPosition() {
                        return position;
                    }

                    public void setPosition(String position) {
                        this.position = position;
                    }

                    public String getImgbackground() {
                        return imgbackground;
                    }

                    public void setImgbackground(String imgbackground) {
                        this.imgbackground = imgbackground;
                    }

                    public String getImghead() {
                        return imghead;
                    }

                    public void setImghead(String imghead) {
                        this.imghead = imghead;
                    }

                    public Object getAllwordcount() {
                        return allwordcount;
                    }

                    public void setAllwordcount(Object allwordcount) {
                        this.allwordcount = allwordcount;
                    }

                    public String getError() {
                        return error;
                    }

                    public void setError(String error) {
                        this.error = error;
                    }
                }

                public static class WordStarsBeanXX {
                    /**
                     * id : 6
                     * from_id : 123131
                     * phone : 13018600506
                     * to_id : 21323131
                     * title_id : 0
                     */

                    private int id;
                    private String from_id;
                    private String phone;
                    private String to_id;
                    private int title_id;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getFrom_id() {
                        return from_id;
                    }

                    public void setFrom_id(String from_id) {
                        this.from_id = from_id;
                    }

                    public String getPhone() {
                        return phone;
                    }

                    public void setPhone(String phone) {
                        this.phone = phone;
                    }

                    public String getTo_id() {
                        return to_id;
                    }

                    public void setTo_id(String to_id) {
                        this.to_id = to_id;
                    }

                    public int getTitle_id() {
                        return title_id;
                    }

                    public void setTitle_id(int title_id) {
                        this.title_id = title_id;
                    }
                }
            }
        }
    }
}
