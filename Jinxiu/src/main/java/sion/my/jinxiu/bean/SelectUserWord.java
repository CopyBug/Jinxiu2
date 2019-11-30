package sion.my.jinxiu.bean;

import java.util.List;

/**
 * 作者： 梁浩文, 日期： 2019/9/25.
 * 让代码更加美观
 */
public class SelectUserWord {


    /**
     * rephone : null
     * code : 200
     * bean : {"words":[{"id":66,"word":"anxious","ukarticulation":"英 [ˈæŋkʃəs]","usaarticulation":"美 [ˈæŋkʃəs]","ukmusic":"https://picflow.koolearn.com/dict/mp3/b2ff051c7458f02aa44d16653c26786d.mp3","usamusic":"https://picflow.koolearn.com/dict/mp3/98df500001e19687dfeedb84f86bbf81.mp3","transaction":"adj.焦急的；渴望的；令人焦虑的；流露出忧虑的","sentence":"The whole country was anxious for peace.全国上下都渴望和平。\nI am anxious to compare my fancy with reality.我焦切地把我的想象同现实作一番比较。\nSmall businesses are anxious to experiment with computers.小型企业都急于试用计算机。\nShe was anxious to enlighten me about the events that led up to the dispute.她急着要使我明白引起这场争执的那些事情。\nI'm very anxious about the speech contest.我对此次演讲比赛十分忧虑。\nThe moderates have plenty to be anxious about.温和派有许多问题要担忧。\nI was anxious about the children when they didn't come back home from school.孩子们放学后没有回家，我非常担心。\n","worddate":"2019-10-10","wordcode":1,"number":5},{"id":157,"word":"await","ukarticulation":"英 [əˈweɪt]","usaarticulation":"美 [əˈwet]","ukmusic":"https://picflow.koolearn.com/dict/mp3/b82995576bf54d50cfa6e2a11b67ba3f.mp3","usamusic":"https://picflow.koolearn.com/dict/mp3/2b0513850fa1e5c7ebc853f2df6af7ca.mp3","transaction":"vt.等候；等待；期待；","sentence":"We await your shipping instructions.我们等候你们的装船指示。\nI am awaiting their reply.我正在等待他们的答复。\nWe eagerly await your early arrival.我们殷切地期待你早日光临。\nA warm welcome awaits you.你将受到热烈的欢迎。\nIt was completely hopeless. They had to await their doom.希望已绝，他们只能坐以待毙了。\n","worddate":"2019-10-10","wordcode":0,"number":10}],"maxCount":200}
     * error : Success
     */

    private Object rephone;
    private int code;
    private BeanBean bean;
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

    public BeanBean getBean() {
        return bean;
    }

