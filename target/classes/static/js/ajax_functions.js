$(document).ready(function () {
    
    //proses fungsi login pada button submit
    $("#login-form").submit(function (event) {
 
        //stop submit the form event. Do this manually using ajax post function
        event.preventDefault();
        
        //login untuk form username dan password dan email
        var loginForm = {}
        loginForm["username"] = $("#username").val();
        loginForm["password"] = $("#password").val();
        
        //disable form btn-login
        $("#btn-login").prop("disabled", true);
        
        //fungsi ajax dengan tipe post
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/api/login",
            data: JSON.stringify(loginForm),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            
            //jika sukses dia akan menampilkan dialog box bahwa data sesuai dengan yang diinputkan
            success: function (data) {
 
                //judul dialog box dengan variabel json
                var json = "<h4>Ajax Response</h4><pre>"
                
                //(data, null, 1) pada angka 1 untuk <br>
                    + JSON.stringify(data, null, 1) + "</pre>";
            
                //setelah dieksekusi klik submit maka feedback message akan tampil
                $('#feedback').html(json);
 
            },
            
            //jika tidak sukses dia akan menampilkan dialog box eror
            error: function (e) {
                
                //judul dialog box dengan variabel json
                var json = "<h4>Ajax Response Error</h4><pre>"
                
                //
                    + e.responseText + "</pre>";
            
                //setelah dieksekusi klik submit maka feedback message akan tampil
                $('#feedback').html(json);
 
            }
        });
        
    });
 
});