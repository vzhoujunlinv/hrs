/**
 * 职称管理页面
 */

$(function() {
  //拉取部门列表
  getDepartmentList();

  function getDepartmentList() {
    $.ajax({
      type: "GET",
      contentType: "application/json",
      url: "department/selAllDep.do",
      success: function(data) {
        if (data.status == 12) {
          var strHTML = "";
          var departments = eval(data.body);
          var editBtn = "<button type='button' class='btn btn-primary editBtn' data-toggle='modal' data-target='#myModal'>" + "修改" + "</button>";
          var deleteBtn = "<button type='button' class='btn btn-warning deleteBtn' data-toggle='modal' data-target='#myModal6'>" + "删除" + "</button>";
          $.each(departments, function(index) {
            //strHTML += "<tr><td class='id' style='display: none'>" + userMessage[index].id + "</td>";
            strHTML += "<tr><td class='dId'>" + departments[index].dId + "</td>";
            strHTML += "<td class='dName'>" + departments[index].dName + "</td>";
            strHTML += "<td style='display: none'>" + departments[index].dState + "</td>";
            strHTML += "<td class='dSName'>" + departments[index].dSuperior + "</td>";
            strHTML += "<td>" + editBtn;
            strHTML += deleteBtn + "</td></tr>";
            $(".dataBody").html(strHTML);
          })
            //删除部门
            $(".deleteBtn").bind( "click",function(){
                var dId = $(this).parent().siblings(".dId").html();
              
                $(".subDeleteBtn").click(function(){
                  $.ajax({
                      type: "POST",
                      contentType: "application/json",
                      url: window.prePath + "department/deleteDep.do?dId="+dId,
                      success: function(data) {
                          if (data.status == 12) {
                            alert("删除成功");
                            location.reload();
                          }
                      }
                  })
                })
            })
          
          // 修改部门
            // $(".editBtn").click(funtion(){
            //    console.log(1111123);
            // })
          $(".editBtn").bind("click",function(){
            var dId = $(this).parent().siblings(".dId").html();
            console.log(dId);
            
            $(".saveDep").click(function(){
              console.log(11111111234456);
              var dName = $(".newDepName").val();
              var dSuperior = $(".newSDepName").val();
              console.log($(".newSDepName").length);
              var data = {
                dId: dId,
                dName: dName,
                dSuperior: dSuperior
              };
              $.ajax({
                  type: "POST",
                  contentType: "application/json",
                  data:JSON.stringify(data),
                  url: window.prePath + "department/updateDep.do",
                  success: function(data) {
                      if (data.status == 12) {
                        alert("修改成功");
                        location.reload();
                      }
                  }
              })
            })
          })
        }
      }
    })
  }
  //添加部门
  $(".submitAddBtn").click(function() {

      var dName = $(".dName").val();
      var dSName = $(".dSName").val();

      var data = {
        dName: dName,
        // dState: 1,
        dSuperior: dSName
      };

      $.ajax({
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(data),
        url: window.prePath + "department/AddDep.do",
        success: function(data) {
          if (data.status == 12) {
            alert("添加成功");
            location.reload();
          }
        }
      })
    })

  
})