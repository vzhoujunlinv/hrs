/**
 * 员工管理页面
 */

$(function(){
    selAllEmp();

    function selAllEmp(){
        $.ajax({                                   
            type: "GET",
            dataType: "json",
            url: "employee/selAllEmp.do",
            success: function (data) {
              if (data.status == 12) {
                var strHTML = "";
                var employees = eval(data.body);
                var editBtn = "<button type='button' class='btn btn-primary editBtn' data-toggle='modal' data-target='#myModal1'>"
                              + "修改"
                              + "</button>";
                var deleteBtn = "<button type='button' class='btn btn-warning deleteBtn' data-toggle='modal' data-target='#myModal2'>"
                              + "删除"
                              + "</button>";
        
                $.each(employees, function (index) {
                    strHTML += "<tr><td class='eNo'>" + employees[index].eNo + "</td>";
                    strHTML += "<td>" + employees[index].eName+ "</td>";
                    strHTML += "<td class='eDepartment'>" + employees[index].eDepartment + "</td>";
                    strHTML += "<td class='eTitle'>" + employees[index].eTitle+ "</td>";
                    strHTML += "<td>" + employees[index].eSex+ "</td>";
                    strHTML += "<td class='eTele'>" + employees[index].eTele+ "</td>";
                    strHTML += "<td class='eMail'>" + employees[index].eMail+ "</td>";
                    strHTML += "<td>" + editBtn ;
                    strHTML += deleteBtn + "</td></tr>";
                    
                    $(".dataBody").html(strHTML);
                    //console.log(111111111);           
               })
              }
              //删除员工
              $(".deleteBtn").bind( "click",function(){
                var eNo = $(this).parent().siblings(".eNo").html();
              
                $(".subDeleteBtn").click(function(){
                  $.ajax({
                      type: "POST",
                      contentType: "application/json",
                      url: window.prePath + "employee/deleteEmp.do?eNo="+eNo,
                      success: function(data) {
                          if (data.status == 12) {
                            alert("删除成功");
                            location.reload();
                          }
                      }
                  })
                })
            })
              //修改员工资料
              $(".editBtn").bind("click",function(){
                var eNo = $(this).parent().siblings(".eNo").html();
                var currentTitle = $(this).parent().siblings(".eTitle").html();
                var currentDepartment = $(this).parent().siblings(".eDepartment").html();
                //console.log( $(this).parent().siblings(".eNo").length);
                console.log(eNo);
                $(".saveEmp").click(function(){
                    var MeDepartment = $(".newDepName").val();
                    var MeTitle =$(".newTitleName").val();
                    var MeTele =$(".newTele").val();
                    var MeMail = $(".newEmail").val();
                    console.log($(".newDepName").length);
                    if (MeTitle == "") {
                      MeTitle = currentTitle;
                      console.log("metitle2222222222222"+MeTitle);
                    }
                    if (MeDepartment == "") {
                      MeDepartment = currentDepartment;
                      console.log("MeDepartment222222222222222"+MeDepartment);
                    }
                    var modifyData = {
                        eNo:eNo,
                        eDepartment: MeDepartment,
                        eTitle:MeTitle,
                        eTele:MeTele,
                        eMail:MeMail
                    };
                    $.ajax({
                        type:"POST",
                        dataType:"json",
                        contentType:"application/json",
                        url:window.prePath +"employee/updateEmp.do",
                        data:JSON.stringify(modifyData),
                        success:function(data){
                            if(data.status == 12){
                                alert("修改成功！");
                                //刷新当前界面
                                location.reload();
                                }
                            }
                    })
                    })
                })
            }
        })        
    }

    //添加员工
   $(".submitAddBtn").click(function() {
        location.href="addWorker.html";
    })
    //分页
    $(".saveBtn").click(function(){
      console.log(555555);
      var name = $(".eName").val();
      var number = $(".eNo").val();
      var password = $(".ePwd").val();
      var dep = $(".eDepartment").val();
      var title = $(".eTitle").val();
      var sex = $(".eSex").val();
      var tele = $(".eTele").val();
      var email = $(".eMail").val();
      var data = {
        eName: name,
        eNo:number,
        ePwd:password,
        eDepartment: dep,
        eTitle: title,
        eSex: sex,
        eTele: tele,
        eMail: email
      };

      $.ajax({
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(data),
        url: window.prePath + "employee/AddEmp.do",
        success: function(data) {
          if (data.status == 12) {
            alert("添加成功");
            //location.reload();
          }
        }
      })
  })
    //搜索单个员工
     $(".selectOneBtn").click(function() {

      var eNo = $(".eNo").val();

      $.ajax({
        type: "POST",
        contentType: "application/json",
        url: window.prePath + "employee/selEmpById.do?eNo="+eNo,
        success: function(data) {
          if (data.status == 12) {
            var strHTML = "";
            var employees = eval(data.body);
            var editBtn = "<button type='button' class='btn btn-primary editBtn' data-toggle='modal' data-target='#myModal1'>"
                          + "修改"
                          + "</button>";
            var deleteBtn = "<button type='button' class='btn btn-warning deleteBtn' data-toggle='modal' data-target='#myModal2'>"
                          + "删除"
                          + "</button>";
            
            $.each(employees, function (index) {
                    strHTML += "<tr><td class='eNo'>" + employees[index].eNo + "</td>";
                    strHTML += "<td>" + employees[index].eName+ "</td>";
                    strHTML += "<td class='eDepartment'>" + employees[index].eDepartment + "</td>";
                    strHTML += "<td class='eTitle'>" + employees[index].eTitle+ "</td>";
                    strHTML += "<td>" + employees[index].eSex+ "</td>";
                    strHTML += "<td class='eTele'>" + employees[index].eTele+ "</td>";
                    strHTML += "<td class='eMail'>" + employees[index].eMail+ "</td>";
                    strHTML += "<td>" + editBtn ;
                    strHTML += deleteBtn + "</td></tr>";
                    
                    $(".dataBody").html(strHTML);
                    //console.log(111111111);           
               })
          }
        }
      })
    }) 

     //由部门搜索
     $(".eDep").change(function() {

      var eDepartment=$(this).val();

      $.ajax({
        type: "POST",
        contentType: "application/json",
        url: window.prePath + "employee/selEmpByDep.do?eDepartment="+eDepartment,
        success: function(data) {
         //console.log(233);
          if (data.status == 12) {
            var strHTML = "";
            var employees = eval(data.body);
            var editBtn = "<button type='button' class='btn btn-primary editBtn' data-toggle='modal' data-target='#myModal1'>"
                          + "修改"
                          + "</button>";
            var deleteBtn = "<button type='button' class='btn btn-warning deleteBtn' data-toggle='modal' data-target='#myModal2'>"
                          + "删除"
                          + "</button>";
      
            $.each(employees, function (index) {
              console.log(4444);
                    strHTML += "<tr><td class='eNo'>" + employees[index].eNo + "</td>";
                    strHTML += "<td>" + employees[index].eName+ "</td>";
                    strHTML += "<td class='eDepartment'>" + employees[index].eDepartment + "</td>";
                    strHTML += "<td class='eTitle'>" + employees[index].eTitle+ "</td>";
                    strHTML += "<td>" + employees[index].eSex+ "</td>";
                    strHTML += "<td class='eTele'>" + employees[index].eTele+ "</td>";
                    strHTML += "<td class='eMail'>" + employees[index].eMail+ "</td>";
                    strHTML += "<td>" + editBtn ;
                    strHTML += deleteBtn + "</td></tr>";
                    
                    $(".dataBody").html(strHTML);
                    //console.log(111111111);           
               })
          }
        }
      })
    }) 
})