/**
 * Created by jiangli on 2015/6/7 0005.
 */
$(function(){

        $.ajax({
            type: "POST",
            dataType: "json",
            url: window.prePath + "leave/LeaveStatus.do?lId=" + HRS.userId,
            success:function(data){
                if(data.status == 12){

                    var message = eval(data.body)
                    var lName = message.lName;
                    var lNo = message.lNo;
                    var lApproveState = message.lApproveState;
                    var lApproveTime = message.lApproveTime;
                    var lApproveAdvice = message.lApproveAdvice;

                    //展示个人信息
                    var message=[lName,lNo,lApproveState,lApproveTime,lApproveAdvice];
                    $(".form-group span").each(function(index){
                        $(this).html( message[index]);
                    })


                }
            }
        })
    });
 

