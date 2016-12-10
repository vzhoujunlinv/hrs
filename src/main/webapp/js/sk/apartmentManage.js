/**
 * 职称管理页面
 */

$(function(){
    selAllPos("");
    function selAllPos(){
    $.ajax({
        type:"GET",
        dataType:"json",
        url:window.prePath+"position/selAllPos.do",
        success:function(data){
            if(data.status == 12) {
                var positions = eval(data.body);
                var strHTML = "";
                var deleteBtn = "<button class='deleteBtn btn btn-sm btn-primary m-t-n-xs '  data-toggle='modal' data-target='#myModal1'><strong>删除</strong></button>";//删除按钮
                var editBtn = "<button class='editBtn btn btn-sm btn-primary m-t-n-xs'  data-toggle='modal' data-target='#myModal'><strong>修改</strong></button>";//修改按钮
                var addBtn = "<button class='addBtn btn btn-sm btn-primary m-t-n-xs'  data-toggle='modal' data-target='#myModal'><strong>添加</strong></button>";//添加按钮
               $.each(positions, function (index) {
                    
                    strHTML += "<tr><td class='sNo'>" + positions[index].sNo + "</td>";
                    strHTML += "<td>" + positions[index].sName + "</td>";
                    strHTML += "<td>" + positions[index].employee.eDepartment+ "</td>";
                    strHTML += "<td>" + positions[index].employee.eTitle+ "</td>";
                    strHTML += "<td>" + positions[index].sBasic+ "</td>";
                    strHTML += "<td>" + positions[index].sReal+ "</td>";
                    strHTML += "<td>" + positions[index].sDate+ "</td>";
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
            