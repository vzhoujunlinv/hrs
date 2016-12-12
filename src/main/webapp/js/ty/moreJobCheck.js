$(function(){
    var currentPage =1;
    getStaffList(currentPage);
    function getStaffList(currentPage){
    $.ajax({
        type:"GET",
        dataType:"json",
        url:window.prePath +"overtime/OvertimeCheck.do?",
        success:function(data){
            if(data.status == 12) {

                var checkMore = eval(data.body);
                
                var strHTML = "";
                var lookBtn = "<button type='button' class='look btn btn-primary' data-toggle='modal' data-target='#myModal'><strong>查看详情</strong></button>"
                //console.log(checkLeave[0].lId);               

               $.each(checkMore, function (index) {
                    strHTML += "<tr><td class='oId' style='display: none'>" + checkMore[index].oId + "</td>";
                    strHTML += "<td>" + checkMore[index].oNo + "</td>";
                    strHTML += "<td>" + checkMore[index].oName + "</td>";
                    strHTML += "<td>" + checkMore[index].oStartTime+ "</td>";
                    strHTML += "<td>" + checkMore[index].oEndTime+ "</td>";
                    strHTML += "<td>" + checkMore[index].oApproveState+ "</td>";
                    strHTML += "<td>" + checkMore[index].oApprover+ "</td>";
                    strHTML += "<td>" + checkMore[index].oApproveTime+ "</td>";
                    strHTML += "<td>" + lookBtn + "</td></tr>";
                    $("tbody").html(strHTML);           
                })
           
            }

            $(".look").click(function(){
                
                var oId=$(this).parents("td").parents("tr").children(".oId").html();
                console.log(oId);
                $.ajax({   
                    type: "POST",
                    dataType: "json",
                    url: window.prePath + "overtime/OvertimeCheckDetail.do?oId="+oId,
                    success:function(data){
                        if(data.status == 12){

                        var message = eval(data.body)
                        //var message1=message[0];

                        $("#oReason").html(message.oReason);
                        $("#oApproveAdvice").html(message.oApproveAdvice);

                         }
                    } 
                })
            })


        },
        error:function(){alert("获取Ajax失败！")}




    });
    }




})









