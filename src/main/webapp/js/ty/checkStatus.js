$(function(){
    getStaffList();
    function getStaffList(){
    $.ajax({
        type:"POST",
        dataType:"json",
        url:window.prePath +"leave/LeaveState.do?lNo=" + HRS.userNo,
        
        

        success:function(data){
            if(data.status == 12) {
            	console.log(HRS.userNo);            
                var checkLeave = eval(data.body);
                console.log(checkLeave);
                var strHTML = "";
                var lookBtn = "<button type='button' class='look btn btn-primary' data-toggle='modal' data-target='#myModal'><strong>查看详情</strong></button>"
                console.log(checkLeave[0]);               

               $.each(checkLeave, function (index) {
                   // console.log(1111111);
                    strHTML += "<tr><td class='lId' style='display: none'>" + checkLeave[index].lId + "</td>";
                    strHTML += "<td>" + checkLeave[index].lNo + "</td>";
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

            $(".look").click(function(){
                
                var lId=$(this).parents("td").parents("tr").children(".lId").html();
                console.log(lId);
                $.ajax({   
                    type: "POST",
                    dataType: "json",
                    url: window.prePath + "leave/LeaveStateDetail.do?lId="+lId,
                    success:function(data){
                        if(data.status == 12){

                        var message = eval(data.body)
                        //var message1=message[0];

                        $("#lReason").html(message.lReason);
                        $("#lApproveAdvice").html(message.lApproveAdvice);

                         }
                    } 
                })
            })


        },
        error:function(){alert("获取Ajax失败！")}




    });
    }




})









