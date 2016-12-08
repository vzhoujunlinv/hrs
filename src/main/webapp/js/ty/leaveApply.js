/**
 * Created by jiangli on 2015/6/7 0005.
 */
$(function(){
    checkNull();//检查输入框是否为空

    //请假申请
    $("#leaveapply").click(function() {
        var modifyData = {
            // id:HRS.userId,
            lNo:"2014029",
            lName: $("#leaveName").val(),
            lStartTime: $("#start").val(),
            lEndTime: $("#end").val(),
            lReason: $("#leaveReason").val(),
            lApplyTime: $("#lApplyTime").val()
        };
        console.log(modifyData);
        console.log($("#end").val(),$("#start").val());
        var ulHTML = "";//用于存放警示提示内容
        var valHTML="";
        ulHTML += $(".inputName-status").html();
        ulHTML += $(".inputId-status").html();
        valHTML += $("#leaveName").val();
        if(ulHTML == ""){
            if(!(valHTML == null ||valHTML == "")){
                $.ajax({
                    type: "POST",
                    dataType: "json",
                    contentType:"application/json",
                    url: window.prePath +"leave/LeaveApply.do",
                    data: JSON.stringify(modifyData),
                    success: function (data) {
                        if (data.status == 12) {
                            
                        }
                    },
                    error: function () {
                        alert("ajax请求失败！");
                    }
                })}
        }
    })


    //判断输入是否为空
    function checkNull(){
            $("input").blur(function(){
            var s = $(this).val();
            if( s == null){
                $(this).parents(".form-group").children("p").html("*输入不能为空！");}
            }).focus(function(){
            $(this).parents(".form-group").children("p").html("");
        });
        }

    
})