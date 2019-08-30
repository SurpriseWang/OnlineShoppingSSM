$(function(){
	$.ajax({
		url : "../../queryCategorys.action",
		type : "post",
		data : {},
		success : function(returnValue) {
			select = $("select[name='category']");
			$.each(returnValue, function(i, v) {
				$("<option id = "+i+1+">" + v.categoryType + "</option>").appendTo(select);
			})
		}
	});
})
$(document).ready(function() {
});
