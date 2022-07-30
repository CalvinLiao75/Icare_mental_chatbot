using System.Net;
using System.Net.Http;
using System.Threading.Tasks;
using System.Web.Http;
using MHAT.HotelBot.Dialogs;
using Microsoft.Bot.Builder.Dialogs;
using Microsoft.Bot.Connector;

using System.Collections.Generic;
using System.Threading;





namespace MHAT.HotelBot
{
    [BotAuthentication]
    public class MessagesController : ApiController
    {
        /// <摘要>
        /// POST: api/消息
        /// 接收來自用戶的消息並回复它
        /// </總結>

        public async Task<HttpResponseMessage> Post([FromBody]Activity activity)
        {
            if (activity.GetActivityType() == ActivityTypes.Message)
            {
               await Conversation.SendAsync(activity, MakeLuisDialog);
            }
            else
            {
                HandleSystemMessage(activity);
            }
            var response = Request.CreateResponse(HttpStatusCode.OK);
            return response;
        }

        private IDialog<object> MakeLuisDialog()
        {

            return Chain.From(() => new RootLuisDialog());
        }

        private Activity HandleSystemMessage(Activity message)
        {
            string messageType = message.GetActivityType();
            if (messageType == ActivityTypes.DeleteUserData)
            {
                // 這裡實現用戶刪除
                // 如果我們處理用戶刪除，返回一個真實的消息
            }
            else if (messageType == ActivityTypes.ConversationUpdate)
            {
               
                // 處理對話狀態變化，比如添加和刪除成員
                // 使用 Activity.MembersAdded 和 Activity.MembersRemoved 和 Activity.Action 獲取信息
                // 並非在所有頻道中都可用

            }
            else if (messageType == ActivityTypes.ContactRelationUpdate)
            {
                // 處理從聯繫人列表中添加/刪除
                // Activity.From + Activity.Action 代表發生了什麼
            }
            else if (messageType == ActivityTypes.Typing)
            {
                //處理知道用戶正在輸入
            }
            else if (messageType == ActivityTypes.Ping)
            {
            }

            return null;
        }


      



    }
}