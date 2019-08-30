$(function(){
	$.ajax({
		url : "../../queryItems.action",
		type : "post",
		data : {},
		success : function(response) {
			oTab = $("#tab01");
			$.each(response, function(i, v) {
				oTr = $("<tr name = user"+i+"></tr>");
				$("<td class = delete style='display: none;'><input name='itemId' type='checkbox' value="+v.id+"></td>").appendTo(oTr);
				$("<td><button class='btn' type='button' onclick='photo(this.value)' value='"+ v.id + "'>显示商品图片</button></td>").appendTo(oTr);
				$("<td>" + v.itemName + "</td>").appendTo(oTr);
				$("<td>" + v.category + "</td>").appendTo(oTr);
				$("<td>" + v.price + "</td>").appendTo(oTr);
				$("<td>" + v.unit + "</td>").appendTo(oTr);
				$("<td>" + v.productionDate + "</td>").appendTo(oTr);
				$("<td>" + v.expiryDate + "</td>").appendTo(oTr);
				$("<td>" + v.supplier + "</td>").appendTo(oTr);
				$("<td>" + v.information + "</td>").appendTo(oTr);
				let udpateTd = $("<td><button type='button' class='btn' href='javascript:;'>修改</button></td>")
				udpateTd.click(function(){
					let modalBody = $("#updateItemsModal .modal-body");
					modalBody.html("");
					$("<input type='hidden' name='id' value ='"+v.id+"'/>").appendTo(modalBody);
					$("<b>商品名:</b><input type='text' name='itemName' value ='"+v.itemName+"'/></br>").appendTo(modalBody);
					$("<b>商品类别:</b><select name ='category'></select></br>").appendTo(modalBody);
					$("<b>商品价格:</b><input type='number' name='price' value ='"+v.price+"'/></br>").appendTo(modalBody);
					$("<b>商品单位:</b><input type='text' name='unit' value ='"+v.unit+"'/></br>").appendTo(modalBody);
					$("<b>生产日期:</b><input type='date' name='productionDate' value ='"+v.productionDate+"'/></br>").appendTo(modalBody);
					$("<b>保质期:</b><input type='date' name='expiryDate' value ='"+v.expiryDate+"'/></br>").appendTo(modalBody);
					$("<b>供货商名:</b><input type='text' name='supplier' value ='"+v.supplier+"'/></br>").appendTo(modalBody);
					$("<b>描述信息:</b><input type='text' name='information' value ='"+v.information+"'/></br>").appendTo(modalBody);
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
					$("#updateItemsModal").modal({
				        show:true,/*show代表是否显示：true/false*/
				        backdrop:"static",/*backdrop代表是否需要黑灰背景：true/false/static*/
				        keyboard:true,/*keyboard代表是否可以通过ESC关闭模态框：true/false*/
					});
				});
				udpateTd.appendTo(oTr);
				oTr.appendTo(oTab);
				
				
			});
		}
	});
});

$(document).ready(function() {
	//显示复选框以及删除按钮
	$("button[name='deleteItems']").click(function(){
		$("button[name='delete']").show();
		$(".delete").show();
	});
	//跳转添加商品界面
	$("button[name='createItem']").click(function(){
		window.location.href ="./createitem.html";
	});
});
function photo(itemId){
	let modalBody = $("#showPhotoModal .modal-body");
	modalBody.html("");
	$.ajax({
		url : "../../queryPhoto.action",
		type : "post",
		data : {"itemId":itemId},
		success : function(breakValue) {
			$.each(breakValue, function(i, v) {
				$("<td><img src='"+v.src+"'></td>").appendTo(modalBody);
				$("<td><h2>"+v.title+"</h2></td>").appendTo(modalBody);
				$("<td><button type='button' class = 'btn' onclick='deletePhoto("+v.id+")'>删除</button></td>").appendTo(modalBody);
			});
		}
	});
	$("<form action='../../insertPhotos.action' class = 'form' enctype='multipart/form-data' method='post'>").appendTo(modalBody);
	let modalBodyForm = $("#showPhotoModal .modal-body .form");
	$("<div class='divStyle'>").appendTo(modalBodyForm);
	$("<td><img src='' class='img'></td>").appendTo(modalBodyForm);
	let modalBodyFormDiv = $("#showPhotoModal .modal-body .form .divStyle");
	$("<td><input type='file' name='inputfile' class='imgInput'></td>").appendTo(modalBodyFormDiv);
	$(".imgInput").change(function(){
	    $(".img").attr("src",URL.createObjectURL($(this)[0].files[0]));
	});
	$("<td><input type='hidden' name='itemId' value="+itemId+"></td>").appendTo(modalBodyFormDiv);
	$("<td><input name='title' value='图片描述'></td>").appendTo(modalBodyFormDiv);
	$("</div>").appendTo(modalBodyForm);
	//$("<td><button type='button' onclick='inserPhotos("+itemId+")' class='btn'>添加图片</td>").appendTo(modalBodyForm);
	$("<td><button type='submit' class = 'btn'>提交添加</button></td>").appendTo(modalBodyForm);
	$("</form>").appendTo(modalBodyForm);
	$("#showPhotoModal").modal({
        show:true,/*show代表是否显示：true/false*/
        backdrop:"static",/*backdrop代表是否需要黑灰背景：true/false/static*/
        keyboard:true,/*keyboard代表是否可以通过ESC关闭模态框：true/false*/
	});
}
function deletePhoto(pictureId){
	$.ajax({
		url : "../../deletePhoto.action",
		type : "post",
		data : {"pictureId":pictureId},
		success : function(breakValue) {
			if(breakValue){
				window.location.href ="./adminhomespaces.html";
			}else{
				alert("删除失败请重新添加");
				window.location.href ="./adminhomespaces.html";
			}
		}
	});
}
function inserPhotos(itemId){
	let modalBodyFormDiv = $("#showPhotoModal .modal-body .form .divStyle");
	$("</br>").appendTo(modalBodyFormDiv);
	$("<td><input type='file' name='inputfile' class='imgInput'></td>").appendTo(modalBodyFormDiv);
	$(".imgInput").change(function(){
	    $(".img").attr("src",URL.createObjectURL($(this)[0].files[0]));
	});
	$("<td><input type='hidden' name='itemId' value="+itemId+"></td>").appendTo(modalBodyFormDiv);
	$("<td><input name='title' value='图片描述'></td>").appendTo(modalBodyFormDiv);
}
