$(function(){
    var currentPage =1;
    getStaffList(currentPage);
    function getStaffList(currentPage){
    $.ajax({
        type:"GET",
        dataType:"json",
        url:window.prePath +"leave/LeaveCheck.do?eNo"+eNo,
        success:function(data){
            if(data.status == 12) {
                $(".pagination-nav").empty().remove();
                var checkLeave = eval(data.body);
                var strHTML = "";
                var lookBtn = "<button type='button' class='look btn btn-primary'  data-toggle='modal' data-target='#myModal'><strong>查看详情</strong></button>"

                

               $.each(checkLeave, function (index) {
                    
                    strHTML += "<tr><td class='lNo'>" + checkLeave[index].lNo + "</td>";
                    strHTML += "<td>" + checkLeave[index].lName + "</td>";
                    strHTML += "<td>" + checkLeave[index].lStartTime+ "</td>";
                    strHTML += "<td>" + checkLeave[index].lEndTime+ "</td>";
                    strHTML += "<td>" + checkLeave[index].lApproveState+ "</td>";
                    strHTML += "<td>" + checkLeave[index].lApprover+ "</td>";
                    strHTML += "<td>" + checkLeave[index].lApproveTime+ "</td>";
                    strHTML += "<td>" + lookBtn + "</td></tr>";


                    $("tbody").html(strHTML);           
                })
           
            }
        },
        error:function(){alert("获取Ajax失败！")}
    });
    }



     $(".look").click(function(){
        var eNo=$(this).parents("td").parents("tr").children(".lNo").html();
        $.ajax({   
            type: "POST",
            dataType: "json",
            url: window.prePath + "leave/LeaveStatus.do?eNo="+eNo,
            success:function(data){
                if(data.status == 12){

                    var message = eval(data.body)
                    var message1=message[0];

                    $("#lReason").html(message1.lReason);
                    $("#ApproveAdvice").html(message1.lApproveAdvice);

                }
            }
        })
    })
})









