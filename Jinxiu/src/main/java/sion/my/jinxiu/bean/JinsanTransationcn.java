package sion.my.jinxiu.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 作者： 梁浩文, 日期： 2019/10/9.
 * 让代码更加美观
 */
public class JinsanTransationcn implements Serializable {
    private static final long serialVersionUID = 3114005178108007010L;
    /**
     * errno : 0
     * errmsg : success
     * baesInfo : {"word_name":"你好","is_CRI":0,"symbols":[{"word_symbol":"nǐ hǎo","symbol_mp3":"","parts":[{"means":["hello","hi","How do you do!"],"part":""}]}],"fromSymbolsMean":[{"word_symbol":"nǐ hǎo","word":[{"word":[{"word_name":"hello","is_CRI":1,"symbols":[{"ph_en":"hə'ləʊ","ph_am":"həˈloʊ","ph_other":"","ph_en_mp3":"","ph_am_mp3":"http://res.iciba.com/resource/amp3/1/0/5d/41/5d41402abc4b2a76b9719d911017c592.mp3","ph_tts_mp3":"http://res-tts.iciba.com/5/d/4/5d41402abc4b2a76b9719d911017c592.mp3","parts":[{"part":"int.","means":["哈喽，喂","你好，您好","表示问候","打招呼"]},{"part":"n.","means":["\u201c喂\u201d的招呼声或问候声"]},{"part":"vi.","means":["喊\u201c喂\u201d"]}]}]},{"word_name":"hi","is_CRI":1,"symbols":[{"ph_en":"haɪ","ph_am":"haɪ","ph_other":"","ph_en_mp3":"http://res.iciba.com/resource/amp3/oxford/0/9e/13/9e13a7b46bb5fb45f0890985f84934a1.mp3","ph_am_mp3":"http://res.iciba.com/resource/amp3/1/0/49/f6/49f68a5c8493ec2c0bf489821c21fc3b.mp3","ph_tts_mp3":"http://res-tts.iciba.com/4/9/f/49f68a5c8493ec2c0bf489821c21fc3b.mp3","parts":[{"part":"int.","means":["（用作问候语）嘿，喂"]},{"part":"abbr.","means":["夏威夷群岛的书面缩写","（=high intensity）高强度"]}]}]},{"word_name":"how do you do","is_CRI":"0","symbols":[{"ph_en":"hau du: ju: du:","ph_am":"haʊ du ju du","ph_other":"","ph_en_mp3":"","ph_am_mp3":"","ph_tts_mp3":"http://res-tts.iciba.com/3/d/5/3d5a5ea8c78cdb828ad83049316e3993.mp3","parts":[{"part":"","means":["你好"]}]}]}],"part":""}]}],"translate_type":1}
     * err_words : [{"word_name":"How do you do","means":["你好"]}]
     * sentence : [{"Network_id":"2319702","Network_en":"Good day to you, Bernard! It's a positive delight to see you.","Network_cn":"你好，伯纳德！见到你真高兴。","tts_mp3":"http://res-tts.iciba.com/tts_new_dj//5/7/e/57efeb4456e4f66dfe9aed84d597357e.mp3","tts_size":"21K","source_type":0,"source_id":0,"source_title":"普通双语例句"},{"Network_id":"2332351","Network_en":"It's not a very good line. Shall we call you back Susan?","Network_cn":"电话线路不太好。苏珊，我待会儿再打给你好吗？","tts_mp3":"http://res-tts.iciba.com/tts_new_dj//b/b/0/bb0bd42bd748159aa25b4aa3a94fa7a8.mp3","tts_size":"19K","source_type":0,"source_id":0,"source_title":"普通双语例句"},{"Network_id":"2336985","Network_en":"\"Shall I come to see you?\" \u2014 \"Are you kidding? It's miles.\"","Network_cn":"\u201c我去看望你好吗？\u201d\u2014\u2014\u201c你在开玩笑吗？路很远的。\u201d","tts_mp3":"http://res-tts.iciba.com/tts_new_dj//9/2/1/92111a6e12026f237ae834f49ec45837.mp3","tts_size":"25K","source_type":0,"source_id":0,"source_title":"普通双语例句"}]
     * synthesize : [{"symbol_id":"11714","word_id":"11638","word_symbol":"nǐ hǎo","xg":"","parts":[{"means":[{"mean_id":"12614","part_id":"","cy_id":"11478","word_mean":"how do you do; how are you; hello"}]}]}]
     * chinese : {"ci":{"id":"83711","ciyu":"你好","pinxie":"nihao","pinyin":"nǐ hǎo","jieshi":"","goucheng":"","tongyi":"","fanyi":"","tongyin":"","liju":"","zi":"你","zid":"4383","ciyi":""}}
     * traditional :
     * _word_flag : 2
     * exchanges : ["你好"]
     */

