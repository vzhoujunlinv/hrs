window.prePath = "http://localhost:8080/hrs/";

var HRS={};
HRS.userId = sessionStorage.Id;
HRS.userRank = sessionStorage.userRank;//字符串
HRS.rankNumber = sessionStorage.rankNumber;//等级数字
HRS.loginName =sessionStorage.loginName;
HRS.password =sessionStorage.password;
HRS.userNo =sessionStorage.eNo;

//console.log(HRS.loginName);
console.log(window.location.pathname);
//权限管理，当未登录时，跳转到登陆界面
if(HRS.loginName == null && window.location.pathname != "/hrs/login.html"){
    location.href = "login.html";
}

//登录后的标题栏显示
$(".userName").html(HRS.loginName);
$(".userRank").html(HRS.userRank);



//退出登录
$(".logoutBtn").click(function() {
    $.ajax({
        url: "/hrs/employee/showOneEmp.do?id=" + HRS.userId,
        type: "POST",
        dataType: "json",
        contentType: "application/json",
        success: function (userdata) {
            if (userdata.status == 12) {
                var message = eval(userdata.body);
                var loginoutData = {
                    eId: message.eId,
                    eNo: message.eNo,
                    ePwd: message.ePwd,
                    eName: message.eName,
                    eSex: message.eSex,
                    eAddress: message.eAddress,
                    eNativeplace: message.eNativeplace,
                    eNation: message.eNation,
                    eDepartment: message.eDepartment,
                    eTitle: message.eTitle,
                    eRecord: message.eRecord,
                    eJointime: message.eJointime,
                    eIntroduction: message.eIntroduction,
                    eState: message.eState,
                    eTele: message.eTele,
                    eMail: message.eMail,
                    eBeizhu: message.eBeizhu,
                    role: message.role
                }
                $.ajax({
                    url: "/hrs/employee/logout.do",
                    type: "POST",
                    dataType: "json",
                    contentType: "application/json",
                    data: JSON.stringify(loginoutData),
                    success: function (data) {
                        if (data.status == 12) {
                            alert("退出登录！")
                            location.href = "login.html";
                            //清除本地储存
                            sessionStorage.clear();
                        }
                    }
                })
            }
        }
    })
})






