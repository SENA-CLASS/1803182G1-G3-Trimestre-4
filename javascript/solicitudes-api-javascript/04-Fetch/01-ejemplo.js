function ajaxFe(url) {
    fetch(url).then(function (response) {
        if (response.status === 200)
            return response.json()
    }).catch(function (error) {
        return output(error, '0', 'Fetch FAILED')
    }).then(function (response) {
        return output(response, '200', 'Fetch AJAX')
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

ajaxFe("https://reqres.in/api/users?page=2");