    private int errno;
    private String errmsg;
    private BaesInfoBean baesInfo;
    private ChineseBean chinese;
    private String traditional;
    private int _word_flag;
    private List<ErrWordsBean> err_words;
    private List<SentenceBean> sentence;
    private List<SynthesizeBean> synthesize;
    private List<String> exchanges;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public BaesInfoBean getBaesInfo() {
        return baesInfo;
    }

    public void setBaesInfo(BaesInfoBean baesInfo) {
        this.baesInfo = baesInfo;
    }

    public ChineseBean getChinese() {
        return chinese;
    }

    public void setChinese(ChineseBean chinese) {
        this.chinese = chinese;
    }

    public String getTraditional() {
        return traditional;
    }

    public void setTraditional(String traditional) {
        this.traditional = traditional;
    }

    public int get_word_flag() {
        return _word_flag;
    }

    public void set_word_flag(int _word_flag) {
        this._word_flag = _word_flag;
    }

    public List<ErrWordsBean> getErr_words() {
        return err_words;
    }

    public void setErr_words(List<ErrWordsBean> err_words) {
        this.err_words = err_words;
    }

    public List<SentenceBean> getSentence() {
        return sentence;
    }

    public void setSentence(List<SentenceBean> sentence) {
        this.sentence = sentence;
    }

    public List<SynthesizeBean> getSynthesize() {
        return synthesize;
    }

    public void setSynthesize(List<SynthesizeBean> synthesize) {
        this.synthesize = synthesize;
    }

    public List<String> getExchanges() {
        return exchanges;
    }

    public void setExchanges(List<String> exchanges) {
        this.exchanges = exchanges;
    }

    public static class BaesInfoBean implements Serializable{
        /**
         * word_name : 你好
         * is_CRI : 0
         * symbols : [{"word_symbol":"nǐ hǎo","symbol_mp3":"","parts":[{"means":["hello","hi","How do you do!"],"part":""}]}]
         * fromSymbolsMean : [{"word_symbol":"nǐ hǎo","word":[{"word":[{"word_name":"hello","is_CRI":1,"symbols":[{"ph_en":"hə'ləʊ","ph_am":"həˈloʊ","ph_other":"","ph_en_mp3":"","ph_am_mp3":"http://res.iciba.com/resource/amp3/1/0/5d/41/5d41402abc4b2a76b9719d911017c592.mp3","ph_tts_mp3":"http://res-tts.iciba.com/5/d/4/5d41402abc4b2a76b9719d911017c592.mp3","parts":[{"part":"int.","means":["哈喽，喂","你好，您好","表示问候","打招呼"]},{"part":"n.","means":["\u201c喂\u201d的招呼声或问候声"]},{"part":"vi.","means":["喊\u201c喂\u201d"]}]}]},{"word_name":"hi","is_CRI":1,"symbols":[{"ph_en":"haɪ","ph_am":"haɪ","ph_other":"","ph_en_mp3":"http://res.iciba.com/resource/amp3/oxford/0/9e/13/9e13a7b46bb5fb45f0890985f84934a1.mp3","ph_am_mp3":"http://res.iciba.com/resource/amp3/1/0/49/f6/49f68a5c8493ec2c0bf489821c21fc3b.mp3","ph_tts_mp3":"http://res-tts.iciba.com/4/9/f/49f68a5c8493ec2c0bf489821c21fc3b.mp3","parts":[{"part":"int.","means":["（用作问候语）嘿，喂"]},{"part":"abbr.","means":["夏威夷群岛的书面缩写","（=high intensity）高强度"]}]}]},{"word_name":"how do you do","is_CRI":"0","symbols":[{"ph_en":"hau du: ju: du:","ph_am":"haʊ du ju du","ph_other":"","ph_en_mp3":"","ph_am_mp3":"","ph_tts_mp3":"http://res-tts.iciba.com/3/d/5/3d5a5ea8c78cdb828ad83049316e3993.mp3","parts":[{"part":"","means":["你好"]}]}]}],"part":""}]}]
         * translate_type : 1
         */

