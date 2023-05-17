function search(){
    var searchKeyWord = $('#search_key').val()
    if(searchKeyWord == null || searchKeyWord==''){
        return;
    }
    var groupId = $('#group_id').val()
    location.href='/groupMsg/'+groupId+'?s='+searchKeyWord;
}

function clean(){
    $('#search_key').val('');
    var groupId = $('#group_id').val()
    location.href='/groupMsg/'+groupId;
}

function handle(){
    if(event.keyCode == 13){
        $('#search_btn').click();
    }
}

$(document).ready(function() {
    var searchKeyWord = $('#search_key').val();
    if(searchKeyWord == null || searchKeyWord==''){
        return;
    }
    $('#msg_table td:nth-child(2)').each(function(){
        var originHtml = $( this ).html()
        var newHtml = originHtml.replace(searchKeyWord,"<font color='red'>"+searchKeyWord+"</font>")
        $( this ).html(newHtml)
    })
});
