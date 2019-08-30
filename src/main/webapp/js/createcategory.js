$(function(){
	$.ajax({
		url : "../../queryCategorys.action",
		type : "post",
		data : {},
		success : function(returnValue) {
			table = $("#table tbody");
			$.each(returnValue, function(i, v) {
				$("<tr name = 'tr"+i+"'>").appendTo(table);
				tr = $("tr[name='tr"+i+"']");
				$("<td class = delete style='display: none;'><input name='categoryId' type='checkbox' value="+v.id+"></td>").appendTo(tr);
				$("<td id = "+(i+1)+">" + v.categoryType + "</td>").appendTo(tr);
				$("</tr>").appendTo(table);
			})
		}
	});
})
$(document).ready(function() {
	//显示复选框以及删除按钮
	$("button[name='deleteItems']").click(function(){
		$("button[name='delete']").show();
		$(".delete").show();
	});
});