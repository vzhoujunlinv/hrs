/**
 * Created by jiangli on 2015/6/7 0005.
 */
$(function(){

        $.ajax({
            type: "POST",
            dataType: "json",
            url: window.prePath + "overtime/OvertimeStatus.do?oId=" + HRS.userId,
            success:function(data){
                if(data.status == 12){

                    var message = eval(data.body)
                    var oName = message.oName;
                    var oNo = message.oNo;
                    var oApproveState = message.oApproveState;
                    var oApproveTime = message.oApproveTime;
                    var oApproveAdvice = message.oApproveAdvice;

                    //展示个人信息
                    var message=[oName,oNo,oApproveState,oApproveTime,oApproveAdvice];
                    $(".form-group span").each(function(index){
                        $(this).html( message[index]);
                    })


                }
            }
        })
});
 
    
