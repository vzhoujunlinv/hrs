$(function(){
    getStaffList();
    function getStaffList(){
    $.ajax({
        type:"POST",
        dataType:"json",
        url:window.prePath +"overtime/OvertimeState.do?oNo=" + HRS.userNo,
        
        

        success:function(data){
            console.log(HRS.userNo);
            if(data.status == 12) {           
                var checkMore = eval(data.body);
                console.log(checkMore[0]);
                var strHTML = "";
                var lookBtn = "<button type='button' class='look btn btn-primary' data-toggle='modal' data-target='#myModal'><strong>查看详情</strong></button>";
                $.each(checkMore, function (index) {
                    console.log(1111111);
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

            // $(".look").click(function(){
                
            //     var oId=$(this).parents("td").parents("tr").children(".oId").html();
            //     console.log(lId);
            //     $.ajax({   
            //         type: "POST",
            //         dataType: "json",
            //         url: window.prePath + "overtime/OvertimeStateDetail.do?oId=" + oId,
            //         success:function(data){
            //             if(data.status == 12){

            //             var message = eval(data.body)
            //             //var message1=message[0];

            //             $("#oReason").html(message.oReason);
            //             $("#oApproveAdvice").html(message.oApproveAdvice);

            //              }
            //         } 
            //     })
            // })


            $(".look").click(function(){
                    //console.log("hahah");
                    var oId=$(this).parents("td").parents("tr").children(".oId").html();
                    $.ajax({
                        type: "POST",
                        dataType: "json",
                        url:window.prePath+"overtime/OvertimeStateDetail.do?oId="+oId,
                        success:function(data){
                            if(data.status == 12){
                                var message = eval(data.body);
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









