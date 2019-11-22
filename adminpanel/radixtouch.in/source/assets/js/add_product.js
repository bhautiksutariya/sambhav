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

    function loadCategory(){
        $.ajax({
            url: 'https://sambhav1.herokuapp.com/rest/getCategory',
            type: 'GET',
            beforeSend: function(request) {
                request.setRequestHeader("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyIiwiaWF0IjoxNTc0MjY4OTQwLCJleHAiOjE1NzQ4NzM3NDB9.rGA2K0CtGvWOXT-XSdfb_w1xsuoMhJB-icf6CeE5mI_nAQXREXMuRBBd6NcHOjdMxBaTJemg1d1yJ8M_Vo2IQg");
            },
            contentType: 'application/json'
            })
            .done(function(response) {
                for(var i=0;i<response.length;i++)
                {
                    $("#categoryid").append("<option value="+response[i].categoryid+">"+response[i].categoryname+"</option>");
                }
            })
            .fail(function() {
                alert("Invalid Token");
            })
            .always(function() {
                console.log("complete");
            });
    }

    //authenticate();

    loadCategory();

    $("#form_addproduct").validate({
        
    });

    $("#form_addproduct").on("submit",function(e){
        e.preventDefault();
        if($("#form_addproduct").valid())
        {
            var fd=new FormData();
            var json={
                "productname":$("#productname").val(),
                "description":$("#description").val(),
                "qty":$("#qty").val(),
                "price":$("#price").val(),
                "categoryid":$("#categoryid").val(),
            };
            for (var x = 0; x < $("#productImg").length; x++) {
                fd.append("files[]", document.getElementById('productImg').files[x]);
            }
            fd.append("productDTO",JSON.stringify(json));
            console.log(json);
            $.ajax({
                url: 'https://sambhav1.herokuapp.com/rest/addProduct',
                type: 'POST',
                data: fd,
                processData: false,
                contentType: false,
                beforeSend: function(request) {
                    request.setRequestHeader("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyIiwiaWF0IjoxNTc0Mjc4MDg2LCJleHAiOjE1NzQ4ODI4ODZ9.Vgz51jaKG6C81kGXI8QsAWxZC6acHpGnkL9lAvQ3kQ8tRLl9tJ9N7dbXbuYRnALx0AHcLaJb2lxH8LMYIF53lw");
                },
                })
                .done(function(response) {
                    $('#form_addproduct').trigger("reset");
                    alert("Product added");
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