        private String word_name;
        private int is_CRI;
        private int translate_type;
        private List<SymbolsBean> symbols;
        private List<FromSymbolsMeanBean> fromSymbolsMean;

        public String getWord_name() {
            return word_name;
        }

        public void setWord_name(String word_name) {
            this.word_name = word_name;
        }

        public int getIs_CRI() {
            return is_CRI;
        }

        public void setIs_CRI(int is_CRI) {
            this.is_CRI = is_CRI;
        }

        public int getTranslate_type() {
            return translate_type;
        }

        public void setTranslate_type(int translate_type) {
            this.translate_type = translate_type;
        }

        public List<SymbolsBean> getSymbols() {
            return symbols;
        }

        public void setSymbols(List<SymbolsBean> symbols) {
            this.symbols = symbols;
        }

        public List<FromSymbolsMeanBean> getFromSymbolsMean() {
            return fromSymbolsMean;
        }

        public void setFromSymbolsMean(List<FromSymbolsMeanBean> fromSymbolsMean) {
            this.fromSymbolsMean = fromSymbolsMean;
        }

        public static class SymbolsBean implements Serializable {
            /**
             * word_symbol : nǐ hǎo
             * symbol_mp3 :
             * parts : [{"means":["hello","hi","How do you do!"],"part":""}]
             */

            private String word_symbol;
            private String symbol_mp3;
            private List<PartsBean> parts;

            public String getWord_symbol() {
                return word_symbol;
            }

            public void setWord_symbol(String word_symbol) {
                this.word_symbol = word_symbol;
            }

            public String getSymbol_mp3() {
                return symbol_mp3;
            }

            public void setSymbol_mp3(String symbol_mp3) {
                this.symbol_mp3 = symbol_mp3;
            }

            public List<PartsBean> getParts() {
                return parts;
            }

            public void setParts(List<PartsBean> parts) {
                this.parts = parts;
            }

            public static class PartsBean implements Serializable {
                /**
                 * means : ["hello","hi","How do you do!"]
                 * part :
                 */

                private String part;
                private List<String> means;

                public String getPart() {
                    return part;
                }

                public void setPart(String part) {
                    this.part = part;
                }

                public List<String> getMeans() {
                    return means;
                }

                public void setMeans(List<String> means) {
                    this.means = means;
                }
            }
        }

