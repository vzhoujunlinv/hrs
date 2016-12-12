
$(function(){
    $(".logBtn").click(function(){
        console.log("Aaaaaaaaaaa");
        console.log(window.prePath);
        var loginName=$("#loginName").val();
        var passWord = $("#loginPassword").val();

        if(loginName == "" || passWord == ""){
            alert("输入不能为空");
            return false;
        }

        $.ajax({
            url:window.prePath + "employee/login.do?eNo="+loginName +"&password="+ passWord,
            type:"POST",
            contentType:"application/json",
            success:function(data){
                var message = eval(data.body);

                if(data.status == 0){
                     sessionStorage.userRank = "老大";// 用户身份
                     sessionStorage.loginName = message.eName;
                     sessionStorage.password = message.ePwd;
                     sessionStorage.Id = message.eId;
                     sessionStorage.rankNumber = message.role;
                     sessionStorage.eNo = message.eNo;
                     sessionStorage.department = message.eDepartment;
                     location.href = window.prePath +"index.html"
                }
                if(data.status== 1){
                    sessionStorage.userRank = "管理员";// 用户身份
                    sessionStorage.loginName = message.eName;
                     sessionStorage.password = message.ePwd;
                     sessionStorage.Id = message.eId;
                     sessionStorage.rankNumber = message.role;
                     sessionStorage.eNo = message.eNo;
                     sessionStorage.department = message.eDepartment;
                    location.href = window.prePath +"index.html"
                }
                if(data.status== 2){
                    sessionStorage.userRank = "普通员工";// 用户身份
                    sessionStorage.loginName = message.eName;
                     sessionStorage.password = message.ePwd;
                     sessionStorage.Id = message.eId;
                     sessionStorage.rankNumber = message.role;
                     sessionStorage.eNo = message.eNo;
                    sessionStorage.department = message.eDepartment;
                    location.href = window.prePath +"index.html"
                }
                
                if(data.status == 16){
                    alert("密码不正确，请重新输入！");
                    
                }
                if(data.status == 15){
                    alert("该用户不存在！");
                }
            },
            error:function(){ console.log("发送ajax失败");}
        });
    });
    
});