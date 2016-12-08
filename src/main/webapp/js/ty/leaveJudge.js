
$(function(){
    getStaffList("");
    function getStaffList(eNo){
    $.ajax({
        type:"GET",
        dataType:"json",
        url:window.prePath+"leave/LeaveApprove.do?eNo="+eNo,
        success:function(data){
            if(data.status == 12) {
                var leaveJudge = eval(data.body);
                var strHTML = "";
                var ApproveBtn = "<button type='button' class='Approve btn btn-primary'  data-toggle='modal' data-target='#myModal'><strong>审批</strong></button>"
                $.each(leaveJudge, function (index) {
                    strHTML += "<tr><td class='lNo'>" +leaveJudge[index].lNo + "</td>";
                    strHTML += "<td>" + leaveJudge[index].lName + "</td>";
                    strHTML += "<td>" + leaveJudge[index].lStartTimet+ "</td>";
                    strHTML += "<td>" + leaveJudge[index].lEndTime+ "</td>";
                    strHTML += "<td>" + ApproveBtn +"</td></tr>";
                    $("tbody").html(strHTML);           
               }) 
             }
        }
    })
    }
            $(".ApproveBtn").click(function(){
                    var eNo=$(this).parents("td").parents("tr").children(".lNo").html();
                    var modifyData = {
                         id:hrs.lId,
                         lApproveTime: $("#puttime").val(),
                         lApproveState: $('input[name="toasts"]:checked').val(),
                         lApprover: $("#putpeople").val(),
                         lApproveAdvice: $("#putadv").val()
                    };

                    if (lApproveTime == ""|| lApprover==""||lApproveAdvice =="" ) {
                         alert("输入不能为空");
                         return false;
                    }
                $.ajax({
                    type: "GET",
                    dataType: "json",
                    contentType:"application/json",
                    url: window.prePath +"leave/LeaveApprove.do?eNo="+eNo,
                    data: JSON.stringify(modifyData),
                    success: function (data) {
                        if (data.status == 12) {
                            
                        }
                    },
                    error: function () {
                        alert("ajax请求失败！");
                    }
                 })
            }) 
 })