        public static class FromSymbolsMeanBean implements Serializable {
            /**
             * word_symbol : nǐ hǎo
             * word : [{"word":[{"word_name":"hello","is_CRI":1,"symbols":[{"ph_en":"hə'ləʊ","ph_am":"həˈloʊ","ph_other":"","ph_en_mp3":"","ph_am_mp3":"http://res.iciba.com/resource/amp3/1/0/5d/41/5d41402abc4b2a76b9719d911017c592.mp3","ph_tts_mp3":"http://res-tts.iciba.com/5/d/4/5d41402abc4b2a76b9719d911017c592.mp3","parts":[{"part":"int.","means":["哈喽，喂","你好，您好","表示问候","打招呼"]},{"part":"n.","means":["\u201c喂\u201d的招呼声或问候声"]},{"part":"vi.","means":["喊\u201c喂\u201d"]}]}]},{"word_name":"hi","is_CRI":1,"symbols":[{"ph_en":"haɪ","ph_am":"haɪ","ph_other":"","ph_en_mp3":"http://res.iciba.com/resource/amp3/oxford/0/9e/13/9e13a7b46bb5fb45f0890985f84934a1.mp3","ph_am_mp3":"http://res.iciba.com/resource/amp3/1/0/49/f6/49f68a5c8493ec2c0bf489821c21fc3b.mp3","ph_tts_mp3":"http://res-tts.iciba.com/4/9/f/49f68a5c8493ec2c0bf489821c21fc3b.mp3","parts":[{"part":"int.","means":["（用作问候语）嘿，喂"]},{"part":"abbr.","means":["夏威夷群岛的书面缩写","（=high intensity）高强度"]}]}]},{"word_name":"how do you do","is_CRI":"0","symbols":[{"ph_en":"hau du: ju: du:","ph_am":"haʊ du ju du","ph_other":"","ph_en_mp3":"","ph_am_mp3":"","ph_tts_mp3":"http://res-tts.iciba.com/3/d/5/3d5a5ea8c78cdb828ad83049316e3993.mp3","parts":[{"part":"","means":["你好"]}]}]}],"part":""}]
             */

            private String word_symbol;
            private List<WordBeanX> word;

            public String getWord_symbol() {
                return word_symbol;
            }

            public void setWord_symbol(String word_symbol) {
                this.word_symbol = word_symbol;
            }

            public List<WordBeanX> getWord() {
                return word;
            }

            public void setWord(List<WordBeanX> word) {
                this.word = word;
            }

            public static class WordBeanX  implements Serializable{
                /**
                 * word : [{"word_name":"hello","is_CRI":1,"symbols":[{"ph_en":"hə'ləʊ","ph_am":"həˈloʊ","ph_other":"","ph_en_mp3":"","ph_am_mp3":"http://res.iciba.com/resource/amp3/1/0/5d/41/5d41402abc4b2a76b9719d911017c592.mp3","ph_tts_mp3":"http://res-tts.iciba.com/5/d/4/5d41402abc4b2a76b9719d911017c592.mp3","parts":[{"part":"int.","means":["哈喽，喂","你好，您好","表示问候","打招呼"]},{"part":"n.","means":["\u201c喂\u201d的招呼声或问候声"]},{"part":"vi.","means":["喊\u201c喂\u201d"]}]}]},{"word_name":"hi","is_CRI":1,"symbols":[{"ph_en":"haɪ","ph_am":"haɪ","ph_other":"","ph_en_mp3":"http://res.iciba.com/resource/amp3/oxford/0/9e/13/9e13a7b46bb5fb45f0890985f84934a1.mp3","ph_am_mp3":"http://res.iciba.com/resource/amp3/1/0/49/f6/49f68a5c8493ec2c0bf489821c21fc3b.mp3","ph_tts_mp3":"http://res-tts.iciba.com/4/9/f/49f68a5c8493ec2c0bf489821c21fc3b.mp3","parts":[{"part":"int.","means":["（用作问候语）嘿，喂"]},{"part":"abbr.","means":["夏威夷群岛的书面缩写","（=high intensity）高强度"]}]}]},{"word_name":"how do you do","is_CRI":"0","symbols":[{"ph_en":"hau du: ju: du:","ph_am":"haʊ du ju du","ph_other":"","ph_en_mp3":"","ph_am_mp3":"","ph_tts_mp3":"http://res-tts.iciba.com/3/d/5/3d5a5ea8c78cdb828ad83049316e3993.mp3","parts":[{"part":"","means":["你好"]}]}]}]
                 * part :
                 */

                private String part;
                private List<WordBean> word;

