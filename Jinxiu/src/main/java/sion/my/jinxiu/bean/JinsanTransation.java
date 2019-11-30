package sion.my.jinxiu.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * 作者： 梁浩文, 日期： 2019/10/2.
 * 让代码更加美观
 */
public class JinsanTransation implements Serializable {


    /**
     * errno : 0
     * errmsg : success
     * baesInfo : {"word_name":"open","is_CRI":"1","exchange":{"word_pl":[],"word_third":["opens"],"word_past":["opened"],"word_done":["opened"],"word_ing":["opening"],"word_er":[],"word_est":[],"word_prep":[],"word_adv":[],"word_verb":[],"word_noun":[],"word_adj":[],"word_conn":[]},"symbols":[{"ph_en":"ˈəʊpən","ph_am":"ˈoʊpən","ph_other":"","ph_en_mp3":"http://res.iciba.com/resource/amp3/oxford/0/6e/67/6e6767f6e4aef49f4345582c9b40cbea.mp3","ph_am_mp3":"http://res.iciba.com/resource/amp3/1/0/7c/ef/7cef8a734855777c2a9d0caf42666e69.mp3","ph_tts_mp3":"http://res-tts.iciba.com/7/c/e/7cef8a734855777c2a9d0caf42666e69.mp3","parts":[{"part":"adj.","means":["敞开的，开着的","公开的，公共的","坦率的","有议论余地的"]},{"part":"vt.& vi.","means":["（打）开","开始","睁开","启动"]},{"part":"n.","means":["户外，野外","空旷","公开"]},{"part":"vi.","means":["使打开","展示，显现"]},{"part":"vt.","means":["张开","开放","开张营业","为（建筑物）揭幕"]}],"ph_en_mp3_bk":"http://res.ksyun.iciba.com/resource/amp3/oxford/0/6e/67/6e6767f6e4aef49f4345582c9b40cbea.mp3","ph_am_mp3_bk":"http://res.ksyun.iciba.com/resource/amp3/1/0/7c/ef/7cef8a734855777c2a9d0caf42666e69.mp3","ph_tts_mp3_bk":"http://res-tts.ksyun.iciba.com/7/c/e/7cef8a734855777c2a9d0caf42666e69.mp3"}],"frequence":5,"word_tag":[0,1,2],"translate_type":1}
     * err_words : [{"word_name":"OPEN","means":["Olympic public electronic network 奥林匹克公用电子网","open platform exchange network 开放式平台交换网络","optical Pan European network 泛欧光网络"]},{"word_name":"OPen","means":["Olympic Peninsula 奥林匹亚半岛"]}]
     * sameAnalysis : [{"part_name":"这些形容词都有\"空的\"之意。","word_list":"empty, vacant, hollow, blank, open","means":["empty ： 指空无一人或一物，或空洞无意义的。","vacant ： 普通用词，侧重某物或某个位置没有被占用。","hollow ： 指物体中间是空的。","blank ： 指上面没有写字、印刷或做记号的空白表面，或指上面留着准备被填写的空白处。","open ： 指未被占有，从而可被别人得到的。"]},{"part_name":"这些形容词都有\"坦率，诚实\"之意。","word_list":"frank, open, plain, blunt, honest, sincere, straightforward","means":["frank ： 强调毫无保留地畅所欲言，不受任何约束。","open ： 指不隐瞒自己的秘密，愿意向他人表露自己或公开暴露自己的缺点。","plain ： 指直言不讳，毫不做作或故弄玄虚。","blunt ： 指讲话坦白直率、不客气，但隐含不得体、不顾及他人感情等意味。","honest ： 指遵守正直等道德准则。","sincere ： 侧重指一个人出自内心地对某人某事表示一种诚意。","straightforward ： 多用于答复、叙述等场合。指直截了当，不回避，或故弄玄虚。"]},{"part_name":"这两个动词均有\"打开\"之意。","word_list":"unfold, open","means":["unfold ： 主要指把原来包好、卷好或叠好的东西再打开。","open ： 普通用词，指把原来关起来或盖紧的东西打开。"]}]
     * trade_means : [{"word_trade":"体育","word_mean":["自由式","展开","首攻","开叫","公开","开室","开放面","无人拦网","扣空网球","没有被对手严密防守的","对参加者没有严格限制的","前脚比后脚离击球路线较远的"]},{"word_trade":"医学","word_mean":["开放的：暴露于空气中的没有完整皮肤覆盖的","断路的：电路切断，电流不能通过的","开通的：没有闭塞、阻塞或关闭的"]},{"word_trade":"土木工程","word_mean":["开式热水热网","open-type hot-water heat-supply  network","透空式码头","open-type wharf","透空式防波堤","open-type breakwater, permeable  breakwater"]},{"word_trade":"大气科学","word_mean":["开口型细胞状云","［cloud］ cells 中间无云或少云, 四周有云, 云型呈指环状或\u201cU\u201d字型的细胞状云体。"]},{"word_trade":"机械","word_mean":["开［关］启装置","open-initiate system 使天平横梁和吊架升高和下降的装置。","开环控制","open-loop control 输出变量不持久，影响系统本身具有的控制作用的控制。"]},{"word_trade":"法律","word_mean":["不记名提单","未完成的","公开"]},{"word_trade":"物理学","word_mean":["开端几何位形","open-ended geometry"]},{"word_trade":"电力","word_mean":["开路阻抗矩阵","open-circuit impedance matrix","非全相运行","open-phase running  又称\u201c断相运行\u201d。"]}]
     * sentence : [{"Network_id":"2303764","Network_en":"The action is an open violation of the Vienna Convention.","Network_cn":"该行为公然违背了《维也纳公约》。","tts_mp3":"http://res-tts.iciba.com/tts_new_dj//e/0/4/e041ba6b89c72fa04d1fec8e313ef390.mp3","tts_size":"17K","source_type":0,"source_id":0,"source_title":"普通双语例句"},{"Network_id":"2306648","Network_en":"Don't leave a child alone in a room with an open fire.","Network_cn":"房间里有裸露的明火时，不要让孩子独处其中。","tts_mp3":"http://res-tts.iciba.com/tts_new_dj//6/7/b/67b8163c72cca34096d2035acdf50aac.mp3","tts_size":"15K","source_type":0,"source_id":0,"source_title":"普通双语例句"},{"Network_id":"2308252","Network_en":"Rachel burst out as the door was flung open again.","Network_cn":"当门被再次猛地推开时，雷切尔冲了出去。","tts_mp3":"http://res-tts.iciba.com/tts_new_dj//d/9/c/d9ce1ecb899b4a35a65733cac6b2f828.mp3","tts_size":"15K","source_type":0,"source_id":0,"source_title":"普通双语例句"}]
     * phrase : [{"cizu_name":"open up","jx":[{"jx_en_mean":"To spread out; unfold","jx_cn_mean":"展开；摊开","lj":[{"lj_ly":"A green valley opened up before us.","lj_ls":"青翠的山谷展现在我们眼前"}]},{"jx_en_mean":"To begin operation","jx_cn_mean":"开战；开火","lj":[{"lj_ly":"The new store opens up next month.","lj_ls":"这家新商店将在下个月开张"},{"lj_ly":"The artillery opened up at dawn.","lj_ls":"炮兵于拂晓时开口"}]},{"jx_en_mean":"&I{Informal} To speak freely and candidly","jx_cn_mean":"【非正式用语】 直言不讳","lj":[{"lj_ly":"At last the frightened witness opened up and told the truth.","lj_ls":"这名吓坏了的目击者终于直言不讳说出了事实"}]},{"jx_en_mean":"To make an opening in by cutting","jx_cn_mean":"切开","lj":[{"lj_ly":"The surgeon opened up the patient's chest.","lj_ls":"这名外科医生切开了病人的胸部"}]},{"jx_en_mean":"To make available or accessible","jx_cn_mean":"使可利用；使通往","lj":[{"lj_ly":"open up new markets.","lj_ls":"打开了新的市场"}]},{"jx_en_mean":"&I{Informal} To accelerate. Used of a motor vehicle.","jx_cn_mean":"【非正式用语】 （用于汽车）加速","lj":[]}]},{"cizu_name":"be open with","jx":[{"jx_en_mean":"speak frankly to; conceal nothing from","jx_cn_mean":"坦率直言","lj":[{"lj_ly":"I had always been completely open with my mother.","lj_ls":"我一直在妈妈面前知无不言。"}]}]},{"cizu_name":"in (或 into) the open","jx":[{"jx_en_mean":"out of doors; not under cover","jx_cn_mean":"户外","lj":[]}]},{"cizu_name":"in open court","jx":[{"jx_en_mean":"in a court of law, before the judge and the public","jx_cn_mean":"在法庭上（面对法官和群众）","lj":[]}]},{"cizu_name":"open-and-shut","jx":[{"jx_en_mean":"(of a case or argument) admitting no doubt or dispute; straightforward","jx_cn_mean":"（案件或争论）一目了然的","lj":[]}]},{"cizu_name":"open the batting","jx":[{"jx_en_mean":"(Cricket)play as one of the pair of batsmen who begin a side's innings","jx_cn_mean":"(板球)开球","lj":[]}]},{"cizu_name":"open the door to","jx":[]},{"cizu_name":"open someone's eyes","jx":[]},{"cizu_name":"an open mind","jx":[]},{"cizu_name":"with one's eyes open (或with open eyes)","jx":[{"jx_en_mean":"fully aware of the risks and other implications of an action or situation","jx_cn_mean":"睁大眼睛（充分认识到风险）","lj":[{"lj_ly":"I went into the job with my eyes open\u2014everyone knows what happens to an unsuccessful manager.","lj_ls":"我睁大眼睛开始了工作\u2014\u2014每个人都知道失败的经理会有什么下场。"}]}]},{"cizu_name":"with open arms","jx":[{"jx_en_mean":"","jx_cn_mean":"","lj":[{"lj_ly":"I went into the job with my eyes open\u2014everyone knows what happens to an unsuccessful manager.","lj_ls":"我睁大眼睛开始了工作\u2014\u2014每个人都知道失败的经理会有什么下场。"}]}]},{"cizu_name":"open something up","jx":[{"jx_en_mean":"accelerate a motor vehicle","jx_cn_mean":"加速（机车）","lj":[]},{"jx_en_mean":"(of a sports player or team) create an advantage for one's side","jx_cn_mean":"（运动员，运动队）取得本方的领先","lj":[{"lj_ly":"he opened up a lead of 14\u20138.","lj_ls":"他开了个好头，以14比8领先。"}]}]},{"jx":[{"jx_en_mean":"To begin firing on.","jx_cn_mean":"开火","lj":[]}],"cizu_name":"open fire"},{"jx":[{"jx_en_mean":"To become aware of the truth of a situation.","jx_cn_mean":"使看清事实真相","lj":[]}],"cizu_name":"open (one's) eyes"}]
     * synonym : [{"part_name":"vt.","means":[{"word_mean":"使露出,使显露","cis":["show","disclose","bare","expose","reveal","uncover"]},{"word_mean":"开始","cis":["begin","establish","start","unfold","originate","launch","initiate"]}]},{"part_name":"","means":[{"word_mean":"其他释义","cis":["unoccupied","vulnerable","demonstrative","uncover","ajar","propose","susceptible","expansive","originate","approachable","unlock","shell","high-minded","visible","start","conversable","ingenuous","reveal","show","accessible","honest","contingent","single","expose","begin","broaden","unfasten","unveil","flagrant","void","patent","clear","conversational","naive","free","crack","aboveboard","establish","initiate","off","manifest","launch","frank","straight","unfold","bald","disclose","straightforward","communicative","aesthetic","bare"]}]}]
     * antonym : [{"part_name":"vt.","means":[{"word_mean":"打开;翻开","cis":["shut","close"]}]},{"part_name":"","means":[{"word_mean":"其他释义","cis":["end","secret","close","shut"]}]}]
     * derivation : [{"yuyuan_name":"Old English open (adjective), openian (verb), of Germanic origin; related to Dutch open and German offen, from the root of the adverb up"}]
     * collins : [{"entry":[{"posp":"V-ERG","tran":"打开（门、窗、盖等）","def":"If you open something such as a door, window, or lid, or if it opens, its position is changed so that it no longer covers a hole or gap.","example":[{"ex":"He opened the window and looked out...","tran":"他打开窗户往外看。","tts_mp3":"http://res-tts.iciba.com/tts_dj/0/9/0/090496829e9a42a983cc30902702087a.mp3","tts_size":"10K"},{"ex":"The church doors would open and the crowd would surge out.","tran":"教堂的门会打开，人群会蜂拥而出。","tts_mp3":"http://res-tts.iciba.com/tts_dj/b/e/0/be0baa942eb60748899bba7cd2e29b37.mp3","tts_size":"15K"}]},{"posp":"VERB","tran":"将（瓶、盒等）开封；拆开（包裹、信封等）","def":"If you open something such as a bottle, box, parcel, or envelope, you move, remove, or cut part of it so you can take out what is inside.","example":[{"ex":"The Inspector opened the packet of cigarettes...","tran":"检查员撕开了那包香烟。","tts_mp3":"http://res-tts.iciba.com/tts_dj/f/2/b/f2bc33e49e965d28dbbe873ecc75997c.mp3","tts_size":"14K"},{"ex":"The capsules are fiddly to open.","tran":"这些胶囊得小心翼翼地打开。","tts_mp3":"http://res-tts.iciba.com/tts_dj/0/f/5/0f510ad33e99061495d92a932a2ab9c6.mp3","tts_size":"11K"}]},{"posp":"V-ERG","tran":"翻开；张开；展开","def":"If you open something such as a book, an umbrella, or your hand, or if it opens, the different parts of it move away from each other so that the inside of it can be seen.","example":[{"ex":"He opened the heavy Bible...","tran":"他翻开那本厚厚的《圣经》。","tts_mp3":"http://res-tts.iciba.com/tts_dj/f/0/a/f0a8c955fa1e5a12d6a2b56d332b70d8.mp3","tts_size":"8K"},{"ex":"She opens her umbrella, and walks up River Street...","tran":"她撑开伞，沿着河街向前走。","tts_mp3":"http://res-tts.iciba.com/tts_dj/f/d/e/fde58acd62f8e87fb0e6026ef72c1a84.mp3","tts_size":"16K"}]},{"posp":"VERB","tran":"打开（计算机文件）","def":"If you open a computer file, you give the computer an instruction to display it on the screen.","example":[{"ex":"Double click on the icon to open the file.","tran":"双击图标打开文件。","tts_mp3":"http://res-tts.iciba.com/tts_dj/8/1/d/81df79174bc0182f9ce1fce59d1c1b3d.mp3","tts_size":"13K"}]},{"posp":"V-ERG","tran":"（使)(眼睛）睁开","def":"When you open your eyes or your eyes open, you move your eyelids upwards, for example when you wake up, so that you can see.","example":[{"ex":"When I opened my eyes I saw a man with an axe standing at the end of my bed...","tran":"我睁开眼睛时，看见一个手持斧头的男人站在床尾。","tts_mp3":"http://res-tts.iciba.com/tts_dj/d/4/a/d4a0fd15f401f65304276db2d39f9794.mp3","tts_size":"21K"},{"ex":"His eyes were opening wide.","tran":"他双眼圆睁。","tts_mp3":"http://res-tts.iciba.com/tts_dj/e/d/4/ed431a33562d583b4b7703942117e968.mp3","tts_size":"9K"}]},{"posp":"VERB","tran":"敞开（双臂）","def":"If you open your arms, you stretch them wide apart in front of you, usually in order to put them round someone.","example":[{"ex":"She opened her arms and gave me a big hug.","tran":"她张开双臂，紧紧地拥抱了我。","tts_mp3":"http://res-tts.iciba.com/tts_dj/7/0/3/7031a119fe6be1bf9f4d6e73346bbe57.mp3","tts_size":"13K"}]},{"posp":"ADJ-GRADED","tran":"（身前）无遮挡的；（姿势）端正的","def":"If you stand or sit in an open way, the front of your body is fully exposed and you are not bending forward or at an angle to someone.","example":[{"ex":"Good listeners even sit in an open way: relaxed, arms loose...","tran":"善于倾听的人甚至坐姿也很坦荡端正：身体放松，双臂自然下垂。","tts_mp3":"http://res-tts.iciba.com/tts_dj/a/8/6/a86fe522cc9e6b4aa30528e4a2832e6e.mp3","tts_size":"22K"},{"ex":"I play normal bunker shots with an open stance.","tran":"我打一般的沙坑球采取开立击球姿势。","tts_mp3":"http://res-tts.iciba.com/tts_dj/5/1/0/510c896e657973a52092fbdf63e4cb51.mp3","tts_size":"15K"}]},{"posp":"ADJ-GRADED","tran":"坦率的；诚恳的；不作伪的","def":"If you describe a person or their character as open, you mean they are honest and do not want or try to hide anything or to deceive anyone.","example":[{"ex":"He had always been open with her and she always felt she would know if he lied...","tran":"他对她总是坦诚相待，她也一直觉得如果他说谎，自己一定能察觉。","tts_mp3":"http://res-tts.iciba.com/tts_dj/1/0/4/104564322cc2df5cfe94bd358bfc09df.mp3","tts_size":"20K"},{"ex":"She has an open, trusting nature.","tran":"她天性坦诚，对人信赖。","tts_mp3":"http://res-tts.iciba.com/tts_dj/2/1/b/21bdfa8a8e2ac88d45fce191bf194f1d.mp3","tts_size":"12K"}]},{"posp":"ADJ","tran":"公开的；不加掩饰的","def":"If you describe a situation, attitude, or way of behaving as open, you mean it is not kept hidden or secret.","example":[{"ex":"The action is an open violation of the Vienna Convention...","tran":"该行为公然违背了《维也纳公约》。","tts_mp3":"http://res-tts.iciba.com/tts_dj/1/4/1/1419f662a933738502c18242b03d5500.mp3","tts_size":"17K"},{"ex":"Hearing the case in open court is only one part of the judicial process.","tran":"公开审理这一案件只是司法程序的一部分。","tts_mp3":"http://res-tts.iciba.com/tts_dj/2/0/2/202d75833900b890eafd7a6efa04880b.mp3","tts_size":"20K"}]},{"posp":"ADJ-GRADED","tran":"愿意接受（建议、观点等）的；虚怀若谷的","def":"If you are open to suggestions or ideas, you are ready and willing to consider or accept them.","example":[{"ex":"They are open to suggestions on how working conditions might be improved.","tran":"他们愿意就如何改善工作条件听取各种意见。","tts_mp3":"http://res-tts.iciba.com/tts_dj/2/5/2/2526fabb339153db5f29455391877cce.mp3","tts_size":"21K"}]},{"posp":"ADJ","tran":"容易招致（滥用、批评等）的；易受（攻击）的","def":"If you say that a system, person, or idea is open to something such as abuse or criticism, you mean they might receive abuse or criticism because of their qualities, effects, or actions.","example":[{"ex":"The system, though well-meaning, is open to abuse...","tran":"该制度动机虽好，却易遭滥用。","tts_mp3":"http://res-tts.iciba.com/tts_dj/c/8/8/c888965a993bdca73f1bfb53c3c076d3.mp3","tts_size":"17K"},{"ex":"They left themselves wide open to accusations of double standards and hypocrisy.","tran":"他们使自己陷于被人指责搞双重标准和虚伪不实的境地。","tts_mp3":"http://res-tts.iciba.com/tts_dj/1/5/2/152cb7404b934345e4378396984a8dbb.mp3","tts_size":"24K"}]},{"posp":"ADJ","tran":"悬而未决的；尚未决定的","def":"If you say that a fact or question is open to debate, interpretation, or discussion, you mean that people are uncertain whether it is true, what it means, or what the answer is.","example":[{"ex":"The truth of the facts produced may be open to doubt...","tran":"所摆出事实的真实性仍然值得怀疑。","tts_mp3":"http://res-tts.iciba.com/tts_dj/0/b/5/0b5412f511e4915aeca2d1103dfe00fa.mp3","tts_size":"15K"},{"ex":"It is an open question how long that commitment can last.","tran":"这一承诺能维持多久还不确定。","tts_mp3":"http://res-tts.iciba.com/tts_dj/e/d/9/ed9bbc94562c19f4a047393fb6c22b0e.mp3","tts_size":"16K"}]},{"posp":"V-ERG","tran":"开放（被封的道路、边界等）；开通","def":"If people open something such as a blocked road or a border, or if it opens, people can then pass along it or through it.","example":[{"ex":"The rebels have opened the road from Monrovia to the Ivory Coast...","tran":"叛乱分子已经开放了从蒙罗维亚到象牙海岸的道路。","tts_mp3":"http://res-tts.iciba.com/tts_dj/3/5/5/355839fdfac81fc3493475b994e08ef4.mp3","tts_size":"19K"},{"ex":"The solid rank of police officers lining the courtroom opened to let them pass.","tran":"把法庭围得水泄不通的一队警察让开一条路让他们通过。","tts_mp3":"http://res-tts.iciba.com/tts_dj/d/d/9/dd9e0acb4e7fda7c8ea3a27f26d5a966.mp3","tts_size":"22K"}]},{"posp":"VERB","tran":"通向（更大的地方）","def":"If a place opens into another, larger place, you can move from one directly into the other.","example":[{"ex":"The corridor opened into a low smoky room.","tran":"这条走廊通向一间烟雾弥漫的低矮房间。","tts_mp3":"http://res-tts.iciba.com/tts_dj/8/c/2/8c2784d8cbbe4d665f322e348b5c0d50.mp3","tts_size":"14K"}]},{"posp":"ADJ","tran":"开阔的；空旷的","def":"An open area is a large area that does not have many buildings or trees in it.","example":[{"ex":"Officers will also continue their search of nearby open ground.","tran":"警察还将继续在附近的开阔地带搜寻。","tts_mp3":"http://res-tts.iciba.com/tts_dj/e/7/1/e71774c2dd6da0130f310b6216a89950.mp3","tts_size":"19K"}]},{"posp":"ADJ","tran":"敞开的；无遮盖的；无围挡的","def":"An open structure or object is not covered or enclosed.","example":[{"ex":"Don't leave a child alone in a room with an open fire.","tran":"房间里有裸露的明火时，不要让孩子独处其中。","tts_mp3":"http://res-tts.iciba.com/tts_dj/6/7/b/67b8163c72cca34096d2035acdf50aac.mp3","tts_size":"15K"},{"ex":"...open sandwiches.","tran":"单片三明治","tts_mp3":"http://res-tts.iciba.com/tts_dj/6/0/5/605cc15062f64fd70f90abf2afe685de.mp3","tts_size":"7K"}]},{"posp":"ADJ","tran":"（伤口）外露的，裸露的，流血的","def":"An open wound is one from which a liquid such as blood is coming.","example":[]},{"posp":"VERB","tran":"把（衣服）解开；把\u2026的拉链拉开","def":"If you open your shirt or coat, you undo the buttons or pull down the zip.","example":[{"ex":"I opened my coat and let him see the belt.","tran":"我解开外衣，让他看那条皮带。","tts_mp3":"http://res-tts.iciba.com/tts_dj/f/c/1/fc12aa800bd5820b7f9078bb995a1203.mp3","tts_size":"13K"}]},{"posp":"V-ERG","tran":"（使）开始营业；（使）开门","def":"When a shop, office, or public building opens or is opened, its doors are unlocked and the public can go in.","example":[{"ex":"Banks closed on Friday afternoon and did not open again until Monday morning.","tran":"银行星期五下午关门，直到星期一上午才营业。","tts_mp3":"http://res-tts.iciba.com/tts_dj/0/6/5/0656b7301bde0886bd79f969f428e0a0.mp3","tts_size":"22K"},{"ex":"...a gang of three who'd apparently been lying in wait for him to open the shop.","tran":"显然一直潜伏着等待他打开店门营业的3人团伙","tts_mp3":"http://res-tts.iciba.com/tts_dj/a/a/0/aa02a564c587a9272ae7a5d159d61e9b.mp3","tts_size":"19K"}]},{"posp":"V-ERG","tran":"为（大楼、工厂、公司等）举行揭幕典礼；开设；开办；开张","def":"When a public building, factory, or company opens or when someone opens it, it starts operating for the first time.","example":[{"ex":"The original station opened in 1754...","tran":"最初的车站于1754年落成。","tts_mp3":"http://res-tts.iciba.com/tts_dj/6/6/7/6673a611703f99e8d0f9963ab26a04c0.mp3","tts_size":"16K"},{"ex":"The complex opens to the public tomorrow...","tran":"这幢综合大楼将于明天对公众开放。","tts_mp3":"http://res-tts.iciba.com/tts_dj/7/e/a/7eaeda3573d3ee8b4a9e8ae11962b871.mp3","tts_size":"13K"}]},{"posp":"V-ERG","tran":"（使）（会议、会谈）开始；召开","def":"If something such as a meeting or series of talks opens, or if someone opens it, it begins.","example":[{"ex":"...an emergency session of the Russian Parliament due to open later this morning...","tran":"将于今天上午晚些时候召开的俄罗斯议会紧急会议","tts_mp3":"http://res-tts.iciba.com/tts_dj/c/9/d/c9dd8c5423a69a63801f9a2ace0be6de.mp3","tts_size":"22K"},{"ex":"They are now ready to open negotiations.","tran":"他们现在已经准备好开始谈判。","tts_mp3":"http://res-tts.iciba.com/tts_dj/8/5/f/85f69fc82c467a1e0ce7dd4d3f6828f8.mp3","tts_size":"13K"}]},{"posp":"V-ERG","tran":"（以\u2026）开始","def":"If an event such as a meeting or discussion opens with a particular activity or if a particular activity opens an event, that activity is the first thing that happens or is dealt with. You can also say that someone such as a speaker or singer opens by doing a particular thing.","example":[{"ex":"The service opened with a hymn...","tran":"礼拜仪式从唱圣歌开始。","tts_mp3":"http://res-tts.iciba.com/tts_dj/d/1/8/d186c8bd49f14d97f904f5cd345ad106.mp3","tts_size":"9K"},{"ex":"She opened with an impressive version of 'I Still Haven't Found What I'm Looking For'...","tran":"她以一首优美动人的《我仍在寻找》开场。","tts_mp3":"http://res-tts.iciba.com/tts_dj/e/d/3/ed3e596055254a024e437603463de010.mp3","tts_size":"21K"}]},{"posp":"VERB","tran":"（股市）开盘，开市","def":"On the stock exchange, the price at which currencies, shares, or commodities open is their value at the start of that day's trading.","example":[{"ex":"Gold declined $2 in Zurich to open at 385.50...","tran":"苏黎世的金价下挫2美元，以385.50元开盘。","tts_mp3":"http://res-tts.iciba.com/tts_dj/3/d/7/3d71d20b1617fa4fb0767def578f8400.mp3","tts_size":"26K"},{"ex":"In Paris and Milan, the dollar opened almost unchanged.","tran":"在巴黎和米兰，美元开市时几乎没有变化。","tts_mp3":"http://res-tts.iciba.com/tts_dj/3/5/0/350c8012eb35b9bba697dc4e6e3eaf69.mp3","tts_size":"19K"}]},{"posp":"VERB","tran":"上映；开演；开幕","def":"When a film, play, or other public event opens, it begins to be shown, be performed, or take place for a limited period of time.","example":[{"ex":"A photographic exhibition opens at the Royal College of Art on Wednesday...","tran":"星期三一个摄影展在皇家艺术学院开幕。","tts_mp3":"http://res-tts.iciba.com/tts_dj/3/5/a/35ab901dc62f20c7f6d00ec727f52ee4.mp3","tts_size":"21K"},{"ex":"This show, too, was virtually sold out before it opened.","tran":"这场演出的门票也是几乎在开演前就销售一空了。","tts_mp3":"http://res-tts.iciba.com/tts_dj/7/f/1/7f196f2a63530fe4d1ec661e98b6c01d.mp3","tts_size":"18K"}]},{"posp":"VERB","tran":"（在银行等处）开立（账户）","def":"If you open an account with a bank or a commercial organization, you begin to use their services.","example":[{"ex":"He tried to open an account at the branch of his bank nearest to his workplace.","tran":"他想在自己银行离工作单位最近的网点开一个账户。","tts_mp3":"http://res-tts.iciba.com/tts_dj/c/c/d/ccdd4268ff07166f72f68fd4369c2ccb.mp3","tts_size":"23K"}]},{"posp":"ADJ","tran":"（机会、选择等）可利用的，可得到的","def":"If an opportunity or choice is open to you, you are able to do a particular thing if you choose to.","example":[{"ex":"There are a wide range of career opportunities open to young people.","tran":"年轻人有各种职业选择机会。","tts_mp3":"http://res-tts.iciba.com/tts_dj/9/8/8/988070323e1c6f9ad552a486b6b5416d.mp3","tts_size":"20K"}]},{"posp":"V-ERG","tran":"（使）（机会、可能性等）出现;（使）产生","def":"To open opportunities or possibilities means the same as to open them up.","example":[{"ex":"The chief of naval operations wants to open opportunities for women in the Navy...","tran":"美国海军作战部长希望能为女兵提供机会。","tts_mp3":"http://res-tts.iciba.com/tts_dj/d/0/f/d0f094fe2986c227f020c0284f0e8a53.mp3","tts_size":"24K"},{"ex":"A series of fortunate opportunities opened to him.","tran":"很多好机会陆续向他招手。","tts_mp3":"http://res-tts.iciba.com/tts_dj/3/2/7/327d9e9d08a7eecc84062bd92702ebe6.mp3","tts_size":"15K"}]},{"posp":"ADJ","tran":"人人可以参加（或接受）的；开放的","def":"You can use open to describe something that anyone is allowed to take part in or accept.","example":[{"ex":"A recent open meeting of College members revealed widespread dissatisfaction...","tran":"最近的一次学会成员公开会上，大家普遍流露出不满情绪。","tts_mp3":"http://res-tts.iciba.com/tts_dj/c/b/1/cb1808325d64a51bfe168bbb8877a360.mp3","tts_size":"23K"},{"ex":"A portfolio approach would keep entry into the managerial profession open and flexible.","tran":"项目组合的方法会使成为管理人员的机会公开灵活。","tts_mp3":"http://res-tts.iciba.com/tts_dj/2/d/c/2dcd24073bf5dcf4da4d1d3572a669ed.mp3","tts_size":"26K"}]},{"posp":"ADJ","tran":"（提议等）有效的；（职位等）空缺的，可申请的","def":"If something such as an offer or job is open, it is available for someone to accept or apply for.","example":[{"ex":"The offer will remain open until further notice.","tran":"该提议仍然有效，直到另行通知。","tts_mp3":"http://res-tts.iciba.com/tts_dj/f/1/a/f1a3d43063e14a3a6d7848215b073fe7.mp3","tts_size":"14K"}]},{"posp":"PHRASE","tran":"在露天；在户外；在野外","def":"If you do something in the open, you do it out of doors rather than in a house or other building.","example":[{"ex":"Many are sleeping in the open because they have no shelter.","tran":"很多人因为没有栖身之所，只好露宿在外。","tts_mp3":"http://res-tts.iciba.com/tts_dj/c/6/a/c6a15a80bb675ffff02c8115cebd965f.mp3","tts_size":"17K"}]},{"posp":"PHRASE","tran":"公开的；众人皆知的","def":"If an attitude or situation is in the open or out in the open, people know about it and it is no longer kept secret.","example":[{"ex":"The medical service had advised us to keep it a secret, but we wanted it in the open.","tran":"这家医疗机构建议我们保密，而我们却想公开此事。","tts_mp3":"http://res-tts.iciba.com/tts_dj/1/f/d/1fdb211f93f05d30a305d811a1ebe198.mp3","tts_size":"24K"}]},{"posp":"PHRASE","tran":"大开的；敞开的；（眼睛）睁大的","def":"If something is wide open, it is open to its full extent.","example":[{"ex":"The child had left the inner door wide open.","tran":"这个孩子将里面的门大敞着。","tts_mp3":"http://res-tts.iciba.com/tts_dj/b/f/1/bf1e36af73358373a5efe86feba32a7c.mp3","tts_size":"12K"}]},{"posp":"PHRASE","tran":"（比赛、选举等）结果不确定的，胜负难定的","def":"If you say that a competition, race, or election is wide open, you mean that anyone could win it, because there is no competitor who seems to be much better than the others.","example":[{"ex":"The competition has been thrown wide open by the absence of the world champion.","tran":"由于世界冠军缺阵，这场比赛变得胜负难定。","tts_mp3":"http://res-tts.iciba.com/tts_dj/4/1/1/4117f43c637c7fb0a6e980ed44419643.mp3","tts_size":"21K"}]}]}]
     * ee_mean : [{"part_name":"Noun","means":[{"word_mean":"1. a clear or unobstructed space or expanse of land or water;","sentences":[{"sentence":"\"finally broke out of the forest into the open\""}]},{"word_mean":"2. where the air is unconfined;","sentences":[{"sentence":"\"he wanted to get outdoors a little\""},{"sentence":"\"the concert was held in the open air\""},{"sentence":"\"camping in the open\""}]},{"word_mean":"3. a tournament in which both professionals and amateurs may play","sentences":[]},{"word_mean":"4. information that has become public;","sentences":[{"sentence":"\"all the reports were out in the open\""},{"sentence":"\"the facts had been brought to the surface\""}]}]},{"part_name":"Verb","means":[{"word_mean":"1. cause to open or to become open;","sentences":[{"sentence":"\"Mary opened the car door\""}]},{"word_mean":"2. start to operate or function or cause to start operating or functioning;","sentences":[{"sentence":"\"open a business\""}]},{"word_mean":"3. become open;","sentences":[{"sentence":"\"The door opened\""}]},{"word_mean":"4. begin or set in action, of meetings, speeches, recitals, etc.;","sentences":[{"sentence":"\"He opened the meeting with a long speech\""}]},{"word_mean":"5. spread out or open from a closed or folded state;","sentences":[{"sentence":"\"open the map\""},{"sentence":"\"spread your arms\""}]},{"word_mean":"6. make available;","sentences":[{"sentence":"\"This opens up new possibilities\""}]},{"word_mean":"7. become available;","sentences":[{"sentence":"\"an opportunity opened up\""}]},{"word_mean":"8. have an opening or passage or outlet;","sentences":[{"sentence":"\"The bedrooms open into the hall\""}]},{"word_mean":"9. make the opening move;","sentences":[{"sentence":"\"Kasparov opened with a standard opening\""}]},{"word_mean":"10. afford access to;","sentences":[{"sentence":"\"the door opens to the patio\""},{"sentence":"\"The French doors give onto a terrace\""}]},{"word_mean":"11. display the contents of a file or start an application as on a computer","sentences":[]}]},{"part_name":"Adjective","means":[{"word_mean":"1. affording unobstructed entrance and exit; not shut or closed;","sentences":[{"sentence":"\"an open door\""},{"sentence":"\"they left the door open\""}]},{"word_mean":"2. affording free passage or access;","sentences":[{"sentence":"\"open drains\""},{"sentence":"\"the road is open to traffic\""},{"sentence":"\"open ranks\""}]},{"word_mean":"3. with no protection or shield;","sentences":[{"sentence":"\"the exposed northeast frontier\""},{"sentence":"\"open to the weather\""},{"sentence":"\"an open wound\""}]},{"word_mean":"4. open to or in view of all;","sentences":[{"sentence":"\"an open protest\""},{"sentence":"\"an open letter to the editor\""}]},{"word_mean":"5. used of mouth or eyes;","sentences":[{"sentence":"\"keep your eyes open\""},{"sentence":"\"his mouth slightly opened\""}]},{"word_mean":"6. not having been filled;","sentences":[{"sentence":"\"the job is still open\""}]},{"word_mean":"7. accessible to all;","sentences":[{"sentence":"\"open season\""},{"sentence":"\"an open economy\""}]},{"word_mean":"8. not defended or capable of being defended;","sentences":[{"sentence":"\"an open city\""},{"sentence":"\"open to attack\""}]},{"word_mean":"9. (of textures) full of small openings or gaps;","sentences":[{"sentence":"\"an open texture\""},{"sentence":"\"a loose weave\""}]},{"word_mean":"10. having no protecting cover or enclosure;","sentences":[{"sentence":"\"an open boat\""},{"sentence":"\"an open fire\""},{"sentence":"\"open sports cars\""}]},{"word_mean":"11. opened out;","sentences":[{"sentence":"\"an open newspaper\""}]},{"word_mean":"12. of a set; containing points whose neighborhood consists of other points of the same set, or being the complement of an open set; of an interval; containing neither of its end points","sentences":[]},{"word_mean":"13. not brought to a conclusion; subject to further thought;","sentences":[{"sentence":"\"an open question\""},{"sentence":"\"our position on this bill is still undecided\""},{"sentence":"\"our lawsuit is still undetermined\""}]},{"word_mean":"14. not sealed or having been unsealed;","sentences":[{"sentence":"\"the letter was already open\""},{"sentence":"\"the opened package lay on the table\""}]},{"word_mean":"15. without undue constriction as from e.g. tenseness or inhibition;","sentences":[{"sentence":"\"the clarity and resonance of an open tone\""},{"sentence":"\"her natural and open response\""}]},{"word_mean":"16. relatively empty of and unobstructed by fences or hedges or headlands or shoals;","sentences":[{"sentence":"\"in open country\""},{"sentence":"\"the open countryside\""},{"sentence":"\"open waters\""},{"sentence":"\"on the open seas\""}]},{"word_mean":"17. open and observable; not secret or hidden;","sentences":[{"sentence":"\"an overt lie\""},{"sentence":"\"overt hostility\""},{"sentence":"\"overt intelligence gathering\""}]},{"word_mean":"18. used of string or hole or pipe of instruments","sentences":[]},{"word_mean":"19. not requiring union membership;","sentences":[{"sentence":"\"an open shop employs nonunion workers\""}]},{"word_mean":"20. possibly accepting or permitting;","sentences":[{"sentence":"\"a passage capable of misinterpretation\""},{"sentence":"\"open to interpretation\""},{"sentence":"\"an issue open to question\""},{"sentence":"\"the time is fixed by the director and players and therefore subject to much variation\""}]},{"word_mean":"21. not secret;","sentences":[{"sentence":"\"open plans\""},{"sentence":"\"an open ballot\""}]},{"word_mean":"22. without any attempt at concealment; completely obvious;","sentences":[{"sentence":"\"open disregard of the law\""},{"sentence":"\"open family strife\""},{"sentence":"\"open hostility\""},{"sentence":"\"a blatant appeal to vanity\""},{"sentence":"\"a blazing indiscretion\""}]},{"word_mean":"23. affording free passage or view;","sentences":[{"sentence":"\"a clear view\""},{"sentence":"\"a clear path to victory\""}]},{"word_mean":"24. lax in enforcing laws;","sentences":[{"sentence":"\"an open town\""}]},{"word_mean":"25. openly straightforward and direct without reserve or secretiveness;","sentences":[{"sentence":"\"his candid eyes\""},{"sentence":"\"an open and trusting nature\""},{"sentence":"\"a heart-to-heart talk\""}]},{"word_mean":"26. sincere and free of reserve in expression;","sentences":[{"sentence":"\"Please be open with me\""}]},{"word_mean":"27. receptive to new ideas;","sentences":[{"sentence":"\"an open mind\""},{"sentence":"\"open to new ideas\""}]},{"word_mean":"28. ready for business;","sentences":[{"sentence":"\"the stores are open\""}]}]}]
     * slang : [{"tokens":"open a can of beans","class":["美国俚语"],"list":[{"explanation":"惹祸","example":[{"en":"It was I who opened a can of beans.","zh":"是我惹的祸。"},{"en":"She was one of those people who like opening a can of beans.","zh":"她就是那种喜欢惹祸的人。"}]}],"type":"v "},{"tokens":"keep ones eyes open","class":["加拿大俚语","南非俚语","新西兰俚语","澳大利亚俚语","爱尔兰俚语","美国俚语","苏格兰俚语","英国俚语"],"list":[{"explanation":"留心，警觉，密切注意","example":[{"en":"It has kept my eyes open that the boy stutters.","zh":"我已注意到了，这男孩子说活口吃。"},{"en":"He's keeping an eye out for a more profitable job.","zh":"他正在留心找个更能赚钱的工作。"}]}],"type":"v "}]
     * abbreviation : [{"mean_en":"opening","mean_cn":"开口，孔，穴"}]
     * cetFour : {"word":"open","count":13,"kd":[],"Sentence":[{"sentence":"At the age of six she started reading the daily financial newspapers and opened her own bank account.","come":"出自-2014年6月听力原文"},{"sentence":"After swiping（敲击）into the iPad app (应用软件 ), which you can get for free here, he opens up a few different types of textbooks.","come":"出自-2013年6月阅读原文"},{"sentence":"Hotel owners found themselves with a huge number of empty rooms even as a lot of unnecessary new hotels were ready to open.","come":"出自-2013年6月阅读原文"}]}
     * cetSix : {"word":"open","count":14,"kd":[],"Sentence":[{"sentence":"Democrats and Republicans can and will take sides on a number of issues, but a more crucial concern is that both are basing major policy decisions on guesstimates rather than looking at the vast wealth of raw data with a critical eye and an open mind.","come":"出自-2013年6月阅读原文"},{"sentence":"I went there last Saturday for their grand opening sale, but I drove around the parking lot for nearly an hour, looking for a space before I finally gave up and came home","come":"出自-2013年6月听力原文"},{"sentence":"She attended the supermarket's grand opening ceremony","come":"出自-2013年6月听力原文"}]}
     * bidec : {"word_name":"open","parts":[{"part_name":"adj.","word_id":"23362","part_id":"30701","means":[{"word_mean":"开着的; 开放的, 公开的","part_id":"30701","mean_id":"58195","sentences":[{"en":"The outer door was wide open but the inner one was locked.","cn":"外面的门大开着而里面的门锁着。"},{"en":"They decided to declare Paris an open city.","cn":"他们决定宣布巴黎为不设防城市。"}]},{"word_mean":"空旷的; 开阔的","part_id":"30701","mean_id":"58196","sentences":[{"en":"An open sea appeared before us.","cn":"我们前面呈现出广阔的大海。"}]},{"word_mean":"坦率的, 无偏见的","part_id":"30701","mean_id":"58197","sentences":[{"en":"She is a very friendly, open person.","cn":"她是个非常友好、坦率的人。"}]},{"word_mean":"开始营业的; 活动的","part_id":"30701","mean_id":"58198","sentences":[{"en":"The bank isn't open yet.","cn":"那家银行还没有开门营业。"}]},{"word_mean":"(职位等)空缺的","part_id":"30701","mean_id":"58199","sentences":[{"en":"Is the teaching vacancy still open?","cn":"教员职位还有空缺吗?"}]},{"word_mean":"尚未决定的, 悬而未决的","part_id":"30701","mean_id":"58200","sentences":[{"en":"This is an open question at the moment.","cn":"此刻这还是个悬而未决的问题。"}]}]},{"part_name":"vt. & vi.","word_id":"23362","part_id":"30702","means":[{"word_mean":"开始; 开设","part_id":"30702","mean_id":"58215","sentences":[{"en":"The meeting will open the day after tomorrow.","cn":"这个会议将于后天开幕。"},{"en":"The chairman opened the Parliament.","cn":"主席宣布议会开始。"},{"en":"Negotiations would probably be opened again.","cn":"谈判可能又要开始。"}]}]}]}
     * traditional :
     * tik_word_info : {"is_have_video_info":0}
     * _word_flag : 1
     * exchanges : ["opens","opened","opened","opening","open"]
     */