    public void setBean(BeanBean bean) {
        this.bean = bean;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public static class BeanBean {
        /**
         * words : [{"id":66,"word":"anxious","ukarticulation":"英 [ˈæŋkʃəs]","usaarticulation":"美 [ˈæŋkʃəs]","ukmusic":"https://picflow.koolearn.com/dict/mp3/b2ff051c7458f02aa44d16653c26786d.mp3","usamusic":"https://picflow.koolearn.com/dict/mp3/98df500001e19687dfeedb84f86bbf81.mp3","transaction":"adj.焦急的；渴望的；令人焦虑的；流露出忧虑的","sentence":"The whole country was anxious for peace.全国上下都渴望和平。\nI am anxious to compare my fancy with reality.我焦切地把我的想象同现实作一番比较。\nSmall businesses are anxious to experiment with computers.小型企业都急于试用计算机。\nShe was anxious to enlighten me about the events that led up to the dispute.她急着要使我明白引起这场争执的那些事情。\nI'm very anxious about the speech contest.我对此次演讲比赛十分忧虑。\nThe moderates have plenty to be anxious about.温和派有许多问题要担忧。\nI was anxious about the children when they didn't come back home from school.孩子们放学后没有回家，我非常担心。\n","worddate":"2019-10-10","wordcode":1,"number":5},{"id":157,"word":"await","ukarticulation":"英 [əˈweɪt]","usaarticulation":"美 [əˈwet]","ukmusic":"https://picflow.koolearn.com/dict/mp3/b82995576bf54d50cfa6e2a11b67ba3f.mp3","usamusic":"https://picflow.koolearn.com/dict/mp3/2b0513850fa1e5c7ebc853f2df6af7ca.mp3","transaction":"vt.等候；等待；期待；","sentence":"We await your shipping instructions.我们等候你们的装船指示。\nI am awaiting their reply.我正在等待他们的答复。\nWe eagerly await your early arrival.我们殷切地期待你早日光临。\nA warm welcome awaits you.你将受到热烈的欢迎。\nIt was completely hopeless. They had to await their doom.希望已绝，他们只能坐以待毙了。\n","worddate":"2019-10-10","wordcode":0,"number":10}]
         * maxCount : 200
         */

        private int maxCount;
        private List<WordsBean> words;

        public int getMaxCount() {
            return maxCount;
        }

        public void setMaxCount(int maxCount) {
            this.maxCount = maxCount;
        }

        public List<WordsBean> getWords() {
            return words;
        }

        public void setWords(List<WordsBean> words) {
            this.words = words;
        }

        public static class WordsBean {
            /**
             * id : 66
             * word : anxious
             * ukarticulation : 英 [ˈæŋkʃəs]
             * usaarticulation : 美 [ˈæŋkʃəs]
             * ukmusic : https://picflow.koolearn.com/dict/mp3/b2ff051c7458f02aa44d16653c26786d.mp3
             * usamusic : https://picflow.koolearn.com/dict/mp3/98df500001e19687dfeedb84f86bbf81.mp3
             * transaction : adj.焦急的；渴望的；令人焦虑的；流露出忧虑的
             * sentence : The whole country was anxious for peace.全国上下都渴望和平。
             I am anxious to compare my fancy with reality.我焦切地把我的想象同现实作一番比较。
             Small businesses are anxious to experiment with computers.小型企业都急于试用计算机。
             She was anxious to enlighten me about the events that led up to the dispute.她急着要使我明白引起这场争执的那些事情。
             I'm very anxious about the speech contest.我对此次演讲比赛十分忧虑。
             The moderates have plenty to be anxious about.温和派有许多问题要担忧。
             I was anxious about the children when they didn't come back home from school.孩子们放学后没有回家，我非常担心。
             * worddate : 2019-10-10
             * wordcode : 1
             * number : 5
             */

            private int id;
            private String word;
            private String ukarticulation;
            private String usaarticulation;
            private String ukmusic;
            private String usamusic;
            private String transaction;
            private String sentence;
            private String worddate;
            private int wordcode;
            private int number;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getWord() {
                return word;
            }

            public void setWord(String word) {
                this.word = word;
            }

            public String getUkarticulation() {
                return ukarticulation;
            }

            public void setUkarticulation(String ukarticulation) {
                this.ukarticulation = ukarticulation;
            }

            public String getUsaarticulation() {
                return usaarticulation;
            }

            public void setUsaarticulation(String usaarticulation) {
                this.usaarticulation = usaarticulation;
            }

            public String getUkmusic() {
                return ukmusic;
            }

            public void setUkmusic(String ukmusic) {
                this.ukmusic = ukmusic;
            }

            public String getUsamusic() {
                return usamusic;
            }

            public void setUsamusic(String usamusic) {
                this.usamusic = usamusic;
            }

            public String getTransaction() {
                return transaction;
            }

            public void setTransaction(String transaction) {
                this.transaction = transaction;
            }

            public String getSentence() {
                return sentence;
            }

            public void setSentence(String sentence) {
                this.sentence = sentence;
            }

            public String getWorddate() {
                return worddate;
            }

            public void setWorddate(String worddate) {
                this.worddate = worddate;
            }

            public int getWordcode() {
                return wordcode;
            }

            public void setWordcode(int wordcode) {
                this.wordcode = wordcode;
            }

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
                this.number = number;
            }
        }
    }
}