                public String getPart() {
                    return part;
                }

                public void setPart(String part) {
                    this.part = part;
                }

                public List<WordBean> getWord() {
                    return word;
                }

                public void setWord(List<WordBean> word) {
                    this.word = word;
                }

                public static class WordBean  implements Serializable{
                    /**
                     * word_name : hello
                     * is_CRI : 1
                     * symbols : [{"ph_en":"hə'ləʊ","ph_am":"həˈloʊ","ph_other":"","ph_en_mp3":"","ph_am_mp3":"http://res.iciba.com/resource/amp3/1/0/5d/41/5d41402abc4b2a76b9719d911017c592.mp3","ph_tts_mp3":"http://res-tts.iciba.com/5/d/4/5d41402abc4b2a76b9719d911017c592.mp3","parts":[{"part":"int.","means":["哈喽，喂","你好，您好","表示问候","打招呼"]},{"part":"n.","means":["\u201c喂\u201d的招呼声或问候声"]},{"part":"vi.","means":["喊\u201c喂\u201d"]}]}]
                     */

                    private String word_name;
                    private int is_CRI;
                    private List<SymbolsBeanX> symbols;

                    public String getWord_name() {
                        return word_name;
                    }

                    public void setWord_name(String word_name) {
                        this.word_name = word_name;
                    }

                    public int getIs_CRI() {
                        return is_CRI;
                    }

                    public void setIs_CRI(int is_CRI) {
                        this.is_CRI = is_CRI;
                    }

                    public List<SymbolsBeanX> getSymbols() {
                        return symbols;
                    }

                    public void setSymbols(List<SymbolsBeanX> symbols) {
                        this.symbols = symbols;
                    }

                    public static class SymbolsBeanX  implements Serializable{
                        /**
                         * ph_en : hə'ləʊ
                         * ph_am : həˈloʊ
                         * ph_other :
                         * ph_en_mp3 :
                         * ph_am_mp3 : http://res.iciba.com/resource/amp3/1/0/5d/41/5d41402abc4b2a76b9719d911017c592.mp3
                         * ph_tts_mp3 : http://res-tts.iciba.com/5/d/4/5d41402abc4b2a76b9719d911017c592.mp3
                         * parts : [{"part":"int.","means":["哈喽，喂","你好，您好","表示问候","打招呼"]},{"part":"n.","means":["\u201c喂\u201d的招呼声或问候声"]},{"part":"vi.","means":["喊\u201c喂\u201d"]}]
                         */

                        private String ph_en;
                        private String ph_am;
                        private String ph_other;
                        private String ph_en_mp3;
                        private String ph_am_mp3;
                        private String ph_tts_mp3;
                        private List<PartsBeanX> parts;

                        public String getPh_en() {
                            return ph_en;
                        }

                        public void setPh_en(String ph_en) {
                            this.ph_en = ph_en;
                        }

                        public String getPh_am() {
                            return ph_am;
                        }

                        public void setPh_am(String ph_am) {
                            this.ph_am = ph_am;
                        }

                        public String getPh_other() {
                            return ph_other;
                        }

                        public void setPh_other(String ph_other) {
                            this.ph_other = ph_other;
                        }

                        public String getPh_en_mp3() {
                            return ph_en_mp3;
                        }

                        public void setPh_en_mp3(String ph_en_mp3) {
                            this.ph_en_mp3 = ph_en_mp3;
                        }

                        public String getPh_am_mp3() {
                            return ph_am_mp3;
                        }

                        public void setPh_am_mp3(String ph_am_mp3) {
                            this.ph_am_mp3 = ph_am_mp3;
                        }

                        public String getPh_tts_mp3() {
                            return ph_tts_mp3;
                        }

                        public void setPh_tts_mp3(String ph_tts_mp3) {
                            this.ph_tts_mp3 = ph_tts_mp3;
                        }

                        public List<PartsBeanX> getParts() {
                            return parts;
                        }

                        public void setParts(List<PartsBeanX> parts) {
                            this.parts = parts;
                        }

