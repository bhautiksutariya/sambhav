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
    function jsonConverter(data){
        var result={};
        data.forEach((element) => {
            result[element.name]=element.value;
        });
        return JSON.stringify(result);
    }

    function setCookie(cname, cvalue) {
        document.cookie = cname + "=" + cvalue + ";";
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

    function authenticate(){
        
        if(getCookie("token")!="")
        {
            var fd=new FormData();
            fd.append("token",getCookie("token"));
            $.ajax({
                url: 'https://sambhav1.herokuapp.com/rest/verifyToken',
                type: 'POST',
                data: fd,
                })
                .done(function(response) {
                    console.log("complete");
                })
                .fail(function() {
                    window.location.href="./../../source/hover/login.html";
                })
                .always(function() {
                    console.log("complete");
                });
        }
        else
        {
            window.location.href="./../../source/hover/login.html";
        }
    }


    //authenticate();



    $("#form_addcategory").validate({
        
    });

    $("#form_addcategory").on("submit",function(e){
        e.preventDefault();
        if($("#form_addcategory").valid())
        {
            $.ajax({
                url: 'https://sambhav1.herokuapp.com/rest/addCategory',
                type: 'POST',
                beforeSend: function(request) {
                    request.setRequestHeader("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyIiwiaWF0IjoxNTc0MjY4OTQwLCJleHAiOjE1NzQ4NzM3NDB9.rGA2K0CtGvWOXT-XSdfb_w1xsuoMhJB-icf6CeE5mI_nAQXREXMuRBBd6NcHOjdMxBaTJemg1d1yJ8M_Vo2IQg");
                },
                contentType: 'application/json',
                data: jsonConverter($("#form_addcategory").serializeArray()),
                })
                .done(function(response) {
                    $('#form_addcategory').trigger("reset");
                    alert("category added");
                })
                .fail(function() {
                    alert("Invalid Token");
                })
                .always(function() {
                    console.log("complete");
                });
        }
    });

    




});