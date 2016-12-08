/**
 * 薪资管理页面
 */

$(function(){
    getStaffList("");
    function getStaffList(eNo){
    $.ajax({
        type:"GET",
        dataType:"json",
        url:window.prePath+"salary/GetSalaryList.do?eNo="+eNo,
        success:function(data){
            if(data.status == 12) {
                var salarys = eval(data.body);
                //var salaryMessage = salary.salarys;
                var strHTML = "";
                var DetailBtn = "<button class='DetailBtn btn btn-sm btn-primary m-t-n-xs '  data-toggle='modal' data-target='#myModal1'><strong>查看详情</strong></button>";//详情按钮
                var editBtn = "<button class='editBtn btn btn-sm btn-warning m-t-n-xs'  data-toggle='modal' data-target='#myModal'><strong>修改</strong></button>";//修改按钮
               $.each(salarys, function (index) {
                    //strHTML += "<tr><td class='id' style='display: none'>" + userMessage[index].id + "</td>";
                    strHTML += "<tr><td class='sNo'>" + salarys[index].sNo + "</td>";
                    strHTML += "<td>" + salarys[index].sName + "</td>";
                    strHTML += "<td>" + salarys[index].employee.eDepartment+ "</td>";
                    strHTML += "<td>" + salarys[index].employee.eTitle+ "</td>";
                    strHTML += "<td>" + salarys[index].sBasic+ "</td>";
                    strHTML += "<td>" + salarys[index].sReal+ "</td>";
                    strHTML += "<td>" + salarys[index].sDate+ "</td>";
                    strHTML += "<td>" + DetailBtn ;
                    strHTML += editBtn + "</td></tr>";
                    //strHTML += "<td class=" + index + " >" + DetailBtn ;
                   // strHTML += editBtn + "</td></tr>";
                    $("tbody").html(strHTML);           
               }) 
             }
             $(".DetailBtn").click(function(){
                    var eNo=$(this).parents("td").parents("tr").children(".sNo").html();
                    console.log(eNo);
                    // $(".modal").modal();
                    $.ajax({
                        type: "GET",
                        dataType: "json",
                        url:window.prePath+"salary/GetSalaryDetail.do?eNo="+eNo,
                        success:function(data){
                            if(data.status == 12){
                                var message = eval(data.body);
                                var message1=message[0];
                                $("#lno").html(message1.lno);
                                $("#ono").html(message1.ono);
                                $("#plus").html(message1.plus);
                                $("#minus").html(message1.minus);
                            }
                        }
                    })

                })
             $(".editBtn").bind("click", function (e){
                    var eNo=$(this).parents("td").parents("tr").children(".sNo").html();
                    $(".modal").modal();
                    $.ajax({
                        type: "POST",
                        dataType: "json",
                        url:window.prePath+"salary/GetSalaryDetail.do?eNo="+eNo,
                        success:function(data){
                            if(data.status == 12){
                                var message = eval(data.body)
                                $("#lno").html(message.lno);
                                $("#ono").html(message.ono);
                                $("#plus").html(message.plus);
                                $("#minus").html(message.minus);
                            }
                        }
                    })
                })





        	},
            error:function(){alert("获取Ajax失败！")}
    	});

    }
  //删除员工信息
         $("#Search").click(function(){
                 var eNo= $("#searchtxt").val();
                 getStaffList(eNo);                
        })

    
  //结算员工工资
         $("#Compute").click(function(){
        	 	var text1=$("#searchtxt").val();
                 $.ajax({               	                 	 
                     type: "POST",
                     dataType: "json",
                     url: "salary/insert.do?eDepartment="+text1,
                     success: function (data) {
                         if (data.status == 12) {
                             alert("发放薪资成功");
                         }
                     }
                 })
        })

                // $(".DetailBtn").bind("click", function (e){
                //     console.log(11111111111111);
                //     var eNo=$(this).parents("td").parents("tr").children(".sNo").html();
                //     console.log($(this).parents("td").length);
                //     // $(".modal").modal();
                //     $.ajax({
                //         type: "GET",
                //         dataType: "json",
                //         url:window.prePath+"salary/GetSalaryDetail.do?eNo="+eNo,
                //         success:function(data){
                //             if(data.status == 12){
                //                 var message = eval(data.body)
                //                 $("#lno").html(message.lno);
                //                 $("#ono").html(message.ono);
                //                 $("#plus").html(message.plus);
                //                 $("#minus").html(message.minus);
                //             }
                //         }
                //     })
                // })
                


                

})
            