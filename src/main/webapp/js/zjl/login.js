
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

                if(message.eTitle == "总经理"){
                     sessionStorage.userRank = "总经理";// 用户身份
                     sessionStorage.loginName = message.eName;
                     sessionStorage.password = message.ePwd;
                     sessionStorage.Id = message.eId;
                     sessionStorage.rankNumber = message.role;
                     sessionStorage.department = message.eDepartment;
                     sessionStorage.eNo = message.eNo;
                     location.href = window.prePath +"index.html"
                }
                if(message.eTitle == "经理"){
                    sessionStorage.userRank = "经理";// 用户身份
                    sessionStorage.loginName = message.eName;
                     sessionStorage.password = message.ePwd;
                     sessionStorage.Id = message.eId;
                     sessionStorage.rankNumber = message.role;
                     sessionStorage.department = message.eDepartment;
                     sessionStorage.eNo = message.eNo;
                    location.href = window.prePath +"index.html"
                }
                if(message.eTitle == "员工"){
                    sessionStorage.userRank = "员工";// 用户身份
                    sessionStorage.loginName = message.eName;
                     sessionStorage.password = message.ePwd;
                     sessionStorage.Id = message.eId;
                     sessionStorage.rankNumber = message.role;
                    sessionStorage.department = message.eDepartment;
                    sessionStorage.eNo = message.eNo;
                    location.href = window.prePath +"checkStatus.html"
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