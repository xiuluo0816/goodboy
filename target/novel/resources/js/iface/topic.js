$(document).ready(function(){
	$(".imgAdBtn").click(function () {
		location.href = "../imgAd/?topicId=" + $(this).attr('data-topic');
	});
});