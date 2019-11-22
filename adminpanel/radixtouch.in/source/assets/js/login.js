$(document).ready(function(){
    $.validator.setDefaults({
		errorClass:'text-danger',
		highlight:function(element){
			$(element)
			.closest('.form-group')
			.addClass('has-error');
		},
		unhighlight:function(element){
			$(element)
			.closest('.form-group')
			.removeClass('has-error');	
		}
	});
    $("#form_login").validate({

    });
    $("#form_login").on("submit",function(e){
        e.preventDefault();
        if($("#form_login").valid())
        {
            $.ajax({
                url: 'https://sambhav1.herokuapp.com/rest/signin',
                type: 'POST',
                contentType: 'application/json',
                data: jsonConverter($("#form_login").serializeArray()),
                })
                .done(function(response) {
                    setCookie("token",response["accessToken"]);
                    window.location.href="./../../source/hover/add_category.html";
                })
                .fail(function() {
                    alert("Invalid credential");
                })
                .always(function() {
                    console.log("complete");
                });
        }
    });

    $("#form_register").validate({

    });

    $("#form_register").on("submit",function(e){
        e.preventDefault();
        if($("#form_register").valid())
        {
            $.ajax({
                url: 'https://sambhav1.herokuapp.com/rest/signup',
                type: 'POST',
                contentType: 'application/json',
                data: jsonConverter($("#form_register").serializeArray()),
                })
                .done(function(response) {
                    alert("user successfully registered");
                    $("#form_register").reset();
                })
                .fail(function() {
                    alert("someting wrong");
                })
                .always(function() {
                    console.log("complete");
                });
        }
    });

    function jsonConverter(data){
        var result={};
        data.forEach((element) => {
            result[element.name]=element.value;
        });
        return JSON.stringify(result);
    }

    function setCookie(cname, cvalue) {
        document.cookie = '"'+cname + "=" + cvalue+'"';
    }

    function getCookie(cname) {
        var name = cname + "=";
        var ca = document.cookie.split(';');
        for(var i = 0; i < ca.length; i++) {
          var c = ca[i];
          while (c.charAt(0) == ' ') {
            c = c.substring(1);
          }
          if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
          }
        }
        return "";
    }

    function deleteCookie(name){
        document.cookie = name+"=;";
    }

});