                        public static class PartsBeanX  implements Serializable{
                            /**
                             * part : int.
                             * means : ["哈喽，喂","你好，您好","表示问候","打招呼"]
                             */

                            private String part;
                            private List<String> means;

                            public String getPart() {
                                return part;
                            }

                            public void setPart(String part) {
                                this.part = part;
                            }

                            public List<String> getMeans() {
                                return means;
                            }

                            public void setMeans(List<String> means) {
                                this.means = means;
                            }
                        }
                    }
                }
            }
        }
    }

    public static class ChineseBean implements  Serializable {
        /**
         * ci : {"id":"83711","ciyu":"你好","pinxie":"nihao","pinyin":"nǐ hǎo","jieshi":"","goucheng":"","tongyi":"","fanyi":"","tongyin":"","liju":"","zi":"你","zid":"4383","ciyi":""}
         */

        private CiBean ci;

        public CiBean getCi() {
            return ci;
        }

        public void setCi(CiBean ci) {
            this.ci = ci;
        }

        public static class CiBean implements Serializable{
            /**
             * id : 83711
             * ciyu : 你好
             * pinxie : nihao
             * pinyin : nǐ hǎo
             * jieshi :
             * goucheng :
             * tongyi :
             * fanyi :
             * tongyin :
             * liju :
             * zi : 你
             * zid : 4383
             * ciyi :
             */

            private String id;
            private String ciyu;
            private String pinxie;
            private String pinyin;
            private String jieshi;
            private String goucheng;
            private String tongyi;
            private String fanyi;
            private String tongyin;
            private String liju;
            private String zi;
            private String zid;
            private String ciyi;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getCiyu() {
                return ciyu;
            }

            public void setCiyu(String ciyu) {
                this.ciyu = ciyu;
            }

            public String getPinxie() {
                return pinxie;
            }

            public void setPinxie(String pinxie) {
                this.pinxie = pinxie;
            }

            public String getPinyin() {
                return pinyin;
            }

            public void setPinyin(String pinyin) {
                this.pinyin = pinyin;
            }

            public String getJieshi() {
                return jieshi;
            }

            public void setJieshi(String jieshi) {
                this.jieshi = jieshi;
            }

            public String getGoucheng() {
                return goucheng;
            }

            public void setGoucheng(String goucheng) {
                this.goucheng = goucheng;
            }

            public String getTongyi() {
                return tongyi;
            }

            public void setTongyi(String tongyi) {
                this.tongyi = tongyi;
            }

            public String getFanyi() {
                return fanyi;
            }

            public void setFanyi(String fanyi) {
                this.fanyi = fanyi;
            }

            public String getTongyin() {
                return tongyin;
            }

            public void setTongyin(String tongyin) {
                this.tongyin = tongyin;
            }

            public String getLiju() {
                return liju;
            }

            public void setLiju(String liju) {
                this.liju = liju;
            }

            public String getZi() {
                return zi;
            }

            public void setZi(String zi) {
                this.zi = zi;
            }

            public String getZid() {
                return zid;
            }

            public void setZid(String zid) {
                this.zid = zid;
            }

            public String getCiyi() {
                return ciyi;
            }

            public void setCiyi(String ciyi) {
                this.ciyi = ciyi;
            }
        }
    }

    public static class ErrWordsBean implements Serializable{
        /**
         * word_name : How do you do
         * means : ["你好"]
         */

        private String word_name;
        private List<String> means;

        public String getWord_name() {
            return word_name;
        }

        public void setWord_name(String word_name) {
            this.word_name = word_name;
        }

        public List<String> getMeans() {
            return means;
        }

        public void setMeans(List<String> means) {
            this.means = means;
        }
    }

