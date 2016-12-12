/**
 * 职称管理页面
 */

$(function() {
  //拉取部门列表
  getPositionList();

  function getPositionList() {
    $.ajax({
      type: "GET",
      contentType: "application/json",
      url: "position/selAllPos.do",
      success: function(data) {
        if (data.status == 12) {
          var strHTML = "";
          var positions = eval(data.body);
          var editBtn = "<button type='button' class='btn btn-primary editBtn' data-toggle='modal' data-target='#myModal'>" + "修改" + "</button>";
          var deleteBtn = "<button type='button' class='btn btn-warning deleteBtn' data-toggle='modal' data-target='#myModal6'>" + "删除" + "</button>";
          $.each(positions, function(index) {
            //strHTML += "<tr><td class='id' style='display: none'>" + userMessage[index].id + "</td>";
            strHTML += "<tr><td class='pId' style='display: none'>" + positions[index].pId + "</td>";
            strHTML += "<td class='pName'>" + positions[index].pName + "</td>";
            strHTML += "<td style='display: none'>" + positions[index].pState + "</td>";
            strHTML += "<td>" + editBtn;
            strHTML += deleteBtn + "</td></tr>";
            $(".dataBody").html(strHTML);
          })

          // 删除部门
          $(".deleteBtn").bind("click",function(){
            var pId = $(this).parent().siblings(".pId").html();
              
                $(".subDeleteBtn").click(function(){
                  $.ajax({
                      type: "POST",
                      contentType: "application/json",
                      url: window.prePath + "position/deletePos.do?pId="+pId,
                      success: function(data) {
                          if (data.status == 12) {
                            alert("删除成功");
                            location.reload();
                          }
                      }
                  })
                })    
          })
          //修改部门
          $(".editBtn").bind("click",function(){
            var pId = $(this).parent().siblings(".pId").html();
            console.log(pId);
            
            $(".savePos").click(function(){
              console.log(11111111234456);
              var pName = $(".editPosName").val();

              var data = {
                pId: pId,
                pName: pName
              };
              $.ajax({
                  type: "POST",
                  contentType: "application/json",
                  data:JSON.stringify(data),
                  url: window.prePath + "position/updatePos.do",
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
      console.log("怎么");
      var pName = $(".newPName").val();
      console.log(pName);

      var data = {
        pName: pName,
        pState: 1
      };

      $.ajax({
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(data),
        url: window.prePath + "position/AddPos.do",
        success: function(data) {
          if (data.status == 12) {
            alert("添加成功");
            location.reload();
          }
        }
      })
    })

  
})