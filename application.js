$(document).ready(function(){
    $('input').last().on('click',function(){
        $.ajax({
          url: "calculs",
          data: $("form").serialize(),
          success: function(result) {
              $("h2").after(result);
          }
        });
    });
});