    public static class SentenceBean implements Serializable{
        /**
         * Network_id : 2319702
         * Network_en : Good day to you, Bernard! It's a positive delight to see you.
         * Network_cn : 你好，伯纳德！见到你真高兴。
         * tts_mp3 : http://res-tts.iciba.com/tts_new_dj//5/7/e/57efeb4456e4f66dfe9aed84d597357e.mp3
         * tts_size : 21K
         * source_type : 0
         * source_id : 0
         * source_title : 普通双语例句
         */

        private String Network_id;
        private String Network_en;
        private String Network_cn;
        private String tts_mp3;
        private String tts_size;
        private int source_type;
        private int source_id;
        private String source_title;

        public String getNetwork_id() {
            return Network_id;
        }

        public void setNetwork_id(String Network_id) {
            this.Network_id = Network_id;
        }

        public String getNetwork_en() {
            return Network_en;
        }

        public void setNetwork_en(String Network_en) {
            this.Network_en = Network_en;
        }

        public String getNetwork_cn() {
            return Network_cn;
        }

        public void setNetwork_cn(String Network_cn) {
            this.Network_cn = Network_cn;
        }

        public String getTts_mp3() {
            return tts_mp3;
        }

        public void setTts_mp3(String tts_mp3) {
            this.tts_mp3 = tts_mp3;
        }

        public String getTts_size() {
            return tts_size;
        }

        public void setTts_size(String tts_size) {
            this.tts_size = tts_size;
        }

        public int getSource_type() {
            return source_type;
        }

        public void setSource_type(int source_type) {
            this.source_type = source_type;
        }

        public int getSource_id() {
            return source_id;
        }

        public void setSource_id(int source_id) {
            this.source_id = source_id;
        }

        public String getSource_title() {
            return source_title;
        }

        public void setSource_title(String source_title) {
            this.source_title = source_title;
        }
    }

    public static class SynthesizeBean implements Serializable{
        /**
         * symbol_id : 11714
         * word_id : 11638
         * word_symbol : nǐ hǎo
         * xg :
         * parts : [{"means":[{"mean_id":"12614","part_id":"","cy_id":"11478","word_mean":"how do you do; how are you; hello"}]}]
         */

        private String symbol_id;
        private String word_id;
        private String word_symbol;
        private String xg;
        private List<PartsBeanXX> parts;

        public String getSymbol_id() {
            return symbol_id;
        }

        public void setSymbol_id(String symbol_id) {
            this.symbol_id = symbol_id;
        }

        public String getWord_id() {
            return word_id;
        }

        public void setWord_id(String word_id) {
            this.word_id = word_id;
        }

        public String getWord_symbol() {
            return word_symbol;
        }

        public void setWord_symbol(String word_symbol) {
            this.word_symbol = word_symbol;
        }

        public String getXg() {
            return xg;
        }

        public void setXg(String xg) {
            this.xg = xg;
        }

        public List<PartsBeanXX> getParts() {
            return parts;
        }

        public void setParts(List<PartsBeanXX> parts) {
            this.parts = parts;
        }

        public static class PartsBeanXX implements Serializable {
            private List<MeansBean> means;

            public List<MeansBean> getMeans() {
                return means;
            }

            public void setMeans(List<MeansBean> means) {
                this.means = means;
            }

            public static class MeansBean implements Serializable{
                /**
                 * mean_id : 12614
                 * part_id :
                 * cy_id : 11478
                 * word_mean : how do you do; how are you; hello
                 */

                private String mean_id;
                private String part_id;
                private String cy_id;
                private String word_mean;

                public String getMean_id() {
                    return mean_id;
                }

                public void setMean_id(String mean_id) {
                    this.mean_id = mean_id;
                }

                public String getPart_id() {
                    return part_id;
                }

                public void setPart_id(String part_id) {
                    this.part_id = part_id;
                }

                public String getCy_id() {
                    return cy_id;
                }

                public void setCy_id(String cy_id) {
                    this.cy_id = cy_id;
                }

                public String getWord_mean() {
                    return word_mean;
                }

                public void setWord_mean(String word_mean) {
                    this.word_mean = word_mean;
                }
            }
        }
    }
}
