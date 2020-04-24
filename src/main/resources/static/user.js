/**
 * JQUERY INTEGRATION
 */

$(document).ready(()=>{
	$.ajax({
		url: "http://localhost:8080/SpringMVCConference/user"
	}).then((data)=>{
		$('.firstname').append(data.firstname);
		$('.lastname').append(data.lastname);
		$('.age').append(data.age);
	});
});