$(function(){
    if (HRS.userRank == "经理") {

      $.ajax({
        type: "POST",
        contentType: "application/json",
        url: window.prePath + "overtime/OvertimeApproveListByDep.do?eDepartment="+HRS.dep,
        success: function(data) {
          
          if(data.status == 12) {
                var moreJudge = eval(data.body);
                var strHTML = "";
                var ApproveBtn = "<button type='button' class='Approve btn btn-primary m-t-n-xs'  data-toggle='modal' data-target='#myModal'><strong>审批</strong></button>"
                var LookBtn = "<button type='button' class='look btn btn-warning m-t-n-xs'  data-toggle='modal' data-target='#myModal1'><strong>查看详情</strong></button>"

                $.each(moreJudge, function (index) {
                    strHTML += "<tr><td class='oId' style='display: none'>" + moreJudge[index].oId + "</td>";
                    strHTML += "<td>" + moreJudge[index].oNo + "</td>";
                    strHTML += "<td>" + moreJudge[index].oName + "</td>";
                    strHTML += "<td>" + moreJudge[index].oStartTime+ "</td>";
                    strHTML += "<td>" + moreJudge[index].oEndTime+ "</td>";
                    strHTML += "<td>" + ApproveBtn ;
                    strHTML += LookBtn + "</td></tr>";
                    $("tbody").html(strHTML);       
               }) 
             }
             $(".look").click(function(){
                    //console.log("hahah");
                    var oId=$(this).parents("td").parents("tr").children(".oId").html();
                    $.ajax({
                        type: "POST",
                        dataType: "json",
                        url:window.prePath+"overtime/OvertimeApproveDetail.do?oId="+oId,
                        success:function(data){
                            if(data.status == 12){
                                var message = eval(data.body);
                                $("#oReason").html(message.oReason);
        
                            }
                        }
                    })                   
                })


            var eNumber;
            $(".Approve").click(function(){
                    eNumber=$(this).parents("td").parents("tr").children(".oId").html();
                })
                $("#save").bind("click", function(){
                     console.log(eNumber);
                     var modifyData={
                            oId:eNumber,
                            oApproveTime:$("#oApproveTime").val(),
                            oApproveState:$("#oApproveState").val(),
                            oApprover:$("#oApprover").val(),
                            oApproveAdvice:$("#oApproveAdvice").val()

                     }; 
                     //console.log(modifyData);               
                    $.ajax({
                        type: "POST",
                        contentType:"application/json",
                        url:window.prePath+"overtime/OvertimeApprove.do",
                        data: JSON.stringify(modifyData),
                        success: function (data) {
                            if (data.status == 12) {
                                alert("审核成功！"); 
                            }
                         },
                        error: function () {
                            alert("ajax请求失败！");
                        }
                    })
                })

        
        }
      })
    }else{
      OvertimeApproveList();
    }
    
    function OvertimeApproveList(){
    $.ajax({
        type:"GET",
        dataType:"json",
        url:window.prePath+"overtime/OvertimeApproveList.do",
        success:function(data){
            if(data.status == 12) {
                var moreJudge = eval(data.body);
                var strHTML = "";
                var ApproveBtn = "<button type='button' class='Approve btn btn-primary m-t-n-xs'  data-toggle='modal' data-target='#myModal'><strong>审批</strong></button>"
                var LookBtn = "<button type='button' class='look btn btn-warning m-t-n-xs'  data-toggle='modal' data-target='#myModal1'><strong>查看详情</strong></button>"

                $.each(moreJudge, function (index) {
                    strHTML += "<tr><td class='oId' style='display: none'>" + moreJudge[index].oId + "</td>";
                    strHTML += "<td>" + moreJudge[index].oNo + "</td>";
                    strHTML += "<td>" + moreJudge[index].oName + "</td>";
                    strHTML += "<td>" + moreJudge[index].oStartTime+ "</td>";
                    strHTML += "<td>" + moreJudge[index].oEndTime+ "</td>";
                    strHTML += "<td>" + ApproveBtn ;
                    strHTML += LookBtn + "</td></tr>";
                    $("tbody").html(strHTML);       
               }) 
             }
             $(".look").click(function(){
                    //console.log("hahah");
                    var oId=$(this).parents("td").parents("tr").children(".oId").html();
                    $.ajax({
                        type: "POST",
                        dataType: "json",
                        url:window.prePath+"overtime/OvertimeApproveDetail.do?oId="+oId,
                        success:function(data){
                            if(data.status == 12){
                                var message = eval(data.body);
                                $("#oReason").html(message.oReason);
        
                            }
                        }
                    })                   
                })


            var eNumber;
            $(".Approve").click(function(){
                    eNumber=$(this).parents("td").parents("tr").children(".oId").html();
                })
                $("#save").bind("click", function(){
                     console.log(eNumber);
                     var modifyData={
                            oId:eNumber,
                            oApproveTime:$("#oApproveTime").val(),
                            oApproveState:$("#oApproveState").val(),
                            oApprover:$("#oApprover").val(),
                            oApproveAdvice:$("#oApproveAdvice").val()

                     }; 
                     console.log(modifyData);               
                    $.ajax({
                        type: "POST",
                        contentType:"application/json",
                        url:window.prePath+"overtime/OvertimeApprove.do",
                        data: JSON.stringify(modifyData),
                        success: function (data) {
                            if (data.status == 12) {
                                alert("审核成功！"); 
                            }
                         },
                        error: function () {
                            alert("ajax请求失败！");
                        }
                    })
                })





        }
    })
    }
 })