    private int errno;
    private String errmsg;
    private BaesInfoBean baesInfo;
    private CetFourBean cetFour;
    private CetSixBean cetSix;
    private BidecBean bidec;
    private String traditional;
    private TikWordInfoBean tik_word_info;
    private int _word_flag;
    private List<ErrWordsBean> err_words;
    private List<SameAnalysisBean> sameAnalysis;
    private List<TradeMeansBean> trade_means;
    private List<SentenceBeanXX> sentence;
    private List<PhraseBean> phrase;
    private List<SynonymBean> synonym;
    private List<AntonymBean> antonym;
    private List<DerivationBean> derivation;
    private List<CollinsBean> collins;
    private List<EeMeanBean> ee_mean;
    private List<SlangBean> slang;
    private List<AbbreviationBean> abbreviation;
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

    public CetFourBean getCetFour() {
        return cetFour;
    }

    public void setCetFour(CetFourBean cetFour) {
        this.cetFour = cetFour;
    }

    public CetSixBean getCetSix() {
        return cetSix;
    }

    public void setCetSix(CetSixBean cetSix) {
        this.cetSix = cetSix;
    }

    public BidecBean getBidec() {
        return bidec;
    }

    public void setBidec(BidecBean bidec) {
        this.bidec = bidec;
    }

