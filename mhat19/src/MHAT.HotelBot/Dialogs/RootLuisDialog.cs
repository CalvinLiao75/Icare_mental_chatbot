using Microsoft.Bot.Builder.Dialogs;
using Microsoft.Bot.Builder.Luis;
using Microsoft.Bot.Builder.Luis.Models;
using Microsoft.Bot.Connector;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Web;

namespace MHAT.HotelBot.Dialogs
{
    [LuisModel("874d8e59-b0e9-44b7-9b85-f9b8e52f1acb", "59cbabf764c64cd2be77a3dc5ee93823")]
    [Serializable]

   
    public class RootLuisDialog : LuisDialog<object>
    {
       
    [LuisIntent("")]
        public async Task None
            (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("你可以再表達得更清楚一點嗎");

            context.Wait(MessageReceived);
        }

        [LuisIntent("打招呼")]
        public async Task hello
        (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("你好，我是聊天機器人，有甚麼問題需要我幫你解決的嗎");
            await context.PostAsync("如果想跟我說的話請回答有");
            await context.PostAsync("如果不想跟我說的話請回答沒有");
            context.Wait(MessageReceived);
        }

        [LuisIntent("沒有")]
        public async Task nope
       (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("好的，不想告訴我也沒關係，或許你可以直接告訴我你現在的感受");
            await context.PostAsync("悲傷 開心 暴躁 焦慮 憂鬱 驚恐 憤怒 ");
            await context.PostAsync("在此之前，我想先跟你解釋次感元是甚麼，這對你會有極大的幫助\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            await context.PostAsync("我們之所以會對不同的事物有不同的感受、\n\n對於不同的內在影像、聲音感受到不同情緒，");
            await context.PostAsync("諸如信任、愛、有信心、勇氣或是它們的反面情緒，\n\n都來自於大腦中的一個奇妙特質 - 次感元(Sub - modality)。");
            await context.PostAsync("其中我們相對比較常用的三種次感元(Sub - modalities)包含：");
            await context.PostAsync("內視覺的次感元：光暗、顏色、距離、大小、清晰度、位置、動或靜畫面等。");
            await context.PostAsync("內聽覺的次感元：音量、聲調、聲音來源方向、距離、清晰度、位置、快慢等。");
            await context.PostAsync("內觸覺的次感元：位置、重量、範圍、溫度、頻率、形狀等。");
            await context.PostAsync("簡單來說就是你腦中建構的一切「想像」");
            await context.PostAsync("次感元可以用來做些什麼呢？");
            await context.PostAsync("從NLP的角度來看，次感元是我們個人一切的主觀經驗的基本構成元素。\n\n只要改變次感元，我們對於過往經驗的記憶以及感受就會隨之改變。");
            context.Wait(MessageReceived);

        }
        
        
        
        [LuisIntent("有")]
        public async Task yape
      (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("好的，請你告訴我最近發生了甚麼不愉快的事");
            await context.PostAsync("並且詳細的告訴我你對於這件事的感受以及看法");
            await context.PostAsync("範例:我最近諸事不順(對於這件事我感到很焦慮)");
            await context.PostAsync("在此之前，我想先跟你解釋次感元是甚麼，這對你會有極大的幫助\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            await context.PostAsync("我們之所以會對不同的事物有不同的感受、\n\n對於不同的內在影像、聲音感受到不同情緒，");
            await context.PostAsync("諸如信任、愛、有信心、勇氣或是它們的反面情緒，\n\n都來自於大腦中的一個奇妙特質 - 次感元(Sub - modality)。");
            await context.PostAsync("其中我們相對比較常用的三種次感元(Sub - modalities)包含：");
            await context.PostAsync("內視覺的次感元：光暗、顏色、距離、大小、清晰度、位置、動或靜畫面等。");
            await context.PostAsync("內聽覺的次感元：音量、聲調、聲音來源方向、距離、清晰度、位置、快慢等。");
            await context.PostAsync("內觸覺的次感元：位置、重量、範圍、溫度、頻率、形狀等。");
            await context.PostAsync("簡單來說就是你腦中建構的一切「想像」");
            await context.PostAsync("次感元可以用來做些什麼呢？");
            await context.PostAsync("從NLP的角度來看，次感元是我們個人一切的主觀經驗的基本構成元素。\n\n只要改變次感元，我們對於過往經驗的記憶以及感受就會隨之改變。");
            context.Wait(MessageReceived);
       }

        [LuisIntent("有幫助")]
        public async Task havehelp
     (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("太棒了，很開心我解決了你的困境"); 
            await context.PostAsync("下次心情不好記得找我喔\n\n我會盡我所能幫助你的");
            context.Wait(MessageReceived);
        }

//憤怒
        [LuisIntent("表達憤怒")]
        public async Task angry
      (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("1.回想某個讓你惱火的人,或是讓你火冒三丈的人。想象一幅他正盯者你看並讓你惱火的那個場景的圖像。聆聽他在說些什麼, 留意你身體內升起的糟糕感覺。\n\n2.把這幅圖像黑白化。讓它遠離你。把它變小一些,變為原來的八分之一大小。在他的鼻子上加一個小醜的紅鼻頭。\n\n3.不論他在說些什麼, 都去聆聽, 但是把他的聲音變成米老鼠, 或唐老鴨, 或大笨貓的聲音。\n\n4.留意你身體的不同感覺,接著打斷一下你的思維, 然後再次把註意力轉向他,你對他的感覺會大為不同。");
            await context.PostAsync("請問這個答案對你有幫助嗎?");
            await context.PostAsync("有幫到你的話請幫我回答有幫助");
            await context.PostAsync("沒有的話請幫我回答 憤怒nlp沒幫助");
            context.Wait(MessageReceived);
        }

        [LuisIntent("憤怒nlp沒幫助")]
        public async Task angrynlp
     (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("有時當我們感到憤怒，我們只需要暫時抽離當下情況。這可以給你時間梳理你對當下情況的想法，再決定你想如何做出反應和控制情況。");
            await context.PostAsync("或許你可以試試看 深呼吸，開始數數字");
            await context.PostAsync("你受了委屈時覺得很氣憤，想握緊拳頭尖叫。但發洩怒氣的更好辦法是深呼吸，同時在腦中數到8，停下來，再緩慢地呼吸。重複做幾次，直到你冷靜下來，這時你的心跳會放緩，肌肉也不會再緊張。");
            await context.PostAsync("請問這個答案對你有幫助嗎?");
            await context.PostAsync("有幫到你的話請幫我回答有幫助");
            await context.PostAsync("沒有的話請幫我回答 深呼吸沒幫助");
            context.Wait(MessageReceived);
        }

        [LuisIntent("深呼吸沒幫助")]
        public async Task angrynohelp
     (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("或許你可以試試看 寫下不好的心情，然後把它扔掉");
            await context.PostAsync("在紙上寫下你對家人、朋友或同事的不滿。可以假裝向讓你不快的人寫信。這也能幫助你記下如何解決使你不安的問題。隨後把紙片扔掉，就像把憤怒的情緒扔掉一樣。寫信也能讓你有時間冷靜下來，讓你心情變好，減輕壓力。");
            await context.PostAsync("請問這個答案對你有幫助嗎?");
            await context.PostAsync("有幫到你的話請幫我回答有幫助");
            await context.PostAsync("如果以上建議都無效可以進入身心地圖尋找附近診所讓專業醫生幫你診斷");
            context.Wait(MessageReceived);
        }

 //悲傷
        [LuisIntent("表達悲傷")]
        public async Task sad
        (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("1。明確你想停止回想的記憶。\n\n2.留意其中的次感元。凍結框架, 縮小框架。\n\n3.跳躍到記憶的終點, 凍結框架, 想象有一個白色的按鈕,抓住它, 想象它瞬間完全變白。\n\n4.重復這個過程3次。\n\n5.看著影片結尾的你, 然後倒放這部影片, 把影像和聲音都倒放過來, 在你體內向相反的方向旋轉這個感覺。\n\n6。當你試著去回想這個痛苦的記憶時, 你越回想它, 就越難回憶起來。");
            await context.PostAsync("在悲傷的時候，你其實不用壓抑自己的眼淚。曾經有研究指出，哭泣時的淚水，和眼睛受到物理刺激流出的淚水是不同的。情緒帶來的淚水中，有與壓力相關的激素，哭泣的時候是真的可以釋放壓力。所以不要多想了，需要哭的時候，就好好哭吧。");
            await context.PostAsync("請問這個答案對你有幫助嗎?");
            await context.PostAsync("有幫到你的話請幫我回答有幫助");
            await context.PostAsync("沒有的話請幫我回答 改變悲傷記憶沒幫助");
            context.Wait(MessageReceived);
        }

        [LuisIntent("改變悲傷記憶沒幫助")]
        public async Task changesadmemory
      (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("或許你可以試試看  讓自己哭出來：");
            await context.PostAsync("在悲傷的時候，你其實不用壓抑自己的眼淚。曾經有研究指出，哭泣時的淚水，和眼睛受到物理刺激流出的淚水是不同的。情緒帶來的淚水中，有與壓力相關的激素，哭泣的時候是真的可以釋放壓力。所以不要多想了，需要哭的時候，就好好哭吧。");
            await context.PostAsync("請問這個答案對你有幫助嗎?");
            await context.PostAsync("有幫到你的話請幫我回答有幫助");
            await context.PostAsync("沒有的話請幫我回答 哭沒幫助");
            context.Wait(MessageReceived);
        }

        [LuisIntent("哭沒幫助")]
        public async Task cry
    (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("或許你可以試試看 正視自己的悲傷");
            await context.PostAsync("悲傷沒有對錯，也不代表懦弱。有些人無法面對自己悲傷的感受，或不能原諒自己想哭的衝動。可是其實，每個人都有不同的負面情緒，經歷傷痛時，不需要過度要求自己，只要接受自己、感受你自己的感受就好。即使世界上有兩個人經歷了相同的不幸，他們也可能會採取截然不同的處理方式，你不需要懷疑自己宣洩情緒的方式「對不對」，徒然讓人生更加艱難。");
            await context.PostAsync("請問這個答案對你有幫助嗎?");
            await context.PostAsync("有幫到你的話請幫我回答有幫助");
            await context.PostAsync("沒有的話請幫我回答 正視悲傷沒幫助");
            context.Wait(MessageReceived);
        }
        [LuisIntent("正視悲傷沒幫助")]
        public async Task seesad
    (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("或許你可以試試看 一個練習方法");
            await context.PostAsync("首先在腦海裡架起一面無限擴大的螢幕，然後將忘不了的挫折場景在上頭放映，在心裡品嘗哪些辛酸與難過；接著，將螢幕上的映像由彩色轉為黑白，逐漸淡化其真實感，褪成彷彿久遠以前的回憶；最後，將這片黑白螢幕逐漸縮小，直到成為一個點，然後對自己說「記憶，再見，從今天開始我會把你忘記，然後我會變得幸福。」一邊說著，一邊將映像遠遠地投射出去，可以投向一片藍天或大海，或從很高的地方往下丟擲。");
            await context.PostAsync("這種訓練看似很玄，但其實就是透過一道儀式，讓自己放下心裡的執著，告訴自己這件事已經過去了。只要多練習幾次，一旦上手了，就可以快速地轉換心情，避免沉溺於失落中。");
            await context.PostAsync("請問這個答案對你有幫助嗎?");
            await context.PostAsync("有幫到你的話請幫我回答有幫助");
            await context.PostAsync("如果以上建議都無效可以進入身心地圖尋找附近診所讓專業醫生幫你診斷");
            context.Wait(MessageReceived);
        }



        [LuisIntent("表達開心")]
        public async Task happy
          (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("恭喜你最近心情不錯，請繼續保持樂觀，如果你身邊有朋友心情不好的，可以請他來使用我們的app喔");
            context.Wait(MessageReceived);
        }
       
        
        [LuisIntent("表達憂鬱")]    
        public async Task fuck
         (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("那請問你持續這樣的狀態多久了");
            await context.PostAsync("請把你的狀態跟持續時間打出來(範例:我心情低落了3天)");
            context.Wait(MessageReceived);
        }

        [LuisIntent("表達憂鬱超過兩個禮拜")]
        public async Task fucktwoweek
      (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("(1) 每天大部分時間有憂鬱情緒，心情主觀描述或他人觀察為悲傷或沮喪  \n\n(2) 每天大部分時間有興趣減退  \n\n(3) 體重或食欲顯著變化  \n\n(4) 失眠或睡眠過多  \n\n(5)精神運動性變化，激動或遲滯  \n\n(6) 失去活力或疲倦  \n\n(7)無價值感或罪惡感  \n\n(8)思考、專注或決斷能力減退  \n\n(9)反覆出現死亡想法、自殺意念或自殺嚐試");
            await context.PostAsync("請問有符合五項以上嗎");
            await context.PostAsync("如果有的話 請幫我回覆 我有符合五項以上");
            await context.PostAsync("如果沒有的話 請幫我回覆 我沒有符合");
            context.Wait(MessageReceived);
        }

        [LuisIntent("我有符合五項以上")]
        public async Task fiveup
     (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("這邊強烈建議你，請立刻找尋附近的精神科診所就醫，為了你的心理健康著想﹑本程式的地圖功能將會為您找到附近高評分身心診所");
            context.Wait(MessageReceived);
        }


  //憂鬱
        [LuisIntent("表達憂鬱跟時間")]
        public async Task fuckandtime
      (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("1.回想你曾經感覺很美妙的一次經驗。\n\n2.閉上你的眼睛, 想象那個時候的具體細節,把你所看到的一切圖像清晰化, 加大你聽到的聲音, 記住那些升起的感覺。\n\n3.想象自己步入那個經驗之中, 並想象那個記憶如實閃現,就像正在發生一樣,看見你希望看見的東西, 聽到你希望聽到的聲音, 感覺你此刻的美好感覺。把顏色調得更鮮艷、更明亮些,如果這樣更好的話,留意到你是如何呼吸的, 就按那樣的方式呼吸。\n\n 4.留意你體內升起的那種美妙的感覺, 意識這一感覺升起的方向以及它的移動方向,想象可以調控這一感覺, 在你的體內把它旋轉得更快、再快些, 更強、再強些。\n\n 5.想象一下, 未來何時你將擁有這些美妙的感受。當你想著未來幾周將要完成的事情時, 在你的體內同時旋轉這些感受。如果你發現自己無端的就感覺很棒, 請不要太大驚小怪哦!");
            await context.PostAsync("請問這個答案對你有幫助嗎?");
            await context.PostAsync("有幫到你的話請幫我回答有幫助");
            await context.PostAsync("沒有的話請幫我回答 回憶美好沒幫助");
            context.Wait(MessageReceived);
        }

        [LuisIntent("回憶美好沒幫助")]
        public async Task memorynohelp
      (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("1.當你心情鬱悶時,有三樣事會發生。你會製造出讓你感覺不爽的圖像, 用悲觀的論調跟自己對話, 並且感覺糟糕。留意這些圖像、聲音以及感覺。\n\n2.想想你想要做些什麼, 弄清楚自己想要到怎樣的有益狀態里去。\n\n3.移開那些負面的圖像, 用積極的圖像來替換, 以便讓你感受到你希望獲得的感覺。\n\n4.用咒語來停止你內在的負面對話。用積極的自我確認、暗示、鼓勵和贊美來替換它們。\n\n5.注意當下的感覺旋轉的方向。反向旋轉這個感覺。\n\n6.改變你的生理狀態。動起來, 用不同方式的呼吸, 想象自己處於巔峰狀態。看著你所看見的, 聽著你所聽見的, 在你體內劇烈地旋轉這個感覺。");
            await context.PostAsync("請問這個答案對你有幫助嗎?");
            await context.PostAsync("有幫到你的話請幫我回答有幫助");
            await context.PostAsync("沒有的話請幫我回答 轉變心情沒幫助");
            context.Wait(MessageReceived);
        }

        [LuisIntent("轉變心情沒幫助")]
        public async Task turnmoodnohelp
       (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("或許你可以試試看 早上起來曬太陽");
            await context.PostAsync("固定時間睡眠、起床，然後曬太陽，\n\n一來可調整生理時鐘，\n\n二來可促進分泌維生素D ，\n\n三來可避免睡太晚影響晚上睡眠。\n\n早上散步曬太陽，傍晚跑步完洗澡吃飯，是最理想的抗憂節奏。");
            await context.PostAsync("請問這個答案對你有幫助嗎?");
            await context.PostAsync("有幫到你的話請幫我回答有幫助");
            await context.PostAsync("沒有的話請幫我回答 曬太陽沒幫助");
            context.Wait(MessageReceived);
        }

        [LuisIntent("曬太陽沒幫助")]
        public async Task sunnohelp
       (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("或許你可以試試看 有氧運動(例如跑步、騎腳踏車、游泳等等)");
            await context.PostAsync("有氧運動能調節情緒上的反應，可能暫時忘記對外界的擔憂，\n\n下回因為工作壓力情緒不佳、不妨先去做做有氧運動再重回工作崗位中。");
            await context.PostAsync("請問這個答案對你有幫助嗎?");
            await context.PostAsync("有幫到你的話請幫我回答有幫助");
            await context.PostAsync("沒有的話請幫我回答 有氧沒幫助");
            context.Wait(MessageReceived);
        }

        [LuisIntent("有氧沒幫助")]
        public async Task runnohelp
       (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("或許你可以試試看 正念認知療法");
            await context.PostAsync("接下來請你跟著我的步驟做");
            await context.PostAsync("首先，請放下手邊的事情，閉上眼睛。" +"\n\n讓我們慢慢深吸一口氣……" + "\n\n慢慢吐盡……"+ "\n\n慢慢吸……" + "\n\n吐……"+ "\n\n請再持續重複幾次。");
            await context.PostAsync("請問這個答案對你有幫助嗎?");
            await context.PostAsync("有幫到你的話請幫我回答有幫助");
            await context.PostAsync("如果以上建議都無效可以進入身心地圖尋找附近診所讓專業醫生幫你診斷");
            context.Wait(MessageReceived);
        }


 
        
        [LuisIntent("表達驚恐")]
        public async Task scared
        (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("那請問你持續這樣的狀態多久了");
            await context.PostAsync("請把你的狀態跟持續時間打出來(範例:我心情低落了3天)");

            context.Wait(MessageReceived);
        }
        //驚恐
        [LuisIntent("表達驚恐跟時間")]
        public async Task scaredandtime
    (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("1找出一個你特有的恐懼症。回想你曾經在何時經驗了這個恐懼症(或者是引發了你恐懼症的虛構場景)。\n\n2.想象你在一個影劇院里, 看著銀幕上正在播放自己經歷恐懼的過程。\n\n3.想象你自己正在放映室里, 朝下看, 看著自己正在觀看銀幕上的自己正在經歷恐懼。\n\n4.將影片播放到最後, 結局是你成功地從恐懼經驗里走了出來, 在影片最後想象自己元神歸位, 回到自己的身體里。\n\n5。在這部恐怖片的最後, 你回到自己的身體里, 想象這部影片倒著播放, 讓每一樣東西都倒過來。你在退步走, 反著說話、倒行, 同時聽著滑稽的馬戲團音樂, 直到回放到這個影片的開頭, 你切入到這個經驗的地方。再想想這個恐懼症, 留意到你的感覺有多麼的不同。\n\n6.多次重復1~5步。\n\n7.留意當你做這個練習時你的感覺的變化, 當你再想到這個恐懼的時候, 注意到你是如何再也感受不到這個恐懼的!");
            await context.PostAsync("請問這個答案對你有幫助嗎?");
            await context.PostAsync("有幫到你的話請幫我回答 有幫助");
            await context.PostAsync("沒有的話請幫我回答 恐懼nlp沒幫助");
            
            context.Wait(MessageReceived);
        }

        [LuisIntent("恐懼nlp沒幫助")]
        public async Task scarednlp
      (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("或許你可以試試看 反駁自己的負面想法?");
            await context.PostAsync("如「我快要瘋了」、「我快要死了」，代換成「恐慌發作不會讓人瘋掉」、「不會死掉」。告訴自己「我不會瘋掉」");
            await context.PostAsync("請問這個答案對你有幫助嗎?");
            await context.PostAsync("有幫到你的話請幫我回答 有幫助");
            await context.PostAsync("沒有的話請幫我回答 反駁沒幫助");
            context.Wait(MessageReceived);
        }

        [LuisIntent("反駁沒幫助")]
        public async Task refutenohelp
       (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("或許你可以試試看 分散注意力?");
            await context.PostAsync("將自己的注意力從關注恐慌發作中轉移，並坐下休息。如正在上學、上班，可以試著先緊緊抓住椅子的把手。當在開車時恐慌發作，需馬上將車停靠路邊，或將注意力專注在前面的車牌。");
            await context.PostAsync("請問這個答案對你有幫助嗎?");
            await context.PostAsync("有幫到你的話請幫我回答 有幫助");
            await context.PostAsync("沒有的話請幫我回答 分散注意力沒幫助");
            context.Wait(MessageReceived);
        }

        [LuisIntent("分散注意力沒幫助")]
        public async Task distractnohelp
    (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("或許你可以試試看 不斷加強正面想法?");
            await context.PostAsync("請把這些句子記住，當你很恐慌時，在心理不斷默念，例如:「很快就會過去的」、「雖然恐怖但我不會有危險」。");
            await context.PostAsync("請問這個答案對你有幫助嗎?");
            await context.PostAsync("有幫到你的話請幫我回答 有幫助");
            await context.PostAsync("如果以上建議都無效可以進入身心地圖尋找附近診所讓專業醫生幫你診斷");
            context.Wait(MessageReceived);
        }


//疲乏
        [LuisIntent("表達疲乏")]
        public async Task tired
      (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("那請問你持續這樣的狀態多久了");
            await context.PostAsync("請把你的狀態跟持續時間打出來(範例:我心情低落了3天)");

            context.Wait(MessageReceived);
        }
//焦慮
        [LuisIntent("表達焦慮")]
        public async Task anxiety
     (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("請問你持續這個狀態多久了");
            await context.PostAsync("請把你的狀態跟持續時間打出來(範例:我心情低落了3天)");

            context.Wait(MessageReceived);
        }

        [LuisIntent("表達焦慮超過6個月")]
        public async Task anxietysix
    (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("您焦慮的情況偏向嚴重，建議您到身心科診所就診，我們的地圖功能可以幫您尋找附近高評分的身心診所");
            

            context.Wait(MessageReceived);
        }


        [LuisIntent("表達焦慮跟時間")]
        public async Task anxietyandtime
      (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("1.想想你生活中哪個方面,你期望更有條理一些,並且想一想, 如何條理化這一切。給任務預留足夠的時間。\n\n2.想象一下, 你自己把所有的東西都取出來了, 看著這一切, 把挑選出來的東西分放在不同的區域,想象你自己整理好了這一切, 並且把它們放回原處, 次序井然。看著你自己享受這整個過程。\n\n3.把挑選出來的一切分門別類。下一步, 把這一切按新的次序放回原處。\n\n4.建立一個規則, 以便你能長期有條理地存放東西, 並且定期督你自己。");
         
            await context.PostAsync("請問這個答案對你有幫助嗎?");
            await context.PostAsync("有幫到你的話請幫我回答 有幫助");
            await context.PostAsync("沒有的話請幫我回答 焦慮nlp沒幫助");
            context.Wait(MessageReceived);
        }

        [LuisIntent("焦慮nlp沒幫助")]
        public async Task anxietynlp
  (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("1.回想一些讓你感到恐懼或焦慮的事。\n\n2.留意到這個焦慮在你體內的旋轉方向, 觀想它有一些紅色的箭頭朝向它前進的方向。\n\n3.想象你把這個感覺移植到體外, 把游渦的方向逆轉過來,並讓紅色的箭頭統統變成藍色, 再把它們放回身體裡, 這樣它們就在你體內往相反的方向旋轉。\n\n4.繼續加速這個感覺的旋轉, 並留意到你的感覺有何不同。\n\n5.回想那些讓你感覺到舒服的東西, 留意這種感覺是怎樣的旋轉方向。\n\n6.旋轉這個舒服的感覺, 並想象自己感覺非常好, 這個練習以完美的方式進行著。\n\n7.當你這麼做時, 看著當下你眼前所呈現的事物, 聆聽當下你耳朵所能聽到的聲音, 關注當下在這個現實世界里你所能關注到的事物。");
            await context.PostAsync("請問這個答案對你有幫助嗎?");
            await context.PostAsync("有幫到你的話請幫我回答 有幫助");
            await context.PostAsync("沒有的話請幫我回答 逆轉焦慮沒幫助");
            context.Wait(MessageReceived);
        }


        [LuisIntent("逆轉焦慮沒幫助")]
        public async Task reverseanxietynlp
   (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("或許你可以試試看泡澡?");
            await context.PostAsync("泡澡可以減少外界環境刺激，以減輕焦慮");
            await context.PostAsync("請問這個答案對你有幫助嗎?");
            await context.PostAsync("有幫到你的話請幫我回答 有幫助");
            await context.PostAsync("沒有的話請幫我回答 泡澡沒幫助");
            context.Wait(MessageReceived);
        }

        [LuisIntent("泡澡沒幫助")]
        public async Task bathnohelp
     (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("如果泡澡沒用的話，我想請你嘗試呼吸練習法");
            await context.PostAsync("接下來請你跟著我做");
            await context.PostAsync("嘗試輕輕的從鼻孔吸入空氣，然後緩緩地從嘴巴呼出，注意頻率要緩慢和有規律。從腳趾到頭頂慢慢收緊和放鬆全身肌肉，再保持身體靜止，留意身體感受到的所有觸覺。");
            await context.PostAsync("請重複以上動作1分鐘");
            await context.PostAsync("完成之後請告訴我是否有幫助你舒緩");
            await context.PostAsync("有幫到你的話請幫我回答 有幫助");
            await context.PostAsync("沒有幫助的話請回我  呼吸法沒幫助");
            context.Wait(MessageReceived);
        }

        [LuisIntent("呼吸法沒幫助")]
        public async Task breathenohelp
         (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("如果呼吸法也沒用的話，接下來我想請你轉移焦點");
            await context.PostAsync("轉移焦點可以助你減低焦慮。看看花朵、相片或任何你覺得有趣或令你感到平靜的東西。留意它們的細節、顏色、氣味或聲音。");
            await context.PostAsync("有幫到你的話請幫我回答 有幫助");
            await context.PostAsync("如果還是沒幫助的話，請你回我 轉移焦點沒幫助，讓我在為你想想辦法");
            context.Wait(MessageReceived);
        }
        [LuisIntent("轉移焦點沒幫助")]
        public async Task shiftfocusnohelp
        (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("如果轉移焦點也沒用的話，接下來我想請你吃點巧克力");
            await context.PostAsync("請你吃點巧克力，確保自己在疲憊時攝取足夠的鎂，身體缺鎂會使焦慮惡化，而焦慮和壓力又進一步耗盡鎂的含量，形成惡性循環。");
            await context.PostAsync("有幫到你的話請幫我回答 有幫助");
            await context.PostAsync("如果以上建議都無效可以進入身心地圖尋找附近診所讓專業醫生幫你診斷");
            context.Wait(MessageReceived);
        }

 //躁鬱
        [LuisIntent("表達躁")]
        public async Task hot
        (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("請問你持續這個狀態多久了");
            await context.PostAsync("請把你的狀態跟持續時間打出來(範例:我心情低落了3天)");
            context.Wait(MessageReceived);
        }

        [LuisIntent("表達躁跟時間")]
        public async Task hotandtime
       (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("或許你可以試試看轉移目標法?");
            await context.PostAsync("透過看綜藝節目、聽相聲、玩網路遊戲去發洩多餘的精力");
            await context.PostAsync("請問這個答案對你有幫助嗎?");
            await context.PostAsync("有幫到你的話請幫我回答 有幫助");
            await context.PostAsync("沒有的話請幫我回答 目標轉換沒幫助");
            context.Wait(MessageReceived);
        }

        [LuisIntent("目標轉換沒幫助")]
        public async Task goalnohelp
       (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("或許你可以試試看出門運動?");
            await context.PostAsync("通過消耗體能達到消除煩躁的目的。跑步、打球、踢球，在流汗的同時，大腦釋放出多巴胺，有利於放鬆心情。");
            await context.PostAsync("請問這個答案對你有幫助嗎?");
            await context.PostAsync("有幫到你的話請幫我回答 有幫助");
            await context.PostAsync("沒有的話請幫我回答 流汗沒幫助");
            context.Wait(MessageReceived);
        }

        [LuisIntent("流汗沒幫助")]
        public async Task soprtnohelp
      (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("或許你可以試試看色彩調節法?");
            await context.PostAsync("適當的添加一些暖色調，改變躁鬱的情緒。在布置房間時，採用亮一點的色調，如給人生機的綠色、給人活力的紅色、給人暖心的粉色等，通過色調帶動你的情緒。");
            await context.PostAsync("請問這個答案對你有幫助嗎?");
            await context.PostAsync("有幫到你的話請幫我回答 有幫助");
            await context.PostAsync("沒有的話請幫我回答 色彩調節沒幫助");
            context.Wait(MessageReceived);
        }


        [LuisIntent("色彩調節沒幫助")] 
        public async Task colornohelp
     (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("或許你可以試試看色彩調節法?");
            await context.PostAsync("適當的添加一些暖色調，改變躁鬱的情緒。在布置房間時，採用亮一點的色調，如給人生機的綠色、給人活力的紅色、給人暖心的粉色等，通過色調帶動你的情緒。");
            await context.PostAsync("請問這個答案對你有幫助嗎?");
            await context.PostAsync("有幫到你的話請幫我回答 有幫助");
            await context.PostAsync("如果以上建議都無效可以進入身心地圖尋找附近診所讓專業醫生幫你診斷");
            context.Wait(MessageReceived);
        }

//強迫
        [LuisIntent("表達強迫症狀")]
        public async Task   force
        (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("請問你持續這個狀態多久了");
            await context.PostAsync("請把你的狀態跟持續時間打出來(範例:我心情低落了3天)");
            context.Wait(MessageReceived);
        }


        [LuisIntent("表達強迫症狀跟時間")]
        public async Task forceandtime
       (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("或許你可以試試看思維阻斷法:? ");
            await context.PostAsync("每當你有強迫行為的衝動或強迫性思考又要開始時，就用手拍擊桌子三至五次，讓手感到適當疼痛，並大聲地喊叫：「停止！」。這樣拍擊的聲音和疼痛感就會阻斷頭腦中的強迫衝動或意念。堅持這樣做，必有效果。");
            await context.PostAsync("請問這個答案對你有幫助嗎?");
            await context.PostAsync("有幫到你的話請幫我回答 有幫助");
            await context.PostAsync("沒有的話請幫我回答 思維阻斷沒幫助");
            context.Wait(MessageReceived);
        }

        [LuisIntent("思維阻斷沒幫助")]
        public async Task stopthinknohelp
   (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("或許你可以試試看思維阻斷法:? ");
            await context.PostAsync("每當你有強迫行為的衝動或強迫性思考又要開始時，就用手拍擊桌子三至五次，讓手感到適當疼痛，並大聲地喊叫：「停止！」。這樣拍擊的聲音和疼痛感就會阻斷頭腦中的強迫衝動或意念。堅持這樣做，必有效果。");
            await context.PostAsync("請問這個答案對你有幫助嗎?");
            await context.PostAsync("有幫到你的話請幫我回答 有幫助");
            await context.PostAsync("如果以上建議都無效可以進入身心地圖尋找附近診所讓專業醫生幫你診斷");
            context.Wait(MessageReceived);
        }






        //社交恐懼

        [LuisIntent("表達社交恐懼")]
        public async Task socialscared
       (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("1.想想某個你參加一個派對或社會集會的時候。留意緊張的感受, 並注意它移動的方向。\n\n2.想像拿起這個感覺,將它反轉,使得它朝相反的方向移動。在相反的方向旋轉得越來越快。\n\n3.注意你腦子里冒出的緊張的聲音,改變它,使得它不管說什麼,聲音都是非常放鬆的。\n\n4.把任何你被拒絕或看起來緊張的圖像移到最遠的地方,取而代之的圖像是, 與你交談的人們正看著你, 你感覺放鬆自若。\n\n5.想象你與一個又一個的人交流,感覺輕鬆自在,他們也感覺如沐春風。想象讓他們微笑, 他們自己也感覺好多了, 享受著整個過程。");
          
            await context.PostAsync("請問這個答案對你有幫助嗎?");
            await context.PostAsync("有幫到你的話請幫我回答 有幫助");
            await context.PostAsync("沒有的話請幫我回答 勇敢面對沒幫助");
            context.Wait(MessageReceived);
        }


        [LuisIntent("社交nlp沒幫助")]
        public async Task socialnlp
        (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("或許你應該勇敢地去面對");
            await context.PostAsync("有緊張現象的人，在社交場合下，往往會表現出逃避心理，害怕自己會出醜而不去面對。其實，逃避並不能消除緊張，相反，它會使你感到自己的懦弱，使你責備自己，以致下次會更加緊張。而且，我們也不可能逃避一輩子的，我們生活在這個社會上，是必須與人交往的，早晚有一天，我們都必須去面對。");
            await context.PostAsync("請問這個答案對你有幫助嗎?");
            await context.PostAsync("有幫到你的話請幫我回答 有幫助");
            await context.PostAsync("沒有的話請幫我回答 勇敢面對沒幫助");
            context.Wait(MessageReceived);
        }

        [LuisIntent("勇敢面對沒幫助")]
        public async Task facenohelp
        (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("或許你應該 別太在意自己的身體反應");
            await context.PostAsync("緊張總是伴隨著一系列的身體上的不適，根據強化理論，如果緊張時我們太在意自己的身體某些部位的緊張反應，就相當於在強化自己的緊張行為。使其一步一步的加重。而當我們不去管自己的緊張反應後，由於緊張得不到注意和強化，緊張反應就會隨著時間的推移而逐漸消退。");
            await context.PostAsync("請問這個答案對你有幫助嗎?");
            await context.PostAsync("有幫到你的話請幫我回答 有幫助");
            await context.PostAsync("沒有的話請幫我回答 不在意沒幫助");
            context.Wait(MessageReceived);
        }

        [LuisIntent("不在意沒幫助")]
        public async Task dontcarenohelp
      (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("或許你應該 試著去觀察這個世界和他人");
            await context.PostAsync("很多時候，人之所以會形成各種各樣的心理困擾，是因為封閉了自己的心，在自己的思維框架和情緒感受里，矛盾、糾結。所以不妨試著去觀察這個世界和自己周圍的人，看看他們都在做什麼，他們是如何看問題和做事情的。三人行，必有我師焉。也許他們身上有很多值得你學習的閃光點。");
            await context.PostAsync("請問這個答案對你有幫助嗎?");
            await context.PostAsync("有幫到你的話請幫我回答 有幫助");
            await context.PostAsync("沒有的話請幫我回答 觀察沒幫助");
            context.Wait(MessageReceived);
        }

        [LuisIntent("觀察沒幫助")]
        public async Task observenohelp
    (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("或許你應該 專注於一件感興趣事情");
            await context.PostAsync("當人專注於一件自己特別感興趣的事情的時候，會感到輕鬆、愉快、充實、有成就感。而且心會特別的靜，特別容易專注。所以不妨給自己培養一個健康的興趣愛好，自己真正喜歡的、感興趣的，可以使自己的心靜下來，對我們的身心健康非常有益。");
            await context.PostAsync("請問這個答案對你有幫助嗎?");
            await context.PostAsync("有幫到你的話請幫我回答 有幫助");
            await context.PostAsync("沒有的話請幫我回答 專注沒幫助");
            context.Wait(MessageReceived);
        }

        [LuisIntent("專注沒幫助")]
        public async Task focusnohelp
        (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("或許你應該 學會表達自己的感受和想法");
            await context.PostAsync("自以為是和不表達才是人際交往最大的阻礙，所以請嘗試著表達自己的想法和疑惑");
            await context.PostAsync("請問這個答案對你有幫助嗎?");
            await context.PostAsync("有幫到你的話請幫我回答 有幫助");
            await context.PostAsync("沒有的話請幫我回答 表達自己沒幫助");
            context.Wait(MessageReceived);
        }

        [LuisIntent("表達自己沒幫助")]
        public async Task shownohelp
        (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("或許你應該 學會看見自己的長處");
            await context.PostAsync("很多社交緊張者就是因為不接納自己、對自己不自信造成的，所以，要改變首先就得在心裡接受和接納自己，樹立起對自我的信心。");
            await context.PostAsync("請問這個答案對你有幫助嗎?");
            await context.PostAsync("有幫到你的話請幫我回答 有幫助");
            await context.PostAsync("沒有的話請幫我回答 接納自己沒幫助");
            context.Wait(MessageReceived);
        }

        [LuisIntent("接納自己沒幫助")]
        public async Task acceptnohelp
(IDialogContext context, LuisResult result)
        {
            await context.PostAsync("或許你應該 學會不要對自己要求太高");
            await context.PostAsync("過於追求完美，對自己要求過高，就容易患得患失，太在意別人對自己的看法，一心想要得到別人的承認，從而迷失自己。接受自己的現況，不要去管別人怎麼看，你越害怕出錯，就越會感到手足無措。");
            await context.PostAsync("請問這個答案對你有幫助嗎?");
            await context.PostAsync("有幫到你的話請幫我回答 有幫助");
            await context.PostAsync("如果以上建議都無效可以進入身心地圖尋找附近診所讓專業醫生幫你診斷");
            context.Wait(MessageReceived);
        }


        [LuisIntent("人際")]
        public async Task people
   (IDialogContext context, LuisResult result)
        {
            await context.PostAsync("可以告訴我你發生甚麼事了嗎");

            context.Wait(MessageReceived);
        }


    }
}