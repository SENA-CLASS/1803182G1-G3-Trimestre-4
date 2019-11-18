function ajaxJQ(url) {
    $.ajax({
        url: url
        , type: 'GET'
        , success: function (data) {
            //console.log(data)
        }
    }).done(function (response, textStatus, xhr) {
        output(response, xhr.status, 'jQuery response')
    })
}

function output(responseText, status, xhr) {
    var output = document.getElementById('output');
    responseText = ((typeof responseText) === 'string') ? JSON.parse(responseText) : responseText;
    console.log(responseText);
    output.innerHTML = '<div><span class="heading">Response Text</span><p>' + JSON.stringify(responseText) + '</p></div>';
    output.innerHTML += '<div><span class="heading">Status</span><p>' + JSON.stringify(status) + '</p></div>';
    output.innerHTML += '<div><span class="heading">Response</span><p>' + JSON.stringify(xhr) + '</p></div>';
}

ajaxJQ("https://reqres.in/api/users?page=2");
