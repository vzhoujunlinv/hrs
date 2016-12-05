window.prePath = "http://localhost:8080/hrs/";

var HRS={};
HRS.userId = sessionStorage.Id;
HRS.userRank = sessionStorage.userRank;//字符串
HRS.rankNumber = sessionStorage.rankNumber;//等级数字
HRS.loginName =sessionStorage.loginName;
HRS.password =sessionStorage.password;

//权限管理，当未登录时，跳转到登陆界面
// if(SMS.loginName == null && $(".login-form").length == 0){
//     location.href = "login.html";
// }
// $(document).on("mouseenter",function(){
//     var height = $(".main-content").height()-188;
//     $(".first-nav>li:eq(2)").height(height).css("border-bottom","solid 1px #DDD");
// });
//登录后的标题栏显示
//$(".user-identity").html(SMS.userRank);
//$(".user-name").html(SMS.loginName+"<span>|</span><a href='javascript:;'>退出</a>");



//退出登录
// $(".user-name a").click(function() {
//     $.ajax({
//         url: "/sms/staff/showOneStaff.do?id=" + SMS.userId,
//         type: "POST",
//         dataType: "json",
//         contentType: "application/json",
//         success: function (userdata) {
//             if (userdata.status == 12) {
//                 var message = eval(userdata.body);
//                 var loginoutData = {
//                     id: message.id,
//                     userName: message.name,
//                     loginName: message.loginName,
//                     password: message.password,
//                     weixinNumber: message.weixinNumber,
//                     rank: message.rank,
//                     jobNumber: message.jobNumber
//                 }
//                 $.ajax({
//                     url: "/sms/staff/logout.do",
//                     type: "POST",
//                     dataType: "json",
//                     contentType: "application/json",
//                     data: JSON.stringify(loginoutData),
//                     success: function (data) {
//                         if (data.status == 12) {
//                             alert("退出登录！")
//                             location.href = "login.html";
//                             //清除本地储存
//                             sessionStorage.clear();
//                         }
//                     }
//                 })
//             }
//         }
//     })
// })