    public String getTraditional() {
        return traditional;
    }

    public void setTraditional(String traditional) {
        this.traditional = traditional;
    }

    public TikWordInfoBean getTik_word_info() {
        return tik_word_info;
    }

    public void setTik_word_info(TikWordInfoBean tik_word_info) {
        this.tik_word_info = tik_word_info;
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

    public List<SameAnalysisBean> getSameAnalysis() {
        return sameAnalysis;
    }

    public void setSameAnalysis(List<SameAnalysisBean> sameAnalysis) {
        this.sameAnalysis = sameAnalysis;
    }

    public List<TradeMeansBean> getTrade_means() {
        return trade_means;
    }

    public void setTrade_means(List<TradeMeansBean> trade_means) {
        this.trade_means = trade_means;
    }

    public List<SentenceBeanXX> getSentence() {
        return sentence;
    }

    public void setSentence(List<SentenceBeanXX> sentence) {
        this.sentence = sentence;
    }

    public List<PhraseBean> getPhrase() {
        return phrase;
    }

    public void setPhrase(List<PhraseBean> phrase) {
        this.phrase = phrase;
    }

    public List<SynonymBean> getSynonym() {
        return synonym;
    }

    public void setSynonym(List<SynonymBean> synonym) {
        this.synonym = synonym;
    }

    public List<AntonymBean> getAntonym() {
        return antonym;
    }

    public void setAntonym(List<AntonymBean> antonym) {
        this.antonym = antonym;
    }

    public List<DerivationBean> getDerivation() {
        return derivation;
    }

    public void setDerivation(List<DerivationBean> derivation) {
        this.derivation = derivation;
    }

    public List<CollinsBean> getCollins() {
        return collins;
    }

    public void setCollins(List<CollinsBean> collins) {
        this.collins = collins;
    }

    public List<EeMeanBean> getEe_mean() {
        return ee_mean;
    }

    public void setEe_mean(List<EeMeanBean> ee_mean) {
        this.ee_mean = ee_mean;
    }

    public List<SlangBean> getSlang() {
        return slang;
    }

    public void setSlang(List<SlangBean> slang) {
        this.slang = slang;
    }

    public List<AbbreviationBean> getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(List<AbbreviationBean> abbreviation) {
        this.abbreviation = abbreviation;
    }

    public List<String> getExchanges() {
        return exchanges;
    }

    public void setExchanges(List<String> exchanges) {
        this.exchanges = exchanges;
    }

    public static class BaesInfoBean implements Serializable {
        /**
         * word_name : open
         * is_CRI : 1
         * exchange : {"word_pl":[],"word_third":["opens"],"word_past":["opened"],"word_done":["opened"],"word_ing":["opening"],"word_er":[],"word_est":[],"word_prep":[],"word_adv":[],"word_verb":[],"word_noun":[],"word_adj":[],"word_conn":[]}
         * symbols : [{"ph_en":"ˈəʊpən","ph_am":"ˈoʊpən","ph_other":"","ph_en_mp3":"http://res.iciba.com/resource/amp3/oxford/0/6e/67/6e6767f6e4aef49f4345582c9b40cbea.mp3","ph_am_mp3":"http://res.iciba.com/resource/amp3/1/0/7c/ef/7cef8a734855777c2a9d0caf42666e69.mp3","ph_tts_mp3":"http://res-tts.iciba.com/7/c/e/7cef8a734855777c2a9d0caf42666e69.mp3","parts":[{"part":"adj.","means":["敞开的，开着的","公开的，公共的","坦率的","有议论余地的"]},{"part":"vt.& vi.","means":["（打）开","开始","睁开","启动"]},{"part":"n.","means":["户外，野外","空旷","公开"]},{"part":"vi.","means":["使打开","展示，显现"]},{"part":"vt.","means":["张开","开放","开张营业","为（建筑物）揭幕"]}],"ph_en_mp3_bk":"http://res.ksyun.iciba.com/resource/amp3/oxford/0/6e/67/6e6767f6e4aef49f4345582c9b40cbea.mp3","ph_am_mp3_bk":"http://res.ksyun.iciba.com/resource/amp3/1/0/7c/ef/7cef8a734855777c2a9d0caf42666e69.mp3","ph_tts_mp3_bk":"http://res-tts.ksyun.iciba.com/7/c/e/7cef8a734855777c2a9d0caf42666e69.mp3"}]
         * frequence : 5
         * word_tag : [0,1,2]
         * translate_type : 1
         */

        private String word_name;
        private String is_CRI;
        private ExchangeBean exchange;
        private int frequence;
        private int translate_type;
        private List<SymbolsBean> symbols;
        private List<Integer> word_tag;

        public String getWord_name() {
            return word_name;
        }

        public void setWord_name(String word_name) {
            this.word_name = word_name;
        }

        public String getIs_CRI() {
            return is_CRI;
        }

        public void setIs_CRI(String is_CRI) {
            this.is_CRI = is_CRI;
        }

        public ExchangeBean getExchange() {
            return exchange;
        }

        public void setExchange(ExchangeBean exchange) {
            this.exchange = exchange;
        }

        public int getFrequence() {
            return frequence;
        }

        public void setFrequence(int frequence) {
            this.frequence = frequence;
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

        public List<Integer> getWord_tag() {
            return word_tag;
        }

        public void setWord_tag(List<Integer> word_tag) {
            this.word_tag = word_tag;
        }

        public static class ExchangeBean  implements Serializable{
            private List<?> word_pl;
            private List<String> word_third;
            private List<String> word_past;
            private List<String> word_done;
            private List<String> word_ing;
            private List<?> word_er;
            private List<?> word_est;
            private List<?> word_prep;
            private List<?> word_adv;
            private List<?> word_verb;
            private List<?> word_noun;
            private List<?> word_adj;
            private List<?> word_conn;

            public List<?> getWord_pl() {
                return word_pl;
            }

            public void setWord_pl(List<?> word_pl) {
                this.word_pl = word_pl;
            }

            public List<String> getWord_third() {
                return word_third;
            }

            public void setWord_third(List<String> word_third) {
                this.word_third = word_third;
            }

            public List<String> getWord_past() {
                return word_past;
            }

            public void setWord_past(List<String> word_past) {
                this.word_past = word_past;
            }

            public List<String> getWord_done() {
                return word_done;
            }

            public void setWord_done(List<String> word_done) {
                this.word_done = word_done;
            }

            public List<String> getWord_ing() {
                return word_ing;
            }

            public void setWord_ing(List<String> word_ing) {
                this.word_ing = word_ing;
            }

            public List<?> getWord_er() {
                return word_er;
            }

            public void setWord_er(List<?> word_er) {
                this.word_er = word_er;
            }

            public List<?> getWord_est() {
                return word_est;
            }

            public void setWord_est(List<?> word_est) {
                this.word_est = word_est;
            }

            public List<?> getWord_prep() {
                return word_prep;
            }

            public void setWord_prep(List<?> word_prep) {
                this.word_prep = word_prep;
            }

            public List<?> getWord_adv() {
                return word_adv;
            }

            public void setWord_adv(List<?> word_adv) {
                this.word_adv = word_adv;
            }

            public List<?> getWord_verb() {
                return word_verb;
            }

            public void setWord_verb(List<?> word_verb) {
                this.word_verb = word_verb;
            }

            public List<?> getWord_noun() {
                return word_noun;
            }

            public void setWord_noun(List<?> word_noun) {
                this.word_noun = word_noun;
            }

            public List<?> getWord_adj() {
                return word_adj;
            }

            public void setWord_adj(List<?> word_adj) {
                this.word_adj = word_adj;
            }

            public List<?> getWord_conn() {
                return word_conn;
            }

            public void setWord_conn(List<?> word_conn) {
                this.word_conn = word_conn;
            }
        }

        public static class SymbolsBean implements Serializable {
            /**
             * ph_en : ˈəʊpən
             * ph_am : ˈoʊpən
             * ph_other :
             * ph_en_mp3 : http://res.iciba.com/resource/amp3/oxford/0/6e/67/6e6767f6e4aef49f4345582c9b40cbea.mp3
             * ph_am_mp3 : http://res.iciba.com/resource/amp3/1/0/7c/ef/7cef8a734855777c2a9d0caf42666e69.mp3
             * ph_tts_mp3 : http://res-tts.iciba.com/7/c/e/7cef8a734855777c2a9d0caf42666e69.mp3
             * parts : [{"part":"adj.","means":["敞开的，开着的","公开的，公共的","坦率的","有议论余地的"]},{"part":"vt.& vi.","means":["（打）开","开始","睁开","启动"]},{"part":"n.","means":["户外，野外","空旷","公开"]},{"part":"vi.","means":["使打开","展示，显现"]},{"part":"vt.","means":["张开","开放","开张营业","为（建筑物）揭幕"]}]
             * ph_en_mp3_bk : http://res.ksyun.iciba.com/resource/amp3/oxford/0/6e/67/6e6767f6e4aef49f4345582c9b40cbea.mp3
             * ph_am_mp3_bk : http://res.ksyun.iciba.com/resource/amp3/1/0/7c/ef/7cef8a734855777c2a9d0caf42666e69.mp3
             * ph_tts_mp3_bk : http://res-tts.ksyun.iciba.com/7/c/e/7cef8a734855777c2a9d0caf42666e69.mp3
             */

            private String ph_en;
            private String ph_am;
            private String ph_other;
            private String ph_en_mp3;
            private String ph_am_mp3;
            private String ph_tts_mp3;
            private String ph_en_mp3_bk;
            private String ph_am_mp3_bk;
            private String ph_tts_mp3_bk;
            private List<PartsBean> parts;

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

            public String getPh_en_mp3_bk() {
                return ph_en_mp3_bk;
            }

            public void setPh_en_mp3_bk(String ph_en_mp3_bk) {
                this.ph_en_mp3_bk = ph_en_mp3_bk;
            }

            public String getPh_am_mp3_bk() {
                return ph_am_mp3_bk;
            }

            public void setPh_am_mp3_bk(String ph_am_mp3_bk) {
                this.ph_am_mp3_bk = ph_am_mp3_bk;
            }

            public String getPh_tts_mp3_bk() {
                return ph_tts_mp3_bk;
            }

            public void setPh_tts_mp3_bk(String ph_tts_mp3_bk) {
                this.ph_tts_mp3_bk = ph_tts_mp3_bk;
            }

            public List<PartsBean> getParts() {
                return parts;
            }

            public void setParts(List<PartsBean> parts) {
                this.parts = parts;
            }

            public static class PartsBean  implements Serializable{
                /**
                 * part : adj.
                 * means : ["敞开的，开着的","公开的，公共的","坦率的","有议论余地的"]
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

    public static class CetFourBean implements Serializable {
        /**
         * word : open
         * count : 13
         * kd : []
         * Sentence : [{"sentence":"At the age of six she started reading the daily financial newspapers and opened her own bank account.","come":"出自-2014年6月听力原文"},{"sentence":"After swiping（敲击）into the iPad app (应用软件 ), which you can get for free here, he opens up a few different types of textbooks.","come":"出自-2013年6月阅读原文"},{"sentence":"Hotel owners found themselves with a huge number of empty rooms even as a lot of unnecessary new hotels were ready to open.","come":"出自-2013年6月阅读原文"}]
         */

        private String word;
        private int count;
        private List<?> kd;
        private List<SentenceBean> Sentence;

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<?> getKd() {
            return kd;
        }

        public void setKd(List<?> kd) {
            this.kd = kd;
        }

        public List<SentenceBean> getSentence() {
            return Sentence;
        }

        public void setSentence(List<SentenceBean> Sentence) {
            this.Sentence = Sentence;
        }

        public static class SentenceBean implements Serializable {
            /**
             * sentence : At the age of six she started reading the daily financial newspapers and opened her own bank account.
             * come : 出自-2014年6月听力原文
             */

            private String sentence;
            private String come;

            public String getSentence() {
                return sentence;
            }

            public void setSentence(String sentence) {
                this.sentence = sentence;
            }

            public String getCome() {
                return come;
            }

            public void setCome(String come) {
                this.come = come;
            }
        }
    }

    public static class CetSixBean implements Serializable{
        /**
         * word : open
         * count : 14
         * kd : []
         * Sentence : [{"sentence":"Democrats and Republicans can and will take sides on a number of issues, but a more crucial concern is that both are basing major policy decisions on guesstimates rather than looking at the vast wealth of raw data with a critical eye and an open mind.","come":"出自-2013年6月阅读原文"},{"sentence":"I went there last Saturday for their grand opening sale, but I drove around the parking lot for nearly an hour, looking for a space before I finally gave up and came home","come":"出自-2013年6月听力原文"},{"sentence":"She attended the supermarket's grand opening ceremony","come":"出自-2013年6月听力原文"}]
         */

        private String word;
        private int count;
        private List<?> kd;
        private List<SentenceBeanX> Sentence;

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<?> getKd() {
            return kd;
        }

        public void setKd(List<?> kd) {
            this.kd = kd;
        }

        public List<SentenceBeanX> getSentence() {
            return Sentence;
        }

        public void setSentence(List<SentenceBeanX> Sentence) {
            this.Sentence = Sentence;
        }

        public static class SentenceBeanX implements Serializable{
            /**
             * sentence : Democrats and Republicans can and will take sides on a number of issues, but a more crucial concern is that both are basing major policy decisions on guesstimates rather than looking at the vast wealth of raw data with a critical eye and an open mind.
             * come : 出自-2013年6月阅读原文
             */

            private String sentence;
            private String come;

            public String getSentence() {
                return sentence;
            }

            public void setSentence(String sentence) {
                this.sentence = sentence;
            }

            public String getCome() {
                return come;
            }

            public void setCome(String come) {
                this.come = come;
            }
        }
    }

    public static class BidecBean implements Serializable{
        /**
         * word_name : open
         * parts : [{"part_name":"adj.","word_id":"23362","part_id":"30701","means":[{"word_mean":"开着的; 开放的, 公开的","part_id":"30701","mean_id":"58195","sentences":[{"en":"The outer door was wide open but the inner one was locked.","cn":"外面的门大开着而里面的门锁着。"},{"en":"They decided to declare Paris an open city.","cn":"他们决定宣布巴黎为不设防城市。"}]},{"word_mean":"空旷的; 开阔的","part_id":"30701","mean_id":"58196","sentences":[{"en":"An open sea appeared before us.","cn":"我们前面呈现出广阔的大海。"}]},{"word_mean":"坦率的, 无偏见的","part_id":"30701","mean_id":"58197","sentences":[{"en":"She is a very friendly, open person.","cn":"她是个非常友好、坦率的人。"}]},{"word_mean":"开始营业的; 活动的","part_id":"30701","mean_id":"58198","sentences":[{"en":"The bank isn't open yet.","cn":"那家银行还没有开门营业。"}]},{"word_mean":"(职位等)空缺的","part_id":"30701","mean_id":"58199","sentences":[{"en":"Is the teaching vacancy still open?","cn":"教员职位还有空缺吗?"}]},{"word_mean":"尚未决定的, 悬而未决的","part_id":"30701","mean_id":"58200","sentences":[{"en":"This is an open question at the moment.","cn":"此刻这还是个悬而未决的问题。"}]}]},{"part_name":"vt. & vi.","word_id":"23362","part_id":"30702","means":[{"word_mean":"开始; 开设","part_id":"30702","mean_id":"58215","sentences":[{"en":"The meeting will open the day after tomorrow.","cn":"这个会议将于后天开幕。"},{"en":"The chairman opened the Parliament.","cn":"主席宣布议会开始。"},{"en":"Negotiations would probably be opened again.","cn":"谈判可能又要开始。"}]}]}]
         */

        private String word_name;
        private List<PartsBeanX> parts;

        public String getWord_name() {
            return word_name;
        }

        public void setWord_name(String word_name) {
            this.word_name = word_name;
        }

        public List<PartsBeanX> getParts() {
            return parts;
        }

        public void setParts(List<PartsBeanX> parts) {
            this.parts = parts;
        }

        public static class PartsBeanX implements Serializable{
            /**
             * part_name : adj.
             * word_id : 23362
             * part_id : 30701
             * means : [{"word_mean":"开着的; 开放的, 公开的","part_id":"30701","mean_id":"58195","sentences":[{"en":"The outer door was wide open but the inner one was locked.","cn":"外面的门大开着而里面的门锁着。"},{"en":"They decided to declare Paris an open city.","cn":"他们决定宣布巴黎为不设防城市。"}]},{"word_mean":"空旷的; 开阔的","part_id":"30701","mean_id":"58196","sentences":[{"en":"An open sea appeared before us.","cn":"我们前面呈现出广阔的大海。"}]},{"word_mean":"坦率的, 无偏见的","part_id":"30701","mean_id":"58197","sentences":[{"en":"She is a very friendly, open person.","cn":"她是个非常友好、坦率的人。"}]},{"word_mean":"开始营业的; 活动的","part_id":"30701","mean_id":"58198","sentences":[{"en":"The bank isn't open yet.","cn":"那家银行还没有开门营业。"}]},{"word_mean":"(职位等)空缺的","part_id":"30701","mean_id":"58199","sentences":[{"en":"Is the teaching vacancy still open?","cn":"教员职位还有空缺吗?"}]},{"word_mean":"尚未决定的, 悬而未决的","part_id":"30701","mean_id":"58200","sentences":[{"en":"This is an open question at the moment.","cn":"此刻这还是个悬而未决的问题。"}]}]
             */

            private String part_name;
            private String word_id;
            private String part_id;
            private List<MeansBean> means;

            public String getPart_name() {
                return part_name;
            }

            public void setPart_name(String part_name) {
                this.part_name = part_name;
            }

            public String getWord_id() {
                return word_id;
            }

            public void setWord_id(String word_id) {
                this.word_id = word_id;
            }

            public String getPart_id() {
                return part_id;
            }

            public void setPart_id(String part_id) {
                this.part_id = part_id;
            }

            public List<MeansBean> getMeans() {
                return means;
            }

            public void setMeans(List<MeansBean> means) {
                this.means = means;
            }

            public static class MeansBean implements Serializable{
                /**
                 * word_mean : 开着的; 开放的, 公开的
                 * part_id : 30701
                 * mean_id : 58195
                 * sentences : [{"en":"The outer door was wide open but the inner one was locked.","cn":"外面的门大开着而里面的门锁着。"},{"en":"They decided to declare Paris an open city.","cn":"他们决定宣布巴黎为不设防城市。"}]
                 */

                private String word_mean;
                private String part_id;
                private String mean_id;
                private List<SentencesBean> sentences;

                public String getWord_mean() {
                    return word_mean;
                }

                public void setWord_mean(String word_mean) {
                    this.word_mean = word_mean;
                }

                public String getPart_id() {
                    return part_id;
                }

                public void setPart_id(String part_id) {
                    this.part_id = part_id;
                }

                public String getMean_id() {
                    return mean_id;
                }

                public void setMean_id(String mean_id) {
                    this.mean_id = mean_id;
                }

                public List<SentencesBean> getSentences() {
                    return sentences;
                }

                public void setSentences(List<SentencesBean> sentences) {
                    this.sentences = sentences;
                }

                public static class SentencesBean implements Serializable{
                    /**
                     * en : The outer door was wide open but the inner one was locked.
                     * cn : 外面的门大开着而里面的门锁着。
                     */

                    private String en;
                    private String cn;

                    public String getEn() {
                        return en;
                    }

                    public void setEn(String en) {
                        this.en = en;
                    }

                    public String getCn() {
                        return cn;
                    }

                    public void setCn(String cn) {
                        this.cn = cn;
                    }
                }
            }
        }
    }

    public static class TikWordInfoBean implements Serializable {
        /**
         * is_have_video_info : 0
         */

        private int is_have_video_info;

        public int getIs_have_video_info() {
            return is_have_video_info;
        }

        public void setIs_have_video_info(int is_have_video_info) {
            this.is_have_video_info = is_have_video_info;
        }
    }

    public static class ErrWordsBean implements Serializable{
        /**
         * word_name : OPEN
         * means : ["Olympic public electronic network 奥林匹克公用电子网","open platform exchange network 开放式平台交换网络","optical Pan European network 泛欧光网络"]
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

    public static class SameAnalysisBean implements Serializable{
        /**
         * part_name : 这些形容词都有"空的"之意。
         * word_list : empty, vacant, hollow, blank, open
         * means : ["empty ： 指空无一人或一物，或空洞无意义的。","vacant ： 普通用词，侧重某物或某个位置没有被占用。","hollow ： 指物体中间是空的。","blank ： 指上面没有写字、印刷或做记号的空白表面，或指上面留着准备被填写的空白处。","open ： 指未被占有，从而可被别人得到的。"]
         */

        private String part_name;
        private String word_list;
        private List<String> means;

        public String getPart_name() {
            return part_name;
        }

        public void setPart_name(String part_name) {
            this.part_name = part_name;
        }

        public String getWord_list() {
            return word_list;
        }

        public void setWord_list(String word_list) {
            this.word_list = word_list;
        }

        public List<String> getMeans() {
            return means;
        }

        public void setMeans(List<String> means) {
            this.means = means;
        }
    }

    public static class TradeMeansBean implements Serializable{
        /**
         * word_trade : 体育
         * word_mean : ["自由式","展开","首攻","开叫","公开","开室","开放面","无人拦网","扣空网球","没有被对手严密防守的","对参加者没有严格限制的","前脚比后脚离击球路线较远的"]
         */

        private String word_trade;
        private List<String> word_mean;

        public String getWord_trade() {
            return word_trade;
        }

        public void setWord_trade(String word_trade) {
            this.word_trade = word_trade;
        }

        public List<String> getWord_mean() {
            return word_mean;
        }

        public void setWord_mean(List<String> word_mean) {
            this.word_mean = word_mean;
        }
    }

    public static class SentenceBeanXX implements Serializable{
        /**
         * Network_id : 2303764
         * Network_en : The action is an open violation of the Vienna Convention.
         * Network_cn : 该行为公然违背了《维也纳公约》。
         * tts_mp3 : http://res-tts.iciba.com/tts_new_dj//e/0/4/e041ba6b89c72fa04d1fec8e313ef390.mp3
         * tts_size : 17K
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

    public static class PhraseBean implements Serializable{
        /**
         * cizu_name : open up
         * jx : [{"jx_en_mean":"To spread out; unfold","jx_cn_mean":"展开；摊开","lj":[{"lj_ly":"A green valley opened up before us.","lj_ls":"青翠的山谷展现在我们眼前"}]},{"jx_en_mean":"To begin operation","jx_cn_mean":"开战；开火","lj":[{"lj_ly":"The new store opens up next month.","lj_ls":"这家新商店将在下个月开张"},{"lj_ly":"The artillery opened up at dawn.","lj_ls":"炮兵于拂晓时开口"}]},{"jx_en_mean":"&I{Informal} To speak freely and candidly","jx_cn_mean":"【非正式用语】 直言不讳","lj":[{"lj_ly":"At last the frightened witness opened up and told the truth.","lj_ls":"这名吓坏了的目击者终于直言不讳说出了事实"}]},{"jx_en_mean":"To make an opening in by cutting","jx_cn_mean":"切开","lj":[{"lj_ly":"The surgeon opened up the patient's chest.","lj_ls":"这名外科医生切开了病人的胸部"}]},{"jx_en_mean":"To make available or accessible","jx_cn_mean":"使可利用；使通往","lj":[{"lj_ly":"open up new markets.","lj_ls":"打开了新的市场"}]},{"jx_en_mean":"&I{Informal} To accelerate. Used of a motor vehicle.","jx_cn_mean":"【非正式用语】 （用于汽车）加速","lj":[]}]
         */

        private String cizu_name;
        private List<JxBean> jx;

        public String getCizu_name() {
            return cizu_name;
        }

        public void setCizu_name(String cizu_name) {
            this.cizu_name = cizu_name;
        }

        public List<JxBean> getJx() {
            return jx;
        }

        public void setJx(List<JxBean> jx) {
            this.jx = jx;
        }

        public static class JxBean implements Serializable{
            /**
             * jx_en_mean : To spread out; unfold
             * jx_cn_mean : 展开；摊开
             * lj : [{"lj_ly":"A green valley opened up before us.","lj_ls":"青翠的山谷展现在我们眼前"}]
             */

            private String jx_en_mean;
            private String jx_cn_mean;
            private List<LjBean> lj;

            public String getJx_en_mean() {
                return jx_en_mean;
            }

            public void setJx_en_mean(String jx_en_mean) {
                this.jx_en_mean = jx_en_mean;
            }

            public String getJx_cn_mean() {
                return jx_cn_mean;
            }

            public void setJx_cn_mean(String jx_cn_mean) {
                this.jx_cn_mean = jx_cn_mean;
            }

            public List<LjBean> getLj() {
                return lj;
            }

            public void setLj(List<LjBean> lj) {
                this.lj = lj;
            }

            public static class LjBean implements Serializable{
                /**
                 * lj_ly : A green valley opened up before us.
                 * lj_ls : 青翠的山谷展现在我们眼前
                 */

                private String lj_ly;
                private String lj_ls;

                public String getLj_ly() {
                    return lj_ly;
                }

                public void setLj_ly(String lj_ly) {
                    this.lj_ly = lj_ly;
                }

                public String getLj_ls() {
                    return lj_ls;
                }

                public void setLj_ls(String lj_ls) {
                    this.lj_ls = lj_ls;
                }
            }
        }
    }

    public static class SynonymBean implements Serializable{
        /**
         * part_name : vt.
         * means : [{"word_mean":"使露出,使显露","cis":["show","disclose","bare","expose","reveal","uncover"]},{"word_mean":"开始","cis":["begin","establish","start","unfold","originate","launch","initiate"]}]
         */

        private String part_name;
        private List<MeansBeanX> means;

        public String getPart_name() {
            return part_name;
        }

        public void setPart_name(String part_name) {
            this.part_name = part_name;
        }

        public List<MeansBeanX> getMeans() {
            return means;
        }

        public void setMeans(List<MeansBeanX> means) {
            this.means = means;
        }

        public static class MeansBeanX implements Serializable{
            /**
             * word_mean : 使露出,使显露
             * cis : ["show","disclose","bare","expose","reveal","uncover"]
             */

            private String word_mean;
            private List<String> cis;

            public String getWord_mean() {
                return word_mean;
            }

            public void setWord_mean(String word_mean) {
                this.word_mean = word_mean;
            }

            public List<String> getCis() {
                return cis;
            }

            public void setCis(List<String> cis) {
                this.cis = cis;
            }
        }
    }

    public static class AntonymBean implements Serializable{
        /**
         * part_name : vt.
         * means : [{"word_mean":"打开;翻开","cis":["shut","close"]}]
         */

        private String part_name;
        private List<MeansBeanXX> means;

        public String getPart_name() {
            return part_name;
        }

        public void setPart_name(String part_name) {
            this.part_name = part_name;
        }

        public List<MeansBeanXX> getMeans() {
            return means;
        }

        public void setMeans(List<MeansBeanXX> means) {
            this.means = means;
        }

        public static class MeansBeanXX implements Serializable{
            /**
             * word_mean : 打开;翻开
             * cis : ["shut","close"]
             */

            private String word_mean;
            private List<String> cis;

            public String getWord_mean() {
                return word_mean;
            }

            public void setWord_mean(String word_mean) {
                this.word_mean = word_mean;
            }

            public List<String> getCis() {
                return cis;
            }

            public void setCis(List<String> cis) {
                this.cis = cis;
            }
        }
    }

    public static class DerivationBean implements Serializable{
        /**
         * yuyuan_name : Old English open (adjective), openian (verb), of Germanic origin; related to Dutch open and German offen, from the root of the adverb up
         */

        private String yuyuan_name;

        public String getYuyuan_name() {
            return yuyuan_name;
        }

        public void setYuyuan_name(String yuyuan_name) {
            this.yuyuan_name = yuyuan_name;
        }
    }

    public static class CollinsBean implements Serializable{
        private List<EntryBean> entry;

        public List<EntryBean> getEntry() {
            return entry;
        }

        public void setEntry(List<EntryBean> entry) {
            this.entry = entry;
        }

        public static class EntryBean implements Serializable{
            /**
             * posp : V-ERG
             * tran : 打开（门、窗、盖等）
             * def : If you open something such as a door, window, or lid, or if it opens, its position is changed so that it no longer covers a hole or gap.
             * example : [{"ex":"He opened the window and looked out...","tran":"他打开窗户往外看。","tts_mp3":"http://res-tts.iciba.com/tts_dj/0/9/0/090496829e9a42a983cc30902702087a.mp3","tts_size":"10K"},{"ex":"The church doors would open and the crowd would surge out.","tran":"教堂的门会打开，人群会蜂拥而出。","tts_mp3":"http://res-tts.iciba.com/tts_dj/b/e/0/be0baa942eb60748899bba7cd2e29b37.mp3","tts_size":"15K"}]
             */

            private String posp;
            private String tran;
            private String def;
            private List<ExampleBean> example;

            public String getPosp() {
                return posp;
            }

            public void setPosp(String posp) {
                this.posp = posp;
            }

            public String getTran() {
                return tran;
            }

            public void setTran(String tran) {
                this.tran = tran;
            }

            public String getDef() {
                return def;
            }

            public void setDef(String def) {
                this.def = def;
            }

            public List<ExampleBean> getExample() {
                return example;
            }

            public void setExample(List<ExampleBean> example) {
                this.example = example;
            }

            public static class ExampleBean implements Serializable {
                /**
                 * ex : He opened the window and looked out...
                 * tran : 他打开窗户往外看。
                 * tts_mp3 : http://res-tts.iciba.com/tts_dj/0/9/0/090496829e9a42a983cc30902702087a.mp3
                 * tts_size : 10K
                 */

                private String ex;
                private String tran;
                private String tts_mp3;
                private String tts_size;

                public String getEx() {
                    return ex;
                }

                public void setEx(String ex) {
                    this.ex = ex;
                }

                public String getTran() {
                    return tran;
                }

                public void setTran(String tran) {
                    this.tran = tran;
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
            }
        }
    }

    public static class EeMeanBean implements Serializable{
        /**
         * part_name : Noun
         * means : [{"word_mean":"1. a clear or unobstructed space or expanse of land or water;","sentences":[{"sentence":"\"finally broke out of the forest into the open\""}]},{"word_mean":"2. where the air is unconfined;","sentences":[{"sentence":"\"he wanted to get outdoors a little\""},{"sentence":"\"the concert was held in the open air\""},{"sentence":"\"camping in the open\""}]},{"word_mean":"3. a tournament in which both professionals and amateurs may play","sentences":[]},{"word_mean":"4. information that has become public;","sentences":[{"sentence":"\"all the reports were out in the open\""},{"sentence":"\"the facts had been brought to the surface\""}]}]
         */

        private String part_name;
        private List<MeansBeanXXX> means;

        public String getPart_name() {
            return part_name;
        }

        public void setPart_name(String part_name) {
            this.part_name = part_name;
        }

        public List<MeansBeanXXX> getMeans() {
            return means;
        }

        public void setMeans(List<MeansBeanXXX> means) {
            this.means = means;
        }

        public static class MeansBeanXXX implements Serializable{
            /**
             * word_mean : 1. a clear or unobstructed space or expanse of land or water;
             * sentences : [{"sentence":"\"finally broke out of the forest into the open\""}]
             */

            private String word_mean;
            private List<SentencesBeanX> sentences;

            public String getWord_mean() {
                return word_mean;
            }

            public void setWord_mean(String word_mean) {
                this.word_mean = word_mean;
            }

            public List<SentencesBeanX> getSentences() {
                return sentences;
            }

            public void setSentences(List<SentencesBeanX> sentences) {
                this.sentences = sentences;
            }

            public static class SentencesBeanX implements Serializable{
                /**
                 * sentence : "finally broke out of the forest into the open"
                 */

                private String sentence;

                public String getSentence() {
                    return sentence;
                }

                public void setSentence(String sentence) {
                    this.sentence = sentence;
                }
            }
        }
    }

    public static class SlangBean implements Serializable{
        /**
         * tokens : open a can of beans
         * class : ["美国俚语"]
         * list : [{"explanation":"惹祸","example":[{"en":"It was I who opened a can of beans.","zh":"是我惹的祸。"},{"en":"She was one of those people who like opening a can of beans.","zh":"她就是那种喜欢惹祸的人。"}]}]
         * type : v
         */

        private String tokens;
        private String type;
        @SerializedName("class")
        private List<String> classX;
        private List<ListBean> list;

        public String getTokens() {
            return tokens;
        }

        public void setTokens(String tokens) {
            this.tokens = tokens;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<String> getClassX() {
            return classX;
        }

        public void setClassX(List<String> classX) {
            this.classX = classX;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean implements Serializable {
            /**
             * explanation : 惹祸
             * example : [{"en":"It was I who opened a can of beans.","zh":"是我惹的祸。"},{"en":"She was one of those people who like opening a can of beans.","zh":"她就是那种喜欢惹祸的人。"}]
             */

            private String explanation;
            private List<ExampleBeanX> example;

            public String getExplanation() {
                return explanation;
            }

            public void setExplanation(String explanation) {
                this.explanation = explanation;
            }

            public List<ExampleBeanX> getExample() {
                return example;
            }

            public void setExample(List<ExampleBeanX> example) {
                this.example = example;
            }

            public static class ExampleBeanX implements Serializable{
                /**
                 * en : It was I who opened a can of beans.
                 * zh : 是我惹的祸。
                 */

                private String en;
                private String zh;

                public String getEn() {
                    return en;
                }

                public void setEn(String en) {
                    this.en = en;
                }

                public String getZh() {
                    return zh;
                }

                public void setZh(String zh) {
                    this.zh = zh;
                }
            }
        }
    }

    public static class AbbreviationBean implements Serializable {
        /**
         * mean_en : opening
         * mean_cn : 开口，孔，穴
         */

        private String mean_en;
        private String mean_cn;

        public String getMean_en() {
            return mean_en;
        }

        public void setMean_en(String mean_en) {
            this.mean_en = mean_en;
        }

        public String getMean_cn() {
            return mean_cn;
        }

        public void setMean_cn(String mean_cn) {
            this.mean_cn = mean_cn;
        }
    }
}
