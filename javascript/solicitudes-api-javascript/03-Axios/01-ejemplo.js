function ajaxAX(url) {
    axios({
        method: 'GET'
        , url: url
    }).then(function (response) {
        console.log(response)
        output(response.data, response.status, 'Axios response')
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

ajaxAX("https://reqres.in/api/users?page=2");
