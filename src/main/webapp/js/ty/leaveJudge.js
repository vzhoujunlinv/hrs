$(function(){
    if (HRS.userRank == "经理") {

      $.ajax({
        type: "POST",
        contentType: "application/json",
        url: window.prePath + "leave/LeaveApproveListByDep.do?eDepartment="+HRS.dep,
        success: function(data) {
          if(data.status == 12) {
                          var leaveJudge = eval(data.body);
                          console.log(leaveJudge[0]);
                          var strHTML = "";
                          var ApproveBtn = "<button type='button' class='Approve btn btn-primary m-t-n-xs'  data-toggle='modal' data-target='#myModal'><strong>审批</strong></button>"
                          var LookBtn = "<button type='button' class='look btn btn-warning m-t-n-xs'  data-toggle='modal' data-target='#myModal1'><strong>查看详情</strong></button>"

                          $.each(leaveJudge, function (index) {
                              strHTML += "<tr><td class='lId' style='display: none'>" + leaveJudge[index].lId + "</td>";
                              strHTML += "<td>" +leaveJudge[index].lNo + "</td>";
                              strHTML += "<td>" + leaveJudge[index].lName + "</td>";
                              strHTML += "<td>" + leaveJudge[index].lStartTime+ "</td>";
                              strHTML += "<td>" + leaveJudge[index].lEndTime+ "</td>";
                              strHTML += "<td>" + ApproveBtn ;
                              strHTML += LookBtn + "</td></tr>";
                              $("tbody").html(strHTML);       
                         }) 
                       }
                       $(".look").click(function(){
                              //console.log("hahah");
                              var lId=$(this).parents("td").parents("tr").children(".lId").html();
                              $.ajax({
                                  type: "POST",
                                  dataType: "json",
                                  url:window.prePath+"leave/LeaveApproveDetail.do?lId="+lId,
                                  success:function(data){
                                      if(data.status == 12){
                                          var message = eval(data.body);
                                          $("#lReason").html(message.lReason);
                  
                                      }
                                  }
                              })                   
                          })


                      var eNumber;
                      $(".Approve").click(function(){
                              eNumber=$(this).parents("td").parents("tr").children(".lId").html();
                          })
                          $("#save").bind("click", function(){
                               console.log(eNumber);
                               var modifyData={
                                      lId:eNumber,
                                      lApproveTime:$("#lApproveTime").val(),
                                      lApproveState:$("#lApproveState").val(),
                                      lApprover:$("#lApprover").val(),
                                      lApproveAdvice:$("#lApproveAdvice").val()

                               }; 
                               //console.log(modifyData);               
                              $.ajax({
                                  type: "POST",
                                  contentType:"application/json",
                                  url:window.prePath+"leave/LeaveApprove.do",
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
      LeaveApproveList();
    }

    function LeaveApproveList(){
    $.ajax({
        type:"GET",
        dataType:"json",
        url:window.prePath+"leave/LeaveApproveList.do",
        success:function(data){
            if(data.status == 12) {
                var leaveJudge = eval(data.body);
                console.log(leaveJudge[0]);
                var strHTML = "";
                var ApproveBtn = "<button type='button' class='Approve btn btn-primary m-t-n-xs'  data-toggle='modal' data-target='#myModal'><strong>审批</strong></button>"
                var LookBtn = "<button type='button' class='look btn btn-warning m-t-n-xs'  data-toggle='modal' data-target='#myModal1'><strong>查看详情</strong></button>"

                $.each(leaveJudge, function (index) {
                    strHTML += "<tr><td class='lId' style='display: none'>" + leaveJudge[index].lId + "</td>";
                    strHTML += "<td>" +leaveJudge[index].lNo + "</td>";
                    strHTML += "<td>" + leaveJudge[index].lName + "</td>";
                    strHTML += "<td>" + leaveJudge[index].lStartTime+ "</td>";
                    strHTML += "<td>" + leaveJudge[index].lEndTime+ "</td>";
                    strHTML += "<td>" + ApproveBtn ;
                    strHTML += LookBtn + "</td></tr>";
                    $("tbody").html(strHTML);       
               }) 
             }
             $(".look").click(function(){
                    //console.log("hahah");
                    var lId=$(this).parents("td").parents("tr").children(".lId").html();
                    $.ajax({
                        type: "POST",
                        dataType: "json",
                        url:window.prePath+"leave/LeaveApproveDetail.do?lId="+lId,
                        success:function(data){
                            if(data.status == 12){
                                var message = eval(data.body);
                                $("#lReason").html(message.lReason);
        
                            }
                        }
                    })                   
                })


            var eNumber;
            $(".Approve").click(function(){
                    eNumber=$(this).parents("td").parents("tr").children(".lId").html();
                })
                $("#save").bind("click", function(){
                     console.log(eNumber);
                     var modifyData={
                            lId:eNumber,
                            lApproveTime:$("#lApproveTime").val(),
                            lApproveState:$("#lApproveState").val(),
                            lApprover:$("#lApprover").val(),
                            lApproveAdvice:$("#lApproveAdvice").val()

                     }; 
                     //console.log(modifyData);               
                    $.ajax({
                        type: "POST",
                        contentType:"application/json",
                        url:window.prePath+"leave/LeaveApprove.do",
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
