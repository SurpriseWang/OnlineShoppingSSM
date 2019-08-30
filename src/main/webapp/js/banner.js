$(function(){
	$.ajax({
		url : "../../queryBanner.action",
		type : "post",
		data : {},
		success : function(returnValue) {
			table = $("#table tbody");
			$.each(returnValue, function(i, v) {
				$("<tr name = 'tr"+i+"'>").appendTo(table);
				tr = $("tr[name='tr"+i+"']");
				$("<td class = delete style='display: none;'><input name='ids' type='checkbox' value="+v.id+"></td>").appendTo(tr);
				$("<td>" + v.bannerName + "</td>").appendTo(tr);
				$("<td id = "+(i+1)+"><img src='"+v.bannerUrl+"'></td>").appendTo(tr);
				$("</tr>").appendTo(table);
			})
		}
	});
	$(".imgInput").change(function(){
	    $(".img").attr("src",URL.createObjectURL($(this)[0].files[0]));
	});
})
$(document).ready(function() {
	//显示复选框以及删除按钮
	$("button[name='deleteItems']").click(function(){
		$("button[name='delete']").show();
		$(".delete").show();
	});
});